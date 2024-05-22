package parcial.odontologo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parcial.odontologo.dao.Implementacion.OdontologoEnMemoria;
import parcial.odontologo.model.Odontologo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoEnMemoriaTest {
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoEnMemoria());

    @Test
    @DisplayName("Testear busqueda todos los Odontologos")
    void testTraerTodosLosOdontologos(){
        Odontologo odontologo = new Odontologo(707070,"MATIAS","RODRIGUEZ");
        odontologoService.crearOdontologo(odontologo);
        List<Odontologo> odontologos = odontologoService.traerTodosLosOdontologos();
        assertEquals(3, odontologos.size());
    }

}