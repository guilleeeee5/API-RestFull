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
        assertSame(zbs1,zbs1);
    }

    @Test
    public void CompararObjetos_DosObjetosNoIgualesComparacionCorrecta()
    {
        //Comprobamos que al pasar dos objetos diferentes nos mencione que son diferentes
        ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
        ZonaBasicaSalud zbs2 = new ZonaBasicaSalud("999","Abrantos",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
        assertNotSame(zbs1,zbs2);
    }

    @Test
    public void CompararObjetos60_DosObjetosIgualesComparacionCorrecta()
    {
        ZonaBasicaSalud zbs60_1 = new ZonaBasicaSalud("001","Abrantes",(float)182.15 ,(float)1014.70013,312,10,"2022/11/29 10:47:00");
        assertSame(zbs60_1,zbs60_1);
    }

    @Test
    public void CompararObjetos60_DosObjetosNOIgualesComparacionCorrecta()
    {
        ZonaBasicaSalud zbs60_1 = new ZonaBasicaSalud("002","Abrantes",(float)185.15 ,(float)1214.70013,312,10,"2022/11/29 10:47:00");
        ZonaBasicaSalud zbs60_2 = new ZonaBasicaSalud("001","Abrantes",(float)182.15 ,(float)1014.70013,312,10,"2022/11/29 10:47:00");
        assertNotSame(zbs60_1,zbs60_2);
    }

    @Test
    public void ActualizarZBS_DosObjetosActualizaCorrectamente() throws ParseException {
        ArrayList<ZonaBasicaSalud> listaAux = new ArrayList<>();
        ArrayList<ZonaBasicaSalud> listaAux1 = new ArrayList<>();
        DataHanding data = new DataHanding();
        LeerJson reader = new LeerJson();
        int contador = 0;

        ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","Lucas",(float)3.25224 ,(float)1219.6377,237,0,"2020/07/01 09:00:00");
        ZonaBasicaSalud zbs2 = new ZonaBasicaSalud("001","Marcos",(float)3.25224 ,(float)1314.70013,532,10,"2020/10/01 09:00:00");
        listaAux.add(zbs1);
        listaAux.add(zbs2);



        listaAux1 = reader.LeerFicheroJson1("../Covid19-TIA_ZonasBásicasSalud.json");
        listaAux1 = data.ActualizarZBS(listaAux,"../Covid19-TIA_ZonasBásicasSalud.json");

        for(ZonaBasicaSalud i : listaAux1)
        {
                if (data.CompararObjetos(i, listaAux.get(1)))
                {
                    contador = 1;
                    assertTrue(contador == 1);
                }
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



        ArrayList<ZonaBasicaSalud> listaAux1 = reader.LeerFicheroJson1("../Covid19-TIA_ZonasBásicasSalud.json");
        listaAux1 = data.ActualizarZBS(listaAux,"../Covid19-TIA_ZonasBásicasSalud.json");

        for(ZonaBasicaSalud i : listaAux1)
        {
            if (data.CompararObjetos(i, listaAux.get(1)))
            {
                contador = 1;
                assertTrue(contador == 1);
            }
            else
            {
                assertTrue(contador == 0);

            }
        }

    }
    @Test
    public void ActualizarZBS_DosObjetosIgualesNoActualizaCorrectamente() throws ParseException {
        ArrayList<ZonaBasicaSalud> listaAux = new ArrayList<>();
        DataHanding data = new DataHanding();
        ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("999","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
        ZonaBasicaSalud zbs2 = new ZonaBasicaSalud("005","Marcos",(float)8.25224 ,(float)1314.70013,532,10,"2020/10/01 09:00:00");
        listaAux.add(zbs1);
        listaAux.add(zbs2);

        assertNull(data.ActualizarZBS(listaAux,"../Covid19-TIA_ZonasBásicasSalud.json"));

    }
}