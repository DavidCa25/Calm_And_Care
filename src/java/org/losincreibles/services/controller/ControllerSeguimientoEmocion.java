/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.controller;

import org.losincreibles.services.models.SeguimientoEmocion;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
/**
 *
 * @author axel_
 */
public class ControllerSeguimientoEmocion {
    public SeguimientoEmocion updateEmocion(SeguimientoEmocion emocion){
        String query = "UPDATE SeguimientoEmocion SET emocion = ?, fechaRegistro = ?, WHERE idUsuario = ?";
        try{
            ConexionMySql connection = new ConexionMySql();
            Connection conn = connection.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setTimestamp(1, new Timestamp(emocion.getFechaRegistro().getTime()));
            pstm.setString(2, emocion.getEmocion());
            pstm.setInt(3, emocion.getIdUsuario().getIdUsuario());
            pstm.executeUpdate();
            System.out.println("registro Generado");
            pstm.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return emocion;
    }
}
