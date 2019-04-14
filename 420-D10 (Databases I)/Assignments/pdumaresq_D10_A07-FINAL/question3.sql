/*Question 3*/
--DROP VIEW hvk_reservation_charges_vw;
--CREATE VIEW hvk_reservation_charges_vw AS (
  SELECT DISTINCT r.reservation_number AS "Reservation number", 
      o.owner_number AS "Customer number", 
      p.pet_number AS "Pet Number", 
      'Dog' AS "Pet Type",
      p.pet_name AS "Pet Name", 
      s.service_description AS "Service", 
      CASE 
        WHEN pr.run_run_number is null 
          THEN ' ' 
        ELSE 
          'Run '||pr.run_run_number 
      END AS "Run/Suite",
      r.reservation_start_date AS "Start date", 
      r.reservation_end_date AS "End Date",
      
      NVL(prs.service_frequency, r.reservation_end_date - r.reservation_start_date) AS "Frequency",
      
      CASE dr.serv_service_number
        WHEN 5 THEN 2
        WHEN 4 THEN 1
        ELSE dr.daily_rate
      END AS "Daily Rate" 
      
    FROM hvk_reservation r, hvk_owner o, hvk_pet p, hvk_pet_reservation pr, 
      hvk_pet_reservation_service prs, hvk_service s, hvk_daily_rate dr, 
      hvk_dog d, hvk_run run 
    
    WHERE o.owner_number = p.own_owner_number
      AND p.pet_number = pr.pet_pet_number 
      AND pr.res_reservation_number = r.reservation_number
      AND prs.pr_pet_res_number = pr.pet_res_number
      AND s.service_number = prs.serv_service_number
      AND d.pet_pet_number = p.pet_number
--      
      AND dr.serv_service_number = prs.serv_service_number
      AND dr.daily_rate_dog_size = d.dog_size
      AND dr.daily_rate_pet_type = 'D'
--            
--      AND dr.serv_service_number = prs.serv_service_number
      AND prs.pr_pet_res_number = pr.pet_res_number
     
   UNION 

     SELECT DISTINCT r.reservation_number AS "Reservation number", 
      o.owner_number AS "Customer number", 
      p.pet_number AS "Pet Number", 
      'Cat' AS "Pet Type",
      p.pet_name AS "Pet Name", 
      s.service_description AS "Service",
      NVL(cst.suite_description, ' ') AS "Run/Suite",
      r.reservation_start_date AS "Start date", 
      r.reservation_end_date AS "End Date",
      NVL(prs.service_frequency, r.reservation_end_date - reservation_start_date) AS "Frequency",      
      
      CASE WHEN pr.pr_sharing_with IS NULL THEN (
          CASE dr.cst_cat_suite_type_number
            WHEN 1 THEN 10
            WHEN 2 THEN 11
            WHEN 3 THEN 12
          END          
        )
        ELSE (
          SELECT dr.daily_rate 
          FROM hvk_daily_rate dr
          WHERE dr.daily_rate_number_of_cats = 2
        ) 
      END AS "Daily Rate"
      
    FROM hvk_reservation r, hvk_owner o, hvk_pet p, hvk_pet_reservation pr, 
      hvk_pet_reservation_service prs, hvk_service s, hvk_daily_rate dr, hvk_cat c,
      hvk_cat_suite_type cst
    
    WHERE o.owner_number = p.own_owner_number
      AND p.pet_number = pr.pet_pet_number 
      AND pr.res_reservation_number = r.reservation_number
      AND prs.pr_pet_res_number = pr.pet_res_number
      AND s.service_number = prs.serv_service_number
      AND dr.serv_service_number = prs.serv_service_number
      AND dr.daily_rate_pet_type = 'C'
      AND dr.cst_cat_suite_type_number = cst.cat_suite_type_number
      AND c.pet_pet_number = p.pet_number
      AND cst.cat_suite_type_number = pr.cs_cat_suite_number
      AND prs.pr_pet_res_number = pr.pet_res_number
      
--      AND CASE WHEN pr.pr_sharing_with IS NOT NULL THEN dr.daily_rate_number_of_cats END
      
--   ORDER BY r.reservation_number 
--)
; 

SELECT hvk_pet_reservation_service.* 
  FROM hvk_pet_reservation_service, hvk_pet_reservation, hvk_pet, hvk_cat
  WHERE hvk_pet_reservation.PET_RES_NUMBER = hvk_pet_reservation_service.PR_PET_RES_NUMBER
  AND hvk_pet_reservation.PET_PET_NUMBER = hvk_pet.pet_number
  AND hvk_pet.pet_number = hvk_cat.pet_pet_number;
