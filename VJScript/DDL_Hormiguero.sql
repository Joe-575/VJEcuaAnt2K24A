-- database: ../VJDataBase/VJEcuaAnt.sqlite


DROP TABLE IF EXISTS VJHormiga;
DROP TABLE IF EXISTS VJCatalogo;

CREATE TABLE VJCatalogo(
    idCatalogo              INTEGER PRIMARY KEY AUTOINCREMENT,
    idCatalogoPadre         INTEGER,
    nombre varchar(20)      NOT NULL ,
    detalle varchar(20)     NOT NULL ,
    estado varchar(20)      NOT NULL DEFAULT('A'),
    fechaCreacion DATATIME  DEFAULT (datetime('now', 'localtime')),
    fechaModificacion       DATETIME
);

CREATE TABLE VJHormiga(
    idHormiga               INTEGER PRIMARY KEY AUTOINCREMENT,
    idCatalogoTipo          INTEGER NOT NULL REFERENCES VJCatalogo(idCatalogo),
    idCatalogoSexo          INTEGER NOT NULL REFERENCES VJCatalogo(idCatalogo),
    idCatalogoEstado        INTEGER NOT NULL REFERENCES VJCatalogo(idCatalogo),
    idCatalogoIngestaNativa INTEGER NOT NULL REFERENCES VJCatalogo(idCatalogo),
    idCatalogoGenoAlimento  INTEGER NOT NULL REFERENCES VJCatalogo(idCatalogo),
    nombre                  VARCHAR(255) NOT NULL,
    entranada               BOOLEAN NOT NULL DEFAULT 0,
    estado                  varchar(20) NOT NULL DEFAULT('A'),
    fechaCreacion           DATETIME DEFAULT (datetime('now', 'localtime')),
    fechaModificacion       DATETIME
);