package com.apimonedas.apimonedas.core.interfaces.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apimonedas.apimonedas.dominio.CambioMoneda;

@Repository
public interface ICambioMonedaRepositorio extends JpaRepository<CambioMoneda, Long> {
    @Query("SELECT cm FROM CambioMoneda cm WHERE cm.moneda.id = ?1 AND cm.fecha BETWEEN ?2 AND ?3")
    List<CambioMoneda> listarPorPeriodo(long idmoneda, Date fecha1, Date fecha2);
}
