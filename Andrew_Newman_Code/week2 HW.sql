/*
* Andrew Newman Week 2 Assignment
*/


------------------------2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * from Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;


2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * from Album ORDER BY title DESC;

Task – Select first name from Customer and sort result set in ascending order by city
SELECT FirstName from Customer ORDER BY city;


2.3 INSERT INTO
Task – Insert two new records into Genre table
INSERT INTO Genre (GenreID,Name) VALUES (26, something);
INSERT INTO Genre (GenreID,Name) VALUES (27, othersomething);

Task – Insert two new records into Employee table
INSERT INTO Employee (EmployeeId,LastName,FirstName,Title,ReportsTo,BirthDate,HireDate,Address,City,State,Country,PostalCode,Phone,Fax,Email) VALUES (0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
INSERT INTO Employee (EmployeeId,LastName,FirstName,Title,ReportsTo,BirthDate,HireDate,Address,City,State,Country,PostalCode,Phone,Fax,Email) VALUES (1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);

Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId,LastName,FirstName,Company,Address,City,State,Country,PostalCode,Phone,Fax,Email,SupportRepId) VALUES (0,0,0,0,0,0,0,0,0,0,0,0,0);
INSERT INTO Customer (CustomerId,LastName,FirstName,Company,Address,City,State,Country,PostalCode,Phone,Fax,Email,SupportRepId) VALUES (1,1,1,1,1,1,1,1,1,1,1,1,1);

2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron', LastName = 'Mitchell';

Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';


2.5 LIKE

Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoices WHERE billingaddress LIKE 'T%';


2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoices WHERE total BETWEEN 15 AND 50;

Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE HireDate BETWEEN #06/1/2003# AND #03/1/2004#;


2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM invoiceLine WHERE invoiceid = (
SELECT invoiceid FROM invoice WHERE customerid = (
SELECT customerid FROM Customer WHERE FirstName='Robert' LastName = 'Walter'));
DELETE FROM invoice WHERE customerid = (
SELECT customerid FROM Customer WHERE FirstName='Robert' LastName = 'Walter');
DELETE FROM Customer WHERE FirstName='Robert' LastName = 'Walter';


3.0 SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

3.1 System Defined Functions
Task – Create a function that returns the current time.
SELECT GETDATE() AS CurrentDateTime

Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH('AAC audio file') FROM mediatype;


3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
SELECT AVG(total) FROM invoice;

Task – Create a function that returns the most expensive track
SELECT MAX(unitprice) FROM track;


3.3 User Defined Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE or REPLACE FUNCTION Avg_Price()
RETURNS NUMBER(10,2)
AS
   BEGIN
		RETURN(SELECT AVG(UnitPrice) FROM invoiceLine)
   END

   
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
create or replace function youngEmployees() 
return * 
is
	EmployeeData
begin
    SELECT *  INTO EmployeeData FROM employee WHERE BirthDate > #12/31/1968#
  return EmployeeData;
end;
/


4.0 Stored Procedures
In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE SelectCustomerNames
AS
SELECT FirstName, LastName FROM Customer
GO;


4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee(
      emID IN NUMBER)
  AS
  BEGIN
    UPDATE employee SET FirstName = 'Robert' WHERE employeeID = emID; 
	COMMIT;
  END;
/

Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE FUNCTION employee_managers
(employee_NAME IN VARCHAR2)
RETURN SYS_REFCURSOR
AS
manager_LIST SYS_REFCURSOR;
  BEGIN
  OPEN manager_LIST FOR 
    select e1.employeeid as EMPLOYEE, e2.employeeid as MANAGER
		from employee e1
		right join employee e2
		on e1.reportsto = e2.employeeid;
      RETURN manager_LIST;
  END;

4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
create or replace PROCEDURE customer_info
(cust_cursor OUT SYS_REFCURSOR)
AS
BEGIN
OPEN cust_cursor FOR select firstname,company from customer;
END;
/

5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored
procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(
      INVID IN NUMBER)
  AS
  BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
    DELETE FROM INVOICE WHERE INVOICEID = INVID;
    COMMIT;
  END;
/

Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_Cust()
  AS
  BEGIN
	INSERT INTO Customer (CustomerId,LastName,FirstName,Company,Address,City,State,Country,PostalCode,Phone,Fax,Email,SupportRepId) VALUES (0,0,0,0,0,0,0,0,0,0,0,0,0);
	COMMIT;
  END;
/


6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are
executed on a table.
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_insert 
BEFORE INSERT ON employeee
FOR EACH ROW 
BEGIN 
    SELECT employee_SEQ.NEXTVAL INTO :NEW.employee_ID FROM DUAL;
END;
/

Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_update 
AFTER UPDATE ON album
FOR EACH ROW 
BEGIN 
    SELECT SYSDATE FROM DUAL;
END;
/

Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete 
AFTER DELETE ON customer
FOR EACH ROW 
BEGIN 
    SELECT SYSDATE FROM DUAL;
END;
/

7.0 JOINS
In this section you will be working with combing various tables through the use of joins. You will work
with outer, inner, right, left, cross, and self joins.
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.Firstname, Customer.LastName, invoice.invoiceID
FROM (Orders)
INNER JOIN Customers 
ON customer.CustomerID = invoice.CustomerID)


7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.Firstname, Customer.LastName, invoice.invoiceID
FROM (Orders)
OUTER JOIN Customers 
ON customer.CustomerID = invoice.CustomerID)


7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
select a1.name as ARTIST, a2.title as ALBUM
from artist a1
right join album a2;
ORDER BY a1.name


7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select a1.name as ARTIST, a2.title as ALBUM
from artist a1, album a2;
ORDER BY a1.name


7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
select e1.employeeid as EMPLOYEE, e2.employeeid as MANAGER
from employee e1
right join employee e2
on e1.reportsto = e2.employeeid;

7.6 Complicated Join assignment
Create an inner join between all tables in the chinook database.
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


9.0 Administration
In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
Task – Create a .bak file for the Chinook database 
