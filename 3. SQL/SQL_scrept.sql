
DROP DATABASE human_friends;
CREATE DATABASE IF NOT EXISTS human_friends;
USE human_friends;

DROP TABLE IF EXISTS animal_class;
CREATE TABLE animal_class
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	Class_name VARCHAR(20)
);

INSERT INTO animal_class (Class_name)
VALUES 
('Вьючные'),
('Домашние');  

DROP TABLE IF EXISTS pack_animal;
CREATE TABLE pack_animal
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_class (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animal (Genus_name, Class_id)
VALUES
('Лошади', 1),
('Верблюды', 1),  
('Ослы', 1); 
 
DROP TABLE IF EXISTS home_animal;
CREATE TABLE home_animal
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_class (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO home_animal (Genus_name, Class_id)
VALUES
('Кошки', 2),
('Собаки', 2),  
('Хомяки', 2); 

DROP TABLE IF EXISTS cat;
CREATE TABLE cat 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animal (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO cat (Name, Birthday, Commands, Genus_id)
VALUES
('Cat1', '2020-01-01', 'cat_sit, cat_come, cat_voice', 1),
('Cat3', '2022-01-01', 'cat_sit, cat_come', 1),  
('Cat2', '2023-01-01', 'cat_sit', 1);

 
DROP TABLE IF EXISTS dog;
CREATE TABLE dog 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animal (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dog (Name, Birthday, Commands, Genus_id)
VALUES 
('Dog1', '2020-01-01', 'dog_sit, dog_come, dog_voice', 2),
('Dog2', '2022-01-01', 'dog_sit, dog_come', 2),  
('Dog3', '2022-01-01', 'dog_sit', 2), 
('Dog4', '2023-01-01', 'dog_voice', 2);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animal (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamster (Name, Birthday, Commands, Genus_id)
VALUES 
('Hamster1', '2020-01-01', 'humster_come', 3),
('Hamster2', '2022-01-01', 'humster_sit, humster_come, humster_voice', 3),  
('Hamster3', '2022-01-01', 'humster_sit, humster_come', 3), 
('Hamster4', '2023-01-01','humster_sit', 3);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animal (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horse (Name, Birthday, Commands, Genus_id)
VALUES 
('Horse1', '2020-01-01', 'horse_voice', 1),
('Horse2', '2022-01-01', 'horse_sit, horse_come, horse_voice', 1),  
('Horse3', '2022-01-01', 'horse_sit, horse_come', 1), 
('Horse4', '2023-01-01', 'horse_sit', 1);



DROP TABLE IF EXISTS camel;
CREATE TABLE camel 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animal (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camel (Name, Birthday, Commands, Genus_id)
VALUES 
('Camel1', '2020-01-01', 'camel_sit, camel_come, camel_voice', 2),
('Camel2', '2022-01-01', 'camel_sit, camel_come', 2),  
('Camel3', '2022-01-01', 'camel_sit', 2), 
('Camel4', '2023-01-01', 'camel_voice', 2);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packId_animal (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkey (Name, Birthday, Commands, Genus_id)
VALUES 
('Donkey1', '2020-01-01', 'donkey_sit, donkey_come, donkey_voice', 3),
('Donkey2', '2022-01-01', 'donkey_sit, donkey_come', 3),  
('Donkey3', '2022-01-01', 'donkey_sit', 3), 
('Donkey4', '2023-01-01', 'donkey_voice', 3);


-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
SET SQL_SAFE_UPDATES = 0;
DELETE  FROM camel;

SELECT 
	Name,
    Birthday,
    Commands 
FROM horse
UNION 
SELECT 
	Name, 
    Birthday,
    Commands
FROM donkey;




-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Лошади' as genus FROM horse
UNION 
SELECT *, 'Ослы' AS genus FROM donkey
UNION 
SELECT *, 'Собаки' AS genus FROM dog
UNION
SELECT *, 'Кошки' AS genus FROM cat
UNION
SELECT *, 'Хомяки' AS genus FROM hamster;

CREATE TABLE yang_animal AS
SELECT 
	Name,
    Birthday,
    Commands,
    genus,
    TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals 
WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM yang_animal;

-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

SELECT 
	h.Name,
    h.Birthday,
    h.Commands,
    pa.Genus_name,
    ya.Age_in_month 
FROM horse h
LEFT JOIN yang_animal ya ON ya.Name = h.Name
LEFT JOIN pack_animal pa ON pa.Id = h.Genus_id
UNION 
SELECT 
	d.Name,
    d.Birthday,
    d.Commands,
    pa.Genus_name,
    ya.Age_in_month 
FROM donkey d 
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN pack_animal pa ON pa.Id = d.Genus_id
UNION
SELECT 
	c.Name,
    c.Birthday,
    c.Commands,
    ha.Genus_name,
    ya.Age_in_month 
FROM cat c
LEFT JOIN yang_animal ya ON ya.Name = c.Name
LEFT JOIN home_animal ha ON ha.Id = c.Genus_id
UNION
SELECT 
	d.Name,
    d.Birthday,
    d.Commands,
    ha.Genus_name,
    ya.Age_in_month 
FROM dog d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN home_animal ha ON ha.Id = d.Genus_id
UNION
SELECT 
	hm.Name,
    hm.Birthday,
    hm.Commands,
    ha.Genus_name,
    ya.Age_in_month 
FROM hamster hm
LEFT JOIN yang_animal ya ON ya.Name = hm.Name
LEFT JOIN home_animal ha ON ha.Id = hm.Genus_id;




































