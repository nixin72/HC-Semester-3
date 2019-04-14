/*1*/
SELECT fname||' '||lname AS "Employee name", salary
  FROM NN_employee;
  
/*2*/
SELECT lname||', '||fname AS "Employees with no commission"
  FROM NN_Employee
  WHERE commission IS NULL;
  
/*3*/
SELECT DISTINCT building
  FROM IU_Location;
  
/*4*/
SELECT * 
  FROM IU_crssection
  WHERE termId='WN03';
  
/*5*/
SELECT name 
  FROM IU_faculty
  WHERE deptid IN (1,2);
  
/*6*/
SELECT csid, courseid, maxcount
  FROM IU_crssection
  ORDER BY maxcount desc;

/*7*/
SELECT deptid, name
  FROM IU_faculty 
  ORDER BY deptid desc, name;
  
/*8*/
SELECT name 
  FROM IU_faculty
  WHERE SUBSTR(name, 0,1)='C';
  
/*9*/
SELECT last||' '||first AS "Student name", startterm
  FROM IU_student
  WHERE startterm='WN03';
  
/*10*/
SELECT building, roomno, capacity
  FROM IU_location
  WHERE capacity >= 40;
  
/*11*/
SELECT lname||' '||fname AS "Employee name", salary + commission AS "Total Earnings"
  FROM NN_employee
  WHERE commission IS NOT NULL
  ORDER BY "Total Earnings" desc;
  
/*12*/
SELECT lname||', '||fname AS "Programmers and Accountants"
  FROM NN_Employee
  WHERE positionid = 3 OR positionId = 4;
  
SELECT lname||', '||fname AS "Programmers and Accountants"
  FROM NN_Employee
  WHERE positionid IN (3, 4);
  
/*13*/
SELECT courseID, title
  FROM IU_course
  WHERE courseId LIKE '420%';
  
/*14*/
SELECT csid, courseid
  FROM IU_crssection
  WHERE termid='SP03' AND day='MW';
  
/*15*/
SELECT lname||', '||fname AS "Name", To_CHAR(salary, '$999,999') AS "Salary"
  FROM NN_employee;
  
/*16*/  
SELECT lname||', '||fname AS "Employee name", 
    TO_CHAR(NVL(commission, 0.0), '$999,999.99') AS "Commission"
  FROM NN_employee;
  
/*17*/
SELECT last||', '||first AS "Student name", TO_CHAR(birthdate, 'DD Month YYYY')
  FROM IU_student
  WHERE birthdate IS NOT NULL;
  
/*18*/
SELECT lname||', '||fname AS "Name", TO_CHAR(hiredate, 'YYYY')
  FROM NN_employee;







