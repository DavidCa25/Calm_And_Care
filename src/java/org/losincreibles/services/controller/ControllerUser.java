/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
    public List<User> getAll() {
        List<User> listUsers = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try {
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
              
                
                listUsers.add(u);
            }
            return listUsers;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return listUsers;
        }
    }
          
   public User getUsercc(User u) {
    String query = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";  
    ResultSet rs = null;
    try{
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, u.getUsuario());
            pstm.setString(2, u.getContraseña());
            rs = pstm.executeQuery();
            if(rs.next()){
                u.setIdUsuario(rs.getInt("idUsuario"));               
            }else{
                u.setIdUsuario(0);
            }
            rs.close();
            pstm.close();
            connMySql.close();
        }catch(Exception e){
            e.printStackTrace();
       }        
       return u;     
    }
     public User validate(String username, String password) {       
        List<User> usuarios = getAll();
   
        for (User usuario : usuarios) {
            if (usuario.getUsuario().equals(username) && usuario.getContraseña().equals(password)) {
                return usuario;
            }
        }
        return null; 
     }
}

