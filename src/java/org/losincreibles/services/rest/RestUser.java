/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.rest;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.losincreibles.services.controller.ControllerUser;
import org.losincreibles.services.models.User;

/**
 *
 * @author axel_
 * */

 @Path("user")
public class RestUser {  
    ControllerUser controllerUser = new ControllerUser();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("signUp")    
    public Response signUp(@FormParam("usuario")String user,          
            @FormParam("nombre") String nombre,
            @FormParam("apellido") String apellido,
            @FormParam("edad") int edad,
            @FormParam("correo") String correo,
            @FormParam("contraseña") String password
            ){
        
        String out = """
                     """;
        try{
            
            
            ControllerUser uu = new ControllerUser();
            User us = new User(0,user,nombre, apellido, edad, correo, password);
            uu.saveUser(us);
            out = """
                  {"Response": "Registro Realizado" }
                  """;
        }catch(Exception e){
             out = """
                  {"Response": "Error al registrar el usuario"  }
                  """;
        }
        return Response.ok(out).build();
        
    }
 }
