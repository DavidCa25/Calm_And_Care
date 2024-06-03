/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.models;

import java.util.Date;

/**
 *
 * @author axel_
 */
public class Reservacion {
    private int idReservacion;
    private Date fechaReservacion;
    private User _idUsuario;
    private Tratamiento _idTratamiento;

    public Reservacion() {
    }

    public Reservacion(int idReservacion, Date fechaReservacion, User _idUsuario, Tratamiento _idTratamiento) {
        this.idReservacion = idReservacion;
        this.fechaReservacion = fechaReservacion;
        this._idUsuario = _idUsuario;
        this._idTratamiento = _idTratamiento;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public User getIdUsuario() {
        return _idUsuario;
    }

    public void setIdUsuario(User _idUsuario) {
        this._idUsuario = _idUsuario;
    }

    public Tratamiento getIdTratamiento() {
        return _idTratamiento;
    }

    public void setIdTratamiento(Tratamiento _idTratamiento) {
        this._idTratamiento = _idTratamiento;
    }
    
    
}
