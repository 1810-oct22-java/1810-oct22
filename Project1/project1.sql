CREATE TABLE reimbursement (
    id            NUMBER PRIMARY KEY,
    amount        NUMBER NOT NULL,
    submitted     TIMESTAMP NOT NULL,
    resolved      TIMESTAMP,
    description   VARCHAR2(250),
    receipt       BLOB,
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

DROP TABLE users;

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
  
COMMIT;