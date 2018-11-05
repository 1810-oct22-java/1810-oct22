--2.1 SELECT
select * from Employee;

select * from Employee
where lastname = 'King';

select * from Employee
where firstname = 'Andrews' and reportsto is null;

--2.2 ORDER BY

select * from Album
order by title desc;

select firstname from Customer
order by city asc;

--2.3 Insert into

insert into genre
(genreid, name)
values
(26, 'Future House');

insert into genre
(genreid, name)
values
(27, 'Death Metal');


INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (1, 'Sean', 'Young', 'President', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '7213 S Fulton Lucas Rd', 'Swanton', 'Ohio', 'USA', '43558', '(419)654-2647', '(419)654-2647', 'seanpyoung123@gmail.com');

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (1, 'Bill', 'Bonanza', 'Janitor', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '5277 County Road 3', 'Swanton', 'Ohio', 'USA', '43558', '(419)654-2000', '(419)654-2000', 'youngones21@aol.com');

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (60, 'Sean', 'Young', 'Young & Company', '5243 WindingBrook Trail', 'Wesley Chapel', 'FL', 'USA', '43558', '(419)654-2647', '(419)654-2647', 'seanpyoung123@gmail.com', 3);

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (61, 'Phil', 'Jones', 'Jones & Company', '7211 Jasmine Brooke Circle', 'Land O lakes', 'FL', 'USA', '34639', '(419)654-5555', '(419)654-5555', 'philjones@yahoo.com', 3);

--2.4

update customer
set lastname = 'Walter',
firstname = 'Robert'
where firstname = 'Andrew' and lastname = 'Mitchell';

update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5
select *
from invoice
where billingaddress like 'T%';
--2.6

select *
from invoice
where total between 15 and 90;

select *
from employee
where hiredate between 01-06-03 and 01-04-2004;

--2.7
delete from customer where firstname = 'Robert' and lastname = 'Walter';
--3.1

--3.2



select max(UnitPrice) as maxprice from track;

/*In this section you will be using the Oracle system functions, as well as your own functions, to perform
various actions against the database*/

/*3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of a mediatype from the mediatype table*/

create or replace function get_current_data_time
return timestamp
is
 cr timestamp;
begin
 select current_timestamp into cr from dual;
 return cr;
end;
/

select get_current_data_time from dual;

create or replace function length_mediatype
return varchar2
is 
 lengtho number;
begin
 select length(NAME) into lengtho from mediatype;
 return lengtho;
end;
/



/*3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track*/
create or replace function avergae_total
return number
is
 aveg number;
begin
    select avg(total) into aveg from invoice;
    return aveg;
end;
/
select avg(total) from invoice;

create or replace function MostExpensiveTrack
return number
is 
 aNumber number;
begin
 select max(unitprice) as MostExpensiveTrack into aNumber from track;
 return aNumber;
end;
/
select max(unitprice) as MostExpensiveTrack 
from track;
/*3.3 User Defined Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table*/
create or replace function avginvoice
return number
is
 bNumber number;
begin
 select avg(unitprice) into bNumber from invoiceline;
 return bNumber;
end;
/

select avg(unitprice) from invoiceline;
/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.*/
create or replace function employeebirth
return number
is
 namel number;
begin
 select employeedid into name1 from employee where birthdate > '01/jan/1968';
 return name1;
end;
/

select employeeid
from employee
where birthdate > '01/jan/1968';
/*4.0 Stored Procedures
In this section you will be creating and executing stored procedures. You will be creating various types
of stored procedures that take input and output parameters.*/

/*4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.*/
CREATE OR REPLACE PROCEDURE SELECT_NAMES
(FIRST_NAME out SYS_REFCURSOR)
AS
BEGIN
OPEN FIRST_NAME FOR
 SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
execute select_name;



/*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.*/
create or replace procedure update_info
(FN in fn, LASTNAME in ln)
AS
Begin
 update employee set firstname = fn, lastname = ln;
end;
/

select employeeid from employee where title = 'General Manager' and title = 'IT Manager';
/*4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.*/
CREATE OR REPLACE PROCEDURE NAME_COMPANY
(CD IN NUMBER, DUAL SYS_REFCURSOR )
AS
BEGIN
 SELECT FIRSTNAME, LASTNAME, COMPANY into dual FROM CUSTOMER WHERE CUSTOMERID = CD;
