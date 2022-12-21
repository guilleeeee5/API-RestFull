package com.ufvp2g6.restfullservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class RestFullServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullServiceApplication.class, args);

		ArrayList<ZonaBasicaSalud> ListaZBS = new ArrayList<>();
		ArrayList<ZonaBasicaSaludMayores60> ListaZBS60 = new ArrayList<>();

		ListaZBS = LeerJson.LeerFicheroJson1();
		ListaZBS60 = LeerJson.LeerFicheroJson60();

	}

}
