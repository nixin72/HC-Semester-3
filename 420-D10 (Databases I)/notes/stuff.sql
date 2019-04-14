/*
Anonymous blocks: DECLARE/BEGIN/END

Procedure blocks: Create or Replace procedure_name(param1, param2...) AS
                    declaration section...
                    BEGIN
                    ...
                    END;

Begin 
  procedure_name('param1', 'param2');
END;
*/

BEGIN
  give_raise_sp(&position_id, &raise_percentage);
END;

SET SERVEROUTPUT ON;
DECLARE
  TYPE ltype_student IS RECORD (
      name         iu_student.first%TYPE;
      studentid    IU_STUDENT.STUDENTID%TYPE;
      facultyname  IU_FACULTY.NAME%TYPE;
      department   IU_DEPARTMENT.DEPTNAME%TYPE;
      phone        IU_FACULTY.PHONE%TYPE;      
   );
  lrec_student ltype_student;

  CURSOR lcur_student
  IS SELECT s.first || ' ' || s.last AS STUDENTNAME, s.studentid, f.name AS FACULTYNAME, d.deptname, f.phone
      FROM iu_student s, iu_faculty f, iu_department d
      WHERE s.facultyid = f.facultyid
        AND d.deptid = f.deptid;
BEGIN
  OPEN lcur_student;
  FETCH lcur_student INTO lrec_student;
  LOOP
    DBMS_OUTPUT.PUT_LINE('Student '||lrec_student.STUDENTNAME||'('||lrec_student.studentid||')'||' is advised by '||lrec_student.FACULTYNAME
        ||' from the '||lrec_student.department);
    DBMS_OUTPUT.PUT_LINE('department. His/Her Phone extension is '||lrec_student.phone);
    FETCH lcur_student INTO lrec_student;
    EXIT WHEN lcur_student%NOTFOUND;
  END LOOP;
  CLOSE lcur_student;
END;
