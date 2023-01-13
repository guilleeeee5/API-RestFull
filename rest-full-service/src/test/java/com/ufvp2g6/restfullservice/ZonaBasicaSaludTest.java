package com.ufvp2g6.restfullservice;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class ZonaBasicaSaludTest extends TestCase{

    ZonaBasicaSalud zB;

    @Before
    public void setUp() throws Exception {
        //Creamos aquí las variables comunes a todos los test para evitar código duplicado
       zB = new ZonaBasicaSalud("001", "Abrantes", (float) 3.252244, (float) 1014.70013, 312, 0, "2020/07/01 09:00:00");
    }

    @After
    public void tearDown() throws Exception {
        //Liberamos los valores inicializados en el método setUp
        zB = null;
    }

    @Test
    public void testGetCasos_confirmados_ultimos_14dias() {
        int resultadoEsperado = 0;

        int resultado = zB.getCasos_confirmados_ultimos_14dias();

        assertEquals(resultado, resultadoEsperado);
    }

    @Test
    public void testSetCasos_confirmados_ultimos_14dias() {
        
    }

    @Test
    public void testGetCodigo_geometria() {
        String resultEsperado = "001";

        String resultado = zB.getCodigo_geometria();

        assertEquals(resultEsperado, resultado);
    }

    @Test
    public void testGetZona_basica_salud() {
        String resultEsperado = "Abrantes";

        String resultado = zB.getZona_basica_salud();

        assertEquals(resultEsperado, resultado);
    }

    @Test
    public void testGetTasa_incidencia_acumulada_ultimos_14dias() throws ParseException {
        float resultadoEsperado = (float) 3.252244;

        float resultado = zB.getTasa_incidencia_acumulada_ultimos_14dias();

        assertEquals(Double.doubleToLongBits(resultadoEsperado), Double.doubleToLongBits(resultado));
    }

    @Test
    public void testGetTasa_incidencia_acumulada_total() {
        Float resultadoEsperado = (float) 1014.70013;

        Float resultado = zB.getTasa_incidencia_acumulada_total();

        assertEquals(Double.doubleToLongBits(resultadoEsperado), Double.doubleToLongBits(resultado));
    }

    @Test
    public void testGetCasos_confirmados_totales() {
        int resultEsperado = 312;

        int resultado = zB.getCasos_confirmados_totales();

        assertEquals(resultEsperado, resultado);
    }

    @Test
    public void testGetFecha_informe() {

        String resulEsperado = "2020/07/01 09:00:00";

        String resultado = zB.getFecha_informe();

        assertEquals(resulEsperado, resultado);

    }
}