/*
* Genesis Bonds Week 2 Assignment
*/

------------------------2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * from Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;


-------------------2.2-------------------
SELECT * FROM Album order by TITLE desc;

select FirstName from customer order by City;

-------------------2.3-------------------
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Tv');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Death Metal');

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Bock', 'David', 'Prorgrammer', 8, TO_DATE('1994-7-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Durham', 'NC', 'USA', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'dbock1994@gmail.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Bock', 'Jonathan', 'Consultant', 8, TO_DATE('1989-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Boston', 'MA', 'USA', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'dbock1994@gmail.com');

INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'David', 'Bock', '3,Raj Bhavan Road', 'Bangalore', 'India', '560001', '+91 080 22289999', 'puja_srivastava@yahoo.in', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Jonathan', 'Bock', '3,Raj Bhavan Road', 'Bangalore', 'India', '560001', '+91 080 22289999', 'puja_srivastava@yahoo.in', 3);

-------------------2.4-------------------
update customer
set FirstName = 'Robert', LastName = 'Walter'
where FirstName = 'Aaron' AND LastName = 'Mitchell';

update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

-------------------2.5-------------------

select * 
from invoice
where billingaddress like('T%');

-------------------2.6-------------------
select * 
from invoice
where total between 15 AND 50;

select *
from employee
where hiredate between TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') 
AND TO_DATE('2004-5-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

-------------------2.7-------------------
delete from customer
where firstname = 'Robert' AND lastName = 'Walter';


-------------------3.1-------------------

CREATE OR REPLACE FUNCTION get_time
RETURN TIMESTAMP
IS
 ct TIMESTAMP;
BEGIN

  SELECT CURRENT_TIMESTAMP INTO ct FROM dual;
  RETURN ct;

END;
/



CREATE OR REPLACE FUNCTION get_media_length
RETURN NUMBER
IS
 leng number;
BEGIN

  SELECT length(name) into leng from mediatype;
  RETURN leng;

END;
/

-------------------3.2-------------------

CREATE OR REPLACE FUNCTION avg_invoice
RETURN NUMBER
IS
 av number;
BEGIN

  SELECT avg(total) into av from invoice;
  RETURN av;

END;
/


CREATE OR REPLACE FUNCTION get_me
RETURN NUMBER
IS
 me number;
BEGIN

  SELECT max(unitprice) into me from track;
  RETURN me;

END;
/

-------------------3.3-------------------

CREATE OR REPLACE FUNCTION avg_invoice_item
RETURN NUMBER
IS
 aii number;
BEGIN

  SELECT avg(unitprice) into aii from invoiceline;
  RETURN aii;

END;
/


-------------------3.4-------------------

CREATE OR REPLACE FUNCTION employ_birth
RETURN date
IS
 ep date;
BEGIN
  SELECT firstname into ep from employee 
  where employee.birthdate > TO_DATE('1968-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
  RETURN ep;
END;
/

-------------------4.1-------------------
CREATE PROCEDURE select_name 
as
BEGIN
select firstname, lastname into from employee;
  COMMIT; 
END;
/



-------------------4.2-------------------
CREATE OR REPLACE PROCEDURE updateEmployee(fname IN varchar, lname in varchar,
inbirthdate in date, inaddress in varchar, incity in varchar, instate in varchar
, incountry in varchar, inpostalcode in varchar, inphone in varchar, 
infax in varchar, inemail in varchar) 
as
BEGIN
update employee
set firstname = fname;
update employee
set lastname = lname;
update employee
set birthdate = inbirthdate;
update employee
set address = inaddress;
update employee
set city = incity;
update employee
set state = instate;
update employee
set country = incountry;
update employee
set postalcode = inpostalcode;
update employee
set phone = inphone;
update employee
set fax = infax;
update employee
set email = inemail;
  COMMIT;
END;
/


CREATE OR REPLACE PROCEDURE select_name(e_id in number,m out number) 
as
BEGIN
select reportsto into m from employee WHERE e_id = employeeid;
return;
END;
/



-------------------4.3-------------------
CREATE OR REPLACE PROCEDURE select_name(fname out varchar, lname out varchar, ccompany out varchar) 
as
BEGIN
select firstname into fname
from customer;
select lastname into lname
from customer;
select company into ccompany
from customer;
  COMMIT;
  return;
END;
/

-------------------5-------------------
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(
      INVID IN NUMBER)
  AS
  BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
    DELETE FROM INVOICE WHERE INVOICEID = INVID;
    COMMIT;
  END;
/

CREATE OR REPLACE PROCEDURE DELETE_INVOICE(
      INVID IN NUMBER)
  AS
  BEGIN
    insert into customer(customerid) values(1);
    COMMIT;
  END;
/

-------------------6.1-------------------

CREATE OR REPLACE TRIGGER emp_TRIG -- declare and name trigger
after insert on employee
for each row
begin
insert into employee(employee.employeeid)
values(1);
END;
/

CREATE OR REPLACE TRIGGER alb_TRIG -- declare and name trigger
after update on album
for each row
begin
insert into album(album.AlbumId) values(1);
END;
/



CREATE OR REPLACE TRIGGER cus_TRIG -- declare and name trigger
after delete on employee
for each row
begin
delete from customer;
END;
/


-------------------7.1-------------------
select firstname, lastname, invoiceid
from invoice
inner join employee
on invoiceid = customerid
order by customerid;


-------------------7.2-------------------
select Customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from invoice
full join customer
on customer.customerid = invoice.customerid;

-------------------7.3-------------------
select artist.name, album.title
from album
right join artist
on artist.artistid = album.artistid;

-------------------7.4-------------------

select ar.name as artistname, al.title as albumtitle
from artist ar, album al;

-------------------7.5-------------------
select e.employeeid as EMPLOYEE, m.employeeid as MANAGER
from employee e
right join employee m
on e.reportsto = m.employeeid;

-------------------7.6-------------------
select *
from artist
inner join album
on album.artistid = artist.artistid
inner join customer
on customer.customerid = customerid
inner join invoice
on invoice.invoiceid = invoiceid
inner join genre
on genre.genreid = genreid
inner join playlisttrack
on playlisttrack.trackid = trackid
inner join playlist
on playlist.playlistid = playlisttrack.playlistid
inner join mediatype
on mediatype.mediatypeid = mediatypeid
inner join employee
on employee.employeeid = customer.supportrepid;
