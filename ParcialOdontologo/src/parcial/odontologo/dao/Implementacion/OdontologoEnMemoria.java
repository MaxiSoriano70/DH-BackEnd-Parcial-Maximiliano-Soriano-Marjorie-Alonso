package parcial.odontologo.dao.Implementacion;

import org.apache.log4j.Logger;
import parcial.odontologo.dao.IDao;
import parcial.odontologo.model.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdontologoEnMemoria implements IDao<Odontologo> {
    private static Logger LOGGER = Logger.getLogger(OdontologoEnMemoria.class);
    List<Odontologo> odontologos = new ArrayList<>();

    public OdontologoEnMemoria() {
        this.crear(new Odontologo(1234,"CRYSTAL","RUSH"));
        this.crear(new Odontologo(4321,"ANDRES","GUZMAN"));
    }

    @Override
    public Odontologo crear(Odontologo odontologo) {
        Integer id = odontologos.size()+1;
        odontologo.setId(id);
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> traerTodos() {
        for (Odontologo odontologo: odontologos) {
            LOGGER.info("ODONTOLOGO "+ odontologo);
        }
        return odontologos;
    }
}
