--HW2

--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * from Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album ORDER BY Title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM Customer ORDER BY city ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre (GenreId, Name) VALUES (26, 'New Age');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Radiohead Only');

--Task – Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, 
Address, City, State, Country, PostalCode, Phone, Fax, Email) 
VALUES (9, 'Airey', 'Theodore', 'Trainee', TO_DATE('1996-5-10 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2018-10-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 
'T5K 2N1', '+1 (780) 429-9482', '+1 (780) 429-3457', 'ted@chinookcorp.com');

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, 
Address, City, State, Country, PostalCode, Phone, Fax, Email) 
VALUES (10, 'Meep', 'Meep', 'Trainer', TO_DATE('1492-5-10 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2018-10-21 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 
'T5K 2N1', '+1 (780) 423-9482', '+1 (780) 423-3457', 'meep@chinookcorp.com');

--Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, 
Phone, Fax, Email, SupportRepId) VALUES (60, 'Louís', 'Armstrong', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 
'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5565', 
'+55 (12) 3923-5566', 'louisa@embraer.com.br', null);

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, 
Phone, Fax, Email, SupportRepId) VALUES (61, 'Neil', 'Armstrong', 'NASA', 'Av. Brigadeiro Faria Lima, 2170', 
'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5569', '+55 (12) 3923-5569', 'luisg@embraer.com.br', null);


--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist SET Name = 'CCR' Where Name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Employee WHERE HireDate 
BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss')
AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
SELECT * FROM InvoiceLine; 

DELETE FROM InvoiceLine WHERE InvoiceID IN (SELECT InvoiceID FROM Invoice
WHERE CustomerID = (SELECT CustomerID FROM Customer 
WHERE FirstName = 'Robert' AND LastName = 'Walter'));

DELETE FROM Invoice WHERE CustomerID = (SELECT CustomerID FROM Customer 
WHERE FirstName = 'Robert' AND LastName = 'Walter');

DELETE FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter';

--3.0 SQL Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time
RETURN TIMESTAMP -- data type of return value
IS -- IS/AS -- define variable to return
 current_time TIMESTAMP;
BEGIN -- begin function code
 select CURRENT_TIMESTAMP into current_time from dual;
 return current_time;
END;
/

SELECT CURRENT_TIME FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mt_length
RETURN NUMBER -- data type of return value
IS -- IS/AS -- define variable to return
 mt_length NUMBER;
BEGIN -- begin function code
 select length(name) into mt_length from MEDIATYPE WHERE MEDIATYPEID = 1;
 return mt_length;
END;
/

SELECT mt_length FROM DUAL;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_total
RETURN NUMBER -- data type of return value
IS -- IS/AS -- define variable to return
 avg_total NUMBER(6,2);
BEGIN -- begin function code
 select avg(total) into avg_total from INVOICE;
 return avg_total;
END;
/

select avg_total from dual;

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION max_price
RETURN NUMBER -- data type of return value
IS -- IS/AS -- define variable to return
 max_price NUMBER(6,2);
BEGIN -- begin function code
 select max(unitprice) into max_price from track;
 return max_price;
END;
/

select max_price from dual;


--3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_price
RETURN NUMBER -- data type of return value
IS -- IS/AS -- define variable to return
 avg_price NUMBER(8,2);
BEGIN -- begin function code
 select avg(unitprice) into avg_price from INVOICELINE;
 return avg_price;
END;
/

select avg_price from dual;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION old_employees
RETURN SYS_REFCURSOR
IS
 young_employees SYS_REFCURSOR;
