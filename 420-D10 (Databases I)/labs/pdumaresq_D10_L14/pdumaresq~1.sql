/*PART A*/
/*1*/
SELECT e1.lName||', '||e1.fName AS "Employee"
  FROM nn_employee e1
  WHERE e1.employeeid = (
    SELECT e2.supervisor
    FROM nn_employee e2
    WHERE e2.employeeid = 433
  );
  
/*2*/
SELECT e1.lname||', '||e1.fname AS "Employee"
  FROM nn_employee e1
  WHERE e1.qualid = (
    SELECT e2.qualid
    FROM nn_employee e2 
    WHERE e2.fname = 'Stanley'
      AND e2.lname = 'Garner'
  );
  
/*3*/
SELECT deptname, deptid
  FROM nn_dept
  WHERE (
    SELECT DISTINCT COUNT(deptid) 
    FROM nn_employee 
    WHERE deptid = nn_dept.deptid
  ) > (
    SELECT COUNT(deptid)
    FROM nn_employee
    WHERE deptid = 20
  );
  
/*4*/
SELECT e1.lname||', '||e1.fname AS "employee"
  FROM nn_employee e1
  WHERE e1.hiredate < (
    SELECT e2.hiredate 
    FROM nn_employee e2
    WHERE e2.fname = 'Larry'
      AND e2.lname = 'Houston'
  );
  
/*5*/
DROP TABLE EMP30;
CREATE TABLE EMP30 AS (
  SELECT EMPLOYEEID, LNAME, FNAME,
        HIREDATE, SALARY
  FROM nn_employee
  WHERE deptid = 30
);

/*6*/
DROP TABLE EMP30;
INSERT INTO EMP30 (
  SELECT EMPLOYEEID, LNAME, FNAME,
        HIREDATE, null
  FROM nn_employee
  WHERE deptid = 40
);

/*7*/
MERGE INTO EMP30 e1
  USING (
    SELECT employeeid, lname, fname,
        hiredate, salary
    FROM nn_employee
  ) e2
  ON (e1.employeeid = e2.employeeid)
  WHEN MATCHED THEN UPDATE SET
    e1.fname = e2.fname, 
    e1.lname = e2.lname,
    e1.hiredate = e2.hiredate,
    e1.salary = e2.salary
  WHEN NOT MATCHED THEN INSERT (e1.employeeid, e1.fname, e1.lname, e1.hiredate, e1.salary)
    VALUES (e2.employeeid, e2.fname, e2.lname, e2.hiredate, e2.salary);

/*8*/
SELECT e1.lname||', '||e1.fname AS "Name"
  FROM nn_employee e1
  WHERE e1.salary IN (
    SELECT MIN(salary)
    FROM nn_employee
    GROUP BY deptid
  );

/*9*/
SELECT DISTINCT e1.lname||', '||e1.fname AS "Name"
  FROM nn_employee e1
  WHERE e1.employeeid NOT IN (
    SELECT DISTINCT employeeid 
    FROM nn_employee
    minus 
    SELECT employeeid
    FROM nn_dependent
  );
  
/*10*/
SELECT fname||', '||lname AS "Name"
  FROM nn_employee 
  WHERE employeeid = 543 AND salary = ANY 
    (SELECT AVG(salary) FROM nn_employee GROUP BY deptid);

SELECT fname||', '||lname AS "Name"
  FROM nn_employee 
  WHERE employeeid = 543 AND salary < ANY 
    (SELECT AVG(salary) FROM nn_employee GROUP BY deptid);

SELECT fname||', '||lname AS "Name"
  FROM nn_employee 
  WHERE employeeid = 543 AND salary > ANY 
    (SELECT AVG(salary) FROM nn_employee GROUP BY deptid);

SELECT fname||', '||lname AS "Name"
  FROM nn_employee 
  WHERE employeeid = 543 AND salary < ALL
    (SELECT AVG(salary) FROM nn_employee GROUP BY deptid);

SELECT fname||', '||lname AS "Name"
  FROM nn_employee 
  WHERE employeeid = 543 AND salary > ALL 
    (SELECT AVG(salary) FROM nn_employee GROUP BY deptid);

/*PART B*/
/*1*/
SELECT DISTINCT f.facultyid, name, f.phone, 'Co-ordinator'
  FROM iu_faculty f, iu_department d 
  WHERE d.facultyid = f.facultyid
UNION 
SELECT DISTINCT f.facultyid, name, f.phone, 'Not teaching'
  FROM iu_faculty f, iu_crssection c
  WHERE f.facultyid NOT IN (
    SELECT f.facultyid 
    FROM iu_faculty f, iu_crssection c
    WHERE f.facultyid = c.facultyid
  )
ORDER BY name;

/*2*/
SELECT DISTINCT f.facultyid, f.name, f.phone
  FROM iu_faculty f, iu_department d, iu_crssection c
  WHERE d.facultyid = f.facultyid AND 
  f.facultyid IN c.facultyid;

/*3*/
SELECT DISTINCT f.facultyid, f.name, f.phone
  FROM iu_faculty f, iu_department d, iu_crssection c
  WHERE d.facultyid = f.facultyid
minus 
  SELECT f.facultyid, f.name, f.phone
  FROM iu_faculty f, iu_crssection c
  WHERE f.facultyid = c.facultyid;

/*4*/
SELECT DISTINCT c1.csid, c1.courseid, c2.title, c1.section, c1.maxcount
  FROM iu_crssection c1, iu_course c2
  WHERE c1.courseid = c2.courseid
    AND c1.maxcount <= ALL (
      SELECT l.capacity 
      FROM iu_location l
      WHERE l.roomtype != 'O'
    );

/*5*/
SELECT DISTINCT s.studentid, s.last||', '||s.first AS "Name"
  FROM iu_student s, iu_registration
  WHERE s.studentid = ANY (
    SELECT r.studentid 
    FROM iu_registration r
    WHERE r.final IS NOT NULL
  );

/*6*/
/*a*/
--TO TEST WITH 
DELETE FROM iu_term 
  WHERE termid = 'WN17';
  
INSERT INTO iu_term (termid, termdesc, startdate, enddate)
  VALUES ('WN17', 'Winter 2017', 
  to_date('19-JAN-17','DD-MON-RR'),
  to_date('12-MAY-17','DD-MON-RR'));

/*b*/
INSERT INTO iu_crssection (
    courseid, section, termid, facultyid, 
    day, starttime, endtime, roomid, maxcount
  ) (
    SELECT s.courseid, s.section, 
        'WN17', s.facultyid, s.day, s.starttime, 
        s.endtime, s.roomid, s.maxcount
    FROM iu_crssection s 
    WHERE termid='WN03'
  );

/*7*/
DELETE FROM iu_registration 
  WHERE studentid = (
    SELECT s.studentid 
    FROM iu_student s
    WHERE s.last = 'Lee'
      AND s.first = 'Brian'    
  )
  AND csid = ANY(
    SELECT c.csid 
    FROM iu_crssection c
    WHERE c.termid='SP03'
  );





  
  
  