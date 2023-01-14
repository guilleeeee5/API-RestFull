package com.ufvp2g6.restfullservice;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZonaBasicaSaludMayores60Test extends TestCase {

    ZonaBasicaSaludMayores60 zB60;
    @Before
    public void setUp() throws Exception {
        zB60 = new ZonaBasicaSaludMayores60("001", "Abrantes", (float) 182.15,(float) 13.0, "2022/11/29 10:47:00");
    }

    @After
    public void tearDown() throws Exception {
        zB60 = null;
    }

//=====================================================================================
    //TEST DE MÉTODOS GET
//=====================================================================================
    @Test
    public void testGetCodigo_geometria() {
    }

    @Test
    public void testGetZona_basica_salud() {
    }

    @Test
    public void testGetTasa_incidencia_acumulada_P60mas_ultimos_14dias() {
    }

    @Test
    public void testGetCasos_confirmados_P60mas_ultimos_14dias() {
    }

    @Test
    public void testGetFecha_informe() {
    }


//=====================================================================================
    //TEST DE MÉTODOS SET
//=====================================================================================
    @Test
    public void testSetCodigo_geometria() {
    }

    @Test
    public void testSetZona_basica_salud() {
    }

    @Test
    public void testSetTasa_incidencia_acumulada_P60mas_ultimos_14dias() {
    }

    @Test
    public void testSetCasos_confirmados_P60mas_ultimos_14dias() {
    }

    @Test
    public void testSetFecha_informe() {
    }


}