package com.apimonedas.apimonedas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apimonedas.apimonedas.core.interfaces.servicios.IPaisServicio;
import com.apimonedas.apimonedas.dominio.DTOs.CapitalDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/paises")
public class PaisControlador {
    @Autowired
    private IPaisServicio servicio;

    @GetMapping("/capital/{pais}")
    public CapitalDTO obtenerCapitalDTO(@PathVariable String pais) {
        return servicio.obtenerCapitalDTO(pais);
    }

}
