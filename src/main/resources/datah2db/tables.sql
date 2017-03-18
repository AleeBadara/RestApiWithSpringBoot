//Table developer t_txn_developer
DROP TABLE t_txn_developer IF EXISTS ;
CREATE TABLE t_txn_developer (
id CHAR(36) PRIMARY KEY,
nom VARCHAR(20) NOT NULL,
prenom VARCHAR(50) NOT NULL,
adresse VARCHAR(100)
);

//Table langage
DROP TABLE t_txn_langage IF EXISTS;
CREATE TABLE t_txn_langage (
id CHAR(36) PRIMARY KEY,
libelle VARCHAR(20) NOT NULL
);

//Table developer_langage
DROP TABLE t_txn_developer_langage IF EXISTS;
CREATE TABLE t_txn_developer_langage (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
id_dev CHAR(36) NOT NULL,
id_lang CHAR(36) NOT NULL,
CONSTRAINT fk_dev FOREIGN KEY (id_dev)
REFERENCES t_txn_developer(id),
CONSTRAINT fk_lang FOREIGN KEY (id_lang)
REFERENCES t_txn_langage(id)
);