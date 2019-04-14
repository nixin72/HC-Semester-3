/*
  PART A
*/

/*A*/
SELECT e.lname||', '||e.fname AS "Name", d.deptname AS "Department"
  FROM nn_employee e, nn_dept d
  WHERE e.deptid = d.deptid;
  
/*B*/
SELECT e1.lname||', '||e1.fname AS "Employee Name"
          , e2.lname||', '||e2.fname AS "Supervisor Name"
  FROM nn_employee e1, nn_employee e2
  WHERE e1.supervisor = e2.employeeid AND e1.employeeid = 433;
  
/*C*/
SELECT e1.lname||', '||e1.fname AS "Employee Name", e1.salary
          , e2.lname||', '||e2.fname AS "Supervisor Name", e2.salary
  FROM nn_employee e1, nn_employee e2
  WHERE e1.supervisor = e2.employeeid;

/*D*/
SELECT e1.lname||', '||e1.fname AS "Employee Name", e1.salary, p.posdesc AS "Position"
  FROM nn_employee e1, nn_position p
  WHERE e1.positionid = p.positionid;

/*E*/
SELECT e.lname||', '||e.fname AS "Employee Name"
      , d.deptname AS "Department name"
      , p.posdesc AS "Position"
      , e.qualid AS "Qualification"
  FROM nn_employee e, nn_position p, nn_dept d
  WHERE e.positionid = p.positionid AND e.deptid = d.deptid and e.qualid IS NOT NULL;

/*F*/
SELECT e.lname||', '||e.fname AS "Employee Name"
      , d.deptname AS "Department name"
  FROM nn_employee e, nn_dept d
  WHERE e.deptid = d.deptid AND d.deptname='Sales';
  
/*G*/
SELECT e.lname||', '||e.fname AS "Employee Name", d.dependentid
  FROM nn_employee e
  LEFT JOIN nn_dependent d
  ON e.employeeid = d.employeeid;
  
/*H*/--current_timestamp
SELECT e.lname||', '||e.fname AS "Employee Name", 
      EXTRACT(year FROM current_timestamp) - EXTRACT(year FROM e.hiredate) AS "Years with dept"
      , d.deptname AS "Department name"
  FROM nn_employee e, nn_dept d, nn_job_history j
  WHERE e.deptid = j.deptid AND e.deptid = d.deptid
  ORDER BY 'Years with dept' desc;
  
/*I*/  
SELECT e1.lname||', '||e1.fname AS "Employee Name",
      e2.lname||', '||e2.fname AS "CO-worker"
  FROM nn_employee e1, nn_employee e2
  WHERE e2.deptid = e1.deptid 
    AND e1.fname='John' 
    AND e1.lname='Smith';
  
  
/*
  PART B
*/

/*1*/
SELECT f.name, c1.courseid, c2.title
  FROM iu_crssection c1, iu_course c2, iu_faculty f
  WHERE c1.facultyid = f.facultyid 
    AND c1.courseid = c2.courseid;
    
/*2*/
SELECT c1.title, c2.title AS "Prerequisite"
  FROM iu_course c1, iu_course c2
  WHERE c1.prereq = c2.courseid
union
SELECT c1.title "course title", 'none' "Prerequisite"
  FROM iu_course c1
  WHERE c1.prereq IS NULL;
  
/*3*/
SELECT s.last||', '||s.first AS "Name", 
    '('||substr(s.phone,0,3)||') '||substr(s.phone,4,3)||'-'||substr(s.phone, 7) AS "Phone number"
  FROM iu_student s, iu_faculty f
  WHERE s.facultyid = f.facultyid AND f.name = '&name';

/*4*/
SELECT c1.termid, c1.courseid, c2.title, c1.section, COUNT(r.studentid) AS "Students"
  FROM iu_crssection c1, iu_course c2, iu_registration r 
  WHERE c1.courseid = c2.courseid AND r.csid = c1.csid
  GROUP BY c1.termid, c1.courseid, c2.title, c1.section
  ORDER BY c1.termid, c1.courseid;

/*5*/
SELECT s.first||' '||s.last AS "Name", COUNT(r.studentid) AS "Number of courses" 
  FROM iu_student s, iu_registration r
  WHERE r.final IS NOT NULL AND s.studentid = r.studentid
  GROUP BY s.first||' '||s.last;
  
  
  
   
  
  
  
  
  
  
  