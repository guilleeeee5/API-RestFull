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

    //Creamos los métodos GET para acceder a los elementos del Json leido
    @GetMapping("/ZonaBasicaSalud")
    public ArrayList<ZonaBasicaSalud> zonas(){
        LeerJson reader = new LeerJson();
        //Leemos el reason e introducimos los elementos en un arraylist
        ArrayList<ZonaBasicaSalud> lista = reader.LeerFicheroJson1();
        //Mostramos los elementos leidos
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

    //Creamos los métodos GET para acceder a los elementos del JSON en base al elemento codigo_geometria
    @GetMapping("/ZonaBasicaSaludMayores60/{codigo_geometria}")
    public ResponseEntity<ZonaBasicaSaludMayores60> getByIDmayores60(@PathVariable String codigo_geometria){
        //Creamos la clase que nos permita operar los elementos del Json
        DataHanding dataHanding = new DataHanding();
        ZonaBasicaSaludMayores60 zonaBasicaSaludMayores60 = dataHanding.getZBSM60info(codigo_geometria);
        return new ResponseEntity<>(zonaBasicaSaludMayores60, HttpStatus.OK);
    }

    //Cremos los métodos PUT para actualzar los elementos de los Json
    @PutMapping("/ZonaBasicaSalud")
    public ArrayList<ZonaBasicaSalud> actualizar(@RequestBody ArrayList<ZonaBasicaSalud> ZBS) throws ParseException {
        //Creamos una clase data handling para poder manipular los datos
        DataHanding dataHanding = new DataHanding();
        //Incluimos los elementos a actualizar
        ArrayList<ZonaBasicaSalud> lista = dataHanding.ActualizarZBS(ZBS);
        //Creamos la clase que nos permita esccribir en el Json
        EscribirJSON escribirJSON = new EscribirJSON();
        //EScribimos en el fichero
        escribirJSON.escribirZBS(lista);
        return lista;
    }

    @PutMapping("/ZonaBasicaSaludMayores60")
    public ArrayList<ZonaBasicaSaludMayores60> actualizar60(@RequestBody ArrayList<ZonaBasicaSaludMayores60> ZBS) throws ParseException {
        DataHanding dataHanding = new DataHanding();
        ArrayList<ZonaBasicaSaludMayores60> lista = dataHanding.ActualizarZBS60(ZBS);
        EscribirJSON escribirJSON = new EscribirJSON();
        escribirJSON.escribirZBSMas60(lista);
        return lista;
    }
}
