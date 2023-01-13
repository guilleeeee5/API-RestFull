package com.ufvp2g6.restfullservice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class DataHandingTest {

    DataHanding data = new DataHanding();

    ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");

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
        assertSame(zbs1,data.getZBSinfo("001","2020/07/01 09:00:00"));
        fail("No encuentro correctamente el elemento pasado en la lista");
    }
}