DROP database GestionNotes;
create database GestionNotes;


use GestionNotes;


CREATE TABLE etudiant(
    
    id_etudiant int AUTO_INCREMENT,
    nom varchar(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    sexe  VARCHAR(100) NOT NULL,
    age int (11) NOT NULL,
    telephone VARCHAR(250) NOT NULL,
    adresse VARCHAR(250) NOT NULL,
    matricule varchar(250) NOT NULL UNIQUE,

    PRIMARY KEY(id_etudiant)
);


CREATE TABLE ue(
    id_ue int AUTO_INCREMENT,
    libelle VARCHAR(100) NOT NULL,
    code_ue VARCHAR(100) NOT NULL,
    credit VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_ue)
);


CREATE TABLE notes(
    id_note int AUTO_INCREMENT,
    id_etudiant int not null,
    id_ue int not null,
    cc int(11) null,
    tp int(11) null,
    sn int(11) null,

    PRIMARY KEY(id_note),
    FOREIGN KEY(id_etudiant) REFERENCES etudiant(id_etudiant) ON DELETE CASCADE,
    FOREIGN KEY(id_etudiant) REFERENCES etudiant(id_etudiant) ON UPDATE CASCADE,

    FOREIGN KEY(id_ue) REFERENCES ue(id_ue) ON DELETE CASCADE,
    FOREIGN KEY(id_ue) REFERENCES ue(id_ue) ON UPDATE CASCADE

);





select nom,prenom,age,adresse,cc,sn,tp,code_ue from notes join  etudiant using(id_etudiant) join ue using(id_ue) 
  
  