-- 2.1
select * from employee;
select * from employee where lastname = 'King';
select * from employee where firstname = 'Andrew' and reportsto is null;

-- 2.2
select title from album order by title desc;
select firstname from customer order by city asc;

-- 2.3
insert into genre (genreid, name) values (26, 'record1');
insert into genre (genreid, name) values (26, 'record2');

insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) values (9, 'name1', 'name2', 'title1', 7, '12-FEB-94', '14-AUG-18', '123 Ave SW', 'Lethbridge', 'AB', 'CANADA', 'T1H 1Y8', '+1 (403) 123-1233', '+1 (431) 241-4313', 'email1@chinook.com');
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) values (10, 'name3', 'name4', 'title2', 7, '13-FEB-94', '15-AUG-18', '133 Ave SW', 'Lethbridge', 'AB', 'CANADA', 'T1H 1Y8', '+1 (402) 123-1233', '+1 (421) 241-4313', 'email21@chinook.com');

insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) values (60, 'Billy', 'Billson', 'Target', 'address1', 'Tampa', 'FL', 'USA', 34021, '+1 (123) 123-1234', null, 'qwe.rewq@email.com', 4);
insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid) values (61, 'Dilly', 'Dillson', 'Target', 'address2', 'Tampa', 'FL', 'USA', 34021, '+1 (123) 223-1234', null, 'qwe.1234@email.com', 5);

--2.4
update customer set firstname = 'Robert', lastname = 'Walter' where customerid = 32;
update artist set name = 'CCR' where artistid = 76;

--2.5
select * from invoice where billingaddress like 'T%';

--2.6
select * from invoice where total between 15 and 50;
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

--2.7
delete from customer where firstname = 'Robert' and lastname = 'Walter';
delete from invoice where customerid = 32;
delete FROM INVOICELINE where invoiceid = 342;

--3.1
select SYSDATE from dual;
select length(name) from mediatype;

--3.2
select avg(total) from invoice; 

select name, unitprice from track 
where unitprice = (select max(unitprice) from track);

--3.3
select avg(unitprice) from invoiceline;

--3.4
select * from employee where to_date(birthdate, 'dd-MON-yy') > to_date( '31-DEC-68', 'dd-MON-yy');

--4.1
create or replace procedure employee_names
(curs out sys_refcursor)
as
begin
    open curs for
    select firstname, lastname from employee;
end;
/

--4.2
create or replace procedure update_employee
(id in NUMBER,
first in varchar2,
last in varchar2,
bigtitlebaby in varchar2)
as
begin
    update employee
    set firstname = first, lastname = last, title = bigtitlebaby
    where employeeid = id;
    commit;
end;
/

create or replace procedure emp_managers
(id NUMBER, curs out sys_refcursor)
as
begin
    open curs for
    select m.lastname as "Mans", e.lastname as "Emps"
    from employee m, employee e
    where e.reportsto = m.employeeid;
end;
/

--4.3
create or replace procedure name_company
(id NUMBER, curs out sys_refcursor)
as
begin
    open curs for
    select firstname, lastname, company from customer
    where customerid = id;
end;
/

--5.0
create or replace procedure delete_invoice
(invid in number)
as
begin
    delete from invoiceline where invoiceid = invid;
    delete from invoice where invoiceid = invid;
    commit;
end;
/

execute delete_invoice(240);

--6.1
create or replace trigger employee_trig
after insert 
on employee
for each row
begin
    select employee_seq.nextval into :employee_id from dual;
end;
/

create or replace trigger album_trig
after update 
on album
for each row
begin
    SELECT album_SEQ.NEXTVAL INTO :album_ID FROM DUAL;
end;
/

create or replace trigger customer_trig
after delete 
on customer
for each row
begin
    select customer_seq.nextval into :customer_id from dual;
end;
/
/*
CREATE OR REPLACE TRIGGER BN_BOOK_TRIG
BEFORE INSERT ON BN_BOOK
FOR EACH ROW
BEGIN
    SELECT BN_BOOK_SEQ.NEXTVAL INTO :NEW.BOOK_ID FROM DUAL;
END;
/
*/

SELECT BN_BOOK_SEQ.NEXTVAL INTO :NEW.BOOK_ID FROM DUAL;

--7.1
select c.firstname, i.invoiceid --g.name, count(t.trackid) 
from customer c
inner join invoice i 
on i.customerid = c.customerid;

--7.2
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c
full outer join invoice i
on i.customerid = c.customerid;

--7.3
select al.title, ar.name
from album al
right join artist ar
on ar.artistid = al.artistid;

--7.4
select al.title, ar.name
from album al, artist ar;

--7.5
select e1.lastname as EMPLOYEE, e2.lastname as MANAGER
from employee e1
full join employee e2
on e1.reportsto = e2.employeeid;

--7.6
select album.title as "ALBUM TITLE", artist.name as ARTIST, t.name as SONG, pt.trackid, pl.name, g.name as GENRE, mt.name as MEDIA, il.unitprice, iv.total, c.company, e.title
from album 
join artist on album.artistid = artist.ARTISTID
join track t on t.ALBUMID = album.ALBUMID
join playlisttrack pt on pt.trackid = t.trackid
join playlist pl on pl.playlistid = pt.playlistid
join genre g on t.genreid = g.genreid
join mediatype mt on mt.mediatypeid = t.mediatypeid
join invoiceline il on il.trackid = t.trackid
join invoice iv on iv.invoiceid = il.invoiceid
join customer c on c.customerid = iv.customerid
join employee e on e.firstname = c.firstname;




