/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.losincreibles.services.controller;

import java.util.Date;
import org.losincreibles.services.models.User;

/**
 *
 * @author axel_
 */
public class Main {
    public static void main(String[] args) {
        
     
        
        User u = new User(0,"admin","Jesus David", "Casillas Rios", 20, "jesusdavidcasill@gmail.com", "Casillas_00");
        ControllerUser uu = new ControllerUser();
        uu.saveUser(u);
        System.out.println("Registro realizado");
                 
    }
}
