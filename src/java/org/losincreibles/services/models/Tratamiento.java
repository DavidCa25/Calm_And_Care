/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.models;

import java.util.List;

/**
 *
 * @author axel_
 */
public class Tratamiento {
    private int idTratamiento;
    private String tratamiento;
    private String servicio;
    private int precio;

    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String tratamiento, String servicio, int precio) {
        this.idTratamiento = idTratamiento;
        this.tratamiento = tratamiento;
        this.servicio = servicio;
        this.precio = precio;
    }

    
    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
    
     public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    } 

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
