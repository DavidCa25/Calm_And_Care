/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.losincreibles.services.controller.ControllerTratamiento;

import org.losincreibles.services.models.Tratamiento;

/**
 *
 * @author axel_
 */
@Path("tratamiento")
public class RestTratamiento {
    ControllerTratamiento controllerTratamiento = new ControllerTratamiento();
    @GET
    @Path("getTratamientoByManicura")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out = "";
        Gson gson = new Gson();
        try {
            out = gson.toJson(controllerTratamiento.getTratamientoByManicura());
        } catch (Exception e) {
            out = """
                  {"result": "%s"}
                  """;
            out = String.format(out, e);
        }
        return Response.ok(out).build();
    }
    @GET
    @Path("getTratamientoByMasaje")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTratamientoByMasaje() {
        String out = "";
        Gson gson = new Gson();
        try {
            out = gson.toJson(controllerTratamiento.getTratamientoByMasaje());
        } catch (Exception e) {
            out = """
                  {"result": "%s"}
                  """;
            out = String.format(out, e);
        }
        return Response.ok(out).build();
    }
    @GET
    @Path("getTratamientoByPedicura")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTratamientoByPedicura() {
        String out = "";
        Gson gson = new Gson();
        try {
            out = gson.toJson(controllerTratamiento.getTratamientoByPedicura());
        } catch (Exception e) {
            out = """
                  {"result": "%s"}
                  """;
            out = String.format(out, e);
        }
        return Response.ok(out).build();
    }
    @GET
    @Path("getTratamientoByExfoliacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTratamientoByExfoliacion() {
        String out = "";
        Gson gson = new Gson();
        try {
            out = gson.toJson(controllerTratamiento.getTratamientoByExfoliacion());
        } catch (Exception e) {
            out = """
                  {"result": "%s"}
                  """;
            out = String.format(out, e);
        }
        return Response.ok(out).build();
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addTratamiento")
    public Response agregarTratamiento(
            @FormParam("tratamiento")String tratamiento,
            @FormParam("servicioTratamiento")String servicio,
            @FormParam("precio") int precio
    ) {
    String out = "";
    try {
        ControllerTratamiento controller = new ControllerTratamiento();
        Tratamiento tt = new Tratamiento(0, tratamiento, servicio, precio);
        controller.addTratamiento(tt);
        
        out = "{\"Response\": \"Registro Realizado\"}";
    } catch (Exception e) {
        out = "{\"Response\": \"Error al registrar el tratamiento\"}";
        e.printStackTrace();
    }
    
    return Response.ok(out).build();
}

}
