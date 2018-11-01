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
select * from customer;

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


--7.1
select c.firstname, i.invoiceid --g.name, count(t.trackid) 
from customer c
inner join invoice i 
on i.customerid = c.customerid;

select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c
full outer join invoice i
on i.customerid = c.customerid;

select al.title, ar.name
from album al
right join artist ar
on ar.artistid = al.artistid;