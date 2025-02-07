-- database: ../VJDatabase/VJEcuaAnt.db

DROP VIEW VJVwHormiga;

CREATE VIEW IF NOT EXISTS VJVwHormiga AS
SELECT 
    h.idHormiga AS ID,
    cTipo.nombre AS TIPOHORMIGA,
    cSexo.nombre AS SEXO,
    cIngestaNativa.nombre AS ALIMENTACION,
    cEstado.nombre AS ESTADO,
    cEntrenada.nombre AS ENTRENADA

FROM VJHormiga h
JOIN VJCatalogo cTipo ON h.idCatalogoTipo = cTipo.idCatalogo
JOIN VJCatalogo cSexo ON h.idCatalogoSexo = cSexo.idCatalogo
JOIN VJCatalogo cEstado ON h.idCatalogoEstado = cEstado.idCatalogo
JOIN VJCatalogo cIngestaNativa ON h.idCatalogoIngestaNativa = cIngestaNativa.idCatalogo
JOIN VJCatalogo cEntrenada ON h.idCatalogoEntranada = cEntrenada.idCatalogo
WHERE h.estado = 'A';

SELECT * FROM VJVwHormiga;