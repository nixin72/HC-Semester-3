/*1*/
DROP VIEW nn_dept_salaries_vw;
CREATE VIEW nn_dept_salaries_vw AS (
  SELECT DISTINCT d.deptname, AVG(e.salary) AS "Average Salary"
  FROM nn_dept d, nn_employee e 
  WHERE e.deptid = d.deptid 
  group by d.deptname
);
SELECT *
FROM nn_dept_salaries_vw;

/*2*/
SELECT e.employeeid, e.lname||' '||e.fname AS "Name", 
    e.salary, d.deptname, "Average Salary"
  FROM nn_dept d, nn_employee e, nn_dept_salaries_vw s
  WHERE e.salary < s."Average Salary" 
    AND d.deptid = e.deptid;
    
/*3*/
DROP VIEW nn_dept_10_vw;
CREATE VIEW nn_dept_10_vw AS (
  SELECT DISTINCT e.lname||', '||e.lname AS "Name", 
    e.deptid, e.salary + NVL(e.commission, 0) AS "Income"
  FROM nn_employee e 
  WHERE deptid = 10
) WITH READ ONLY;
SELECT *
FROM nn_dept_10_vw;

/*4*/
DROP INDEX iu_student_majorid_idx;
CREATE INDEX iu_student_majorid_idx 
  ON iu_student (majorid);

/*5*/
DROP SEQUENCE iu_location_roomid_seq;

CREATE SEQUENCE iu_location_roomid_seq
  Start With 45
  increment by 1;
  
INSERT INTO iu_location (
    roomid, building, roomno, capacity, roomtype
  ) 
  values (
    iu_location_roomid_seq.NEXTVAL, 'Heritage', 221, 40 , 'C'
  );

/*6*/
DROP SEQUENCE deptid_seq;
DROP SEQUENCE empid_seq;

CREATE SEQUENCE deptid_seq
  START WITH 50
  INCREMENT BY 10;
CREATE SEQUENCE empid_seq
  START WITH 544
  INCREMENT BY 1;
  
INSERT INTO nn_dept (
    deptid, deptname, location, employeeid
  ) 
  values (
    deptid_seq.nextval, 'Web dev', 'Ottawa', empid_seq.nextval
  );
  
INSERT INTO nn_employee (
    employeeid, lname, fname, positionid, supervisor, 
    hiredate, salary, commission, deptid, qualid
  )
  values (
    empid_seq.nextval, 'Dumaresq', 'Philip', 3, 111, 
    TO_DATE('30-MAY-2017', 'DD-MON-RR'), 100000, null, deptid_seq.currval, 1
  );






