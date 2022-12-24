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
    public void escribirZBS(ArrayList<ZonaBasicaSalud> lista){
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
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
            // create Gson instance
            Gson gson = new Gson();

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
