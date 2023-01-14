package com.ufvp2g6.restfullservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeerJson {
    public static ArrayList<ZonaBasicaSalud> LeerFicheroJson1(String ruta){
        ArrayList <ZonaBasicaSalud> listaJSON = new ArrayList<>();
        try {
            //Creamos el objeto Gson
            Gson gson = new Gson();

            // Creamos el reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Usamos la libreria Gson para leer el fichero Json e introducirlo en un arraylist
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<ZonaBasicaSalud>>() {}.getType());
            System.out.println("FICHERO Covid19-TIA_ZonasBásicasSalud.json LEIDO CORRECTAMENTE");

            //Cerramos el reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }

    public static ArrayList<ZonaBasicaSaludMayores60> LeerFicheroJson60(String ruta){
        ArrayList <ZonaBasicaSaludMayores60> listaJSON = new ArrayList<>();
        try {
            //Mismo procedimiento que con el fichero anterior
            Gson gson = new Gson();

            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<ZonaBasicaSaludMayores60>>() {}.getType());
            System.out.println("FICHERO Covid19-TIA_ZonasBásicasSalud_Mayores60.json LEIDO CORRECTAMENTE");

            // close reader
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listaJSON;
    }
}
