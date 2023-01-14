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
        //Creamos aquí las variables comunes a todos los test para evitar código duplicado
        zB60 = new ZonaBasicaSaludMayores60("001", "Abrantes", (float) 182.15,(float) 13.0, "2022/11/29 10:47:00");
    }

    @After
    public void tearDown() throws Exception {
        //Liberamos los valores inicializados en el método setUp
        zB60 = null;
    }

//=====================================================================================
    //TEST DE MÉTODOS GET
//=====================================================================================

    //En estos test comprobamos que los métodos get para los atributos de la calse de ZonaBasicaSaludMayores60 funcionan como deben
    @Test
    public void testGetCodigo_geometria() {
        //En este test comprobamos que el codigo que recibimos del metodo get es igual al esperado
        String resultEsperado = "001";

        String resultado = zB60.getCodigo_geometria();

        assertEquals(resultEsperado, resultado);
    }

    @Test
    public void testGetZona_basica_salud() {
        //En este test comprobamos que la zona que recibimos del metodo get es igual a la esperada
        String resultEsperado = "Abrantes";

        String resultado = zB60.getZona_basica_salud();

        assertEquals(resultEsperado, resultado);
    }

    @Test
    public void testGetTasa_incidencia_acumulada_P60mas_ultimos_14dias() {
        //En este test comprobamos que la tasa de incidencia que recibimos del metodo get es igual a la esperada
        float resultadoEsperado = (float) 182.15;

        float resultado = zB60.getTasa_incidencia_acumulada_P60mas_ultimos_14dias();

        assertEquals(Double.doubleToLongBits(resultadoEsperado), Double.doubleToLongBits(resultado));
    }

    @Test
    public void testGetCasos_confirmados_P60mas_ultimos_14dias() {
        //En este test comprobamos que los casos confimados que recibimos del metodo get es igual a la esperada
        float resultadoEsperado = (float) 13.0;

        float resultado = zB60.getCasos_confirmados_P60mas_ultimos_14dias();

        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    public void testGetFecha_informe() {
        //En este test comprobamos que la fecha que recibimos del metodo get es igual a la esperada
        String resulEsperado = "2022/11/29 10:47:00";

        String resultado = zB60.getFecha_informe();

        assertEquals(resulEsperado, resultado);
    }


//=====================================================================================
    //TEST DE MÉTODOS SET
//=====================================================================================

    //En estos test comprobamos que los métodos set para los atributos de la calse de ZonaBasicaSaludMayores60 funcionan como deben
    @Test
    public void testSetCodigo_geometria() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        String codigo_geometriaEsperado = "178";

        //Lo cambiamos
        zB60.setCodigo_geometria(codigo_geometriaEsperado);

        //Comprobamos que se ha cambiado bien
        String resultado = zB60.getCodigo_geometria();

        assertEquals(codigo_geometriaEsperado, resultado);
    }

    @Test
    public void testSetZona_basica_salud() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        String zonaBasicaSaludEsperada = "Montesa";

        //Lo cambiamos
        zB60.setZona_basica_salud(zonaBasicaSaludEsperada);

        //Comprobamos que se ha cambiado bien
        String resultado = zB60.getZona_basica_salud();

        assertEquals(zonaBasicaSaludEsperada, resultado);
    }

    @Test
    public void testSetTasa_incidencia_acumulada_P60mas_ultimos_14dias() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        float tasaAcumulada60Esperada = (float) 266.63;

        //Lo cambiamos
        zB60.setTasa_incidencia_acumulada_P60mas_ultimos_14dias(tasaAcumulada60Esperada);

        //Comprobamos que se ha cambiado bien
        float resultado = zB60.getTasa_incidencia_acumulada_P60mas_ultimos_14dias();

        assertEquals(tasaAcumulada60Esperada, resultado);
    }

    @Test
    public void testSetCasos_confirmados_P60mas_ultimos_14dias() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        float casosConfirmados60Esperada = (float) 19.0;

        //Lo cambiamos
        zB60.setCasos_confirmados_P60mas_ultimos_14dias(casosConfirmados60Esperada);

        //Comprobamos que se ha cambiado bien
        float resultado = zB60.getCasos_confirmados_P60mas_ultimos_14dias();

        assertEquals(casosConfirmados60Esperada, resultado);
    }

    @Test
    public void testSetFecha_informe() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        String fechaInformeEsperada = "2022/11/29 10:47:00";

        //Lo cambiamos
        zB60.setFecha_informe(fechaInformeEsperada);

        //Comprobamos que se ha cambiado bien
        String resultado = zB60.getFecha_informe();

        assertEquals(fechaInformeEsperada, resultado);

    }


}