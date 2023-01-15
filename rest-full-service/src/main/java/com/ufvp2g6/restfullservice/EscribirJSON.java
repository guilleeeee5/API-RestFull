package com.ufvp2g6.restfullservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EscribirJSON {
    //En esta clase se ha programa la escritura del JSON
    public void escribirZBS(ArrayList<ZonaBasicaSalud> lista){
        try {
            // Creamos una nueva clase Json
            Gson gson = new Gson();

            //Creamos la clase que permite escribir en el fichero Json
            Writer writer = new FileWriter("Covid19-TIA_ZonasBásicasSalud.json");
            try {
                gson.toJson(lista, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void escribirZBSMas60(ArrayList<ZonaBasicaSaludMayores60> lista){
        try {
            //Mismo procedimiento con el 2 fichero
            Gson gson = new Gson();
            String aux = "";
            int aux2;
            for (ZonaBasicaSaludMayores60 objeto:lista) {
                aux2 = Integer.parseInt(objeto.getCodigo_geometria());
                aux = String.format("%03d", aux2);
                objeto.setCodigo_geometria(aux);
            }
            // create a reader
            Writer writer = new FileWriter("Covid19-TIA_ZonasBásicasSalud_Mayores60.json");
            try {
                gson.toJson(lista, writer);
                writer.close();
            } catch (JsonIOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
