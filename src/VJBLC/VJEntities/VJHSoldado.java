package VJBLC.VJEntities;

import java.util.List;

import VJBLC.VJBLFactory;
import VJDAC.VJDAO.VJHormigaDAO;
import VJDAC.VJDTO.VJHormigaDTO;

public class VJHSoldado extends VJHormiga {
    protected VJHormigaDTO hormigaDTO = new VJHormigaDTO();
    private VJBLFactory<VJHormigaDTO> bl = new VJBLFactory<>(VJHormigaDAO::new);
    public VJIngestaNativa aComido;

    public VJHSoldado(){

    }

    public boolean add(Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
                Integer idCatalogoGenoAlimento, Integer idCatalogoIngestaNativa, String nombre) throws Exception{
        VJhormigaDTO = new VJHormigaDTO( idCatalogoTipo,  idCatalogoSexo, idCatalogoEstado,
        idCatalogoGenoAlimento,  idCatalogoIngestaNativa,  nombre);
        return bl.add(hormigaDTO);
    }


    public boolean upd(Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCatalogoGenoAlimento, Integer idCatalogoIngestaNativa, String nombre) throws Exception {
        if (VJhormigaDTO != null) {
            VJhormigaDTO.setIdCatalogoTipo(idCatalogoTipo);
            VJhormigaDTO.setIdCatalogoSexo(idCatalogoSexo);
            VJhormigaDTO.setIdCatalogoEstado(idCatalogoEstado);
            VJhormigaDTO.setIdCatalogoGenoAlimento(idCatalogoGenoAlimento);
            VJhormigaDTO.setIdCatalogoIngestaNativa(idCatalogoIngestaNativa);
            VJhormigaDTO.setNombre(nombre);
            return bl.upd(VJhormigaDTO);
        }
        return false;
    }

    public List<VJHormigaDTO> getAll() throws Exception{
        return bl.getAll();
    }

    public VJHormigaDTO getBy(Integer id) throws Exception{
        VJhormigaDTO = bl.getBy(id);
        return VJhormigaDTO;
    }

    public boolean del() throws Exception{
        if(VJhormigaDTO != null)
            return bl.del(VJhormigaDTO.getIdHormiga());
        return false;
    }

    public VJHormigaDTO get(){
        return VJhormigaDTO;
    }
    
    public void set(VJHormigaDTO VJhormigaDTO){
        this.VJhormigaDTO = VJhormigaDTO;
    }

}
