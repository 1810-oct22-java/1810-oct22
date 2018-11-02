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

--SELECT * FROM CUSTOMER WHERE FIRSTNAME;

create view set_a as

select * from customer;--;

create view set_b as --
select * from set_a UNION select * from set_b;


/*
JOINS  join clause is used to join columns based on a relationship between them
typically used to bring together columns from different tables based on a foreign key relationship
*/

-- Join without using the join keyword 
select album.title, artist.name 
from album, artist where album.artistid = artist.artistid;

--INNER JOIN AKA JOIN
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

select title from album;

--natural join -- Oracle attempts to match columns based on names 
select album.title, artist.name from artist natural join album;

--natural join will still work even if columns with same name are not 
-- related by a FK reference. ie here, with genre name and artist name
select * from genre natural full join artist;

--SELF JOIN 
select * from employee;

-- FULL SELF JOIN - all employee/manager combinations 
select e1.employeeid as EMPLOYEE, e2.employeeid as MANAGER
from employee e1
right join employee e2
on e1.reportsto = e2.employeeid;

-- LEFT SELF JOIN - every employee + their boss
select e1.lastname as EMPLOYEE, e2.lastname as MANAGER
from employee e1
left join employee e2
on e1.reportsto = e2.employeeid
where e1.reportsto is not null;

-- RIGHT SELF JOIN with conditions - only see people who are not managers
select e1.lastname as EMPLOYEE, e2.lastname as MANAGER
from employee e1
right join employee e2
on e1.reportsto = e2.employeeid
where e1.reportsto is not null;

--CROSS JOIN - Cartesian product of two tables
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1, employee e2;

------------ FUN THINGS W JOINS 
-- find # of tracks in each genre, alphebetize by genre

----------------- FUN QUERIES
-- find # of tracks of each genre. alphabetize by genre
select g.name , count(t.trackid) as "NUM SONGS"
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name, g.genreid
order by g.name;













