/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.rest;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author axel_
 */
@Path("tratamiento")
public class RestTratamiento {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTratamiento")
    public Response getAll(){
        
        return null;  
    }
}
