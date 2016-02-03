/*
Created: 28/12/2015
Modified: 04/01/2016
Model: MySQL 5.6
Database: MySQL 5.6
*/


-- Create tables section -------------------------------------------------

-- Table Equipo

CREATE TABLE "Equipo"
(
  "IdEquipo" Int NOT NULL,
  "Nombre" Varchar(20) NOT NULL,
  "Director" Varchar(20) NOT NULL
)
;

ALTER TABLE "Equipo" ADD  PRIMARY KEY ("IdEquipo")
;

-- Table Ciclista

CREATE TABLE "Ciclista"
(
  "IdCiclista" Int NOT NULL,
  "Nombre" Varchar(20) NOT NULL,
  "NumDorsal" Int NOT NULL,
  "IdEquipo" Int NOT NULL
)
;

ALTER TABLE "Ciclista" ADD  PRIMARY KEY ("IdCiclista")
;

-- Table Etapa

CREATE TABLE "Etapa"
(
  "NumEtapa" Int NOT NULL,
  "NumKm" Int NOT NULL,
  "CiudadSalida" Varchar(20) NOT NULL,
  "CiudadEntrada" Varchar(20) NOT NULL,
  "IdCiclista" Int NOT NULL
)
;

ALTER TABLE "Etapa" ADD  PRIMARY KEY ("NumEtapa")
;

-- Table Puerto

CREATE TABLE "Puerto"
(
  "IdPuerto" Int NOT NULL,
  "Nombre" Varchar(20) NOT NULL,
  "AltMax" Int NOT NULL,
  "IdCiclista" Int NOT NULL,
  "IDCategoria" Int NOT NULL,
  "NumEtapa" Int NOT NULL
)
;

ALTER TABLE "Puerto" ADD  PRIMARY KEY ("IdPuerto")
;

-- Table Maillot

CREATE TABLE "Maillot"
(
  "Codigo" Varchar(2) NOT NULL,
  "Color" Varchar(20) NOT NULL,
  "TipoClasificacion" Varchar(20) NOT NULL
)
;

ALTER TABLE "Maillot" ADD  PRIMARY KEY ("Codigo")
;

-- Table CiclistaMaillotEtapa

CREATE TABLE "CiclistaMaillotEtapa"
(
  "IdCiclista" Int NOT NULL,
  "NumEtapa" Int NOT NULL,
  "Codigo" Varchar(2)
)
;

ALTER TABLE "CiclistaMaillotEtapa" ADD  PRIMARY KEY ("IdCiclista","NumEtapa")
;

-- Table Categoria

CREATE TABLE "Categoria"
(
  "IDCategoria" Int NOT NULL,
  "TipoCategoria" Varchar(20) NOT NULL
)
;

ALTER TABLE "Categoria" ADD  PRIMARY KEY ("IDCategoria")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "Ciclista" ADD CONSTRAINT "Pertenece" FOREIGN KEY ("IdEquipo") REFERENCES "Equipo" ("IdEquipo") ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE "Puerto" ADD CONSTRAINT "GanaPuerto" FOREIGN KEY ("IdCiclista") REFERENCES "Ciclista" ("IdCiclista") ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE "Etapa" ADD CONSTRAINT "GanaEtapa" FOREIGN KEY ("IdCiclista") REFERENCES "Ciclista" ("IdCiclista") ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE "CiclistaMaillotEtapa" ADD CONSTRAINT "CiclistaTer" FOREIGN KEY ("IdCiclista") REFERENCES "Ciclista" ("IdCiclista") ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE "CiclistaMaillotEtapa" ADD CONSTRAINT "EtapaTer" FOREIGN KEY ("NumEtapa") REFERENCES "Etapa" ("NumEtapa") ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE "CiclistaMaillotEtapa" ADD CONSTRAINT "MaillotTer" FOREIGN KEY ("Codigo") REFERENCES "Maillot" ("Codigo") ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE "Puerto" ADD CONSTRAINT "CategoriaPuerto" FOREIGN KEY ("IDCategoria") REFERENCES "Categoria" ("IDCategoria") ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE "Puerto" ADD CONSTRAINT "Tiene" FOREIGN KEY ("NumEtapa") REFERENCES "Etapa" ("NumEtapa") ON DELETE RESTRICT ON UPDATE RESTRICT
;

