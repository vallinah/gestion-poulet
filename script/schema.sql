drop database if exists poulailler;

CREATE DATABASE poulailler;
\c poulailler;

CREATE TABLE type_charge(
    id serial PRIMARY KEY,
    nom VARCHAR (250)
);
insert into type_charge(nom) values('charge incorporable');
insert into type_charge(nom) values('charge non incorporable');
insert into type_charge(nom) values('charge supplétive');

CREATE TABLE charge_analytique(
    id serial PRIMARY KEY,
    nom VARCHAR (250)
);
insert into charge_analytique(nom) values('charge directe');
insert into charge_analytique(nom) values('charge indirecte');

CREATE TABLE analytique_des_coûts(
    id serial PRIMARY KEY,
    nom VARCHAR (250)
);
insert into analytique_des_coûts(nom) values('variable');
insert into analytique_des_coûts(nom) values('fixe');
insert into analytique_des_coûts(nom) values('totale');

CREATE TABLE charge(
    id serial PRIMARY KEY,
    nom VARCHAR (250),
    prix_unitaire DECIMAL(18, 2),
    unité_oeuvre VARCHAR (250),
    id_type_charge int REFERENCES type_charge(id),
    id_charge_analytique int REFERENCES charge_analytique(id),
    id_analytique_coût int REFERENCES analytique_des_coûts(id),
    pourcentage_démarrage DECIMAL(18, 2),
    pourcentage_transition DECIMAL(18, 2),
    pourcentage_finition DECIMAL(18, 2)
);


CREATE TABLE depense(
    id serial PRIMARY KEY,
    id_charge int REFERENCES charge(id),
    quantite DECIMAL(18, 2)
);

CREATE TABLE elevage (
    id SERIAL PRIMARY KEY,
    date_debut DATE NOT NULL,
    dureeCycle INT NOT NULL
);

CREATE TABLE poulet (
    id SERIAL PRIMARY KEY,
    poids_initial DECIMAL(5, 2) NOT NULL,
    poids_final DECIMAL(10, 2),
    poids_grow DECIMAL(10, 2),
    prix_de_vente DECIMAL(10, 2),
    cout DECIMAL(10, 2),
    id_elevage INT REFERENCES elevage(id) -- Clé étrangère vers la table elevage
);





