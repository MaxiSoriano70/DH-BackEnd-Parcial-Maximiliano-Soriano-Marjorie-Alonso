package parcial.odontologo.dao;

import java.util.List;

public interface IDao <T>{
    T crear(T t);
    List <T> traerTodos();
}
