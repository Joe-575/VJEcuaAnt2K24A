-- database: ../VJDataBase/VJEcuaAnt.sqlite


INSERT INTO VJCatalogo(idCatalogoPadre,       nombre,                  detalle)
VALUES                  (NULL,             'hormigaTipo',       'Tipos de hormigas' ),
                        (NULL,             'hormigaSexo',       'Tipos de sexo de hormigas' ),
                        (NULL,             'hormigaEstado',     'Estado de hormigas' ),
                        (NULL,             'hormigaAlimento',   'Ingesta Nativa'),
                        (NULL,             'hormigaGenoma',     'GenoAlimento'),
                        (NULL,             'hormigaEntrenada',   'Entremaniento');



INSERT INTO VJCatalogo(idCatalogoPadre,       nombre,         detalle)
VALUES                  
                        (1,             'HLarva',        'Etapa inicial' ),
                        (1,             'HSoldado',      'Tipos de hormiga' ),
                        (2,             'Macho',         'Sexo de hormiga' ),
                        (2,             'Asexual',       'Sexo de hormiga' ),
                        (3,             'Viva',          'Estado de hormiga' ),
                        (3,             'Muerta',        'Estado de hormiga' ),
                        (4,             'Carnivoro',     'Ingesta Nativa' ),
                        (4,             'Nectarívoros',  'Ingesta Nativa' ),
                        (5,             'XY',            'GenoAlimento' ),
                        (5,             'X',            'GenoAlimento' );



INSERT INTO VJHormiga (
    idCatalogoTipo, idCatalogoSexo, idCatalogoEstado, idCatalogoIngestaNativa, idCatalogoGenoAlimento) 
VALUES
    (7, 10, 11, 14, 16),
    (8, 9, 11, 13, 15),
    (8, 9, 11, 13, 15);
