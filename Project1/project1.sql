CREATE TABLE reimbursement (
    id            NUMBER PRIMARY KEY,
    amount        NUMBER NOT NULL,
    submitted     TIMESTAMP NOT NULL,
    resolved      TIMESTAMP,
    description   VARCHAR2(250),
    author        NUMBER NOT NULL,
    resolver      NUMBER,
    status_id     NUMBER NOT NULL,
    type_id       NUMBER NOT NULL,
    CONSTRAINT fk FOREIGN KEY ( author )
        REFERENCES users ( users_id ),
    FOREIGN KEY ( resolver )
        REFERENCES users ( users_id ),
    FOREIGN KEY ( status_id )
        REFERENCES reimbursement_status ( status_id ),
    FOREIGN KEY ( type_id )
        REFERENCES reimbursement_type ( type_id )
);

insert into reimbursement (amount,submitted,resolved,description,author,resolver,status_id,type_id) values (123,'14-NOV-18 09.49.12.843000000 PM','14-NOV-18 09.49.12.843000000 PM','dewds',1,1,1,1);
insert into users (users_id,username,password,first_name,last_name,email,role_id) values (1,'bill','pass','s','sd','fe',1);
insert into reimbursement_status (status_id, status) values (1, 'approved');
insert into reimbursement_type (type_id, type) values (1, 'Lodging');
insert into reimbursement_type (type_id, type) values (2, 'Travel');
insert into reimbursement_type (type_id, type) values (3, 'Food');
insert into reimbursement_type (type_id, type) values (4, 'Other');

insert into user_roles (user_role_id, user_role) values (1, 'employee');

CREATE TABLE users (
    users_id     NUMBER PRIMARY KEY,
    username     VARCHAR2(50) UNIQUE NOT NULL,
    password     VARCHAR2(50) NOT NULL,
    first_name   VARCHAR2(100) NOT NULL,
    last_name    VARCHAR2(100) NOT NULL,
    email        VARCHAR2(150) UNIQUE NOT NULL,
    role_id      NUMBER NOT NULL,
    CONSTRAINT fk2 FOREIGN KEY ( role_id )
        REFERENCES user_roles ( user_role_id )
);

CREATE TABLE reimbursement_status (
    status_id   NUMBER PRIMARY KEY,
    status      VARCHAR2(10) NOT NULL
);

CREATE TABLE reimbursement_type (
    type_id   NUMBER PRIMARY KEY,
    type      VARCHAR2(10) NOT NULL
);

CREATE TABLE user_roles (
    user_role_id   NUMBER PRIMARY KEY,
    user_role      VARCHAR2(10) NOT NULL
);

DROP TABLE reimbursement_status;

create sequence reimbursement_seq;
create sequence users_seq;
create sequence reimbursement_status_seq;
create sequence reimbursement_type_seq;
create sequence user_roles_seq;

CREATE OR REPLACE TRIGGER reimbursement_trig
BEFORE INSERT ON  reimbursement
FOR EACH ROW
BEGIN
  SELECT reimbursement_seq.nextVAl INTO :new.id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER users_trig 
BEFORE INSERT ON  users 
FOR EACH ROW
BEGIN
  SELECT users_seq.nextVAl INTO :new.users_id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER reimbursement_status_trig 
BEFORE INSERT ON  reimbursement_status 
FOR EACH ROW 
BEGIN
  SELECT reimbursement_status_seq.nextVAl INTO :new.status_id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER reimbursement_type_trig
BEFORE INSERT ON  reimbursement_type
FOR EACH ROW
BEGIN
  SELECT reimbursement_type_seq.nextVAl INTO :new.type_id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER user_roles_trig
BEFORE INSERT ON  user_roles
FOR EACH ROW
BEGIN
  SELECT user_roles_seq.nextVAl INTO :new.user_role_id FROM dual;
END;
/
  
create or replace procedure get_all_reimbursements(reimbursement_cursor OUT SYS_REFCURSOR)
AS
BEGIN
OPEN reimbursement_cursor FOR select * from reimbursement;
  end;
/
  
create or replace procedure get_all_users(users_cursor OUT SYS_REFCURSOR)
AS
BEGIN
OPEN users_cursor FOR select * from users;
  end;
/

CREATE OR REPLACE PROCEDURE get_reimbursements_by_author
(R_CURSOR OUT SYS_REFCURSOR, author IN NUMBER, users_id IN NUMBER)
AS
BEGIN
OPEN R_CURSOR FOR SELECT u.users_id, r.amount, r.submitted, r.resolved, r.description, r.author, r.resolver, r.status_id, r.type_id, rs.status, rt.type
  from users u
  join reimbursement r on u.users_id = r.author
  join reimbursement_status rs on r.status_id = rs.status_id
  join reimbursement_type rt on r.type_id = rt.type_id
  WHERE r.author = users_id
  ORDER BY users_id;
END;
/
  
COMMIT;