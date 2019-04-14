/*Question 2*/
SELECT DISTINCT p.pet_name AS "Pet Name", 'Dog' AS "Pet Type",
    SUM(r.reservation_end_date - r.reservation_start_date) AS "Days Stayed",
    o.owner_first_name||' '||o.owner_last_name AS "Customer", 
    '('||SUBSTR(o.owner_phone, 0, 3)||')'||SUBSTR(o.owner_phone, 4, 3)||'-'||SUBSTR(o.owner_phone, 7) AS "Phone"
  FROM hvk_reservation r, hvk_pet_reservation pr, hvk_pet p, hvk_owner o, hvk_dog d
  WHERE r.reservation_start_date <= SYSDATE
    AND pr.res_reservation_number = r.reservation_number
    AND pr.pet_pet_number = p.pet_number
    AND o.owner_number = p.own_owner_number 
    AND p.pet_number = d.pet_pet_number
    GROUP BY p.pet_name, o.owner_last_name, o.owner_first_name, o.owner_phone
   HAVING SUM(r.reservation_end_date - r.reservation_start_date) >= ALL(
      SELECT DISTINCT SUM(r.reservation_end_date - r.reservation_start_date) AS "Days Stayed"
        FROM hvk_reservation r, hvk_pet_reservation pr, hvk_pet p, hvk_owner o
        WHERE r.reservation_start_date <= SYSDATE
          AND pr.res_reservation_number = r.reservation_number
          AND pr.pet_pet_number = p.pet_number
          AND o.owner_number = p.own_owner_number
          GROUP BY p.pet_name, 'Customer', 'Phone', o.owner_first_name, o.owner_phone
  )
Union
SELECT DISTINCT p.pet_name AS "Pet Name", 'Cat' AS "Pet Type",
    SUM(r.reservation_end_date - r.reservation_start_date) AS "Days Stayed",
    o.owner_first_name||' '||o.owner_last_name AS "Customer", 
    '('||SUBSTR(o.owner_phone, 0, 3)||')'||SUBSTR(o.owner_phone, 4, 3)||'-'||SUBSTR(o.owner_phone, 7) AS "Phone"
  FROM hvk_reservation r, hvk_pet_reservation pr, hvk_pet p, hvk_owner o, hvk_cat c
  WHERE r.reservation_start_date <= SYSDATE
    AND pr.res_reservation_number = r.reservation_number
    AND pr.pet_pet_number = p.pet_number
    AND o.owner_number = p.own_owner_number 
    AND p.pet_number = c.pet_pet_number
    GROUP BY p.pet_name, o.owner_first_name, o.owner_last_name, o.owner_phone
  HAVING SUM(r.reservation_end_date - r.reservation_start_date) >= ALL(
      SELECT DISTINCT SUM(r.reservation_end_date - r.reservation_start_date) AS "Days Stayed"
        FROM hvk_reservation r, hvk_pet_reservation pr, hvk_pet p, hvk_owner o
        WHERE r.reservation_start_date <= SYSDATE
          AND pr.res_reservation_number = r.reservation_number
          AND pr.pet_pet_number = p.pet_number
          AND o.owner_number = p.own_owner_number
          GROUP BY p.pet_name, 'Customer', 'Phone', o.owner_first_name, o.owner_phone
  )
;