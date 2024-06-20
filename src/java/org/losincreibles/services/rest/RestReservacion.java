/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.rest;


import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import org.losincreibles.services.controller.ControllerReservacion;
import org.losincreibles.services.models.Reservacion;
import org.losincreibles.services.models.Tratamiento;
import org.losincreibles.services.models.User;
import java.text.SimpleDateFormat;
import java.text.ParseException;

@Path("reservacion")
public class RestReservacion {
    
    ControllerReservacion controllerRe = new ControllerReservacion();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("addReservacion")
    public Response agregarReservacion(
            @QueryParam("_idUsuario") int idUsuario,
            @QueryParam("_idTratamiento") int idTratamiento,
            @QueryParam("fechaReservacion") String fechaReservacionStr
    ) {
        String out = "";
        try {
            // Crear los objetos User y Tratamiento a partir de los IDs
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaReservacion = sdf.parse(fechaReservacionStr);
            User user = new User();
            user.setIdUsuario(idUsuario);
            
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setIdTratamiento(idTratamiento);
            ControllerReservacion controller = new ControllerReservacion();
            Reservacion reservacion = new Reservacion(0, fechaReservacion, user, tratamiento);
            controller.addReservacion(reservacion);
            
            out = "{\"Response\": \"Registro Realizado\"}";
        } catch (Exception e) {
            out = "{\"Response\": \"Error al registrar el tratamiento\"}";
            e.printStackTrace();
        }
        return Response.ok(out).build();
    }
    
    @GET
    @Path("getReservacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservacionById(@QueryParam("idReservacion") int idReservacion) {
        Gson gson = new Gson();
        String out;
        try {
            Reservacion reservacion1 = new Reservacion();
            reservacion1.setIdReservacion(idReservacion);
            
            Reservacion reservacion = controllerRe.getReservacionById(reservacion1);
            out = gson.toJson(reservacion);
            if (reservacion.getIdReservacion() == 0) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("{\"result\": \"Reservacion no encontrado\"}")
                               .build();
            }
        } catch (Exception e) {
            out = String.format("{\"result\": \"%s\"}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity(out)
                           .build();
        }
        return Response.ok(out).build();
    }
}
