package com.apimonedas.apimonedas.core.interfaces.servicios;

import com.apimonedas.apimonedas.dominio.DTOs.CapitalDTO;

public interface IPaisServicio {
    public CapitalDTO obtenerCapitalDTO(String s);
}
