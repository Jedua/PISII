package com.example.calculadora.poliglota;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SumController {

    private final RestTemplate restTemplate;

    @Value("${c.service.url}")
    private String cServiceUrl;

    public SumController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/sumar")
    public String sumar(@RequestParam int num1, @RequestParam int num2) {

        String url = String.format("%s?num1=%d&num2=%d", cServiceUrl, num1, num2);

        try {
            String resultado = restTemplate.getForObject(url, String.class);
            return String.format("El microservicio en C calculó: %s", resultado);

        } catch (Exception e) {
            return "Error al llamar al servicio C: " + e.getMessage();
        }
    }
}