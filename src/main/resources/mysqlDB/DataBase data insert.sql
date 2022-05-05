USE hospital;

INSERT INTO `person`(id,firstName,lastName,phoneNumber) VALUES (1,'Maria','Stepanko',0978050155);
INSERT INTO `person`(id,firstName,lastName,phoneNumber) VALUES (2,'Olena','Kravetc',0965055128);
INSERT INTO `person`(id,firstName,lastName,phoneNumber) VALUES (3,'Olga','Ivanova',0671110089);
INSERT INTO person 
VALUES (4, 'Henry', 'Fuller','(978)123-1234');
INSERT INTO person
 VALUES (5, 'Zack', 'Futa', '(123)436-1236');
INSERT INTO person
 VALUES (6, 'Cam', 'Ryder','(543)753-1327');
INSERT INTO person
 VALUES (7, 'Janet', 'Grosmen','(617)355-7684');
INSERT INTO
 person VALUES (8, 'Michelle', 'Haverhill','(631)125-1235');
INSERT INTO
 person VALUES (9, 'Oliver', 'Mansman','(934)126-6421');
INSERT INTO
 person VALUES (10, 'Lisa', 'Perez', '(682)165-8523');
INSERT INTO
 person VALUES (11, 'Tilda', 'White','(723)983-8521');
INSERT INTO
 person VALUES (12, 'Patrick', 'McGuiyver','(213)753-7234');
INSERT INTO
 person VALUES (13, 'Wilson', 'Wilson','(734)357-9853');
 INSERT INTO
 person VALUES (14, 'Maria', 'Anders','(380)957985300');
 INSERT INTO
 person VALUES (15, 'Anna', 'Trujillo','(734)557-9853');
 INSERT INTO
 person VALUES (16, 'Thomas', 'Hardy','(735)857-9853');
INSERT INTO patient(id,age,bloodGroup,sex,Person_id) VALUES (1,27,'A','F',3);
INSERT INTO
 patient VALUES (2,19,'AB+','F',11);
 INSERT INTO
 patient VALUES (3,41,'A+','M',12);
  INSERT INTO
 patient VALUES (4,72,'B-','M',13);
INSERT INTO nurses VALUES (1,2,5),(2,  7,7),(3,  8,10),(4,  10,5);
INSERT INTO doctors(id,availaibleDate,Person_id) VALUES (1,'2022-05-07',1);
INSERT INTO
 doctors VALUES (2, '2022-05-25', 4);
 INSERT INTO
 doctors VALUES (3, '2022-05-30', 5);
 INSERT INTO
 doctors VALUES (4, '2022-06-02', 6);
 INSERT INTO
 doctors VALUES (5, '2022-06-15', 9);
 INSERT INTO
 doctors VALUES (6, '2022-06-17', 14);
 INSERT INTO
 doctors VALUES (7, '2022-06-18', 15);
 INSERT INTO
 doctors VALUES (8, '2022-06-19', 16);
INSERT INTO specialization(id,specializationName) VALUES (1,'Ophthalmology');
INSERT INTO specialization VALUES (2,'Pediatric');
INSERT INTO specialization VALUES (3,'ER');
INSERT INTO specialization VALUES (4,'Burn Center');
INSERT INTO specialization VALUES (5,'Surgery');
INSERT INTO expertin(id,Doctors_id,Specialization_id) VALUES (1,1,1);
INSERT INTO
 expertin VALUES (2, 2, 2);
 INSERT INTO
 expertin VALUES (3, 3, 3);
 INSERT INTO
 expertin VALUES (4, 4, 4);
 INSERT INTO
 expertin VALUES (5, 5, 5);
  INSERT INTO
 expertin VALUES (6, 6, 5);
  INSERT INTO
 expertin VALUES (7, 8, 5);
 INSERT INTO
 expertin VALUES (8, 7, 3);
INSERT INTO nurseallocation(id,dateIn,dateOut,Nurses_id,Doctors_id,Patient_id) 
VALUES (1,'2022-05-01','2022-05-10',1,1,1);
INSERT INTO rooms(id,roomNumber,departmentName,dateIn,dateOut,Patient_id) 
VALUES (1,5,'Ophthalmic','2022-05-18','2022-05-28',1);
INSERT INTO bill(id,summ,paymentDate,Patient_id)
 VALUES (1,355.5,'2022-05-18',1);
 INSERT INTO
 bill VALUES (2,700.0,'2022-05-01',2);
 INSERT INTO
 bill VALUES (3,150.0,'2022-05-05',3);
 INSERT INTO
 bill VALUES (4,200.0,'2022-05-12',4);
 INSERT INTO tests(id,testName) VALUES (1,'Retinal Tomography');
 INSERT INTO tests 
VALUES (2,'Some test1');
INSERT INTO tests 
VALUES (3,'Some test2');
INSERT INTO tests 
VALUES (4,'Some test3');
INSERT INTO tests 
VALUES (5,'Some test1');
INSERT INTO tests 
VALUES (6,'Some test1');
INSERT INTO tests 
VALUES (7,'Some test2');
INSERT INTO tests 
VALUES (8,'Some test3');
INSERT INTO tests 
VALUES (9,'Some test1');
 INSERT INTO testsdescriptions(id,testDate,testAnalysis,Tests_id,Patient_id)
 VALUES (1,'2022-05-10','Retinal detachment is absent,age-related macular degeneration not found',1,1),
(2,'2022-05-15','Description for Some test1',2,2),(3,'2022-05-15','Description for Some test2',3,3),
 (4,'2022-05-15','Description for Some test3',4,4);
 INSERT INTO records(id,recordAnalysis,Patient_id)
 VALUES (1,'The retinal tomography was performed. The retinal detachment is negative. Age-related macular degeneration-result is negative',1);
 INSERT INTO medicines(id,medicineName) VALUES (1,'Visine');
 INSERT INTO medicines
VALUES (2, 'Noshpa');
INSERT INTO medicines
VALUES (3, 'Coldrex');
INSERT INTO medicines
VALUES (4, 'Fervex');
INSERT INTO medicines
VALUES (5, 'Lioton');
INSERT INTO medicines
VALUES (6, 'Some medicines1');
INSERT INTO medicines
VALUES (7, 'Some medicines2');
INSERT INTO medicines
VALUES (8, 'Some medicines3');
 INSERT INTO takes(id,quantiti,takesDate,Medicines_id,Patient_id)
 VALUES (1,3.0,'2022-05-19',1,1);
 INSERT INTO appointment(id,appointmentDate,Doctors_id,Patient_id)
 VALUES (1,'2022-05-20',1,1);
