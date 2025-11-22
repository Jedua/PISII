package com.example.calculadora.poliglota;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OperacionesController {

    private final RestTemplate restTemplate;

    // Inyectamos las 4 URLs
    @Value("${c.suma.url}") private String urlSuma;
    @Value("${c.resta.url}") private String urlResta;
    @Value("${c.multiplicacion.url}") private String urlMulti;
    @Value("${c.division.url}") private String urlDivi;

    public OperacionesController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @GetMapping("/sumar")
    public String sumar(@RequestParam double num1, @RequestParam double num2) {
        return llamarAlServicioC(urlSuma, num1, num2, "Suma");
    }

    @GetMapping("/restar")
    public String restar(@RequestParam double num1, @RequestParam double num2) {
        return llamarAlServicioC(urlResta, num1, num2, "Resta");
    }

    @GetMapping("/multiplicar")
    public String multiplicar(@RequestParam double num1, @RequestParam double num2) {
        return llamarAlServicioC(urlMulti, num1, num2, "Multiplicación");
    }

    @GetMapping("/dividir")
    public String dividir(@RequestParam double num1, @RequestParam double num2) {
        return llamarAlServicioC(urlDivi, num1, num2, "División");
    }

    /** Helper para no repetir código */
    private String llamarAlServicioC(String urlBase, double num1, double num2, String opNombre) {
        
        String url = String.format("%s?num1=%.2f&num2=%.2f", urlBase, num1, num2);
        
        try {
            String resultado = restTemplate.getForObject(url, String.class);
            return String.format("Resultado de %s (en C): %s", opNombre, resultado);
        } catch (Exception e) {
            return String.format("Error llamando al servicio C de %s: %s", opNombre, e.getMessage());
        }
    }
}