GRANT SELECT ON iu_student TO d10team2; 
REVOKE SELECT ON iu_student FROM public; 

INSERT INTO iu_student (
  studentid
)
values (
  ''
);

commit;