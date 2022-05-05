USE mydb;

SELECT doctors.id, person.firstName 
FROM doctors
INNER JOIN person ON doctors.id=person.id;

SELECT person.firstName, doctors.id
FROM person
LEFT JOIN doctors ON person.id = doctors.id
ORDER BY person.firstName;

SELECT doctors.id, person.lastName, person.firstName
FROM doctors
RIGHT JOIN person ON doctors.Person_id = person.id
ORDER BY doctors.id;

 
