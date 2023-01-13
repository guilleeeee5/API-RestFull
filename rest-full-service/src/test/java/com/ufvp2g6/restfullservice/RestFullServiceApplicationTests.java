package com.ufvp2g6.restfullservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
class RestFullServiceApplicationTests {
//Out of range, negativos, lectura correcta
	@Test
	void contextLoads()
	{
	}
	@Test
	public void CompararObjetos_DosObjetosIgualesComparacionCorrecta()
	{
		ZonaBasicaSalud zbs1 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
		ZonaBasicaSalud zbs2 = new ZonaBasicaSalud("001","Abrantes",(float)3.25224 ,(float)1014.70013,312,0,"2020/07/01 09:00:00");
		assertSame(zbs1,zbs1);
	}

	@Test
	public void CompararObjetos60_DosObjetosNOIgualesComparacionCorrecta()
	{
		ZonaBasicaSalud zbs60_1 = new ZonaBasicaSalud("002","Abrantes",(float)185.15 ,(float)1214.70013,312,10,"2022/11/29 10:47:00");
		ZonaBasicaSalud zbs60_2 = new ZonaBasicaSalud("001","Abrantes",(float)182.15 ,(float)1014.70013,312,10,"2022/11/29 10:47:00");
		assertNotSame(zbs60_1,zbs60_2);
	}

}
