/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author PC
 */
public class Nomina {
    int anio, mes;
    String dni;
    Double sueldoH, sueldoHE;

    public Nomina(int anio, int mes, String dni) {
        this.anio = anio;
        this.mes = mes;
        this.dni = dni;
    }

    public Nomina(int anio, int mes, String dni, Double sueldoH, Double sueldoHE) {
        this.anio = anio;
        this.mes = mes;
        this.dni = dni;
        this.sueldoH = sueldoH;
        this.sueldoHE = sueldoHE;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getSueldoH() {
        return sueldoH;
    }

    public Double getSueldoHE() {
        return sueldoHE;
    }
}
