package com.ufvp2g6.restfullservice;

import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

    /*@GetMapping("/ZonaBasicaSalud/{codigo_geometria}")
    public ResponseEntity<ZonaBasicaSalud> getByID(@PathVariable String codigo_geometria){
           DataHanding dataHanding = new DataHanding();
           ZonaBasicaSalud zonaBasicaSalud = dataHanding.getZBSinfo(codigo_geometria);

           return new ResponseEntity<>(zonaBasicaSalud, HttpStatus.OK);
    }*/
    @GetMapping("/ZonaBasicaSaludMayores60/{codigo_geometria}")
    public ResponseEntity<ZonaBasicaSaludMayores60> getByIDmayores60(@PathVariable String codigo_geometria){
        DataHanding dataHanding = new DataHanding();
        ZonaBasicaSaludMayores60 zonaBasicaSaludMayores60 = dataHanding.getZBSM60info(codigo_geometria);
        return new ResponseEntity<>(zonaBasicaSaludMayores60, HttpStatus.OK);
    }

    @PutMapping("ZonaBasicaSalud/{codigo_geometria}/{fechaFinal}")
    public ArrayList<ZonaBasicaSalud> actualizar(@PathVariable("codigo_geometria") String codigo_geometria, @PathVariable("fechaFinal") String fechaFinal, @RequestBody ZonaBasicaSalud ZBS) throws ParseException {
        DataHanding dataHanding = new DataHanding();
        ArrayList<ZonaBasicaSalud> lista = dataHanding.ActualizarZBS(codigo_geometria, fechaFinal, ZBS);

        return lista;
    }

    @PutMapping("ZonaBasicaSaludMayores60/{codigo_geometria}/{fechaFinal}")
    public ArrayList<ZonaBasicaSaludMayores60> actualizar(@PathVariable("codigo_geometria") String codigo_geometria, @PathVariable("fechaFinal") String fechaFinal, @RequestBody ZonaBasicaSaludMayores60 ZBS) throws ParseException {
        DataHanding dataHanding = new DataHanding();
        ArrayList<ZonaBasicaSaludMayores60> lista = dataHanding.ActualizarZBS60(codigo_geometria, fechaFinal, ZBS);

        return lista;
    }
}
