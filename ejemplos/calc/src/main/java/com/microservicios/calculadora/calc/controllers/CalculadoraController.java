package com.microservicios.calculadora.calc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.calculadora.calc.models.OperacionRequest;

@RestController
public class CalculadoraController {

    // 1. ENDPOINT GET (SUMA con Query Parameters)
    @GetMapping("/sumar")
    public int sumar(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // 2. ENDPOINT POST (RESTA con JSON Body)
    @PostMapping("/restar")
    public int restar(@RequestBody OperacionRequest request) {
        return request.getNumeroA() - request.getNumeroB();
    }
}