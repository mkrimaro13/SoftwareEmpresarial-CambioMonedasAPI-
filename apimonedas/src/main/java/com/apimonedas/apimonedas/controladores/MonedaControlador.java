package com.apimonedas.apimonedas.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import com.apimonedas.apimonedas.core.interfaces.servicios.IMonedaServicio;

public class MonedaControlador {
    // @Autowired
    private IMonedaServicio servicio;

    public MonedaControlador(IMonedaServicio servicio) {
        this.servicio = servicio;
    }
}
