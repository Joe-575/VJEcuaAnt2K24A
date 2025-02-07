-- database: ../VJDatabase/VJEcuaAnt.db


INSERT INTO VJCatalogo(idCatalogoPadre,       nombre,                  detalle)
VALUES                  (NULL,             'hormigaTipo',       'Tipos de hormigas' ),
                        (NULL,             'hormigaSexo',       'Tipos de sexo de hormigas' ),
                        (NULL,             'hormigaEstado',     'Estado de hormigas' ),
                        (NULL,             'hormigaAlimento',   'Ingesta Nativa'),
                        (NULL,             'hormigaGenoma',     'GenoAlimento'),
                        (NULL,             'hormigaEntrenada',   'Entremaniento');



INSERT INTO VJCatalogo(idCatalogoPadre,       nombre,         detalle)
VALUES                  
                        (1,             'HSoldado',      'Tipos de hormigas' ),
                        (2,             'Hembra',        'Sexo de hormigas' ),
                        (3,             'Viva',          'Estado de hormigas' ),
                        (3,             'Muerta',        'Estado de hormigas' ),
                        (4,             'Carnivoro',     'Ingesta Nativa' ),
                        (5,             'XY',            'GenoAlimento' ),
                        (6,             'Entrenada',      'Entremaniento' );
                        



INSERT INTO VJHormiga(idCatalogoTipo, idCatalogoSexo, idCatalogoEstado, idCatalogoIngestaNativa, idCatalogoGenoAlimento, idCatalogoEntranada) VALUES
    (7, 8, 9, 11, 12, 13 ),
    (7, 8, 9, 11, 12, 13 ),
    (7, 8, 9, 11, 12, 13 );
