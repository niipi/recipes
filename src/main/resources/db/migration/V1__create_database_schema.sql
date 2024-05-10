CREATE TABLE IF NOT EXISTS resepti (
    id_resepti BIGINT unsigned auto_increment primary key,
    nimi VARCHAR(250) NOT NULL,
    suosikki BOOLEAN NOT NULL,
    sesonki VARCHAR(10),
    kuva VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS ohje (
    id_ohje BIGINT unsigned auto_increment primary key,
    järjestysluku INT NOT NULL,
    ohjeet VARCHAR(1000) NOT NULL,
    id_resepti BIGINT UNSIGNED NOT NULL,
    CONSTRAINT foreign key (id_resepti) references resepti(id_resepti)
);

CREATE TABLE IF NOT EXISTS ainekset (
    id_ainekset BIGINT unsigned auto_increment primary key,
    järjestysluku INT NOT NULL,
    määrä VARCHAR(50),
    aines VARCHAR(50) NOT NULL,
    id_resepti BIGINT UNSIGNED NOT NULL,
    CONSTRAINT foreign key (id_resepti) references resepti(id_resepti)
);

CREATE TABLE IF NOT EXISTS kategoriat (
    id_kategoria BIGINT unsigned auto_increment primary key,
    nimi VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS reseptin_kategoria (
    id_kategoria BIGINT unsigned,
    id_resepti BIGINT unsigned,
    CONSTRAINT FOREIGN KEY (id_kategoria) REFERENCES kategoriat(id_kategoria),
    CONSTRAINT FOREIGN KEY (id_resepti) REFERENCES resepti(id_resepti)
);