package com.apimonedas.apimonedas.aplicacion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apimonedas.apimonedas.core.interfaces.repositorios.ICambioMonedaRepositorio;
import com.apimonedas.apimonedas.core.interfaces.repositorios.IMonedaRepositorio;
import com.apimonedas.apimonedas.core.interfaces.servicios.IMonedaServicio;
import com.apimonedas.apimonedas.dominio.CambioMoneda;
import com.apimonedas.apimonedas.dominio.Moneda;

@Service
public class MonedaServicio implements IMonedaServicio {

    private IMonedaRepositorio repositorio; // Injección de dependencias para poder usar los métodos de JPA
    private ICambioMonedaRepositorio monedaRepositorio;

    public MonedaServicio(IMonedaRepositorio repositorio, ICambioMonedaRepositorio monedaRepositorio) {
        this.repositorio = repositorio;
        this.monedaRepositorio = monedaRepositorio;
    }

    @Override
    public List<Moneda> listar() {
        return repositorio.findAll();
    }

    @Override
    public Moneda obtener(Long id) {
        return repositorio.findById(id).isEmpty() ? repositorio.findById(id).get() : null; // Operador ternario (if)
    }

    @Override
    public List<Moneda> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Moneda buscarPorPais(String nombre) {
        return repositorio.buscarPorPais(nombre);
    }

    @Override
    public Moneda agregar(Moneda moneda) {
        // Por defecto si el ID es cero JPA reconoce la creación del registro
        moneda.setId(0);
        return repositorio.save(moneda);
    }

    @Override
    public Moneda modificar(Moneda moneda) {
        Optional<Moneda> monedaEncontrada = repositorio.findById(moneda.getId()); // En caso de que no encuentre nada
        if (monedaEncontrada.isPresent()) {
            return repositorio.save(moneda);
        } else {
            return null;
        }

    }

    @Override
    public boolean eliminar(Long id) {
        // En caso de que no deje eliminar devuelva false, es posible que no deje eliminar si por ejemplo alguna moneda tiene mas de una clave foránea de país
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<CambioMoneda> listarPorPeriodo(long idmoneda, Date fecha1, Date fecha2) {
        return monedaRepositorio.listarPorPeriodo(idmoneda, fecha1, fecha2);
    }

}
