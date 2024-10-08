package com.apimonedas.apimonedas.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apimonedas.apimonedas.dominio.Moneda;

@Repository
public interface IMonedaRepositorio extends JpaRepository<Moneda, Long> {
    // Esta interfaz se encarga de realizar las consultas a la base de datos, maneja
    // una lista de Monedas y su identificador, ya que está heredando de JPA

    @Query("SELECT m FROM Moneda m WHERE m.nombre LIKE '%' || ?1 '%' ") // el ?1 indica que se requiere el parámetro en
                                                                        // la primera posición
    List<Moneda> buscar(String nombre);

    @Query("SELECT m FROM Pais p JOIN p.moneda m WHERE p.nombre=?1") // El objeto PAIS tiene una instancia de MONEDA. JPQPL
    Moneda buscarPorPais(String nombre);
}
