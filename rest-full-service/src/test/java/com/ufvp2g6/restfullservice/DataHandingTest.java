package com.ufvp2g6.restfullservice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

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
    public void getZBSinfo()
    {
        DataHanding data = new DataHanding();
        ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
        assertSame(zbs1,data.getZBSinfo("001","2020/07/01 09:00:00"));
        fail("No encuentro correctamente el elemento pasado en la lista");
    }

    @Test
    public void CompararObjetos_DosObjetosIgualesComparacionCorrecta()
    {
        ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
        ZonaBasicaSalud zbs2 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
        assertSame(zbs1,zbs1);
    }

    @Test
    public void CompararObjetos60_DosObjetosIgualesComparacionCorrecta()
    {
        ZonaBasicaSalud zbs60_1 = new ZonaBasicaSalud("001","Abrantes",(float)182.15 ,(float)1014.70013,312,10,"2022/11/29 10:47:00");
        ZonaBasicaSalud zbs60_2 = new ZonaBasicaSalud("001","Abrantes",(float)182.15 ,(float)1014.70013,312,10,"2022/11/29 10:47:00");
        assertSame(zbs60_1,zbs60_1);
    }

    @Test
    public void CompararObjetos60_DosObjetosNOIgualesComparacionCorrecta()
    {
        ZonaBasicaSalud zbs60_1 = new ZonaBasicaSalud("002","Abrantes",(float)185.15 ,(float)1214.70013,312,10,"2022/11/29 10:47:00");
        ZonaBasicaSalud zbs60_2 = new ZonaBasicaSalud("001","Abrantes",(float)182.15 ,(float)1014.70013,312,10,"2022/11/29 10:47:00");
        assertSame(zbs60_1,zbs60_1);
        fail("Los objetos no son iguales");
    }
}