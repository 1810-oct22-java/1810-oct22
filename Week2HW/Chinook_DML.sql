-- DML: DATA`MANIPULATION LANGUAGE

-- SELECT
-- SELECT[col names] FROM[table name] [WHERE] [condition]

SELECT * FROM Artist;
SELECT NAME FROM ARTIST;

SELECT NAME FROM ARTIST WHERE ARTISTID <=10;

SELECT * FROM ARTIST WHERE NAME = 'Audioslave'; -- case sensitive inside ''


/* System-Defined functions,
--> scalar functions 1 to 1 relationship - functions that operate on single values, ie, upper() lower() length
> Aggregate functions many to 1- function that operate on multiple rows of a column ie max()min()count()sum()
*/

--SCALAR

SELECT LOWER(NAME) FROM ARTIST;
SELECT LENGTH(NAME) FROM ARTIST;
SELECT * FROM ARTIST WHERE LENGTH(NAME) >25;
--LIKE OPERATOR
SELECT * FROM ARTIST WHERE NAME LIKE 'T_e B%';
SELECT * FROM ARTIST WHERE NAME LIKE 'E%';
SELECT * FROM ARTIST WHERE LOWER(NAME) LIKE '%the%';


--AGGREATE EXAMPLES

SELECT COUNT(*) FROM ARTIST;
SELECT COUNT(NAME) FROM ARTIST;

SELECT * FROM CUSTOMER;
SELECT COUNT(CUSTOMERID) FROM CUSTOMER;
SELECT COUNT(CUSTOMERID),COMPANY
FROM CUSTOMER
GROUP BY COMPANY;


SELECT COUNT(CUSTOMERIF),COMPANY
FROM CUSTOMER
GROUP BY COMPANY -- can only be used w aggregate functions
ORDER BY COMPANY DESC; -- for sorting, option ASC/DESC param

--SUBQUERIES
/*Queries nested within the where clause of another query to further narrow the result set
non-correlated - inner query can execute independently from the outer
correlated - internal query cannot execute independently
*/
SELECT * FROM GENRE;
SELECT GENREID FROM GENRE WHERE NAME = 'Drama';
SELECT * FROM TRACK WHERE GENREID = 20;

--here, nested query returns only one row
--SELECT from trak where my genre is Drama
SELECT * FROM TRACK WHERE GENREID = (SELECT GENREID FROM GENRE WHERE NAME = 'Drama');

SELECT * FROM track WHERE genreid IN
(SELECT genreid FROM genre WHERE NAME LIKE 'B%');


SELECT G.NAME
FROM GENRE G
WHERE G.GENREID IN
(SELECT T.GENREID 
FROM TRACK_VIEW T 
WHERE T.GENREID = G.GENREID);

-- VIEW "virtual table", subset of data used for easy retrieval of a query

CREATE VIEW TRACK_VIEW AS
SELECT * FROM TRACK WHERE albumid>100 AND albumid < 120;

SELECT * FROM TRACK_VIEW;

DROP VIEW TRACK_VIEW;


/*
SET OPERATIONS
--  used to compare similar result sets (MUST be same # and type of columns)
UNION = A + (B-AB)
UNION ALL = A+B
INTERSECT = AB
MINUS = A-B
*/

CREATE VIEW SET_A AS
SELECT * FROM CUSTOMER;

CREATE VIEW SET_B AS 
SELECT * FROM SET_A UNION SELECT * FROM SET_B;

/*
JOINS - join clause is used to join columns based on a relationship between them
typically used to bring together columns from different tables based on a foreign 
key relationship

*/

--JOIN without JOIN keyword
SELECT Album.title, artist.name FROM album, artist 
WHERE album.artistid = artist.artistid;

--or ALBUMTITLE, no space
SELECT Album.title AS "ALBUM TITLE", artist.name AS ARTIST
FROM album
INNER JOIN artist
ON album.artistid = artist.artistID;

--using aliases, must stick to shortcuts
-- JOIN or INNER JOIN are the same thing
SELECT al.title AS "ALBUM TITLE", art.name AS ARTIST
FROM album al
INNER JOIN artist art
ON al.artistid = art.artistID
ORDER BY al.title;

SELECT * FROM album;

SELECT art.name AS ARTIST, al.title AS "ALBUM TITLE"
FROM album al
JOIN artist art on al.artistid = art.ARTISTID
JOIN track t on t.albumid = al.albumid
ORDER BY art.name;


--natural join --ORACLE attempts to match columns based on names
SELECT * FROM artist NATURAL JOIN album;

--Doesn't make sense
--Nautral join will still work even if columns with same name are not related
--by a foreign key reference
SELECT * FROM genre NATURAL FULL JOIN artist;

--Self join
SELECT * FROM EMPLOYEE;

--RIGHT JOIN
SELECT e1.lastname AS EMPLOYEE, e2.lastname AS MANAGER
FROM EMPLOYEE e1
RIGHT JOIN Employee e2
ON e1.reportsto = e2.employeeid;

--All employee/manager combinations
SELECT e1.lastname AS EMPLOYEE, e2.lastname AS MANAGER
FROM EMPLOYEE e1
FULL JOIN Employee e2
ON e1.reportsto = e2.employeeid;

--LEFT SELF JOIN - every employee + their boss
SELECT e1.lastname AS Employee, e2.lastname as MANAGER
FROM EMPLOYEE e1
LEFT JOIN Employee e2
ON e1.reportsto = e2.employeeid;

--RIGHT SELF JOIN - every manager
SELECT e1.lastname AS Employee, e2.lastname as MANAGER
FROM EMPLOYEE e1
RIGHT JOIN Employee e2
ON e1.reportsto = e2.employeeid
WHERE e1.reportsto is NOT NULL;

--RIGHT SELF JOIN - only people who aren't managers
--both will give inner join with not null tacked on
SELECT e1.lastname AS Employee, e2.lastname as MANAGER
FROM EMPLOYEE e1
RIGHT JOIN Employee e2
ON e1.reportsto = e2.employeeid
WHERE e1.reportsto is NULL;

--CROSS JOIN - cartesian product of two tables
SELECT e1.lastname as MANAGER, e2.lastname as EMPLOYEE
FROM employee e1, employee e2;

--GIANT JOIN
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

-- FUN THINGS W/ JOINS
-- FIND # of tracks in each genre, alphebetize by genre

SELECT count(t.trackid) as "NUM SONGS", g.name 
FROM Track t
inner JOIN genre g on g.genreid = t.genreid
GROUP BY t.genreid;


