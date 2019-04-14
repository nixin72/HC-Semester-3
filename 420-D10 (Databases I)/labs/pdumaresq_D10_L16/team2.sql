REVOKE SELECT ON iu_student FROM mlurette;
GRANT SELECT ON iu_student TO d10;

DROP SYNONYM pd;
CREATE SYNONYM pd FOR PDUMARESQ.IU_STUDENT;

select * from pd;

update table pd set enddate = to_date