/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import org.losincreibles.services.models.Tratamiento;
import java.sql.ResultSet;

/**
 *
 * @author axel_
 */
public class ControllerTratamiento {  
    public List<Tratamiento> getTratamiento(){
       List<Tratamiento> listTratamientos = new ArrayList<>();
       String query = "SELECT * FROM Tratamiento";
        try {
            ConexionMySql connection = new ConexionMySql();
            Connection conn = connection.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Tratamiento t = new Tratamiento();
                t.setIdTratamiento(rs.getInt("idTratamientos"));
                t.setTratamiento(rs.getString("tratamiento"));            
                t.setServicio(rs.getString("servicio"));
                listTratamientos.add(t);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return listTratamientos;
        }
       return listTratamientos;
    }
    
    public Tratamiento addTratamiento(Tratamiento u){
        String query = "INSERT INTO Tratamiento values (0,?,?,?)";
        try{
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, u.getTratamiento()); 
            pstm.setString(2, u.getServicio());
            pstm.setInt(3, u.getPrecio());
            pstm.execute();
            System.out.println("Registro generado");
            pstm.close();
            connMySql.close();
        }catch(Exception e){
            e.printStackTrace();
       }        
       return u;  
    }   
    public List<Tratamiento> getTratamientoByManicura(){ 
        List<Tratamiento> listManicura = new ArrayList();
        String query = "SELECT * FROM Tratamiento WHERE tratamiento = 'manicura'";  

        try{
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Tratamiento t = new Tratamiento();
                t.setIdTratamiento(rs.getInt("idTratamiento"));
                t.setTratamiento(rs.getString("tratamiento"));
                t.setServicio(rs.getString("servicioTratamiento"));
                t.setPrecio(rs.getInt("precio"));
                
            
                
                listManicura.add(t);
            }
            return listManicura;
               
        }catch(Exception e){
            e.printStackTrace();
            return listManicura;  
       }        
          
    }
    public List<Tratamiento> getTratamientoByMasaje(){ 
        List<Tratamiento> listManicura = new ArrayList();
        String query = "SELECT * FROM Tratamiento WHERE tratamiento = 'masaje'";  

        try{
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Tratamiento t = new Tratamiento();
                t.setIdTratamiento(rs.getInt("idTratamiento"));
                t.setTratamiento(rs.getString("tratamiento"));
                t.setServicio(rs.getString("servicioTratamiento"));
                t.setPrecio(rs.getInt("precio"));
                
            
                
                listManicura.add(t);
            }
            return listManicura;
               
        }catch(Exception e){
            e.printStackTrace();
            return listManicura;  
       }        
          
    }
    public List<Tratamiento> getTratamientoByPedicura(){ 
        List<Tratamiento> listManicura = new ArrayList();
        String query = "SELECT * FROM Tratamiento WHERE tratamiento = 'pedicura'";  

        try{
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Tratamiento t = new Tratamiento();
                t.setIdTratamiento(rs.getInt("idTratamiento"));
                t.setTratamiento(rs.getString("tratamiento"));
                t.setServicio(rs.getString("servicioTratamiento"));
                t.setPrecio(rs.getInt("precio"));
                
            
                
                listManicura.add(t);
            }
            return listManicura;
               
        }catch(Exception e){
            e.printStackTrace();
            return listManicura;  
       }        
          
    }
    public List<Tratamiento> getTratamientoByExfoliacion(){ 
        List<Tratamiento> listManicura = new ArrayList();
        String query = "SELECT * FROM Tratamiento WHERE tratamiento = 'exfoliacion'";  

        try{
            ConexionMySql connMySql = new ConexionMySql();  
            Connection conn = connMySql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Tratamiento t = new Tratamiento();
                t.setIdTratamiento(rs.getInt("idTratamiento"));
                t.setTratamiento(rs.getString("tratamiento"));
                t.setServicio(rs.getString("servicioTratamiento"));
                t.setPrecio(rs.getInt("precio"));
                
            
                
                listManicura.add(t);
            }
            return listManicura;
               
        }catch(Exception e){
            e.printStackTrace();
            return listManicura;  
       }        
          
    }
    private Tratamiento getTratamientoById(int idTratamiento) {
    String query = "SELECT * FROM Tratamiento WHERE idTratamiento = ?";
    Tratamiento tratamiento = null;
    
    try {
        ConexionMySql connMySql = new ConexionMySql();
        Connection conn = connMySql.open();
        PreparedStatement pstm = conn.prepareStatement(query);
        pstm.setInt(1, idTratamiento);
        ResultSet rs = pstm.executeQuery();
        
        if (rs.next()) {
            tratamiento = new Tratamiento(
                rs.getInt("idTratamiento"),
                rs.getString("tratamiento"),
                rs.getString("servicio"),
                rs.getInt("precio")
            );
        }
        
        rs.close();
        pstm.close();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    
    return tratamiento;
}
    
}
