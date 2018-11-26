CREATE TABLE ERS_REIMBURSMENT_STATUS(
    REIMB_STATUS_ID NUMBER Primary Key,
    REIMB_STATUS VARCHAR2(10)NOT NULL
);






CREATE TABLE ERS_REIMBURSMENT_TYPE(
    REIMB_TYPE_ID NUMBER Primary Key,
    REIMB_TYPE VARCHAR2(10) NOT NULL
    
);

CREATE TABLE ERS_USER_ROLES( 
    ERS_USER_ROLE_ID NUMBER Primary Key,
    USER_ROLE VARCHAR2(10) NOT NULL,
    FOREIGN KEY (ERS_USER_ROLE_ID) REFERENCES ERS_USERS(USER_ROLE_ID)
);


CREATE TABLE ERS_USERS(
    ERS_USERS_ID NUMBER Primary Key,
    ERS_USERNAME VARCHAR2(50) UNIQUE NOT NULL,
    ERS_PASSWORD VARCHAR2(50) NOT NULL,
    USER_FIRST_NAME VARCHAR2(100) NOT NULL,
    USER_LAST_NAME VARCHAR2(100) NOT NULL,
    USER_EMAIL VARCHAR2(150) UNIQUE NOT NULL,
    USER_ROLE_ID NUMBER NOT NULL,
    FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID)
);

CREATE TABLE ERS_REIMBURSMENT(
    REIMB_ID NUMBER  Primary Key,
    REIMB_AMOUNT NUMBER NOT NULL,
    REIMB_SUBMITTED TIMESTAMP,
    REIMB_RESOLVED TIMESTAMP,
    REIMB_DESCRIPTION VARCHAR2(250),
    REIMB_AUTHOR NUMBER NOT NULL,
    REIMB_RESOLVER NUMBER,
    REIMB_STATUS_ID NUMBER NOT NULL,
    REIMB_TYPE_ID NUMBER NOT NULL,
    FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS (ERS_USERS_ID),
    FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_USERS (ERS_USERS_ID),
    FOREIGN KEY (REIMB_STATUS_ID) REFERENCES ERS_REIMBURSMENT_STATUS (REIMB_STATUS_ID),
    FOREIGN KEY (REIMB_TYPE_ID) REFERENCES ERS_REIMBURSMENT_TYPE(REIMB_TYPE_ID)
    
);







CREATE SEQUENCE REIMB_ID_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE ERS_USERS_ID_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE REIMB_ID_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE REIMB_STATUS_ID_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE REIMB_TYPE_ID_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE ERS_USER_ROLE_ID_SEQ
START WITH 1
INCREMENT BY 1;

create or replace TRIGGER ERS_USER_TRIG
BEFORE INSERT ON ERS_USERS
FOR EACH ROW
BEGIN
SELECT ERS_USERS_ID_SEQ.NEXTVAL INTO :NEW.ERS_USERS_ID FROM DUAL;
END;

create or replace TRIGGER ERS_REIMB_TRIG
BEFORE INSERT ON ERS_REIMBURSMENT
FOR EACH ROW
BEGIN
SELECT REIMB_ID_SEQ.NEXTVAL INTO :NEW.REIMB_ID FROM DUAL;
END;




CREATE OR REPLACE PROCEDURE GET_ALL_USERS(USER_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
OPEN USER_CURSOR FOR SELECT * FROM ERS_USERS;
  end;
  /
  
  INSERT INTO ERS_REIMBURSMENT_STATUS(REIMB_STATUS_ID, REIMB_STATUS)
  VALUES(1, 'Pending');
  
   INSERT INTO ERS_REIMBURSMENT_STATUS(REIMB_STATUS_ID, REIMB_STATUS)
  VALUES(2, 'Approved');
  
   INSERT INTO ERS_REIMBURSMENT_STATUS(REIMB_STATUS_ID, REIMB_STATUS)
  VALUES(3, 'Denied');
  
   INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID, USER_ROLE)
  VALUES(1, 'Employee');
  
  INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID, USER_ROLE)
  VALUES(2, 'Manager');
  
  
  INSERT INTO ERS_REIMBURSMENT_TYPE(REIMB_TYPE_ID, REIMB_TYPE)
  VALUES(1, 'Lodging');

INSERT INTO ERS_REIMBURSMENT_TYPE(REIMB_TYPE_ID, REIMB_TYPE)
  VALUES(2, 'Travel');  
  
  INSERT INTO ERS_REIMBURSMENT_TYPE(REIMB_TYPE_ID, REIMB_TYPE)
  VALUES(3, 'Food');
  
  INSERT INTO ERS_REIMBURSMENT_TYPE(REIMB_TYPE_ID, REIMB_TYPE)
  VALUES(4, 'Other');
  
  
  
  INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, 
  USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
  VALUES(1,'johnCenafan200','johncena','John','Doe','johndoe@aol.com',1);
  
  INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, 
  USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
  VALUES(2,'dbock1994','123','David','Bock','dbock@email.com',2);

  
  
  INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, 
  USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
  VALUES(3,'mrpojo','123','Pojo','Mojo','pojmoj@email.com',1);
  
   INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, 
  USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
  VALUES(4,'mrmojo','123','Mojo','Pojo','mojpoj@email.com',2);
  
  INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, 
  USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
  VALUES(5,'test','user','Mojo','Pojo','mojpojtest@email.com',2);
  
  INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, 
  USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
  VALUES('abc','abc','abc','abc','abc@aol.com',1);
  
   INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, 
  USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
  VALUES(50, 'HAL9000','2001','Hal','na','hal9000@gmail.com',1);
  
  INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, 
  USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
  VALUES(15, 'Groot','iamgroot','Groot','Groot','groot@gmail.com',1);
  
UPDATE ERS_REIMBURSMENT SET REIMB_RESOLVER = 2, REIMB_STATUS_ID = 3 WHERE REIMB_ID = 52;
 
 
   select * from ERS_REIMBURSMENT; 
 
  select * from ERS_USERS;
  
  select * from ERS_REIMBURSMENT_TYPE;
  
  SELECT *
  FROM user_constraints
 WHERE table_name = 'EMPLOYEE';