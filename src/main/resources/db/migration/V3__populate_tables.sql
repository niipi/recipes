INSERT INTO kategoriat VALUES (1, 'kana');
INSERT INTO kategoriat VALUES (2, 'porsas');
INSERT INTO kategoriat VALUES (3, 'nauta');
INSERT INTO kategoriat VALUES (4, 'jauheliha');
INSERT INTO kategoriat VALUES (5, 'kasvis');
INSERT INTO kategoriat VALUES (6, 'makkara');
INSERT INTO kategoriat VALUES (7, 'äyriäiset');
INSERT INTO kategoriat VALUES (8, 'pasta');
INSERT INTO kategoriat VALUES (9, 'lisukkeet');
INSERT INTO kategoriat VALUES (10, 'kakut');
INSERT INTO kategoriat VALUES (11, 'jälkiruuat');
INSERT INTO kategoriat VALUES (12, 'muu');

INSERT INTO resepti VALUES (1, 'Mangomuffinit', TRUE, 'aina','kuva');
INSERT INTO resepti VALUES (2, 'Hunaja-rakuunaporkkanat', TRUE, 'aina','kuva');

INSERT INTO reseptin_kategoria VALUES (11,1);
INSERT INTO reseptin_kategoria VALUES (9,2);

INSERT INTO ainekset VALUES (1,1,'1','muna',1);
INSERT INTO ainekset VALUES (2,2,'150 g','vaniljajugurtti',1);
INSERT INTO ainekset VALUES (3,3,'1 dl','mangosose',1);
INSERT INTO ainekset VALUES (4,4,'1 dl','sokeri',1);
INSERT INTO ainekset VALUES (5,5,'1 tl','vaniljasokeri',1);
INSERT INTO ainekset VALUES (6,6,'50 g ','margariini sulatettu',1);
INSERT INTO ainekset VALUES (7,7,'2,5 dl','vehnäjauho',1);
INSERT INTO ainekset VALUES (8,8,'1 rkl','perunajauhot',1);
INSERT INTO ainekset VALUES (9,9,'1 tl','leivinjauho',1);
INSERT INTO ainekset VALUES (10,10,'1/3 tl','ruokasooda',1);
INSERT INTO ainekset VALUES (11,1,'6','porkkanaa',2);
INSERT INTO ainekset VALUES (12,2,'2 rkl','hunajaa',2);
INSERT INTO ainekset VALUES (13,3,'2 rkl','öljyä',2);
INSERT INTO ainekset VALUES (14,4,'','rakuunaa',2);
INSERT INTO ainekset VALUES (15,5,'','suolaa',2);

INSERT INTO ohje VALUES (1,1,'uuni 180 celciusta',1);
INSERT INTO ohje VALUES (2,2,'riko kananmunan rakenne kulhossa',1);
INSERT INTO ohje VALUES (3,3,'lisää vaniljajugurtti, mangosose, sokeri ja sulatettu margariini',1);
INSERT INTO ohje VALUES (4,4,'sekoita tasaiseksi',1);
INSERT INTO ohje VALUES (5,5,'sekoita muut kuivat aineet erillisessä kulhossa',1);
INSERT INTO ohje VALUES (6,6,'lisää kuivat aineet ja kääntele taikina sekaisin',1);
INSERT INTO ohje VALUES (7,7,'täytä muffinsipellin kolot muffinssivuoilla',1);
INSERT INTO ohje VALUES (8,8,'jaa taikina vuokiin niin, että täyttyvät n. 2/3',1);
INSERT INTO ohje VALUES (9,9,'paista uunin keskitasolla n. 25 min',1);
INSERT INTO ohje VALUES (10,1,'Kuori ja pilko porkkanat.',2);
INSERT INTO ohje VALUES (11,2,'Laita porkkanat uunivuokaan ja valuta niiden päälle öljyä ja hunajaa.',2);
INSERT INTO ohje VALUES (12,3,'Mausta rakuunalla ja pyörittele ainekset sekaisin.',2);
INSERT INTO ohje VALUES (13,4,'Mausta suolalla.',2);
INSERT INTO ohje VALUES (14,5,'Paista 225-asteisessa uunissa noin 20 min.',2);