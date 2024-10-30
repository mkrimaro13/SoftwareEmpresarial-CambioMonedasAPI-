package com.apimonedas.apimonedas.aplicacion;

import org.springframework.stereotype.Service;

import com.apimonedas.apimonedas.core.interfaces.servicios.IPaisServicio;
import com.apimonedas.apimonedas.dominio.DTOs.CapitalDTO;

@Service
public class PaisServicio implements IPaisServicio {
    private PaisCliente cliente;

    public PaisServicio(PaisCliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public CapitalDTO obtenerCapitalDTO(String nombre) {
        return cliente.obtenerCapitalDTO(nombre);
    }
}
