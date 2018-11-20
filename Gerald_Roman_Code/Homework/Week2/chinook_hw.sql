/*
Gerald Roman  Week 2 Assignment

*/


--2.1
--Task Select all records from the Employee table
SELECT * FROM EMPLOYEE;

--Task Select all records from the Employee table where last name is King
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

--Task Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' and REPORTSTO IS NULL;

--2.2
--Task Select all albums in Album table and sort result set in descending order by title
SELECT * FROM ALBUM ORDER BY TITLE DESC;

--Task Select first name from Customer and sort result set in ascending order by city
SELECT * FROM CUSTOMER ORDER BY CITY ASC;

--2.3
--Task Insert two new records into Genre table
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Disco');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Techno');

--Task Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES(9, 'Gerald', 'Roman', 'IT Staff', 6, TO_DATE('1996-12-20 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-1-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), '9872 Columbia Boulevard West', 'Lethbridge', 'AB', 'Canada', 'T1K 5N8', '+1 (403) 555-1234', '+1 (403) 555-4567', 'gerald@coolemail.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'CoolName', 'OtherName', 'IT Staff', 6, TO_DATE('1898-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2005-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 555-5698', '+1 (403) 555-1234', 'FirstLast@gmail.com');


--Task Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60,'Gerald','Roman','Revature	11730 Plaza America Dr #205','Reston','VA','United States','12227-000','+55 (12) 1234-5555','+55 (12) 3923-5566','coolemailname@embraer.com.br',	3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61,	'Raymon',	'Simmons','Revature',	'11730 Plaza America Dr #205',	'Reston',	'VA',	'United States',	'12227-000',	'+55 (12) 5555-5555',	'+(1) 3923-5566',	'secondemail@embraer.com.br',3);

--2.4
--Task Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task Update name of artist in the Artist table "Creedence Clearwater Revival" to "CRR"
UPDATE ARTIST SET NAME ='CCR' where name = 'Creedence Clearwater Revival';

--2.5
--Task Select all invoices with a billing address like "T%"
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';


--2.6
--Task Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

--Task Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('2003-6-1','yyyy-mm-dd') AND TO_DATE('2004-3-1','yyyy-mm-dd');

--2.7
--Task Delete a record in Customer table where the name is Robert Walter
ALTER TABLE CUSTOMER
DROP CONSTRAINT ;

DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.1
--Task Create a function that returns the current time
select sysdate from dual;

select * from customer;
CREATE OR REPLACE FUNCTION FINDDATE

RETURN NUMBER;

--3.2
--Task Create a function that returns the average total of all invoices

CREATE OR REPLACE FUNCTION AVG_INVOICE
  RETURN NUMBER     
IS
  AVERAGE NUMBER(5,4);
BEGIN
  SELECT AVG(TOTAL) INTO AVERAGE FROM INVOICE;
  RETURN average;
END;
/

--Task Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) FROM TRACK;

CREATE OR REPLACE FUNCTION MOST_EXP
RETURN NUMBER
IS
MAX NUMBER(5,4)
BEGIN 
SELECT MAX(UNITPRICE) INTO MAX FROM TRACK;
RETURN MAX;
END;
/

SELECT MOST_EXP() FROM DUAL;

--3.3
--Task Create a function that  returns the average price of invoiceline items in the invoiceline table
select AVG(UNITPRICE) from invoiceline;


CREATE OR REPLACE FUNCTION AVG_INV
RETURN NUMBER
IS
AVERAGE NUMBER(5,4);
BEGIN
SELECT AVG(UNITPRICE) FROM INVOICELINE;
RETURN AVERAGE;
END;
/

--3.4
--Task Create a function that return all employees who are born after 1968
CREATE OR REPLACE FUNCTION EMP_BD
RETURN NUMBER
IS
BD
BEGIN
SELECT * FROM EMPLOYEE WHERE BIRTHDATE > TO_DATE('1968-01-01','yyyy-mm-dd');
RETURN BD;
END;
/
SELECT EMP_BD() FROM DUAL;


--4.1
--Task Create a stored procedure that selects the first and last names of all the employees

CREATE OR REPLACE PROCEDUE FIRST_LAST_NAME
AS
BEGIN
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

