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
public class SeguimientoEmocion {
    private int idSeguimiento;
    private Date fechaRegistro;
    private String emocion;
    private User _idUsuario;

    public SeguimientoEmocion(int idSeguimiento, Date fechaRegistro, String emocion, User _idUsuario) {
        this.idSeguimiento = idSeguimiento;
        this.fechaRegistro = fechaRegistro;
        this.emocion = emocion;
        this._idUsuario = _idUsuario;
    }

    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public User getIdUsuario() {
        return _idUsuario;
    }

    public void setIdUsuario(User _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    
    
}
