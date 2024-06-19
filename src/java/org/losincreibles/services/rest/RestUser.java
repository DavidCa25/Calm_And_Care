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

import org.losincreibles.services.controller.ControllerUser;
import org.losincreibles.services.models.User;

/**
 *
 * @author axel_
 *
 */
@Path("user")
public class RestUser {

    ControllerUser controllerUser = new ControllerUser();
    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@QueryParam("idUsuario") int idUsuario) {
        Gson gson = new Gson();
        String out;
        try {
            User user1= new User();
            user1.setIdUsuario(idUsuario);
            System.out.println("getUserById called with idUsuario: " + idUsuario);
            User user = controllerUser.getUserById(user1);
            out = gson.toJson(user);
            if (user.getIdUsuario() == 0) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("{\"result\": \"Usuario no encontrado\"}")
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("signUp")
    public Response signUp(@QueryParam("usuario") String user,
            @QueryParam("nombre") String nombre,
            @QueryParam("apellido") String apellido,
            @QueryParam("edad") int edad,
            @QueryParam("correo") String correo,
            @QueryParam("contraseña") String password
    ) {

        String out = """
                     """;
        try {

            ControllerUser uu = new ControllerUser();
            User us = new User(0, user, nombre, apellido, edad, correo, password);
            uu.saveUser(us);
            out = """
                  {"Response": "Registro Realizado" }
                  """;
        } catch (Exception e) {
            out = """
                  {"Response": "Error al registrar el usuario"  }
                  """;
        }
        return Response.ok(out).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public Response login(@QueryParam("usuario") String user,
            @QueryParam("contraseña") String password) {

        String out = "";
        try {
            User validatedUser = controllerUser.validate(user, password);
            if (validatedUser != null && validatedUser.getIdUsuario() != 0) {
                out = "{\"Response\": \"Login exitoso\", \"User\": \"" + validatedUser.getUsuario() + "\", \"idUsuario\": " + validatedUser.getIdUsuario() + "}";
            } else {
                out = "{\"Response\": \"Usuario o contraseña incorrectos\" }";
            }
        } catch (Exception e) {
            out = "{\"Response\": \"Error al realizar el login: " + e.getMessage() + "\" }";
        }
        return Response.ok(out).build();
    }
    
}
