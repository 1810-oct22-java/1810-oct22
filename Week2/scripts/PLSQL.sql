--FUNCTIONS
/*
- executable blocks of code that take in 0 or more parameters and must return 1 value
- cannot perform full DML statements -- only SQL
- typically used to perform some sort of mathematical "function" on data and reutnr output
*/
-- Ex. 1 -- Find avg unit price from invoiceline table
CREATE OR REPLACE FUNCTION INV_LINE_PRICE_AVG -- create [or replace] function [functionName]
  RETURN NUMBER                               -- data type of return value
IS                                            -- IS/AS -- define variable to return
  AVERAGE NUMBER(5,4);
BEGIN -- begin function code
  SELECT AVG(unitprice) INTO average FROM invoiceline;
  RETURN average;
END;
/
SELECT inv_line_price_avg() FROM dual;
-- Ex 2. find number of books by genre title
CREATE OR REPLACE FUNCTION num_books_by_genre(
    gtitle IN VARCHAR2)
  RETURN NUMBER
IS
  total NUMBER;
BEGIN
  SELECT COUNT(book_id)
  INTO total
  FROM bn_book
  WHERE genre =
    ( SELECT genre_id FROM bn_genre WHERE lower(name) = lower(gtitle)
    );
  RETURN total;
END;
/
--ex3. finds max invoice price
CREATE OR REPLACE FUNCTION TESTY
  RETURN NUMBER
IS -- IS/AS -- define type of return value
  return_val NUMBER;
BEGIN --begin function code
  SELECT TOTAL
  INTO return_val
  FROM
    (SELECT * FROM INVOICE ORDER BY INVOICE.TOTAL DESC
    )
  WHERE ROWNUM = 1;
  RETURN return_val;
END;
/
SELECT testy() FROM dual;
SELECT num_books_by_genre('fantasy') FROM dual;
SELECT COUNT(book_id)
FROM bn_book
WHERE genre =
  ( SELECT genre_id FROM bn_genre WHERE lower(name) = lower('Fantasy')
  );
SELECT g.name,
  COUNT(t.name)
FROM track t
JOIN genre g
ON g.genreid = t.genreid
WHERE g.name = 'Rock'
GROUP BY g.name;
------------------- STORED PROCEDURES
--Transactional Procedure
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(
      INVID IN NUMBER)
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
CREATE OR REPLACE PROCEDURE SONGS_BY_ARTIST(
      ARTIST_NAME IN VARCHAR2, SONG_LIST OUT SYS_REFCURSOR)
  AS
  BEGIN
  OPEN SONG_LIST FOR 
    SELECT *FROM TRACK WHERE ALBUMID IN
      (SELECT ALBUMID FROM ALBUM  WHERE ARTISTID IN
        ( SELECT ARTISTID FROM ARTIST WHERE NAME = ARTIST_NAME )
      );
  END;
/
SELECT SONGS_BY_ARTIST_FUNCTION('AC/DC') FROM DUAL;
/
CREATE OR REPLACE FUNCTION SONGS_BY_ARTIST_FUNCTION
(ARTIST_NAME IN VARCHAR2)
RETURN SYS_REFCURSOR
AS
SONG_LIST SYS_REFCURSOR;
  BEGIN
  OPEN SONG_LIST FOR 
    SELECT *FROM TRACK WHERE ALBUMID IN
      (SELECT ALBUMID FROM ALBUM  WHERE ARTISTID IN
        ( SELECT ARTISTID FROM ARTIST WHERE NAME = ARTIST_NAME )
      );
      RETURN SONG_LIST;
  END;
  
  
  /
  select NUM_BOOKS_BY_GENRE('Fantasy') from dual;
  
  -------------------stored procedure to return all books 
  create or replace procedure get_all_books
  (book_cursor OUT SYS_REFCURSOR)
  AS
  BEGIN
  OPEN book_cursor FOR select * from bn_book;
  end;
  /
  ----
  select * from bn_book;
  /
  update bn_book set title = 'Harry Potter - the Sorcerers Stone', price = 19.99 where book_id = 1;
  
  
  
  
  --- testing get all books 
  /
  DECLARE
    BOOKS_CURS SYS_REFCURSOR;
    B_ID NUMBER(10);
    B_ISBN VARCHAR2(10);
    B_AUTHOR NUMBER(10);
    B_TITLE VARCHAR2(100); 
    B_PRICE NUMBER(6,2);
    B_GENRE NUMBER(10);
  BEGIN 
    GET_ALL_BOOKS(BOOKS_CURS);
    LOOP
      FETCH BOOKS_CURS INTO B_ID, B_ISBN, B_AUTHOR, B_TITLE, B_PRICE, B_GENRE;
      EXIT WHEN BOOKS_CURS%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(B_ID || ', ' || B_TITLE);
    END LOOP;
  END;
  /
