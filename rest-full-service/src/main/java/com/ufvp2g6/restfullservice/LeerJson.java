package com.ufvp2g6.restfullservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeerJson {
    public static ArrayList<ZonaBasicaSalud> LeerFicheroJson1(){
        ArrayList <ZonaBasicaSalud> listaJSON = new ArrayList<>();
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get("Covid19-TIA_ZonasBásicasSalud.json"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // convert JSON array to list of users
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<ZonaBasicaSalud>>() {}.getType());
            System.out.println("FICHERO Covid19-TIA_ZonasBásicasSalud.json LEIDO CORRECTAMENTE");
            for(int i = 0; i < listaJSON.size(); i++)
            {
                listaJSON.get(i).setFechaFinal(listaJSON.get(i).getFecha_informe());
            }

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

    public static ArrayList<ZonaBasicaSaludMayores60> LeerFicheroJson60(){
        ArrayList <ZonaBasicaSaludMayores60> listaJSON = new ArrayList<>();
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = null;
            try {
                reader = Files.newBufferedReader(Paths.get("Covid19-TIA_ZonasBásicasSalud_Mayores60.json"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // convert JSON array to list of users
            listaJSON = new Gson().fromJson(reader, new TypeToken<ArrayList<ZonaBasicaSaludMayores60>>() {}.getType());
            System.out.println("FICHERO Covid19-TIA_ZonasBásicasSalud_Mayores60.json LEIDO CORRECTAMENTE");
            for(int i = 0; i < listaJSON.size(); i++)
            {
                listaJSON.get(i).setFechaFinal(listaJSON.get(i).getFecha_informe());
            }

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