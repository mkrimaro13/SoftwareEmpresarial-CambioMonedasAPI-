package com.apimonedas.apimonedas.core.interfaces.servicios;

import java.util.Date;
import java.util.List;

import com.apimonedas.apimonedas.dominio.CambioMoneda;
import com.apimonedas.apimonedas.dominio.Moneda;

public interface IMonedaServicio {
    public List<Moneda> listar();

    public Moneda obtener(Long id);

    public List<Moneda> buscar(String nombre); // Requiere una consulta específica, ya que JPA no provee consultas específicas

    public Moneda buscarPorPais(String nombre);

    public Moneda agregar(Moneda moneda);

    public Moneda modificar(Moneda moneda);

    public boolean eliminar(Long id);

    public List<CambioMoneda> listarPorPeriodo(long idmoneda, Date fecha1, Date fecha2);
}
