/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import org.losincreibles.services.models.Reservacion;
import java.sql.ResultSet;
import org.losincreibles.services.models.Tratamiento;
import org.losincreibles.services.models.User;

/**
 *
 * @author axel_
 */
public class ControllerReservacion {
    public Reservacion addReservacion(Reservacion u){
        String query = "INSERT INTO Reservacion values (0,?,?,?)";
        try{
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setTimestamp(1, new Timestamp(u.getFechaReservacion().getTime()));
            pstm.setInt(2, u.getIdUsuario().getIdUsuario());
            pstm.setInt(3, u.getIdTratamiento().getIdTratamiento());
            pstm.execute();
            System.out.println("Registro generado");
            pstm.close();
            connMySql.close();
        }catch(Exception e){
            e.printStackTrace();
       }        
       return u;  
    }   
public Reservacion getReservacionById(Reservacion reserva){                                                         
    String query = "SELECT * FROM Reservacion WHERE idReservacion = ?";  

    try{
        ConexionMySql connMySql = new ConexionMySql();  
        Connection conn = connMySql.open();
        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setInt(1, reserva.getIdReservacion());
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            reserva.setIdReservacion(rs.getInt("idReservacion"));
            reserva.setFechaReservacion(rs.getTimestamp("fechaReservacion"));
            
           
            User usuario = new User();
            usuario.setIdUsuario(rs.getInt("_idUsuario"));
            reserva.setIdUsuario(usuario);
            
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setIdTratamiento(rs.getInt("_idTratamiento"));
            
            reserva.setIdTratamiento(tratamiento);
            
            
        }else{
            
            reserva.setIdReservacion(0);
        }
        rs.close();
        pstm.close();
        connMySql.close();
    }catch(Exception e){
        e.printStackTrace();
    }        
    return reserva;     
}


}