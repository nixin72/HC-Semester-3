ALTER TABLE hvk_reservation 
  ADD CONSTRAINT chk_status 
  CHECK (reservation_status >= 1 AND reservation_status <= 5);

ALTER TABLE hvk_run 
  ADD CONSTRAINT chk_run_status 
  CHECK (run_status >= 1 AND run_status <= 3);

CREATE SEQUENCE hvk_food_seq START WITH 50;
CREATE SEQUENCE hvk_medication_seq START WITH 10;
CREATE SEQUENCE hvk_owner_seq START WITH 50;
CREATE SEQUENCE hvk_pet_res_seq START WITH 1000;
CREATE SEQUENCE hvk_pet_seq START WITH 50;
CREATE SEQUENCE hvk_reservation_seq START WITH 1000;
CREATE SEQUENCE hvk_vet_seq START WITH 10;

SELECT * FROM all_sequences WHERE sequence_owner = 'pdumaresq';
  
UPDATE hvk_pet
  SET pet_birthdate = add_months(pet_birthdate, 5*12)
  WHERE pet_birthdate IS NOT NULL;
  
UPDATE hvk_pet_vaccination
  SET vaccination_expiry_date = ADD_MONTHS(vaccination_expiry_date, 12)
  WHERE vaccination_expiry_date IS NOT NULL;
  
UPDATE hvk_reservation
  SET reservation_start_date = ADD_MONTHS(reservation_start_date, 12)
  WHERE reservation_start_date IS NOT NULL;
  
UPDATE hvk_reservation
  SET reservation_end_date = ADD_MONTHS(reservation_end_date, 12)
  WHERE reservation_end_date IS NOT NULL;
  
SELECT pet_name, pet_birthdate
  FROM hvk_pet
  WHERE pet_birthdate IS NOT NULL;
  
SELECT DISTINCT p.pet_name, pv.vaccination_expiry_date, v.vaccination_name, p.pet_number
  FROM hvk_pet p, hvk_pet_vaccination pv, hvk_vaccination v
  WHERE p.pet_number = pv.pet_pet_number
    AND pv.vacc_vaccination_number = v.vaccination_number
  ORDER BY p.pet_number asc;
  
SELECT r.reservation_number, r.reservation_start_date, 
  r.reservation_end_date, p.pet_name
FROM hvk_reservation r, hvk_pet p, hvk_pet_reservation pr
WHERE p.pet_number = pr.pet_pet_number 
  AND pr.res_reservation_number = r.reservation_number;
  


--DROP SEQUENCE hvk_food_seq;
--DROP SEQUENCE hvk_medication_seq;
--DROP SEQUENCE hvk_owner_seq;
--DROP SEQUENCE hvk_pet_res_seq;
--DROP SEQUENCE hvk_pet_seq;
--DROP SEQUENCE hvk_reservation_seq;
--DROP SEQUENCE hvk_vet_seq;

COMMIT;