package com.ufvp2g6.restfullservice;

import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZonaBasicaSaludController {

    @GetMapping("/ZonaBasicaSalud")
    public ArrayList<ZonaBasicaSalud> zonas(){
        LeerJson reader = new LeerJson();
        ArrayList<ZonaBasicaSalud> lista = reader.LeerFicheroJson1();
        return lista;
    }

    @GetMapping("/ZonaBasicaSaludMayores60")
    public ArrayList<ZonaBasicaSaludMayores60> zonas60(){
        LeerJson reader = new LeerJson();
        ArrayList<ZonaBasicaSaludMayores60> lista = reader.LeerFicheroJson60();
        return lista;
    }

    @GetMapping("/mostrar")
    public ZonaBasicaSalud mostrarInfoPorID(){

    }

}
