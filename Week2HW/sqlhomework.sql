/*
* Thien Le Week 2 Assignment
*/


------------------------2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * from Employee;

--Task - Select all records from the Employee table where last name is King
select * from employee where lastname = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where firstname = 'Andrew' and REPORTSTO is null;

----------------------2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.

select * from album 
order by title desc;

--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer
order by city;

---------------------2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre VALUES (50, 'country');
insert into genre values (29, 'rock');

--Task – Insert two new records into Employee table
select * from employee where lastname like 'A%';

insert into employee values (9, 'Smith', 'John', 'IT', null, '31-DEC-50', '31-OCT-60', '124 ABC Ave', 'San Jose', 'CA', 'USA',
'83434', '703-343-4324', '703-343-3422', 'dga@gmail.com');

insert into employee values (10, 'Smith', 'John', 'Business', null, '31-DEC-50', '31-OCT-60', '124 ABC Ave', 'San Jose', 'CA', 'USA',
'83434', '703-343-4324', '703-343-3422', 'dga@gmail.com');

--Task – Insert two new records into Customer table
select * from customer;
insert into customer values (60,'Mary','John',null,'Av. Brigadeiro Faria Lima, 2170',null, 'Campos','SP','Brazil','12227',
'+55 (12) 3923-5555','+55 (12) 3923-5566','@gmail.com');	3


-------------------------------2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer 
set lastname = 'Walter', firstname = 'Robert'
where customerid = 32;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist
set name = 'CCR'
where name like 'Creedence%';

---------------------------------2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';

---------------------------------2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

----------------------------------2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).


delete from invoiceline where invoiceid in (select invoiceid from invoice where customerid in (select customerid from customer where firstname = 'Robert' and lastname = 'Walter'));
delete from invoice where customerid in (select customerid from customer where firstname = 'Robert' and lastname = 'Walter');
delete from customer where firstname = 'Robert' and lastname = 'Walter';


----------------------3.1 System Defined Functions
--Task – Create a function that returns the current time.
select systimestamp from dual;
select to_char(current_date, 'DD-MON-YYYY HH:MI:SS') from dual;

--Task – create a function that returns the length of a mediatype from the mediatype table
select length(name) from mediatype;

-----------------------3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
select avg(total) from invoice;

--Task – Create a function that returns the most expensive track
select max(unitprice) from track;

-----------------------3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select avg(unitprice) from invoiceline;

create or replace function INVOICELINE_AVG_PRICE
return number
is
   average number(3,2);
begin
    select avg(unitprice) into average from invoiceline;
    return average;
end;
/

select invoiceline_avg_price() from dual;
-----------------------3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
create or replace function EMPLOYEE_BIRTHDATE
RETURN sys_refcursor
as
 emp_list sys_refcursor;
 begin
 open emp_list for
    select * from employee where birthdate > date '1968-12-31';
    return emp_list;
  end;
/



select employee_birthdate from dual;


----------------------------------4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
----------------------------------4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

create or replace function EMPLOYEE_FIRST_LAST
RETURN sys_refcursor
as
 emp_list sys_refcursor;
 begin
 open emp_list for
    select firstname, lastname from employee;
    return emp_list;
  end;
/

create or replace procedure employee_first_last_procedure
(emp_list OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN emp_list FOR
      select firstname, lastname from employee;
      
END;
/

select employee_first_last_procedure() from dual;

select employee_first_last() from dual;

-------------------------4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure  update_employee (empid in number)
as
begin
   
   update employee
   set firstname = 'John', lastname = 'Smith'
   where employeeid = empid;
   commit;
   
end;
/

select update_employee(4) from dual;

--Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure manager_list
(manager_name OUT SYS_REFCURSOR)
as
begin
 open manager_name FOR
    select lastname from employee where reportsto = null;
end;
/

select manager_list() from dual;

-------------------------4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

create or replace procedure name_comp_customer
(customer_cursor OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN customer_cursor FOR 
    select firstname, company from customer;
    
END;
/


--------------------------5.0 Transactions
---In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure delete_invoice(invid in number)
as
begin
    
    delete from invoiceline where invoiceid in (select invoiceid from invoice where invoiceid = invid);
  commit;
end;
/

execute delete_invoice(240);



--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure insert_customer
as
begin
   insert into customer(customerid, firstname, lastname, email) values(60, 'John', 'Smith', 'johnsmith@gmail.com');
   commit;
end;
/

--------------------------6.0 Triggers
---------In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
---------6.1 AFTER/FOR
--------Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger new_emp
after insert of newemp on employee
for each row
begin
insert into
new_emp_table(employeeid, firstname, lastname, title, hiredate)
values (new.employeeid, :new.firstname, :new.lastname, :new.title, :new.hiredate)
end;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

create or replace trigger 
after insert on genre
for each row
begin
    DBMS_OUTPUT.put_line("Added genre");
end;
/
-----------------------------------7.0 JOINS
--------------------In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--------7.1 INNER
--------Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c.firstname as "Customer name", i.invoiceid
from customer c
join invoice i
on c.customerid = i.customerid;

----7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c
full join invoice i
on c.customerid = i.customerid;

---------------7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select ar.name as "artist name", al.title as "Title"
from album al
right join artist ar
on al.artistid = ar.artistid;

-------------7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select e1.lastname as Manager, e2.lastname as EMPLOYEE
from employee e1, employee e2;

select al.title as Title, ar.name as Name
from album al, artist ar
order by ar.name;


---------------7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select e1.lastname as EMPLOYEE, e2.lastname as MANAGER
from employee e1
join employee e2
on e1.reportsto = e2.employeeid;


--7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database.
select  art.name as ARTIST, al.title AS "ALBUM TITLE", t.name as SONG, g.name as GENRE, 
pl.name as PLAYLIST, e.LASTNAME
from album al
join artist art on al.artistid = art.ARTISTID
join track t on t.ALBUMID = al.ALBUMID
join genre g on g.genreid = t.genreid
join mediatype mt on mt.MEDIATYPEID = t.MEDIATYPEID
join playlisttrack plt on plt.trackid = t.trackid 
join playlist pl on plt.playlistid = pl.PLAYLISTID
join invoiceline inl on inl.TRACKID = t.trackid
join invoice inv on inv.INVOICEID = inl.INVOICEID
join customer c on c.customerid = inv.CUSTOMERID
join employee e on c.SUPPORTREPID = e.employeeid
order by art.name;

-------------9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
--Task – Create a .bak file for the Chinook database


