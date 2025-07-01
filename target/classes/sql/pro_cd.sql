SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pro_cd
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS pro_cd ;
CREATE SCHEMA IF NOT EXISTS pro_cd DEFAULT CHARACTER SET utf8 ;
USE pro_cd ;

-- Tabla paciente
DROP TABLE IF EXISTS pro_cd.paciente ;
CREATE TABLE IF NOT EXISTS pro_cd.paciente (
                                               idPaciente INT NOT NULL AUTO_INCREMENT,
                                               nombre VARCHAR(45) NOT NULL,
                                               aPaterno VARCHAR(45) NOT NULL,
                                               aMaterno VARCHAR(45) NOT NULL,
                                               curp VARCHAR(18) NOT NULL,
                                               fechaNac DATE NOT NULL,
                                               sexo CHAR(1) NOT NULL,
                                               emailPaciente VARCHAR(55) NOT NULL,
                                               PRIMARY KEY (idPaciente)
) ENGINE = InnoDB;
CREATE UNIQUE INDEX idPaciente_UNIQUE ON pro_cd.paciente (idPaciente ASC) VISIBLE;

-- Tabla datosPaciente
DROP TABLE IF EXISTS pro_cd.datosPaciente ;
CREATE TABLE IF NOT EXISTS pro_cd.datosPaciente (
                                                    idDatosMedicos INT NOT NULL AUTO_INCREMENT,
                                                    alergias VARCHAR(120) NOT NULL,
                                                    medicamentos VARCHAR(120) NOT NULL,
                                                    cirugiasPrevias VARCHAR(120) NOT NULL,
                                                    tipoSangre VARCHAR(120) NOT NULL,
                                                    enfermedadesCronicas VARCHAR(120) NOT NULL,
                                                    idPaciente INT NOT NULL,
                                                    PRIMARY KEY (idDatosMedicos),
                                                    CONSTRAINT fk_datosPaciente_paciente
                                                        FOREIGN KEY (idPaciente) REFERENCES pro_cd.paciente (idPaciente)
                                                            ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;
CREATE INDEX idPaciente_idx ON pro_cd.datosPaciente (idPaciente ASC) VISIBLE;
CREATE UNIQUE INDEX idDatosMedicos_UNIQUE ON pro_cd.datosPaciente (idDatosMedicos ASC) VISIBLE;

-- Tabla direccion
DROP TABLE IF EXISTS pro_cd.direccion ;
CREATE TABLE IF NOT EXISTS pro_cd.direccion (
                                                idDireccion INT NOT NULL AUTO_INCREMENT,
                                                calle VARCHAR(100) NOT NULL,
                                                numero INT NOT NULL,
                                                cp INT NOT NULL,
                                                alcaldia VARCHAR(45) NOT NULL,
                                                colonia VARCHAR(45) NOT NULL,
                                                PRIMARY KEY (idDireccion)
) ENGINE = InnoDB;
CREATE UNIQUE INDEX idDireccion_UNIQUE ON pro_cd.direccion (idDireccion ASC) VISIBLE;

-- Tabla relDirPac
DROP TABLE IF EXISTS pro_cd.relDirPac ;
CREATE TABLE IF NOT EXISTS pro_cd.relDirPac (
                                                idRelDirPac INT NOT NULL,
                                                idDireccion INT NOT NULL,
                                                idPaciente INT NOT NULL,
                                                PRIMARY KEY (idRelDirPac),
                                                CONSTRAINT idDireccion
                                                    FOREIGN KEY (idDireccion) REFERENCES pro_cd.direccion (idDireccion)
                                                        ON DELETE NO ACTION ON UPDATE NO ACTION,
                                                CONSTRAINT fk_relDirPac_paciente
                                                    FOREIGN KEY (idPaciente) REFERENCES pro_cd.paciente (idPaciente)
                                                        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;
CREATE INDEX idDireccion_idx ON pro_cd.relDirPac (idDireccion ASC) VISIBLE;
CREATE INDEX idPaciente_idx ON pro_cd.relDirPac (idPaciente ASC) VISIBLE;

-- Tabla direccionClin
DROP TABLE IF EXISTS pro_cd.direccionClin ;
CREATE TABLE IF NOT EXISTS pro_cd.direccionClin (
                                                    idDireccionClin INT NOT NULL AUTO_INCREMENT,
                                                    calleC VARCHAR(100) NOT NULL,
                                                    numeroC VARCHAR(45) NOT NULL,
                                                    coloniaC VARCHAR(45) NOT NULL,
                                                    cpC INT NOT NULL,
                                                    alcaldiaC VARCHAR(45) NOT NULL,
                                                    PRIMARY KEY (idDireccionClin)
) ENGINE = InnoDB;
CREATE UNIQUE INDEX idDireccionClin_UNIQUE ON pro_cd.direccionClin (idDireccionClin ASC) VISIBLE;

-- Tabla clinica
DROP TABLE IF EXISTS pro_cd.clinica ;
CREATE TABLE IF NOT EXISTS pro_cd.clinica (
                                              idClinica INT NOT NULL AUTO_INCREMENT,
                                              idDireccionClin INT NOT NULL,
                                              PRIMARY KEY (idClinica),
                                              CONSTRAINT idDireccionClin
                                                  FOREIGN KEY (idDireccionClin) REFERENCES pro_cd.direccionClin (idDireccionClin)
                                                      ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;
CREATE INDEX idDireccionClin_idx ON pro_cd.clinica (idDireccionClin ASC) VISIBLE;

-- Tabla relPacClin
DROP TABLE IF EXISTS pro_cd.relPacClin ;
CREATE TABLE IF NOT EXISTS pro_cd.relPacClin (
                                                 idRelPC INT NOT NULL AUTO_INCREMENT,
                                                 idPaciente INT NOT NULL,
                                                 idClinica INT NOT NULL,
                                                 PRIMARY KEY (idRelPC),
                                                 CONSTRAINT fk_relPacClin_paciente
                                                     FOREIGN KEY (idPaciente) REFERENCES pro_cd.paciente (idPaciente)
                                                         ON DELETE NO ACTION ON UPDATE NO ACTION,
                                                 CONSTRAINT fk_relPacClin_clinica
                                                     FOREIGN KEY (idClinica) REFERENCES pro_cd.clinica (idClinica)
                                                         ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;
CREATE UNIQUE INDEX idRelPC_UNIQUE ON pro_cd.relPacClin (idRelPC ASC) VISIBLE;
CREATE INDEX idClinica_idx ON pro_cd.relPacClin (idClinica ASC) VISIBLE;
CREATE INDEX idPaciente_idx ON pro_cd.relPacClin (idPaciente ASC) VISIBLE;

-- Tabla gestionCitas modificada (sin relación Pac-Med)
DROP TABLE IF EXISTS pro_cd.gestionCitas ;
CREATE TABLE IF NOT EXISTS pro_cd.gestionCitas (
                                                   idGestionCitas INT NOT NULL AUTO_INCREMENT,
                                                   diaCita DATE NOT NULL,
                                                   horarioCita TIME NOT NULL,
                                                   motivoGeneral VARCHAR(150) NOT NULL,
                                                   notasMed VARCHAR(120) NOT NULL,
                                                   idPaciente INT NOT NULL,
                                                   idClinica INT NOT NULL,
                                                   PRIMARY KEY (idGestionCitas),
                                                   CONSTRAINT fk_gestionCitas_paciente
                                                       FOREIGN KEY (idPaciente) REFERENCES pro_cd.paciente (idPaciente)
                                                           ON DELETE NO ACTION ON UPDATE NO ACTION,
                                                   CONSTRAINT fk_gestionCitas_clinica
                                                       FOREIGN KEY (idClinica) REFERENCES pro_cd.clinica (idClinica)
                                                           ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;
CREATE UNIQUE INDEX idGestionCitas_UNIQUE ON pro_cd.gestionCitas (idGestionCitas ASC) VISIBLE;
CREATE INDEX idPaciente_idx ON pro_cd.gestionCitas (idPaciente ASC) VISIBLE;
CREATE INDEX idClinica_idx ON pro_cd.gestionCitas (idClinica ASC) VISIBLE;

-- Ajuste final
ALTER TABLE datosPaciente MODIFY COLUMN idDatosMedicos INT NOT NULL AUTO_INCREMENT;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;