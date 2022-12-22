package com.ufvp2g6.restfullservice;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataHanding {
    public ZonaBasicaSalud getZBSinfo(String ID){
        ZonaBasicaSalud aux = null;
        LeerJson reader = new LeerJson();

        ArrayList<ZonaBasicaSalud> listaAux = reader.LeerFicheroJson1();

        for(ZonaBasicaSalud i : listaAux){
            if(i.getCodigo_geometria().equals(ID)){
                aux = i;
            }
        }
        return aux;
    }

    public ZonaBasicaSaludMayores60 getZBSM60info(String ID){
        
    }
}
