package com.ufvp2g6.restfullservice;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataHandingTest
{
    //En esta clase se testean las funciones de la clase DataHanding

    public DataHandingTest() throws ParseException {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetZBSinfo_AlBuscarObjetoQueExisteNoDevuelvaNulo()
    {
        //Testeamos que al buscar un objeto que existe en la lista no nos devuelva un valor nulo
        DataHanding data = new DataHanding();
        assertNotNull(data.getZBSinfo("001","2020/07/01 09:00:00","../Covid19-TIA_ZonasBásicasSalud.json"));
    }

    @Test
    public void testGetZBSinfo_AlBuscarObjetoQueNoExisteDevuelvaNulo()
    {
        //Testeamos que al buscar un objeto que no existe en la lista nos devuelva un valor nulo
        DataHanding data = new DataHanding();
        assertNull(data.getZBSinfo("999","2020/07/01 09:00:00","../Covid19-TIA_ZonasBásicasSalud.json"));
    }

    @Test
    public void getZBSM60info_AlBuscarObjetoQueExisteNoDevuelvaNulo()
    {
        DataHanding data = new DataHanding();
        assertNotNull(data.getZBSM60info("001","../Covid19-TIA_ZonasBásicasSalud_Mayores60.json"));
    }

    @Test
    public void getZBSM60info_AlBuscarObjetoQueNoExisteDevuelvaNulo()
    {
        DataHanding data = new DataHanding();
        assertNull(data.getZBSM60info("999","../Covid19-TIA_ZonasBásicasSalud_Mayores60.json"));
    }
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

    @Test
    public void CompararObjetos60_DosObjetosIgualesComparacionCorrecta()
    {
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
        listaAux.add(zbs60_1);



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

        listaAux1 = reader.LeerFicheroJson60("../Covid19-TIA_ZonasBásicasSalud_Mayores60.json");

        ZonaBasicaSaludMayores60 zbs60_1 = new ZonaBasicaSaludMayores60("001","JuanchoPerez",(float)182.5,(float)1014.70013,"2022/11/29 10:47:00");
        ZonaBasicaSaludMayores60 zbs60_2 =  new ZonaBasicaSaludMayores60(null ,null,0,0,null);

        listaAux.add(zbs60_1);
        listaAux.add(zbs60_1);

        for(ZonaBasicaSaludMayores60 i : listaAux1)
        {
            if (data.CompararObjetos60(i, listaAux.get(1)))
            {
                assertFalse(contador == 0);
            }
        }

    }

    @Test
    public void ActualizarZBS_ListaConObjetoConAtributosNulos() throws ParseException {
        ArrayList<ZonaBasicaSalud> listaAux = new ArrayList<>();
        ArrayList<ZonaBasicaSalud> listaAux1 = new ArrayList<>();
        DataHanding data = new DataHanding();
        LeerJson reader = new LeerJson();
        int contador = 0;

        listaAux1 = reader.LeerFicheroJson1("../Covid19-TIA_ZonasBásicasSalud.json");

        ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","RigobertaIV",(float)3.25224 ,(float)1219.6377,237,0,"2020/07/01 09:00:00");
        ZonaBasicaSalud zbs2 = new ZonaBasicaSalud(null,null,0,0,0,0,null);

        listaAux.add(zbs1);
        listaAux.add(zbs2);

        for(ZonaBasicaSalud i : listaAux1)
        {
            if (data.CompararObjetos(i, listaAux.get(1)))
            {
                assertFalse(contador == 0);
            }
        }

    }

    @Test
    public void AniadirZBS_ComprobarSiAniadeCorrectamenteUnObjeto()
    {
        DataHanding data = new DataHanding();
        ZonaBasicaSalud Juancho = new ZonaBasicaSalud("001","Juancho",(float)3.56 ,(float)1254.3,280,12,"2020/07/01 09:00:00");
        ArrayList<ZonaBasicaSalud> listaAux = new ArrayList<>();
        int contador = 0;
        LeerJson reader = new LeerJson();

        ArrayList<ZonaBasicaSalud> listaAux1 = reader.LeerFicheroJson1("../Covid19-TIA_ZonasBásicasSalud.json");

        listaAux = data.AnadirZBS(Juancho,"../Covid19-TIA_ZonasBásicasSalud.json");

        for(ZonaBasicaSalud i : listaAux1)
        {
            if (data.CompararObjetos(i,Juancho))
            {
                assertTrue(contador == 0);
            }
        }
    }

    @Test
    public void AnadirZBSMas60_ComprobarSiAniadeCorrectamenteUnObjeto()
    {
        DataHanding data = new DataHanding();
        ZonaBasicaSaludMayores60 Juancho = new ZonaBasicaSaludMayores60("001","Juancho",(float)3.56 ,(float)1254.3,"2020/07/01 09:00:00");
        ArrayList<ZonaBasicaSaludMayores60> listaAux = new ArrayList<>();
        int contador = 0;
        LeerJson reader = new LeerJson();

        ArrayList<ZonaBasicaSaludMayores60> listaAux1 = reader.LeerFicheroJson60("../Covid19-TIA_ZonasBásicasSalud.json");

        listaAux = data.AnadirZBSMas60(Juancho,"../Covid19-TIA_ZonasBásicasSalud_Mayores60.json");

        for(ZonaBasicaSaludMayores60 i : listaAux1)
        {
            if (data.CompararObjetos60(i,Juancho))
            {
                assertTrue(contador == 0);
            }
        }
    }

}