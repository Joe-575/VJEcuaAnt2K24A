package VJBLC;

import java.util.List;
import java.util.function.Supplier;

import VJDAC.VJIDAO;

public class VJBLFactory<T>{

    private final VJIDAO<T> oDAO;
    
    public VJBLFactory(Supplier<VJIDAO<T>> supplier){
        this.oDAO = supplier.get();
    }

    public List<T> getAll() throws Exception{
        return oDAO.vjreadAll();
    }

    public T getBy(Integer id) throws Exception{
        return oDAO.vjreadBy(id);
    }

    public boolean add(T oT) throws Exception{
        return oDAO.vjcreate(oT);
    }

    public boolean upd(T oT) throws Exception{
        return oDAO.vjupdate(oT);
    }

    public boolean del(Integer id) throws Exception{
        return oDAO.vjdelete(id);
    }
}