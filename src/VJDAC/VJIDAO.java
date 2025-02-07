package VJDAC;

import java.sql.ResultSet;
import java.util.List;

public interface VJIDAO<T> {
    T           vjnewDTO(ResultSet rs);
    T           vjreadBy(Integer id) throws Exception;
    List<T>     vjreadAll() throws Exception;
    boolean     vjcreate(T dto) throws Exception;
    boolean     vjupdate(T dto) throws Exception;
    boolean     vjdelete(Integer id) throws Exception;
    Integer     vjgetMaxRow() throws Exception;
} 
