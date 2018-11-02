--FUNCTIONS
/*
- executable blocks of code that take in 0 or more parameters and must return 1 value
- we cannot perform full DML statements only DQL
- typically used to perform some sort of mathematical "function" on data and return output

*/

SELECT * FROM INVOICELINE;

--Ex. 1 -- find avg unit price from invoiceline table

CREATE OR REPLACE FUNCTION INV_LINE_PRICE_AVG -- create [or replace] function [functionName]
RETURN NUMBER -- data type of return value
IS -- IS/AS -- define variable to return
 AVERAGE NUMBER(3,2);
BEGIN -- begin function code
 select avg(unitprice) into average from INVOICELINE;
 return average;
END;
/

SELECT inv_line_price_avg() FROM dual;

SELECT count(trackid) from track where genreid =
(SELECT genreid from genre where name = 'Rock');

SELECT g.name, count(t.name)
from track t
join genre g
on g.genreid = t.genreid
where g.name = 'Rock'
group by g.name;

--Ex 2. find number of books by genre title

CREATE OR REPLACE FUNCTION num_books_by_genre
(gtitle IN varchar2)
return number
AS 
 total number;
begin
 select count(book_id) into total from bn_book where genre = (
 select genre_id from bn_genre where name = gtitle);
 return total;
end;
/

select num_books_by_genre('History') from dual;

SELECT * FROM BN_BOOK;

SELECT * FROM BN_GENRE;

--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION old_employees
RETURN VARCHAR2 -- data type of return value
IS -- IS/AS -- define variable to return
 all_employees VARCHAR2(36);
BEGIN -- begin function code
 select FirstName into all_employees from EMPLOYEE 
 where BIRTHDATE > TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
 return all_employees;
END;
/

select old_employees from dual;

SELECT * FROM INVOICE;

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

SELECT * FROM BN_BOOK;

--HW?

CREATE OR REPLACE FUNCTION TESTY
RETURN NUMBER
IS -- IS/AS -- define type of return value
return_val NUMBER;
BEGIN --begin function code
   SELECT TOTAL into return_val FROM (SELECT * FROM INVOICE ORDER BY INVOICE.TOTAL DESC) WHERE ROWNUM = 1;
   return return_val;
END;
/

SELECT testy() from dual;


-- STORED PROCEDURES

--Transactional Procedure
CREATE OR REPLACE PROCEDURE DELETE_INVOICE
(INVID IN NUMBER)
AS
BEGIN
 DELETE FROM INVOICELINE WHERE INVOICEID = INVID;
 DELETE FROM INVOICE WHERE INVOICEID = INVID;
 COMMIT;
END;
/
EXECUTE DELETE_INVOICE(240);

SELECT * FROM INVOICE WHERE INVOICEID = 240;

SELECT * FROM INVOICELINE WHERE INVOICEID = 240;

-- EXPLORING CURSORS
--use IN when returning more than one thing

CREATE OR REPLACE PROCEDURE SONGS_BY_ARTIST (
    ARTIST_NAME IN VARCHAR2,SONG_LIST OUT SYS_REFCURSOR)
    AS
BEGIN
    OPEN SONG_LIST FOR
    SELECT * FROM TRACK WHERE ALBUMID IN (
    SELECT ALBUMID FROM ALBUM WHERE ARTISTID IN (
    SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC'));
END;
/

CREATE OR REPLACE FUNCTION SONGS_BY_ARTIST_FUNCTION
(ARTIST_NAME IN VARCHAR2)
RETURN SYS_REFCURSOR
AS
SONG_LIST SYS_REFCURSOR;
BEGIN
    OPEN SONG_LIST FOR
    SELECT * FROM TRACK WHERE ALBUMID IN (
    SELECT ALBUMID FROM ALBUM WHERE ARTISTID IN (
    SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC'));
RETURN
    SONG_LIST;
END;
/

CREATE OR REPLACE PROCEDURE GET_ALL_BOOKS
(BOOK_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN 
OPEN BOOK_CURSOR FOR SELECT * FROM BN_BOOK;
END;
/

update bn_book set price = 19.99 where book_id = 5;

SELECT * FROM BN_BOOK;

CREATE OR REPLACE FUNCTION GET_ALBUMS_BY_ARTIST (
ART_ID IN NUMBER)
RETURN SYS_REFCURSOR
IS
    INFO_CURSOR SYS_REFCURSOR;
BEGIN
OPEN INFO_CURSOR
for 
SELECT album.title, artist.name
FROM ALBUM
INNER JOIN ARTIST on ARTIST.ARTISTID = album.artistid WHERE ALBUM.ARTISTID = ART_ID;
RETURN INFO_CURSOR;
END;
/

select get_albums_by_artist(1) from dual;


SELECT album.title, artist.name 
FROM ALBUM 
inner join ARTIST on artist.artistid = album.artistid WHERE album.ARTISTID = 1;

