package parcial.odontologo.service;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parcial.odontologo.dao.Implementacion.OdontologoIDaoH2;
import parcial.odontologo.model.Odontologo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    public static Logger LOGGER = Logger.getLogger(OdontologoServiceTest.class);
    public static OdontologoService odontologoService = new OdontologoService(new OdontologoIDaoH2());

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/odontologoparcial;INIT=RUNSCRIPT from 'create.sql'","sa","sa");
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("Testear busqueda todos los Odontologos")
    void testTraerTodosLosOdontologos(){
        Odontologo odontologo = new Odontologo(707070,"Matias","Rodriguez");
        odontologoService.crearOdontologo(odontologo);
        List<Odontologo> odontologos = odontologoService.traerTodosLosOdontologos();
        assertEquals(6, odontologos.size());
    }

}