--Create Tables

create table theuser(
    userid number(5) primary key,
    firstname varchar2(20) not null,
    lastname varchar2(20) not null,
    username varchar2(15) unique not null,
    password varchar2(15) not null);
/

create table theaccount(
    accountid number(5) primary key,
    userid number(15) not null,
    typeid number(5) not null,
    acctbalance number(15,2) default 0 not null,
    CONSTRAINT "FKUser" FOREIGN KEY (userid)
    REFERENCES theuser (userid) ENABLE,
    CONSTRAINT "FKType" FOREIGN KEY (typeid)
    REFERENCES accttype (typeid) ENABLE);
/    

create table accttype (
    typeid number(5) primary key,
    typename varchar2(20) unique not null);
/

-- Create Sequences

create sequence theuserseq;
create sequence theaccountseq;
create sequence acctypeseq;

--Create Triggers

create or replace trigger usertrig
before insert on theuser
for each row
begin
    select theuserseq.nextval into :new.userid from dual;
end;
/

create or replace trigger accttrig
before insert on theaccount
for each row
begin
    select THEACCOUNTSEQ.nextval into :new.accountid from dual;
end;
/

create or replace trigger typetrig
before insert on accttype
for each row
begin
    select ACCTYPESEQ.nextval into :new.typeid from dual;
end;
/

--DML

insert into THEUSER(firstname, lastname, username, password) 
values('Dillon', 'Tara', 'dkt14', 'password');

insert into ACCTTYPE(TYPENAME) values('Checking');
insert into ACCTTYPE(TYPENAME) values('Savings');

select * from theuser order by userid;
select * from theaccount order by accountid;
select * from accttype order by typeid;
 

commit;

create or replace procedure getallusers
(user_cursor OUT sys_refcursor)
as
begin
    open user_cursor for select * from THEUSER;
end;

/