BEGIN
 OPEN young_employees FOR
 select FirstName from EMPLOYEE 
 where BIRTHDATE > TO_DATE('1968-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
 return young_employees;
END;
/

select old_employees from dual;

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE FIRST_AND_LAST (names OUT SYS_REFCURSOR)
    AS
BEGIN
    OPEN names FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE (
    EM_ID IN NUMBER, EM_FNAME IN VARCHAR2, EM_LNAME IN VARCHAR2)
    AS
BEGIN
    UPDATE EMPLOYEE SET FIRSTNAME = EM_FNAME, LASTNAME = EM_LNAME WHERE EMPLOYEEID = EM_ID;
END;
/

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE MANAGE_EMS (
    EM_ID IN NUMBER, EM_MANAGERS OUT SYS_REFCURSOR)
    AS
BEGIN
    OPEN EM_MANAGERS FOR
    SELECT LASTNAME FROM EMPLOYEE WHERE EM_ID = REPORTSTO;
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_AND_COM (
    CUST_ID IN NUMBER,CUST_NAME OUT VARCHAR2, CUST_COM OUT VARCHAR2)
    AS
BEGIN
    SELECT LASTNAME, COMPANY INTO CUST_NAME, CUST_COM FROM CUSTOMER 
    WHERE CUST_ID = CUSTOMERID;
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored
--procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE
(INVID IN NUMBER)
AS
BEGIN
 DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
 DELETE FROM INVOICE WHERE INVOICEID = INVID;
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
--table
CREATE OR REPLACE PROCEDURE INSERT_CUST
AS
BEGIN
 INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
 VALUES (60, 'Michael', 'Myers', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 
 'São José dos Campos', 'SP', 'Argentina', '12227-000', '+55 (12) 3923-6665', '+55 (12) 3823-5566', 'mm@embraer.com.br', 3);
 COMMIT;
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.
CREATE OR REPLACE TRIGGER EMPLOYEE_TRIG--Declare and name trigger
AFTER INSERT ON EMPLOYEE --when will trigger execute
FOR EACH ROW -- necessary to change value in a table
BEGIN
    --SQL statement(s) to operate when event happens
    --incrementing book seq and assigning it to a new book_id (book's pk) value
    DBMS_OUTPUT.put_line('Added Employee');
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER ALBUM_TRIG--Declare and name trigger
BEFORE INSERT ON ALBUM --when will trigger execute
FOR EACH ROW -- necessary to change value in a table
BEGIN
    --SQL statement(s) to operate when event happens
    --incrementing book seq and assigning it to a new book_id (book's pk) value
    DBMS_OUTPUT.put_line('Added Album');
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.
CREATE OR REPLACE TRIGGER CUSTOMER_TRIG--Declare and name trigger
AFTER DELETE ON CUSTOMER --when will trigger execute
FOR EACH ROW -- necessary to change value in a table
BEGIN
    --SQL statement(s) to operate when event happens
    --incrementing book seq and assigning it to a new book_id (book's pk) value
    DBMS_OUTPUT.put_line('DELETED CUSTOMER');
END;
/

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work
--with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT i.invoiceid, c.LastName as "CUSTOMER NAME"
FROM Invoice i
inner JOIN customer c on c.customerid = i.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
SELECT c.FirstName, c.LastName, c.customerid, i.invoiceid, i.total
FROM Invoice i
full outer JOIN customer c on c.customerid = i.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT art.name, al.title
FROM artist art
right JOIN album al on art.artistid = al.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM Album, Artist
ORDER BY Artist.NAME;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT e1.lastname as EMPLOYEE, e2.lastname as MANAGER
FROM employee e1
JOIN employee e2 ON e1.reportsto = e2.employeeid;

--7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database.
SELECT art.name AS ARTIST, al.title AS "ALBUM TITLE", t.name as SONG, g.name as GENRE,
m.name as MEDIATYPE, pt.playlistid as "PLAYLIST ID", p.name AS "Playlist", il.invoiceid as "INVOICE ID",
i.invoicedate as "INVOICE DATE", c.lastname AS "CUSTOMER NAME", e.lastname AS "EMPLOYEE NAME"
FROM album al
JOIN artist art on al.artistid = art.ARTISTID
JOIN track t on t.albumid = al.albumid
JOIN genre g on g.genreid = t.genreid
JOIN mediatype m on m.mediatypeid = t.mediatypeid
JOIN playlisttrack pt on pt.trackid = t.trackid
JOIN playlist p on p.playlistid = pt.playlistid
JOIN invoiceline il on il.trackid = t.trackid
JOIN invoice i on i.invoiceid = il.invoiceid
JOIN customer c on c.customerid = i.customerid
JOIN employee e on e.employeeid = c.supportrepid
ORDER BY art.name;
