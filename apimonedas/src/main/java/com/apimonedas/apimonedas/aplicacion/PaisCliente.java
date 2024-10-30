package com.apimonedas.apimonedas.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apimonedas.apimonedas.dominio.DTOs.CapitalDTO;

@Service
public class PaisCliente {
    @Autowired
    private RestTemplate restTemplate;

    public CapitalDTO obtenerCapitalDTO(String nombre) {
        String url = "http://localhost:3030/paises/capital/" + nombre;
        // Llama a la otra API Rest, el tercer parámetro que se está enviando como null
        // sería el requestEntity, es decir, el body request
        ResponseEntity<CapitalDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<CapitalDTO>() {

                });
        return responseEntity.getBody();
    }
}
