--#1
--select firstname, lastname from employee;

--#2
--select FIRSTNAME, lastname from employee where city='Edmonton';

--#3
--select FIRSTNAME, LASTNAME, CITY from CUSTOMER where COUNTRY='USA';

--#4 
/*select c.FIRSTNAME, c.LASTNAME, e.FIRSTNAME, e.LASTNAME 
from EMPLOYEE e, CUSTOMER c 
where c.supportrepid = e.employeeid order by c.lastname;*/

--#5
--select firstname, lastname from employee where reportsto=1;

--#6
/*select e.firstname, e.lastname 
from employee e, customer c 
where c.supportrepid = e.employeeid 
and c.firstname='Frank' and c.lastname='Harris';*/
  
--#7
/*select e1.firstname, e1.lastname, e2.firstname, e2.lastname, e2.title
from employee e1, employee e2, customer c
where c.supportrepid = e1.employeeid
  and c.firstname='Frank' and c.lastname='Harris'
    and e1.reportsto = e2.employeeid;*/

--#8
/*select al.title from album al, artist ar 
where al.ARTISTID = ar.ARTISTID 
  and ar.NAME='Queen';*/

--#9
/*select t.NAME from track t, album a 
where t.albumid = a.albumid 
  and a.TITLE='Greatest Hits I';*/
  
--#10
/*select t.Name from track t, album al, artist ar
where t.ALBUMID = al.ALBUMID 
  and al.ARTISTID = ar.ARTISTID 
  and ar.name='Queen';*/