--4.2
--Task Create a stored procedure that updates the personal information of an employee
SELECT * FROM EMPLOYEE;
CREATE OR REPLACE PROCEDUE UPDATE_EMPLOYEE(ID IN NUMBER, FN IN VARCHAR2, LN IN VARCHAR2,TL IN VARCHAR2)
AS
UPDATE TABLE EMPLOYEE
SET FIRSTNAME = FN, LASTNAME = LN, TITLE = TL
WHERE EMPLOYEEID = ID;
COMMIT;
END;
/


--Task Create a stored procedure that returns the managers of an employee

--4.3
--Task Create a stored proccedure that returns the name and company of a customer
CREATE OR REPLACE PROCEDURE COMP_NAME
(ID IN NUMBER, CURS OUT SYS_REFCURSOR)
AS
BEGIN
OPEN CURS FOR
SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER
WHERE CUSTOMERID = ID;
END;
/

--5.0
--Task Create a transaction that given an invoiceld will delete that invoice
CREATE OR REPLACE PROCEDURE DEL_INV(INVID IN NUMBER)
AS
BEGIN
  DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
  DELETE FROM INVOICE WHERE INVOICEID = INVID;
COMMIT;
END;
/
execute delete_invoice(240);
--Task Create a transaction nested within a stored procedure that inserts a new record in the customer table

--6.1
--Task Create an after insert trigger on the employee table fired after a new record in inserted into the table
CREATE OR REPLACE TRIGGER NEW_EMP
BEFORE INSERT
ON EMPLOYEE
FOR EACH ROW
BEGIN 
  DBMS_OUTPUT.PUT_LINE('INSERT CUSTOMER');
END;
/

--Task Create an after update trigger on the album that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPD_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('UPDATED CUSTOMER');
END;
/

--Task Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER DEL_CUST
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('DELETED CUSTOMER');
END;
/
--7.1
--Task Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceID
SELECT NAME181
FROM CUSTOMER C, ORDERS O
INNER JOIN
--7.2
--Task Create an outer join that joins the customer and invoice table, specifying the customerId, firstname, last name, invoice, and total
SELECT C.CUSTOMERID,C.FIRSTNAME,C.LASTNAME,INV.INVOICEID, INV.TOTAL
FROM CUSTOMER C
FULL OUTER JOIN INVOICE INV
ON C.CUSTOMERID = INV.CUSTOMERID
ORDER BY C.FIRSTNAME;
--7.3
--Task Create a right join that joins album and artist specifying artist name and title
SELECT AR.NAME,AL.TITLE
FROM ALBUM AL
RIGHT JOIN ARTIST AR
ON AL.ARSTISTID = AR.ARTISTID
ORDER BY AR.NAME;


--7.4
--Task Create a cross join that joins album and artist and sort by artist name is ascending order
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
CROSS JOIN ARTIST 
ORDER BY ARTIST.NAME;
--7.5
--Task Perform a self-join on the employee table, joining on the reportsto column
SELECT EM1.FIRSTNAME, EM2.FIRSTNAME
FROM EMPLOYEE EM1
LEFT JOIN EMPLOYEE EM2
ON EM1.REPORTSTO = EM2.EMPLOYEEID;
--7.6
--Create an inner join between all tables in the chinook database
SELECT * FROM ALBUM;
SELECT * FROM TRACK;
SELECT * FROM ARTIST;


SELECT AL.TITLE,T.NAME,AR.NAME,G.NAME,PLT.NAME,E.FIRSNAME
FROM PLAYLIST
JOIN ALBUM AL ON TRACK.ALBUMID = AL.ALBUMID
JOIN ARTIST AR ON AL.ARTISTID = AR.ARTISTID
JOIN TRACK T ON T.ALBUMID = AL.ALBUMID
JOIN MEDIATYPE MT ON T.MEDIATYPE = T.TRACK
JOIN GENRE G ON G.GENREID = AL.GENREID
JOIN INVOICE INV ON INVOICELINE.INVOICEID = INV.INVOICEID
JOIN CUSTOMER C ON C.CUSTOMERID = INV.CUSTOMERID
JOIN EMPLOYEE E ON C.SUPPORTREID = E.EMPLOYEEID
JOIN PLAYLISTTRACK PLT ON T.TRACKID = PLT.TRACKID;




