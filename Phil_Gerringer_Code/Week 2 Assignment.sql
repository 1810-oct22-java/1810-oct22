/* 1.0 - done */

/* 2.1 */
select * from employee;

select * 
from employee
where lastname = 'King';

select *
from employee
where firstname = 'Andrew' and reportsto is null;

/* 2.2 */
select * 
from album 
order by title desc;

select firstname
from customer
order by city asc;

/* 2.3 */
insert into genre (genreid, name) values (100, 'Sad');
insert into genre (genreid, name) values (101, 'Silent');

insert into employee (EmployeeId, LastName, FirstName, Title, Reportsto, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
values (100, 'Gerringer', 'Phil', 'IT Staff', null, null, null, null, null, null, null, null, null, null, null);
insert into employee (EmployeeId, LastName, FirstName, Title, Reportsto, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
values (101, 'Gerringer', 'Danielle', 'IT Staff', null, null, null, null, null, null, null, null, null, null, null);

insert into customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
values (100, 'Bob', 'Builder', null, null, null, null, null, null, null, null, 'bob@builder.com', null);
insert into customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
values (101, 'Fester', 'Jester', null, null, null, null, null, null, null, null, 'ugly@google.com', null);

/* 2.4 */
update customer
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

update artist
set name = 'CCR'
where  name = 'Creedence Clearwater Revival';

/* 2.5 */
select *
from invoice
where  billingaddress like 'T%'

/* 2.6 */
select *
from invoice
where total > 15 and total < 30

select *
from employee
where hiredate > to_date('01-JUN-2003', 'DD-MON-YYYY') and
hiredate < to_date('01-MAR-2004', 'DD-MON-YYYY')

/* 2.7 */
delete
from invoiceline
where invoiceid in (select i.invoiceid from customer c, invoice i 
where i.customerid = c.customerid and 
c.firstname = 'Robert' and c.lastname = 'Walter')

delete
from invoice
where customerid = (select customerid from customer 
where firstname = 'Robert' and lastname = 'Walter')

delete
from customer 
where firstname = 'Robert' and lastname = 'Walter'

/* 3.1 */
create or replace function phil_time return varchar2 as
begin
return to_char(current_date,'HH24:MI:SS');
end phil_time;

create or replace function media_type_length (media_name in varchar2)
return number 
is media_length number;
begin
select length(name)
into media_length
from mediatype
where name = media_name;
return media_length;
end media_type_length;

/* 3.2 */
create or replace function avg_total_invoices 
return number 
is average_total number;
begin
select avg(total)
into average_total
from invoice;
return average_total;
end avg_total_invoices;

    create or replace function most_expensive_track 
    return SYS_REFCURSOR
    as
    a_csr SYS_REFCURSOR; 
    begin
    open a_csr for
    select * from track
    where unitprice in (
    select max(unitprice)
    from track);
    return a_csr;
    end most_expensive_track;

/* 3.3 */
create or replace function average_invoiceline 
return number
is avg_inv number;
begin
select avg(unitprice) 
into avg_inv
from invoiceline;
return avg_inv;
end average_invoiceline;

/* 3.4 */
create or replace function employee_birthdate 
return SYS_REFCURSOR 
as
a_csr SYS_REFCURSOR; 
begin
open a_csr for
select lastname, firstname, birthdate
from employee
where birthdate > to_date('31-DEC-1968', 'DD-MON-YYYY');
return a_csr;
end;
/

/* 4.1 */
create or replace procedure employee_names
(employee_cur out sys_refcursor) as 
begin
  open employee_cur for 
  select firstname, lastname 
  from employee;
end;
/

/* 4.2 */
create or replace procedure employee_update
(e_id in number, last_name in varchar2, 
first_name in varchar2, e_title in varchar2) as
begin
  update employee 
  set lastname = last_name, firstname = first_name, title = e_title 
  where employeeid = e_id;
  commit;
end;

create or replace procedure employee_managers
(e_id number, manager_cur out sys_refcursor) as 
begin
  open manager_cur for 
  select emp.lastname as "Employee", man.lastname as "Manager"  
    from employee emp, employee man
    where emp.reportsto = man.employeeid and emp.employeeid = e_id;
end;
/

/* 4.3 */
create or replace procedure company_info
(c_id number, company_cur out sys_refcursor) as 
begin
  open company_cur for
    select firstname, lastname, company
    from customer
    where customerid = c_id;
end;
/

/* 5.0 */
create or replace procedure company_info
(inv_id number) as 
begin 

savepoint sp_company_info;

--invoiceline has a constraint against invoice so...
delete from invoiceline where invoiceid = inv_id;
 
-- if we made it this far...delete the invoice
delete from invoice where invoiceid = inv_id;

exception
  when others then
    rollback to sp_company_info;
    raise;
end;

create or replace procedure customer_update
(first_name varchar2, last_name varchar2, email_id varchar2) as 
begin 

insert into customer (firstname, lastname, email) 
values(first_name, last_name, email_id);

commit;
end;

/* 6.1 */
create or replace trigger new_employee_trig 
after insert on employee  
for each row 
begin
    null;
end new_employee_trig;

create or replace trigger update_album_trig 
after update on ALBUM 
begin
  null;
end update_album_trig;

create or replace trigger deleting_customer_trig 
after delete on CUSTOMER 
begin
  null;
end deleteing_customer_trig;

/* 7.1 */
select c.firstname, c.lastname, i.invoiceid 
from customer c
natural inner join invoice i;

/* 7.2 */
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c
natural inner join invoice i;

/* 7.3 */
select art.name, alb.title 
from artist art 
natural right join album alb;

/* 7.4 */
select * 
from artist art 
cross join album alb
order by art.name asc;

/* 7.5 */
select *
from employee e1, employee e2
where e1.reportsto = e2.employeeid;

/* 7.6 */  
select * 
from invoiceline il 
join invoice i on il.invoiceid = i.invoiceid
join track t on t.trackid = il.trackid 
join playlisttrack plt on plt.trackid = t.trackid
join playlist pl on plt.playlistid = pl.playlistid 
join mediatype m on t.mediatypeid = m.mediatypeid 
join album a on a.albumid = t.albumid
join artist art on a.artistid = art.artistid 
join customer c on c.customerid = i.customerid
join genre g on g.genreid = t.genreid 
join employee e on e.employeeid = c.supportrepid;