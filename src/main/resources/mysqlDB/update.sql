USE mydb;

UPDATE takes
SET quantiti = 2.0
WHERE id=1;

UPDATE bill
SET summ = 120.0
WHERE (id>2);

UPDATE bill
SET paymentDate = '2022-05-10'
WHERE (id=2);

UPDATE bill
SET summ = 100.0
WHERE (Patient_id=2);

 UPDATE person
SET firstName='Kim'
WHERE id=6;

UPDATE expertin
SET Specialization_id=2
WHERE Doctors_id=5;

UPDATE expertin
SET Specialization_id=5
WHERE Doctors_id=2;