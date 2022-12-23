package com.ufvp2g6.restfullservice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class DataHanding {
    public ZonaBasicaSalud getZBSinfo(String ID, String Fecha){
        ZonaBasicaSalud aux = null;
        LeerJson reader = new LeerJson();

        ArrayList<ZonaBasicaSalud> listaAux = reader.LeerFicheroJson1();

        for(ZonaBasicaSalud i : listaAux){
            if(i.getCodigo_geometria().equals(ID) && i.getFecha_informe().equals(Fecha)){
                aux = i;
            }
        }
        return aux;
    }

    public ZonaBasicaSaludMayores60 getZBSM60info(String ID){
        ZonaBasicaSaludMayores60 aux = null;
        LeerJson reader = new LeerJson();

        ArrayList<ZonaBasicaSaludMayores60> listaAux = reader.LeerFicheroJson60();

        for(ZonaBasicaSaludMayores60 i : listaAux){
            if(i.getCodigo_geometria().equals(ID)){
                aux = i;
            }
        }
        return aux;
    }

    public ArrayList<ZonaBasicaSalud> ActualizarZBS(String ID, String Fecha, ZonaBasicaSalud Nuevo){
        LeerJson reader = new LeerJson();
        ArrayList<ZonaBasicaSalud> listaAux = reader.LeerFicheroJson1();

        for(ZonaBasicaSalud i : listaAux){
            if (i.getCodigo_geometria().equals(ID) && i.getFecha_informe().equals(Fecha)){
                i.setZona_basica_salud(Nuevo.getZona_basica_salud());
                i.setCasos_confirmados_ultimos_14dias(Nuevo.getCasos_confirmados_ultimos_14dias());
                i.setTasa_incidencia_acumulada_total(Nuevo.getTasa_incidencia_acumulada_total());
                i.setCasos_confirmados_totales(Nuevo.getCasos_confirmados_totales());
                i.setFecha_informe(Nuevo.getFecha_informe());
            }
        }

        return listaAux;
    }
}
