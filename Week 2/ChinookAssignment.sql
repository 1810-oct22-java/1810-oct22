--- 2.1 SELECT ---

-- Task – Select all records from the Employee table.
    SELECT * 
    FROM Employee;

-- Task – Select all records from the Employee table where last name is King.
    SELECT * 
    FROM Employee WHERE lastname = 'King';
    
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
    SELECT * 
    FROM Employee 
    WHERE firstname = 'Andrew' AND reportsto = NULL;
    
-- 2.2 ORDER BY -- 

-- Task – Select all albums in Album table and sort result set in descending order by title.
    SELECT * 
    FROM Album 
    ORDER BY TITLE DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
    SELECT * 
    FROM Customer
    ORDER BY CITY ASC;

-- 2.3 INSERT INTO -- 

-- Task – Insert two new records into Genre table
	INSERT INTO GENRE (GenreID, Name) 
	VALUES (26, 'EDM');
	
	INSERT INTO GENRE (GenreID, Name) 
	VALUES (27, 'MUSICAL THEATRE');

-- Task – Insert two new records into Employee table
	INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
	VALUES (9, 'Doe', 'John', 'IT Staff', 6, 
	TO_DATE('1996-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
	TO_DATE('2018-10-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
	'12197 Sunset Hills Rd', 'Reston', 'VA', 'United States', '20190', '+1 (703) 478-0770', '+1 (703) 478-0770', 'john.doe@gmail.com');
	
	INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
	VALUES (10, 'Doe', 'Jane', 'IT Staff', 6, 
	TO_DATE('1995-7-20 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
	TO_DATE('2018-10-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
	'12160 Sunset Hills Rd', 'Reston', 'VA', 'United States', '20190', '+1 (571) 203-1234', '+1 (571) 203-1234', 'jane.doe@gmail.com');

-- Task – Insert two new records into Customer table
    INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
    VALUES (60, 'John', 'Doe', '12197 Sunset Hills Rd', 'Reston', 'United States', '20190', '+1 (703) 478-0770', 'john.doe@gmail.com', 3);
    
    INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
    VALUES (61, 'Jane', 'Doe', '12160 Sunset Hills Rd', 'Reston', 'United States', '20190', '+1 (571) 203-1234', 'jane.doe@gmail.com', 3);

-- 2.4 UPDATE -- 

-- Task – Update Aaron Mitchell in Customer table to Robert Walter
    UPDATE CUSTOMER
    SET FirstName = 'Robert', LastName = 'Walter'
    WHERE CustomerId = 32;

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
    UPDATE ARTIST
    SET Name = 'CCR'
    WHERE Name = 'Creedence Clearwater Revival';
    
-- 2.5 LIKE -- 

-- Task – Select all invoices with a billing address like “T%”
    SELECT *
    FROM INVOICE 
    WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN -- 

-- Task – Select all invoices that have a total between 15 and 50
    SELECT *
    FROM INVOICE
    WHERE TOTAL BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
    SELECT *
    FROM EMPLOYEE
    WHERE HIREDATE BETWEEN TO_DATE('2003-6-1 00:00:00', 'yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00', 'yyyy-mm-dd hh24:mi:ss'); 
    
-- 2.7 DELETE -- 

-- ***** Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
        
    DELETE FROM INVOICELINE WHERE INVOICEID IN 
    (SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN 
    (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
    
    DELETE FROM INVOICE WHERE CUSTOMERID IN(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
    
    DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
    SELECT * FROM CUSTOMER;
    
-- 3.1 System Defined Functions

-- Task – Create a function that returns the current time.
 

-- Task – create a function that returns the length of a mediatype from the mediatype table
    
    CREATE OR REPLACE FUNCTION GET_LENGTH
    (MEDIANAMES IN VARCHAR2)
    RETURN NUMBER
    AS
        LENGTHM NUMBER;
    BEGIN
        SELECT LENGTH(MEDIANAMES) INTO LENGTHM
        FROM MEDIATYPE
        WHERE NAME = MEDIANAMES;
        RETURN LENGTHM; 
    END;
    /
    --TEST METHOD
    SELECT GET_LENGTH('MPEG audio file') FROM DUAL; 

-- 3.2 System Defined Aggregate Functions

-- Task – Create a function that returns the average total of all invoices
    CREATE OR REPLACE FUNCTION AVERAGE_INV
    RETURN NUMBER
    AS -- IS/AS -- define type of return value
    AVG_INV NUMBER;
    BEGIN --begin function code
        SELECT AVG(TOTAL)
        INTO AVG_INV 
        FROM INVOICE;
    RETURN AVG_INV;
    END;
    /
    
    --TEST METHOD
    SELECT AVERAGE_INV FROM DUAL;
    
-- Task – Create a function that returns the most expensive track
    CREATE OR REPLACE FUNCTION EXP_TRACK
    RETURN NUMBER
    AS -- IS/AS -- define type of return value
    TRACK_VAL NUMBER;
    BEGIN --begin function code
        SELECT MAX(UNITPRICE)
        INTO TRACK_VAL
        FROM TRACK;
    RETURN TRACK_VAL;
    END;
    /

    --TEST METHOD
    SELECT EXP_TRACK FROM DUAL;

-- 3.3 User Defined Functions

-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
    CREATE OR REPLACE FUNCTION AVERAGE_INVLINE
    RETURN NUMBER
    AS -- IS/AS -- define type of return value
    AVG_INVLINE NUMBER;
    BEGIN -- begin function code
        SELECT AVG(UNITPRICE) 
        INTO AVG_INVLINE
        FROM INVOICELINE;
    RETURN AVG_INVLINE;
    END;
    /

    --TEST METHOD
    SELECT AVERAGE_INVLINE FROM DUAL;

-- 3.4 User Defined Table Valued Functions

-- Task – Create a function that returns all employees who are born after 1968.
    CREATE OR REPLACE FUNCTION BORN_AFTER
    RETURN SYS_REFCURSOR
    IS
    AFTER68 SYS_REFCURSOR;
    BEGIN
    OPEN AFTER68 FOR
        SELECT *
        FROM EMPLOYEE
        WHERE BIRTHDATE > TO_DATE('1968-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss');
    RETURN AFTER68;
    END;
    /

    SELECT BORN_AFTER FROM DUAL;
    
--    SELECT *
--    FROM EMPLOYEE
--    WHERE BIRTHDATE > TO_DATE('1968-12-31 00:00:00', 'yyyy-mm-dd hh24:mi:ss');

-- 4.0 Stored Procedures

-- In this section you will be creating and executing stored procedures. 
-- You will be creating various types of stored procedures that take input and output parameters.
    
-- 4.1 Basic Stored Procedure

-- Task – Create a stored procedure that selects the first and last names of all the employees.
    CREATE OR REPLACE PROCEDURE ALL_EMPLOYEES
    (NAME_CURSOR OUT SYS_REFCURSOR)
    AS 
    BEGIN
    OPEN 
        NAME_CURSOR FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
    END;
    /
    

-- 4.2 Stored Procedure Input Parameters

-- Task – Create a stored procedure that updates the personal information of an employee.
    CREATE OR REPLACE PROCEDURE ALL_EMPLOYEES
    (NAME_CURSOR OUT SYS_REFCURSOR)
    AS 
    BEGIN
    OPEN 
        NAME_CURSOR FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
    END;
    /
    
-- Task – Create a stored procedure that returns the managers of an employee.
    CREATE OR REPLACE PROCEDURE ALL_MANAGERS
    (MANAGERS OUT SYS_REFCURSOR)
    AS 
    BEGIN
    OPEN 
        MANAGERS FOR
        SELECT REPORTSTO FROM EMPLOYEE;
    END;
    /
    
-- 4.3 Stored Procedure Output Parameters

-- Task – Create a stored procedure that returns the name and company of a customer.
    CREATE OR REPLACE PROCEDURE ALL_MANAGERS
    (CUST_NAME_COMP OUT SYS_REFCURSOR)
    AS 
    BEGIN
    OPEN 
        CUST_NAME_COMP FOR
        SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER;
    END;
    /

-- 5.0 Transactions

-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
    CREATE OR REPLACE PROCEDURE DELETE_INVOICE
    (INVID NUMBER)
    AS
    BEGIN
        DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
        DELETE FROM INVOICE WHERE INVOICEID = INVID;
        COMMIT;
    END;
    /
    
    -- EXECUTE METHOD
    EXECUTE DELETE_INVOICE(239);
    
    
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
    CREATE OR REPLACE PROCEDURE NEW_RECORD
    (INVID NUMBER)
    AS
    BEGIN
        DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
        DELETE FROM INVOICE WHERE INVOICEID = INVID;
        COMMIT;
    END;
    /

-- 6.1 AFTER/FOR

-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
    CREATE OR REPLACE TRIGGER EMPLOYEE_FIRED
    AFTER INSERT ON BANK_USERS
    FOR EACH ROW 
    BEGIN
        SELECT BANK_USERS_SEQ.NEXTVAL INTO: NEW.USER_ID FROM DUAL;
    END;
    /
    
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.


-- 7.0 JOINS

-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

-- 7.1 INNER


-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
    SELECT FIRSTNAME, LASTNAME, INVOICEID
    FROM CUSTOMER
    INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- 7.2 OUTER

-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
    SELECT CUSTOMER.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL
    FROM CUSTOMER
    FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- 7.3 RIGHT

-- Task – Create a right join that joins album and artist specifying artist name and title.
    SELECT NAME, TITLE
    FROM ALBUM
    RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

-- 7.4 CROSS

-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
    SELECT * 
    FROM ARTIST 
    CROSS JOIN ALBUM
    ORDER BY NAME ASC;

-- 7.5 SELF

-- Task – Perform a self-join on the employee table, joining on the reportsto column.
    SELECT *
    FROM EMPLOYEE A, EMPLOYEE B
    WHERE A.REPORTSTO <> B.REPORTSTO;

-- 7.6 Complicated Join assignment

-- Create an inner join between all tables in the chinook database.
    SELECT ART.NAME as ARTIST, AL.TITLE AS "ALBUM TITLE", T.NAME AS SONG, G.NAME AS GENRE, 
    PL.NAME AS PLAYLIST, E.LASTNAME
    FROM ALBUM AL
    JOIN ARTIST ART ON AL.ARTISTID = ART.ARTISTID
    JOIN TRACK T ON T.ALBUMID = AL.ALBUMID
    JOIN GENRE G ON G.GENREID = T.GENREID
    JOIN MEDIATYPE MT ON MT.MEDIATYPEID = T.MEDIATYPEID
    JOIN PLAYLISTTRACK PLT ON PLT.TRACKID = T.TRACKID 
    JOIN PLAYLIST PL ON PLT.PLAYLISTID = PL.PLAYLISTID
    JOIN INVOICELINE INL ON INL.TRACKID = T.TRACKID
    JOIN INVOICE INV ON INV.INVOICEID = INL.INVOICEID
    JOIN CUSTOMER C ON C.CUSTOMERID = INV.CUSTOMERID
    JOIN EMPLOYEE E on C.SUPPORTREPID = E.EMPLOYEEID
    ORDER BY ART.NAME;
