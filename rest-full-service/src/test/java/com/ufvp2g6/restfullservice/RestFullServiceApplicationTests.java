package com.ufvp2g6.restfullservice;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;

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
	public void testGetZBSinfo_AlBuscarObjetoQueExisteNoDevuelvaNulo()
	{
		//Testeamos que al buscar un objeto que existe en la lista no nos devuelva un valor nulo
		DataHanding data = new DataHanding();
		assertNotNull(data.getZBSinfo("001","2020/07/01 09:00:00","Covid19-TIA_ZonasBásicasSalud.json"));
	}

	@Test
	public void testGetZBSinfo_AlBuscarObjetoQueNoExisteDevuelvaNulo()
	{
		//Testeamos que al buscar un objeto que no existe en la lista nos devuelva un valor nulo
		DataHanding data = new DataHanding();
		assertNull(data.getZBSinfo("999","2020/07/01 09:00:00","Covid19-TIA_ZonasBásicasSalud.json"));
	}

	@Test
	public void getZBSM60info_AlBuscarObjetoQueExisteNoDevuelvaNulo()
	{
		DataHanding data = new DataHanding();
		assertNotNull(data.getZBSM60info("001","Covid19-TIA_ZonasBásicasSalud_Mayores60.json"));
	}

	@Test
	public void getZBSM60info_AlBuscarObjetoQueNoExisteDevuelvaNulo()
	{
		DataHanding data = new DataHanding();
		assertNull(data.getZBSM60info("999","Covid19-TIA_ZonasBásicasSalud_Mayores60.json"));
	}
	@Test
	public void CompararObjetos_DosObjetosIgualesComparacionCorrecta()
	{
		//Comprobamos que al pasar dos objetos ZBS identicos nos mencione que son iguales
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
		//Comprobamos que al pasar dos objetos ZBS diferentes nos mencione que son diferentes
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

	@Test
	public void CompararObjetos60_DosObjetosIgualesComparacionCorrecta()
	{
		//Comprobamos que dos objetos iguales ZonaBasicaSaludoMayores60 al ser comparados se realice de manera correcta
		ZonaBasicaSaludMayores60 zbs60_1 = new ZonaBasicaSaludMayores60("001","Abrantes",(float)182.5,(float)1014.70013,"2022/11/29 10:47:00");
		ZonaBasicaSaludMayores60 zbs60_2 = new ZonaBasicaSaludMayores60("001","Abrantes",(float)182.5 ,(float)1014.70013,"2022/11/29 10:47:00");

		DataHanding data = new DataHanding();
		int contador = 0;

		if(data.CompararObjetos60(zbs60_1,zbs60_2) == true)
		{
			assertTrue(contador == 0);
		}
		else
		{
			fail("No comparo correctamente dos objetos iguales de Mayores de 60");
		}
	}
	@Test
	public void CompararObjetos60_DosObjetosNOIgualesComparacionCorrecta()
	{
		//Comprobamos que dos objetos diferentes ZonaBasicaSaludoMayores60 al ser comparados se realice de manera incorrecta

		ZonaBasicaSaludMayores60 zbs60_1 = new ZonaBasicaSaludMayores60("001","Abrantes",(float)182.5,(float)1014.70013,"2022/11/29 10:47:00");
		ZonaBasicaSaludMayores60 zbs60_2 = new ZonaBasicaSaludMayores60("999","Mark Hamil",(float)182.5 ,(float)1014.70013,"2022/11/29 10:47:00");

		DataHanding data = new DataHanding();
		int contador = 0;

		if(data.CompararObjetos60(zbs60_1,zbs60_2) == false)
		{
			assertTrue(contador == 0);
		}
		else
		{
			fail("No comparo correctamente dos objetos diferentes de Mayores de 60");
		}
	}

	@Test
	public void ActualizarZBS_DosObjetosActualizaCorrectamente() throws ParseException {
		ArrayList<ZonaBasicaSalud> listaAux = new ArrayList<>();
		ArrayList<ZonaBasicaSalud> listaAux1 = new ArrayList<>();
		DataHanding data = new DataHanding();
		LeerJson reader = new LeerJson();
		int contador = 0;

		ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("002","Acacias",(float)5.1461506 ,(float)1219.6377,237,0,"2020/07/01 09:00:00");
		ZonaBasicaSalud zbs2 = new ZonaBasicaSalud("002","Marcos",(float)5.1461506 ,(float)1219.6377,237,0,"2020/10/01 09:00:00");
		listaAux.add(zbs1);
		listaAux.add(zbs2);



		listaAux1 = reader.LeerFicheroJson1("Covid19-TIA_ZonasBásicasSalud.json");
		listaAux1 = data.ActualizarZBS(listaAux,"Covid19-TIA_ZonasBásicasSalud.json");

		for(ZonaBasicaSalud i : listaAux1)
		{
			if (data.CompararObjetos(i, listaAux.get(1)))
			{
				contador = 1;
			}
		}

		if (contador == 1)
		{
			assertTrue(contador == 1);
		}
		else
		{
			fail("No puedo actualizar 2 objetos ZBS que si deberia poder hacer");
		}

	}
	@Test
	public void ActualizarZBS_DosObjetosUnoNoExisteNoActualizaCorrectamente() throws ParseException {
		ArrayList<ZonaBasicaSalud> listaAux = new ArrayList<>();
		DataHanding data = new DataHanding();
		LeerJson reader = new LeerJson();
		int contador = 0;

		ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","RigobertaIV",(float)3.25224 ,(float)1219.6377,237,0,"2020/07/01 09:00:00");
		ZonaBasicaSalud zbs2 = new ZonaBasicaSalud("001","Marcos",(float)3.25224 ,(float)1314.70013,532,10,"2020/10/01 09:00:00");
		listaAux.add(zbs1);
		listaAux.add(zbs2);



		ArrayList<ZonaBasicaSalud> listaAux1 = reader.LeerFicheroJson1("Covid19-TIA_ZonasBásicasSalud.json");
		listaAux1 = data.ActualizarZBS(listaAux,"Covid19-TIA_ZonasBásicasSalud.json");

		for(ZonaBasicaSalud i : listaAux1)
		{
			if (data.CompararObjetos(i, listaAux.get(1)))
			{
				contador = 1;
			}

		}
		if (contador == 0)
		{
			assertTrue(contador == 0);
		}
		else
		{
			fail("Actualizo 2 objetos ZBS que no deberia poder hacer");
		}



	}

	@Test
	public void ActualizarZBS60_DosObjetosActualizaCorrectamente() throws ParseException {
		ArrayList<ZonaBasicaSaludMayores60> listaAux = new ArrayList<>();
		ArrayList<ZonaBasicaSaludMayores60> listaAux1 = new ArrayList<>();
		DataHanding data = new DataHanding();
		LeerJson reader = new LeerJson();
		int contador = 0;

		ZonaBasicaSaludMayores60 zbs60_1 = new ZonaBasicaSaludMayores60("001","Abrantes",(float)182.15,(float)13,"2022/11/29 10:47:00");
		ZonaBasicaSaludMayores60 zbs60_2 = new ZonaBasicaSaludMayores60("001","Zanjón",(float)182.15,(float)13,"2022/11/29 10:47:00");
		listaAux.add(zbs60_1);
		listaAux.add(zbs60_2);

		listaAux1 = reader.LeerFicheroJson60("Covid19-TIA_ZonasBásicasSalud_Mayores60.json");
		listaAux1 = data.ActualizarZBS60(listaAux,"Covid19-TIA_ZonasBásicasSalud_Mayores60.json");

		for(ZonaBasicaSaludMayores60 i : listaAux1)
		{
			if (data.CompararObjetos60(i, listaAux.get(1)))
			{
				contador = 1;
			}
		}

		if (contador == 1)
		{
			assertTrue(contador == 1);
		}
		else
		{
			fail("No puedo actualizar 2 objetos ZBS60 que si deberia poder hacer");
		}
	}
	@Test
	public void ActualizarZBS60_DosObjetosUnoNoExisteNoActualizaCorrectamente() throws ParseException
	{
		ArrayList<ZonaBasicaSaludMayores60> listaAux = new ArrayList<>();
		ArrayList<ZonaBasicaSaludMayores60> listaAux1 = new ArrayList<>();
		DataHanding data = new DataHanding();
		LeerJson reader = new LeerJson();
		int contador = 0;

		ZonaBasicaSaludMayores60 zbs60_1 = new ZonaBasicaSaludMayores60("001","JuanchoPerez",(float)182.5,(float)1014.70013,"2022/11/29 10:47:00");
		ZonaBasicaSaludMayores60 zbs60_2 = new ZonaBasicaSaludMayores60("001","Marquinos",(float)182.5,(float)1014.70013,"2022/11/29 10:47:00");
		listaAux.add(zbs60_1);
		listaAux.add(zbs60_2);



		listaAux1 = reader.LeerFicheroJson60("Covid19-TIA_ZonasBásicasSalud_Mayores60.json");
		listaAux1 = data.ActualizarZBS60(listaAux,"Covid19-TIA_ZonasBásicasSalud_Mayores60.json");

		for(ZonaBasicaSaludMayores60 i : listaAux1)
		{
			if (data.CompararObjetos60(i, listaAux.get(1)))
			{
				contador = 1;
			}
		}

		if (contador == 0)
		{
			assertTrue(contador == 0);
		}
		else
		{
			fail("Actualizo 2 objetos ZBS60 que no deberia actualizar ");
		}

	}

	@Test
	public void ActualizarZBS60_ListaConObjetoConAtributosNulos() throws ParseException {
		ArrayList<ZonaBasicaSaludMayores60> listaAux = new ArrayList<>();
		ArrayList<ZonaBasicaSaludMayores60> listaAux1 = new ArrayList<>();
		DataHanding data = new DataHanding();
		LeerJson reader = new LeerJson();
		int contador = 0;

		listaAux1 = reader.LeerFicheroJson60("Covid19-TIA_ZonasBásicasSalud_Mayores60.json");

		ZonaBasicaSaludMayores60 zbs60_1 = new ZonaBasicaSaludMayores60("001","Abrantes",(float)182.15,(float)13,"2022/11/29 10:47:00");
		ZonaBasicaSaludMayores60 zbs60_2 =  new ZonaBasicaSaludMayores60("001" ,null,(float)182.15,(float)13,"2022/11/29 10:47:00");

		listaAux.add(zbs60_1);
		listaAux.add(zbs60_2);

		for(ZonaBasicaSaludMayores60 i : listaAux1)
		{
			if (data.CompararObjetos60(i, listaAux.get(1)))
			{
				contador = 1;
			}
		}

		if (contador == 0)
		{
			assertTrue(contador == 0);
		}
		else
		{
			fail(" Actualizo 2 objetos ZBS 60 que no deberia actualizar ");
		}

	}

	@Test
	public void ActualizarZBS_ListaConObjetoConAtributosNulos() throws ParseException {
		ArrayList<ZonaBasicaSalud> listaAux = new ArrayList<>();
		ArrayList<ZonaBasicaSalud> listaAux1 = new ArrayList<>();
		DataHanding data = new DataHanding();
		LeerJson reader = new LeerJson();
		int contador = 0;

		listaAux1 = reader.LeerFicheroJson1("Covid19-TIA_ZonasBásicasSalud.json");

		ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","RigobertaIV",(float)3.25224 ,(float)1219.6377,237,0,"2020/07/01 09:00:00");
		ZonaBasicaSalud zbs2 = new ZonaBasicaSalud(null,null,0,0,0,0,null);

		listaAux.add(zbs1);
		listaAux.add(zbs2);

		for(ZonaBasicaSalud i : listaAux1)
		{
			if (data.CompararObjetos(i, listaAux.get(1)))
			{
				contador = 1;
			}
		}

		if (contador == 0)
		{
			assertTrue(contador == 0);
		}
		else
		{
			fail(" Actualizo 2 objetos ZBS que no deberia actualizar ");
		}
	}

	@Test
	public void AniadirZBS_ComprobarSiAniadeCorrectamenteUnObjeto()
	{
		DataHanding data = new DataHanding();
		ZonaBasicaSalud Juancho = new ZonaBasicaSalud("001","Juancho",(float)3.56 ,(float)1254.3,280,12,"2020/07/01 09:00:00");
		int contador = 0;
		LeerJson reader = new LeerJson();

		ArrayList<ZonaBasicaSalud> listaAux = reader.LeerFicheroJson1("Covid19-TIA_ZonasBásicasSalud.json");

		listaAux = data.AnadirZBS(Juancho,"Covid19-TIA_ZonasBásicasSalud.json");

		for(ZonaBasicaSalud i : listaAux)
		{
			if (data.CompararObjetos(i,Juancho))
			{
				contador = 1;
			}
		}
		if (contador == 1)
		{
			assertTrue(contador == 1);
		}
		else
		{
			fail(" No añado correctamente un objeto de tipo zbs  ");
		}
	}

	@Test
	public void AnadirZBSMas60_ComprobarSiAniadeCorrectamenteUnObjeto()
	{
		DataHanding data = new DataHanding();
		ZonaBasicaSaludMayores60 Juancho = new ZonaBasicaSaludMayores60("001","Juancho",(float)3.56 ,(float)1254.3,"2020/07/01 09:00:00");
		int contador = 0;
		LeerJson reader = new LeerJson();

		ArrayList<ZonaBasicaSaludMayores60> listaAux = reader.LeerFicheroJson60("Covid19-TIA_ZonasBásicasSalud.json");

		listaAux = data.AnadirZBSMas60(Juancho,"Covid19-TIA_ZonasBásicasSalud_Mayores60.json");

		for(ZonaBasicaSaludMayores60 i : listaAux)
		{
			if (data.CompararObjetos60(i,Juancho))
			{
				contador = 1;
			}
		}

		if (contador == 1)
		{
			assertTrue(contador == 1);
		}
		else
		{
			fail(" No añado correctamente un objeto de tipo zbs 60 ");
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
