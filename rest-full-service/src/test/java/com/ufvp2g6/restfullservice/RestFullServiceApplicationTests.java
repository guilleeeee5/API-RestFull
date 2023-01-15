package com.ufvp2g6.restfullservice;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import static org.junit.Assert.*;

@SpringBootTest
class RestFullServiceApplicationTests extends TestCase{
//Out of range, negativos, lectura correcta
	@Test
	void contextLoads()
	{
	}
	ZonaBasicaSalud zB = new ZonaBasicaSalud("001", "Abrantes", (float) 3.252244, (float) 1014.70013, 312, 0, "2020/07/01 09:00:00");
	ZonaBasicaSaludMayores60 zB60 = new ZonaBasicaSaludMayores60("001", "Abrantes", (float) 182.15,(float) 13.0, "2022/11/29 10:47:00");
	@Test
	public void CompararObjetos_DosObjetosIgualesComparacionCorrecta()
	{
		//Comprobamos que al pasar dos objetos identicos nos mencione que son iguales
		ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
		ZonaBasicaSalud zbs2 =  new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
		DataHanding data = new DataHanding();
		int contador = 0;

		if(data.CompararObjetos(zbs1,zbs2) == true)
		{
			assertTrue(contador == 0);
		}
		else
		{
			fail("No comparo correctamente dos objetos iguales");
		}

	}

	@Test
	public void CompararObjetos_DosObjetosNoIgualesComparacionCorrecta()
	{
		//Comprobamos que al pasar dos objetos diferentes nos mencione que son diferentes
		ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
		ZonaBasicaSalud zbs2 = new ZonaBasicaSalud("999","Abrantos",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
		DataHanding data = new DataHanding();
		int contador = 0;

		if(data.CompararObjetos(zbs1,zbs2) == false)
		{
			assertTrue(contador == 0);
		}
		else
		{
			fail("No comparo correctamente dos objetos diferentes");
		}
	}

//=====================================================================================
	//TEST DE MÉTODOS GET ZONA BASICA SALUD
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
	//TEST DE METODOS SET ZONA BASICA SALUD
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

//=====================================================================================
	//TEST DE MÉTODOS GET ZONA BASICA SALUD MAYORES DE 60
//=====================================================================================

	//En estos test comprobamos que los métodos get para los atributos de la calse de ZonaBasicaSaludMayores60 funcionan como deben
	@Test
	public void testGetCodigo_geometria60() {
		//En este test comprobamos que el codigo que recibimos del metodo get es igual al esperado
		String resultEsperado = "001";

		String resultado = zB60.getCodigo_geometria();

		assertEquals(resultEsperado, resultado);
	}

	@Test
	public void testGetZona_basica_salud60() {
		//En este test comprobamos que la zona que recibimos del metodo get es igual a la esperada
		String resultEsperado = "Abrantes";

		String resultado = zB60.getZona_basica_salud();

		assertEquals(resultEsperado, resultado);
	}

	@Test
	public void testGetTasa_incidencia_acumulada_P60mas_ultimos_14dias60() {
		//En este test comprobamos que la tasa de incidencia que recibimos del metodo get es igual a la esperada
		float resultadoEsperado = (float) 182.15;

		float resultado = zB60.getTasa_incidencia_acumulada_P60mas_ultimos_14dias();

		assertEquals(Double.doubleToLongBits(resultadoEsperado), Double.doubleToLongBits(resultado));
	}

	@Test
	public void testGetCasos_confirmados_P60mas_ultimos_14dias60() {
		//En este test comprobamos que los casos confimados que recibimos del metodo get es igual a la esperada
		float resultadoEsperado = (float) 13.0;

		float resultado = zB60.getCasos_confirmados_P60mas_ultimos_14dias();

		assertEquals(resultadoEsperado,resultado);
	}

	@Test
	public void testGetFecha_informe60() {
		//En este test comprobamos que la fecha que recibimos del metodo get es igual a la esperada
		String resulEsperado = "2022/11/29 10:47:00";

		String resultado = zB60.getFecha_informe();

		assertEquals(resulEsperado, resultado);
	}


//=====================================================================================
	//TEST DE MÉTODOS SET ZONA BASICA SALUD MAYORES DE 60
//=====================================================================================

	//En estos test comprobamos que los métodos set para los atributos de la calse de ZonaBasicaSaludMayores60 funcionan como deben
	@Test
	public void testSetCodigo_geometria60() {
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
	public void testSetZona_basica_salud60() {
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
	public void testSetTasa_incidencia_acumulada_P60mas_ultimos_14dias60() {
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
	public void testSetCasos_confirmados_P60mas_ultimos_14dias60() {
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
	public void testSetFecha_informe60() {
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