END;
/

/*5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored
procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
table*/


CREATE OR REPLACE PROCEDURE DELETE_INVOICE
(INVID IN NUMBER)
AS
 BEGIN
  DELETE FROM INVOICELINE WHERE INVOICE = INVID;
  DELETE FROM INVOICE WHERE INVOICEID = INVID;
  COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE NEW_RECORD
(CD IN NUMBER, FN IN VARCHAR2, LN IN VARCHAR2, CP IN VARCHAR2, AD IN VARCHAR2, CY IN VARCHAR2, ST IN VARCHAR2, CT IN VARCHAR2, PC IN VARCHAR2, PH IN VARCHAR2, FX IN VARCHAR2, EL IN VARCHAR2, SIP IN NUMBER)
AS
BEGIN
 INSERT INTO CUSTOMER VALUES(CD, FN, LN, CP, AD, CY, ST, CT, PC, PH, FX, EL, SIP);
 COMMIT;
END;
/


--SQL Work Book
--Copyright © Revature Page 5

/*6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are
executed on a table.*/

/*6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
table.*/
CREATE OR REPLACE TRIGGER employee_table
AFTER UPDATE ON Employee
FOR EACH ROW
WHEN (new.employeeid > 1)
BEGIN
    INSERT INTO Employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
       VALUES (:new.employeeid, :new.lastname, :new.firstname, :new.title, :new.reportsto, :new.birthdate, :new.hiredate, :new.address, :new.city, :new.state, :new.country, :new.postalcode, :new.phone, :new.fax, :new.email);
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER ALBUM_TABLE
AFTER UPDATE ON ALBUM
FOR EACH ROW
WHEN(NEW.ALBUM > 1)
BEGIN
    INSERT INTO ALBUM(ALBUMID, TITLE, ARTISTID)
    VALUES(:NEW.ALBUMID, :NEW.TITLE, :NEW.ARTISTID);
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.*/
CREATE OR REPLACE TRIGGER DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
DECLARE CUSTOMERID NUMBER(10);
BEGIN
    DELETE FROM CUSTOMER WHERE CUSTOMERID = 1;
END;
/
/*7.0 JOINS
In this section you will be working with combing various tables through the use of joins. You will work
with outer, inner, right, left, cross, and self joins.*/

/*7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and
the invoiceId.*/
select cr.firstname, cr.lastname, il.invoiceId
from customer cr
join invoice il
on cr.customerid = il.customerid;

/*7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
firstname, lastname, invoiceId, and total.*/

select cr.customerid, cr.firstname, cr.lastname, iv.invoiceid, iv.total
from customer cr
join invoice iv
on cr.customerid = iv.customerid;


/*7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.*/
select ar.name, al.title
from artist ar
right join album al
on ar.artistId = al.artistid;

/*7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.*/
select ar.name, al.title
from artist ar
cross join album al
order by ar.name;
/*7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.*/
select e1.lastname as employee, e1.title, e2.lastname as managaer
from employee e1
full join employee e2
on e1.reportsto = e2.employeeid;

/*7.6 Complicated Join assignment
Create an inner join between all tables in the chinook database.*/
select tr.name, i.total, c.firstname, e.employeeid, g.genreid, mt.mediatypeid, a.title, at.name, pt.playlistid, play.playlistid
from track tr
join invoiceline il on tr.trackid = il.trackid
join invoice i on i.invoiceid = il.invoiceid
join customer c on c.customerid = i.customerid
join employee e on e.employeeid = c.supportrepid
join genre g on g.genreid = tr.genreid
join mediatype mt on mt.mediatypeid = tr.mediatypeid
join album a on a.albumid = tr.albumid
join artist at on at.artistid = a.artistid
join playlisttrack pt on pt.playlistid = tr.trackid
join playlist play on play.playlistid = pt.playlistid
order by a.title;
/*9.0 Administration
In this section you will be creating backup files of your database. After you create the backup file you
will also restore the database.
Task – Create a .bak file for the Chinook database*/
