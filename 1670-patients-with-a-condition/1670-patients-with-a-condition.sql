# Write your MySQL query statement below
SELECT patient_id,
       patient_name,
       CONDITIONS
FROM Patients
WHERE conditions LIKE 'DIAB1%'
   OR conditions LIKE '% DIAB1%';
