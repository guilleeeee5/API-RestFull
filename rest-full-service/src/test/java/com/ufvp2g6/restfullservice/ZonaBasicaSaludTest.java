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

    }

    @Test
    public void testGetZona_basica_salud() {
    }

    @Test
    public void testGetTasa_incidencia_acumulada_ultimos_14dias() throws ParseException {
        float resultadoEsperado = (float) 3.252244;

        float resultado = zB.getTasa_incidencia_acumulada_ultimos_14dias();

        assertEquals(Double.doubleToLongBits(resultadoEsperado), Double.doubleToLongBits(resultado));
    }

    @Test
    public void testGetTasa_incidencia_acumulada_total() {
    }

    @Test
    public void testGetCasos_confirmados_totales() {
    }

    @Test
    public void testGetFecha_informe() {
    }
}