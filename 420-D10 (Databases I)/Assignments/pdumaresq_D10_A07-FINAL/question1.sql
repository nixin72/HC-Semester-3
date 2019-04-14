SELECT r.reservation_number
  FROM hvk_reservation r
  WHERE r.RESERVATION_START_DATE > TO_DATE('10-NOV-16','DD-MON-YY');
  
SELECT p.pet_number
  FROM hvk_pet p
  
  ;
  
SELECT DISTINCT p.pet_name, 'Dog' AS "Pet type", v.VACCINATION_NAME
  FROM hvk_pet p, hvk_dog d, hvk_pet_vaccination pv
  inner JOIN hvk_vaccination v
    ON pv.VACC_VACCINATION_NUMBER =  v.VACCINATION_NUMBER
  WHERE p.pet_number = d.pet_pet_number
    AND pv.PET_PET_NUMBER = p.PET_NUMBER
    AND pv.VACC_VACCINATION_NUMBER != ANY (SELECT v.vaccination_number FROM hvk_vaccination v WHERE v.VACCINATION_PET_TYPE != 'D')
    AND p.pet_number = 7  
    AND v.VACCINATION_PET_TYPE = 'D'
    ;
  


SELECT p.pet_name, 'Cat' AS "Pet type"
  FROM hvk_pet p, hvk_cat c, hvk_pet_vaccination pv
  WHERE p.pet_number = c.pet_pet_number
    AND pv.PET_PET_NUMBER = p.PET_NUMBER;  
  
  
  
SELECT DISTINCT o.owner_last_name||', '||o.owner_first_name AS "Owner",
  
  r.reservation_number AS "Reservation number",
  p.pet_name
  
FROM hvk_reservation r, hvk_owner o, hvk_pet_reservation pr, hvk_pet p
WHERE r.RESERVATION_START_DATE > TO_DATE('10-NOV-16','DD-MON-YY')
  AND pr.RES_RESERVATION_NUMBER = r.RESERVATION_NUMBER
  AND pr.PET_PET_NUMBER = p.PET_NUMBER
  AND p.OWN_OWNER_NUMBER = o.OWNER_NUMBER
  ;

SELECT DISTINCT o.owner_last_name||', '||o.owner_first_name AS "Owner",
    o.owner_phone, p.pet_name||' ('||p.pet_number||')' AS "Pet", 
    v.vaccination_pet_type,
    r.reservation_start_date, r.reservation_end_date, v.vaccination_name
  FROM hvk_pet p, hvk_owner o,
    hvk_reservation r, hvk_pet_reservation pr,
    hvk_pet_vaccination pv, hvk_vaccination v
  WHERE r.reservation_start_date >= TO_DATE('10-NOV-2016', 'DD-MON-RR')
    AND pr.pet_pet_number = p.pet_number
    AND p.own_owner_number = o.owner_number
    AND r.reservation_number = pr.res_reservation_number
    AND v.vaccination_number = pv.vacc_vaccination_number
    AND pv.vaccination_expiry_date >= r.reservation_end_date
    AND v.vaccination_number = pv.vacc_vaccination_number
    ;  
    
SELECT DISTINCT p.pet_name, v.vaccination_name, pv.vaccination_expiry_date
  FROM hvk_pet p, hvk_vaccination v, hvk_pet_vaccination pv 
--    hvk_pet_reservation, hvk_reservation, hvk_owner
  WHERE pv.pet_pet_number = p.pet_number
    AND (
        SELECT DISTINCT COUNT(vaccination_expiry_date)
          FROM hvk_pet_vaccination
--          WHERE pet_pet_number = 
      ) != 6
    
    ;
    
SELECT DISTINCT pv.vaccination_expiry_date, pv.pet_pet_number, r.reservation_end_date
  FROM hvk_pet_vaccination pv, hvk_reservation r
  WHERE pv.vaccination_expiry_date <= ANY(
    SELECT DISTINCT reservation_end_date
      FROM hvk_reservation r, hvk_pet_reservation pr
      WHERE r.reservation_number = pr.res_reservation_number
        AND pr.pet_pet_number = pv.pet_pet_number
  )
  ORDER BY pv.pet_pet_number
  ;
    
SELECT pv.vaccination_expiry_date, pv.pet_pet_number
  FROM hvk_pet_vaccination pv, hvk_vaccination v
  WHERE v.vaccination_number NOT IN pv.vacc_vaccination_number
  ORDER BY pv.pet_pet_number
  ;
    
--Works for all owner and pet information
SELECT DISTINCT o.owner_last_name||', '||o.owner_first_name AS "Owner name", 
    o.owner_phone AS "Phone number", p.pet_name AS "Name", 'Dog' AS "Pet type"    
  FROM hvk_pet p, hvk_dog d, hvk_owner o
  WHERE p.pet_number = d.pet_pet_number
    AND o.owner_number = p.own_owner_number
UNION 
SELECT DISTINCT o.owner_last_name||', '||o.owner_first_name AS "Owner name", 
    o.owner_phone AS "Phone number", p.pet_name AS "Name", 'Cat' AS "Pet type"
  FROM hvk_pet p, hvk_cat c, hvk_owner o
  WHERE p.pet_number = c.pet_pet_number
    AND o.owner_number = p.own_owner_number
  ;
--Almost there on the missing vaccinations
SELECT pv.vaccination_expiry_date , pv.pet_pet_number, 'Missing'
  FROM hvk_pet_vaccination pv
  WHERE pv.pet_pet_number = ANY(
    SELECT pv.pet_pet_number
      FROM hvk_pet_vaccination pv
      GROUP BY pv.pet_pet_number
      HAVING count(pv.vaccination_expiry_date) < 4
  )
  ORDER BY pv.pet_pet_number;
  
--Finding expired vaccinations
SELECT DISTINCT pv.vaccination_expiry_date , pv.pet_pet_number
  FROM hvk_pet_vaccination pv, hvk_pet_reservation pr, hvk_reservation r
  WHERE pv.vaccination_expiry_date >= (
    SELECT r.reservation_end_date
      FROM hvk_reservation r
  );