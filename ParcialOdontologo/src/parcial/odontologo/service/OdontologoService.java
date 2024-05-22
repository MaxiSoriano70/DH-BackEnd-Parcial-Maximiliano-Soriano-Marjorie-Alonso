package parcial.odontologo.service;

import parcial.odontologo.dao.IDao;
import parcial.odontologo.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo crearOdontologo(Odontologo odontologo){
        return odontologoIDao.crear(odontologo);
    }

    public List<Odontologo> traerTodosLosOdontologos(){
        return odontologoIDao.traerTodos();
    }
}
