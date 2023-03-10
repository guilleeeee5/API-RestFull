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

//=====================================================================================
    //TEST DE MÉTODOS GET
//=====================================================================================
    @Test
    public void testGetCasos_confirmados_ultimos_14dias() {
        int resultadoEsperado = 0;

        int resultado = zB.getCasos_confirmados_ultimos_14dias();

        assertEquals(resultado, resultadoEsperado);
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
//=====================================================================================
    //TEST DE METODOS SET
//=====================================================================================
    @Test
    public void testSetCasos_confirmados_ultimos_14dias() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        int casosEsperados = 12;

        //Lo cambiamos
        zB.setCasos_confirmados_ultimos_14dias(casosEsperados);

        //Comprobamos que se ha cambiado bien
        int resultado = zB.getCasos_confirmados_ultimos_14dias();

        assertEquals(casosEsperados, resultado);



    }

    @Test
    public void testSetCodigo_geometria() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        String codigo_geometriaEsperado = "056";

        //Lo cambiamos
        zB.setCodigo_geometria(codigo_geometriaEsperado);

        //Comprobamos que se ha cambiado bien
        String resultado = zB.getCodigo_geometria();

        assertEquals(codigo_geometriaEsperado, resultado);
    }

    @Test
    public void testSetZona_basica_salud() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        String zonaBasicaSaludEsperada = "Argüelles";

        //Lo cambiamos
        zB.setZona_basica_salud(zonaBasicaSaludEsperada);

        //Comprobamos que se ha cambiado bien
        String resultado = zB.getZona_basica_salud();

        assertEquals(zonaBasicaSaludEsperada, resultado);
    }

    @Test
    public void testSetTasa_incidencia_acumulada_total() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        float tasaIncidenciaAcumuladaTotalEsperada = (float) 1228.0479;

        //Lo cambiamos
        zB.setTasa_incidencia_acumulada_total(tasaIncidenciaAcumuladaTotalEsperada);

        //Comprobamos que se ha cambiado bien
        float resultado = zB.getTasa_incidencia_acumulada_total();

        assertEquals(tasaIncidenciaAcumuladaTotalEsperada, resultado);
    }

    @Test
    public void testSetCasos_confirmados_totales() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        int casosConfirmadosTotalesEsperado = 193;

        //Lo cambiamos
        zB.setCasos_confirmados_totales(casosConfirmadosTotalesEsperado);

        //Comprobamos que se ha cambiado bien
        int resultado = zB.getCasos_confirmados_totales();

        assertEquals(casosConfirmadosTotalesEsperado, resultado);
    }

    @Test
    public void testSetFecha_informe() {
        //Vamos a crear una variable y vamos a cambiarla en el objeto, después vamos a comprobar que el valor que cogemos
        //es el que hemos puesto
        String fechaInformeEsperada = "2020/07/01 09:00:00";

        //Lo cambiamos
        zB.setFecha_informe(fechaInformeEsperada);

        //Comprobamos que se ha cambiado bien
        String resultado = zB.getFecha_informe();

        assertEquals(fechaInformeEsperada, resultado);
    }
}