package com.ufvp2g6.restfullservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZonaBasicaSalud
{
    private String codigo_geometria;
    private String zona_basica_salud;
    private float tasa_incidencia_acumulada_ultimos_14dias;
    private float tasa_incidencia_acumulada_total;
    private int casos_confirmados_totales;
    private int casos_confirmados_ultimos_14dias;
    private String fecha_informe;

    public ZonaBasicaSalud(String codigo_geometria, String zona_basica_salud, float tasa_incidencia_acumulada_ultimos_14dias, float tasa_incidencia_acumulada_total, int casos_confirmados_totales, int casos_confirmados_ultimos_14dias, String fecha_informe) throws ParseException {
        this.codigo_geometria = codigo_geometria;
        this.zona_basica_salud = zona_basica_salud;
        this.tasa_incidencia_acumulada_ultimos_14dias = tasa_incidencia_acumulada_ultimos_14dias;
        this.tasa_incidencia_acumulada_total = tasa_incidencia_acumulada_total;
        this.casos_confirmados_totales = casos_confirmados_totales;
        this.fecha_informe = fecha_informe;
        this.casos_confirmados_ultimos_14dias = casos_confirmados_ultimos_14dias;
    }

    public ZonaBasicaSalud()
    {
    }

    public ZonaBasicaSalud(String codigo_geometria, String fecha_informe) {
        super();
        this.codigo_geometria = codigo_geometria;
        this.fecha_informe = fecha_informe;
    }

    public void setCodigo_geometria(String codigo_geometria) {
        this.codigo_geometria = codigo_geometria;
    }

    public void setZona_basica_salud(String zona_basica_salud) {
        this.zona_basica_salud = zona_basica_salud;
    }

    public void setTasa_incidencia_acumulada_ultimos_14dias(float tasa_incidencia_acumulada_ultimos_14dias) {
        this.tasa_incidencia_acumulada_ultimos_14dias = tasa_incidencia_acumulada_ultimos_14dias;
    }

    public void setTasa_incidencia_acumulada_total(float tasa_incidencia_acumulada_total) {
        this.tasa_incidencia_acumulada_total = tasa_incidencia_acumulada_total;
    }

    public void setCasos_confirmados_totales(int casos_confirmados_totales) {
        this.casos_confirmados_totales = casos_confirmados_totales;
    }

    public void setFecha_informe(String fecha_informe) {
        this.fecha_informe = fecha_informe;
    }

    public int getCasos_confirmados_ultimos_14dias() {
        return casos_confirmados_ultimos_14dias;
    }

    public void setCasos_confirmados_ultimos_14dias(int casos_confirmados_ultimos_14dias) {
        this.casos_confirmados_ultimos_14dias = casos_confirmados_ultimos_14dias;
    }

    public String getCodigo_geometria() {
        return codigo_geometria;
    }

    public String getZona_basica_salud() {
        return zona_basica_salud;
    }

    public float getTasa_incidencia_acumulada_ultimos_14dias() {
        return tasa_incidencia_acumulada_ultimos_14dias;
    }

    public float getTasa_incidencia_acumulada_total() {
        return tasa_incidencia_acumulada_total;
    }

    public int getCasos_confirmados_totales() {
        return casos_confirmados_totales;
    }

    public String getFecha_informe() {
        return fecha_informe;
    }
}
