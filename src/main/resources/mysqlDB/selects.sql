USE mydb;

SELECT * 
FROM person;

SELECT 
    age, 
    bloodGroup, 
    Person_id
FROM
    patient
WHERE
    sex = 'F';
	
SELECT 
	id,
    paymentDate, 
    Patient_id, 
    summ
FROM
    bill
WHERE
    Patient_id > 1 AND 
    summ > 100;
	
SELECT    
	Doctors_id,
    Specialization_id
FROM    
	expertin
WHERE Specialization_id = 3 OR 
      Specialization_id = 5;
	  
SELECT 
     id,
    firstName, 
    lastName, 
    phoneNumber
FROM
    person
WHERE id IN (SELECT id FROM nurses);

SELECT * FROM bill
WHERE summ BETWEEN 100 AND 300;

SELECT 
    firstName, lastName, phoneNumber
FROM
    person
ORDER BY firstName;

SELECT 
    Specialization_id, 
    COUNT(*)
FROM
    expertin
GROUP BY Specialization_id;	  