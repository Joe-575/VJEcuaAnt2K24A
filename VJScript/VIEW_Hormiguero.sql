-- database: ../VJDataBase/VJEcuaAnt.sqlite

DROP VIEW VJVwHormiga;

CREATE VIEW IF NOT EXISTS VJVwHormiga AS
SELECT 
    h.idHormiga AS ID,
    cTipo.nombre AS TIPOHORMIGA,
    cSexo.nombre AS SEXO,
    cIngestaNativa.nombre AS ALIMENTACION,
    cEstado.nombre AS ESTADO,
    h.entrenada AS ENTRENADA  -- Se toma directamente de VJHormiga, sin JOIN extra
FROM VJHormiga h
JOIN VJCatalogo cTipo ON h.idCatalogoTipo = cTipo.idCatalogo
JOIN VJCatalogo cSexo ON h.idCatalogoSexo = cSexo.idCatalogo
JOIN VJCatalogo cEstado ON h.idCatalogoEstado = cEstado.idCatalogo
JOIN VJCatalogo cIngestaNativa ON h.idCatalogoIngestaNativa = cIngestaNativa.idCatalogo
WHERE h.estado = 'A';
