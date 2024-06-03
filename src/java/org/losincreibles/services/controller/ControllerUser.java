/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import org.losincreibles.services.models.User;

/**
 *
 * @author axel_
 */


public class ControllerUser {

    public User saveUser(User u){
        String query = "INSERT INTO Usuario values (0,?,?,?,?,?,?)";
        try{
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, u.getUsuario());
            pstm.setString(2, u.getNombre());
            pstm.setString(3, u.getApellido());
            pstm.setInt(4, u.getEdad());
            pstm.setString(5, u.getCorreo());
            pstm.setString(6, u.getContraseña());
            
            pstm.execute();
            System.out.println("Registro generado");
            pstm.close();
            connMySql.close();
        }catch(Exception e){
            e.printStackTrace();
       }        
       return u;  
    }   
}
