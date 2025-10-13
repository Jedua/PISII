package com.uam.microservicio.hola_microservicio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Define un controlador REST que manejará peticiones HTTP.
 */
@RestController
public class HolaController {

    /**
     * Mapea peticiones GET a la ruta '/saludar'.
     * @RequestParam extrae el parámetro 'nombre' de la URL, usando 'Invitado' por defecto.
     */
    @GetMapping("/saludar")
    public String saludar(
            @RequestParam(value = "nombre", defaultValue = "Invitado") String nombre) {

        // Retorna la respuesta HTTP (un String en este caso).
        return String.format("¡Hola, %s! Tu microservicio está corriendo.", nombre);
    }
}