package com.ufvp2g6.restfullservice;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class DataHanding {
    public ZonaBasicaSalud getZBSinfo(String ID, String Fecha, String ruta){
        ZonaBasicaSalud aux = null;
        LeerJson reader = new LeerJson();

        ArrayList<ZonaBasicaSalud> listaAux = reader.LeerFicheroJson1(ruta);

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

    public ArrayList<ZonaBasicaSalud> ActualizarZBS(ArrayList<ZonaBasicaSalud> ZBS) throws ParseException {
        LeerJson reader = new LeerJson();
        ArrayList<ZonaBasicaSalud> listaAux = reader.LeerFicheroJson1("Covid19-TIA_ZonasBásicasSalud.json");
        for(ZonaBasicaSalud i : listaAux){
            if (CompararObjetos(i, ZBS.get(0))){
                i.setZona_basica_salud(ZBS.get(1).getZona_basica_salud());
                i.setCasos_confirmados_ultimos_14dias(ZBS.get(1).getCasos_confirmados_ultimos_14dias());
                i.setTasa_incidencia_acumulada_total(ZBS.get(1).getTasa_incidencia_acumulada_total());
                i.setCasos_confirmados_totales(ZBS.get(1).getCasos_confirmados_totales());
                i.setFecha_informe(ZBS.get(1).getFecha_informe());
            }
        }

        return listaAux;
    }

    public ArrayList<ZonaBasicaSaludMayores60> ActualizarZBS60(ArrayList<ZonaBasicaSaludMayores60> ZBS) throws ParseException {
        LeerJson reader = new LeerJson();
        ArrayList<ZonaBasicaSaludMayores60> listaAux = reader.LeerFicheroJson60();

        for(ZonaBasicaSaludMayores60 i : listaAux){
            if (CompararObjetos60(i, ZBS.get(0))){
                i.setZona_basica_salud(ZBS.get(1).getZona_basica_salud());
                i.setTasa_incidencia_acumulada_P60mas_ultimos_14dias(ZBS.get(1).getTasa_incidencia_acumulada_P60mas_ultimos_14dias());
                i.setCasos_confirmados_P60mas_ultimos_14dias(ZBS.get(1).getCasos_confirmados_P60mas_ultimos_14dias());
                i.setFecha_informe(ZBS.get(1).getFecha_informe());
            }
        }

        return listaAux;
    }

    public boolean CompararObjetos(ZonaBasicaSalud Obj1, ZonaBasicaSalud Obj2){
        if(Obj1.getCodigo_geometria().equals(Obj2.getCodigo_geometria())){
            if(Obj1.getZona_basica_salud().equals((Obj2.getZona_basica_salud()))){
                if(Obj1.getCasos_confirmados_ultimos_14dias() == Obj2.getCasos_confirmados_ultimos_14dias()){
                    if(Obj1.getTasa_incidencia_acumulada_total() == Obj2.getTasa_incidencia_acumulada_total()){
                        if(Obj1.getFecha_informe().equals(Obj2.getFecha_informe())){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean CompararObjetos60(ZonaBasicaSaludMayores60 Obj1, ZonaBasicaSaludMayores60 Obj2){
        if(Obj1.getCodigo_geometria().equals(Obj2.getCodigo_geometria())){
            if(Obj1.getZona_basica_salud().equals((Obj2.getZona_basica_salud()))){
                if(Obj1.getCasos_confirmados_P60mas_ultimos_14dias() == Obj2.getCasos_confirmados_P60mas_ultimos_14dias()){
                    if(Obj1.getTasa_incidencia_acumulada_P60mas_ultimos_14dias() == Obj2.getTasa_incidencia_acumulada_P60mas_ultimos_14dias()){
                        if(Obj1.getFecha_informe().equals(Obj2.getFecha_informe())){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
    public ArrayList<ZonaBasicaSalud> AnadirZBS(ZonaBasicaSalud ZBS){
        LeerJson reader = new LeerJson();
        ArrayList<ZonaBasicaSalud> listaAux = reader.LeerFicheroJson1("Covid19-TIA_ZonasBásicasSalud.json");
        int numero = listaAux.size() - 1;
        ZonaBasicaSalud aux = listaAux.get(numero);
        int nuevoCod = Integer.parseInt(aux.getCodigo_geometria()) + 1;
        ZBS.setCodigo_geometria(Integer.toString(nuevoCod));
        listaAux.add(ZBS);
        return listaAux;
    }

    public ArrayList<ZonaBasicaSaludMayores60> AnadirZBSMas60(ZonaBasicaSaludMayores60 ZBS60){
        LeerJson reader = new LeerJson();
        ArrayList<ZonaBasicaSaludMayores60> listaAux = reader.LeerFicheroJson60();
        int numero = listaAux.size() - 1;
        ZonaBasicaSaludMayores60 aux = listaAux.get(numero);
        int nuevoCod = Integer.parseInt(aux.getCodigo_geometria()) + 1;
        ZBS60.setCodigo_geometria(Integer.toString(nuevoCod));
        listaAux.add(ZBS60);
        return listaAux;
    }
}


