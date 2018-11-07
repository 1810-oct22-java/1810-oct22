CREATE TABLE UserInfo
(
    UserId NUMBER PRIMARY KEY,
    FirstName VARCHAR(40) NOT NULL,
    LastName VARCHAR(40) NOT NULL,
    Username VARCHAR2(40) NOT NULL UNIQUE,
    Password VARCHAR(40) NOT NULL
);

CREATE TABLE AccountType
(
    TypeId NUMBER PRIMARY KEY,
    Type VARCHAR(10) NOT NULL
);

CREATE TABLE AccountInfo
(
    AccountId NUMBER PRIMARY KEY,
    TypeId NUMBER NOT NULL,
    Owner VARCHAR(40) NOT NULL,
    Balance NUMBER NOT NULL,
    CONSTRAINT FK_AccountInfoUserInfo FOREIGN KEY (Owner) REFERENCES UserInfo(Username),
    CONSTRAINT FK_AccountInfoAccountType FOREIGN KEY (TypeId) REFERENCES AccountType(TypeId)
);

drop table accounttype;
alter table accountinfo add userid number(15);
commit;
select * from accountinfo;

insert into userinfo (UserId, FirstName, LastName, Username, Password) values (1, 'Jill', 'Johns', 'bigJill', 'passy');
insert into userinfo (UserId, FirstName, LastName, Username, Password) values (2, 'Mick', 'Peters', 'mickey', 'passy');
insert into userinfo (UserId, FirstName, LastName, Username, Password) values (3, 'Bill', 'Dingo', 'weewoo', 'passy');

insert into AccountType (typeid, type) values (1, 'Credit');
insert into AccountType (typeid, type) values (2, 'Checking');
insert into AccountType (typeid, type) values (3, 'Savings');

insert into accountInfo (accountid, typeid, owner, balance) values (1, 1, 'bigJill', 3251);
insert into accountInfo (accountid, typeid, owner, balance) values (2, 2, 'bigJill', 123);
insert into accountInfo (accountid, typeid, owner, balance) values (3, 3, 'bigJill', 5435);
insert into accountInfo (accountid, typeid, owner, balance) values (4, 1, 'mickey', 3251);
insert into accountInfo (accountid, typeid, owner, balance) values (5, 2, 'mickey', 3241);
insert into accountInfo (accountid, typeid, owner, balance) values (6, 3, 'mickey', 355353);
insert into accountInfo (accountid, typeid, owner, balance) values (7, 1, 'weewoo', 344343);
insert into accountInfo (accountid, typeid, owner, balance) values (8, 2, 'weewoo', 11);
insert into accountInfo (accountid, typeid, owner, balance) values (9, 3, 'weewoo', 543);


CREATE OR REPLACE PROCEDURE get_all_users(user OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN user FOR
  SELECT * FROM userinfo;
END;
/

create sequence increment_seq
minvalue 1
start with 1
increment by 1;

create or replace trigger user_id_seq 
before insert
on userInfo
for each row
begin
    select increment_seq.nextval into :new.UserId from dual;
end;
/

create or replace procedure deposit_procedure
(numChange number, aid number)
as
begin
    update accountinfo set balance = (balance+numChange) where accountid = aid;
end;
/

create or replace procedure withdraw_procedure
(numChange number, aid number)
as
begin
    update accountinfo set balance = (balance-numChange) where accountid = aid;
end;
/