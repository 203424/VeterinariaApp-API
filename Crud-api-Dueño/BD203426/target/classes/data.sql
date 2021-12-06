DROP TABLE IF EXISTS tipoMascota;
CREATE TABLE tipoMascota (
    idTipoMascota VARCHAR(10) NOT NULL PRIMARY KEY,
    caracteristicas VARCHAR(50) NOT NULL );


DROP TABLE IF EXISTS duenio;
CREATE TABLE duenio (
    idDuenio char(5) NOT NULL,
    nombreDuenio VARCHAR (50) NOT NULL,
    direccion VARCHAR(50) ,
    numTelefono INT ,
    cantMascotas INT );
INSERT INTO duenio (idDuenio,nombreDuenio, direccion, numTelefono, cantMascotas) values('123','steven', 'campanario #222',961123,1);
INSERT INTO duenio (idDuenio,nombreDuenio, direccion, numTelefono, cantMascotas) values('111','Padilla', 'campanario #111',961122,3);
INSERT INTO duenio (idDuenio,nombreDuenio, direccion, numTelefono, cantMascotas) values('222','Jesus', 'campanario #000',961000,2);


CREATE TABLE MASCOTA ( ID_MASCOTA INT NOT NULL PRIMARY KEY, ID_DUEÑO INT NOT NULL, ID_TIPO_MASCOTA VARCHAR(10) NOT NULL, NOMBRE VARCHAR(20), FECHA_INGRESO DATE NOT NULL, RAZON_ASISTENCIA VARCHAR(30) NOT NULL );

DROP TABLE IF EXISTS cita;
CREATE TABLE cita (
    idCita INT NOT NULL PRIMARY KEY,
    fechaCita varchar(15) ,
    horaCita varchar(15) ,
    servicio VARCHAR (30) ,
    idDuenio char(5) );
INSERT INTO cita (idCita,fechaCita, horaCita, servicio, idDuenio) values('333','30/01/21', '6 pm','Baño normal','123');
INSERT INTO cita (idCita,fechaCita, horaCita, servicio, idDuenio) values('222','20/08/20', '10 am','Baño medicado','111');
INSERT INTO cita (idCita,fechaCita, horaCita, servicio, idDuenio) values('111','20/08/20', '1 pm','Desparacitacion','222');



CREATE TABLE INVENTARIO ( ID_MEDICAMENTO INT NOT NULL PRIMARY KEY, NOMBRE_MED VARCHAR (30) NOT NULL, SUSTANCIA_ACT VARCHAR(20) NOT NULL );

