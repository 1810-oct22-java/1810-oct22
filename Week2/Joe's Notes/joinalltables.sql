SELECT 
INVOICELINE.INVOICELINEID,
INVOICELINE.INVOICEID,
INVOICE.BILLINGADDRESS,
CUSTOMER.FIRSTNAME,
EMPLOYEE.FIRSTNAME,
TRACK.NAME,
GENRE.NAME,
MEDIATYPE.NAME,
ALBUM.TITLE,
ARTIST.NAME,
PLAYLISTTRACK.PLAYLISTID
FROM INVOICELINE
JOIN INVOICE ON INVOICELINE.INVOICEID = INVOICE.INVOICEID
JOIN CUSTOMER ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
JOIN EMPLOYEE ON CUSTOMER.SUPPORTREPID = EMPLOYEE.EMPLOYEEID
JOIN TRACK ON INVOICELINE.TRACKID = TRACK.TRACKID
JOIN GENRE ON TRACK.GENREID = GENRE.GENREID
JOIN MEDIATYPE ON TRACK.MEDIATYPEID = MEDIATYPE.MEDIATYPEID
JOIN ALBUM ON TRACK.ALBUMID = ALBUM.ALBUMID
JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID
JOIN PLAYLISTTRACK ON TRACK.TRACKID = PLAYLISTTRACK.TRACKID;

CREATE OR REPLACE FUNCTION TESTY
RETURN NUMBER
IS -- IS/AS -- define type of return value
 return_val NUMBER;
BEGIN --begin function code
    SELECT TOTAL into return_val FROM (SELECT * FROM INVOICE ORDER BY INVOICE.TOTAL DESC) WHERE ROWNUM = 1;
    return return_val;
END;
/

CREATE OR REPLACE FUNCTION TESTY2
RETURN VARCHAR2
IS -- IS/AS -- define type of return value
 return_val VARCHAR2(200);
BEGIN --begin function code
    select NAME into return_val from track where TRACK.TRACKID = (SELECT TRACKID FROM (SELECT * FROM TRACK ORDER BY UNITPRICE DESC) WHERE ROWNUM = 1);
    return return_val;
END;
/

CREATE OR REPLACE FUNCTION TESTY
RETURN NUMBER
IS -- IS/AS -- define type of return value
 return_val NUMBER;
BEGIN --begin function code
    SELECT TOTAL into return_val FROM (SELECT * FROM INVOICE ORDER BY INVOICE.TOTAL DESC) WHERE ROWNUM = 1;
    return return_val;
END;
/

--select NAME from track where TRACK.TRACKID = (SELECT TRACKID FROM (SELECT * FROM TRACK ORDER BY UNITPRICE DESC) WHERE ROWNUM = 1);

SELECT TESTY2 FROM DUAL;
SELECT TESTY FROM DUAL;

/*
- executable blocks of code that take in 0 or more parameters and must return 1 value
- cannot preform full dml statements -- only SQL
- typically used to perform some sort of mathematical "function" on data and return ouptut
*/
-- Ex. 1 -- Find avg unit price from invoiceline table
/*
CREATE OR REPLACE FUNCTION INV_LINE_PRICE_AVG
RETURN NUMBER
IS -- IS/AS -- define type of return value
 AVERAGE NUMBER(3,2);
BEGIN --begin function code

    select round(avg(unitprice),2) into average from invoiceline;
    return average;

END;
/

select avg(unitprice) from invoiceline;
select round(avg(unitprice),2) from invoiceline;


select count(*), GENRE.NAME from track 
JOIN GENRE ON track.GENREID = GENRE.GENREID
GROUP BY GENRE.NAME;

select count(*),GENRE.NAME from track
JOIN GENRE ON track.GENREID = GENRE.GENREID
WHERE track.GENREID = (SELECT GENEREID FROM GENRE WHERE GENRE.NAME = 'Reggae');


CREATE OR REPLACE FUNCTION get_allitems
  RETURN SYS_REFCURSOR
AS
  my_cursor SYS_REFCURSOR;
BEGIN
  OPEN my_cursor FOR SELECT * FROM employee;
  RETURN my_cursor;
END;
/

*/

CREATE OR replace PROCEDURE SPSingleRefCur(cursor_for_output OUT SYS_REFCURSOR )   
IS   
BEGIN   
OPEN cursor_for_output FOR SELECT * FROM EMPLOYEE;   
END;
/
BEGIN
    var rc refcursor
    call SPSingleRefCur(:rc)
    print rc
END;
/