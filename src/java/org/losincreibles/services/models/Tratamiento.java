/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.models;

/**
 *
 * @author axel_
 */
public class Tratamiento {
    private int idTratamiento;
    private String tratamiento;
    private int precio;

    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String tratamiento, int precio) {
        this.idTratamiento = idTratamiento;
        this.tratamiento = tratamiento;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
