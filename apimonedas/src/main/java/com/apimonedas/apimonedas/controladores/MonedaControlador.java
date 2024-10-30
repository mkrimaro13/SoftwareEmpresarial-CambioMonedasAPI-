package com.apimonedas.apimonedas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apimonedas.apimonedas.core.interfaces.servicios.IMonedaServicio;
import com.apimonedas.apimonedas.dominio.Moneda;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/monedas")
public class MonedaControlador {
    @Autowired // Se usa en contraposición del constructor, aunque también se puede tener un
               // constructor aparte con funciones específicas.
    private IMonedaServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Moneda> listar() {
        return servicio.listar();
    }

    // También se puede hacer con @PostMapping("path")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Moneda agregarMoneda(@RequestBody Moneda moneda) {
        return servicio.agregar(moneda);
    }

}
