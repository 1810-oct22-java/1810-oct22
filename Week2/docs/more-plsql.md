INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) 
VALUES (7, 'Rajnish', 27, 'HP', 9500.00 ); 

INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) 
VALUES (8, 'Riddhi', 21, 'WB', 4500.00 ); 
SAVEPOINT sav1;
  
UPDATE CUSTOMERS 
SET SALARY = SALARY + 1000; 
ROLLBACK TO sav1;
  
UPDATE CUSTOMERS 
SET SALARY = SALARY + 1000 
WHERE ID = 7; 
UPDATE CUSTOMERS 
SET SALARY = SALARY + 1000 
WHERE ID = 8; 

COMMIT;
\
Isolation Level	Dirty Read	Nonrepeatable Read	Phantom Read
Read uncommitted	Possible	Possible	Possible
Read committed	Not possible	Possible	Possible
Repeatable read	Not possible	Not possible	Possible
Serializable	Not possible	Not possible	Not possible


# more pl/sql

### basic syntax

```
/*
CREATE [OR REPLACE] PROCEDURE proc_name [list of parameters]
IS
       Declaration section
BEGIN
       Execution section
EXCEPTION
       Exception section
END;
*/
```

### hello world

```
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN

  DBMS_OUTPUT.PUT_LINE('hello word!');

END;
/
```

```
BEGIN
  hello_world_procedure();
END;
/
```

### out parameters

```
CREATE OR REPLACE PROCEDURE get_answer_procedure(some_q IN VARCHAR2, some_a OUT VARCHAR2)
IS
BEGIN

  SELECT fc_answer INTO some_a FROM flash_card WHERE fc_question = some_q;

END;
/
```

```
DECLARE
  answer VARCHAR2(4000);
BEGIN

  get_answer_procedure('what is java?', answer);
  DBMS_OUTPUT.PUT_LINE('answer: ' || answer);

END;
-=-
Week 2 - SQL 



Key Terms/Questions 
What is a RDBMS?
Relational vs non-relational databases 
Understanding Oracle DB
SQL 
SQL Sublanguages:
DML: Data Manipulation language
INSERT
SELECT
UPDATE
DELETE
DELETE from Table_Name where [whatever]
Can rollback after delete, not truncate
DDL: Data Definition language
Defines schema of DB
CREATE
Make new objects: tables, constraints, sequences, etc.
DROP
Removes any object
DROP [entity] [name]
TRUNCATE
Remove all rows from a table, but keeps schema
ALTER
Alter the schema
DCL: Data Control language
Give access credentials to users
GRANT, REVOKE
DQL: Data Query Language
Data Query Language
SELECT
TCL: Transaction Control Language
COMMIT, ROLLBACK, SAVEPOINT


Transactions
Properties of a transaction 
ACID
Atomicity − ensures that all operations within the work unit are completed successfully. Otherwise, the transaction is aborted at the point of failure and all the previous operations are rolled back to their former state.
Consistency − ensures that the database properly changes states upon a successfully committed transaction.
Isolation − enables transactions to operate independently of and transparent to each other.
Durability − ensures that the result or effect of a committed transaction persists in case of a system failure.
Transaction Control


Tx isolation levels and problems they prevent 
DROP vs TRUNCATE vs DELETE
DROP: Deletes the table including the schema
TRUNCATE: Deletes the data in the schema while keeping table structure, and relationships
WHERE vs HAVING
Use having when following GROUP BY 
Aggregate vs scalar functions 
Joins 
Set operators - UNION, UNION ALL, INTERSECT, MINUS
UNION: 
Return all distinct values between tables
A+ B -AB
UNION ALL
Includes duplicates
A+B
INTERSECT
Returns the rows that tables share in common
AB
MINUS
Rows that are in A that are not in B
A - B
Or A - AB
What is the difference between a join and a union 
What is a commit?
DB normalization 
The process of organizing data to increase efficiency and integrity, and reduce redundancy


What is a benefit of a denormalized DB? 
readability 
Column level constraints 
FK, PK, NN, U, Check, Default
Composite key 
Candidate key 



Referential integrity
A valid foreign key value must always reference an existing primary key or contain a null
Orphan 
Domain integrity 
All values in a column must be the same type
Schema 
ERD
PL/SQL   
Triggers
Joins 
Index
Cursor - implicit vs explicit 
Stored procedures vs functions 
JDBC 
Important interfaces in the JDBC API 


Connection:
Statement:
PreparedStatement:
CallableStatement:
ResultSet:
executeUpdate() vs executeQuery()
How, in Java, do i obtain the keys generated (via triggers, etc) in my database?
getAutoGeneratedKeys()
AWS RDS
.properties
Driver 
DAO
Subqueries 


GROUP BY : Groups rows defined by a specific set of columns for using aggregate functions on the rows in those groups.
ORDER BY : Sorts the returned query by a specific set a columns
DISTINCT
LIKE


Resources



/
```

### if statement

```
CREATE OR REPLACE FUNCTION find_max_num(x IN NUMBER, y IN NUMBER)
RETURN NUMBER
IS
  z NUMBER;
BEGIN

  IF x > y THEN
    z := x;
  ELSE
    z := y;
  END IF;

  RETURN z;

END;
/
```

```
DECLARE
  first_num  NUMBER;
  second_num NUMBER;
  max_num    NUMBER;

BEGIN
  first_num  := 22;
  second_num := 42;

  max_num := find_max_num(first_num, second_num);

  DBMS_OUTPUT.PUT_LINE('Max: ' || max_num);
END;
/
```

# Cursor
* pointer to a **Result Set**

```
CREATE OR REPLACE PROCEDURE get_all_flash_cards(dog OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN dog FOR
  SELECT * FROM flash_card;
END;
/
```

```
DECLARE
  cat SYS_REFCURSOR;
  some_id       flash_card.fc_id%TYPE;
  some_question flash_card.fc_question%TYPE;
  some_answer   flash_card.fc_answer%TYPE;
BEGIN

  get_all_flash_cards(cat);


  LOOP
    FETCH cat INTO some_id, some_question, some_answer;
    EXIT WHEN cat%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(some_id || ' ' || some_question || ' ' || some_answer);

  END LOOP;

  CLOSE cat;

END;
/
```