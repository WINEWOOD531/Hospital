USE mydb;

DELETE FROM medicines
 WHERE medicineName='Noshpa';
DELETE FROM medicines
 WHERE id > 1 LIMIT 2;
DELETE FROM medicines
 WHERE id > 1;
DELETE FROM tests
WHERE testName = 'Some test1'
ORDER BY id
LIMIT 2;
DELETE FROM tests 
WHERE testName
 LIKE 'Some test%';
