package com.apimonedas.apimonedas.dominio;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // Anotación de serialización, sirve para ahorrar la escritura manual del
      // Constructor, los Get y Set
@Entity // Se indica que es una entidad referente a la base de datos
@Table(name = "moneda") // Se indica la tabla a la que va a hacer relación
public class Moneda {
    // Atributos, deben ser las mismas columnas de la BD
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_moneda")
    @GenericGenerator(name = "secuencia_moneda", strategy = "increment")
    private long id;
    @Column(name = "moneda", length = 100, unique = true)
    private String nombre; // Se referencia al campo "moneda" en la BD
    @Column(name = "sigla", length = 5, unique = true)
    private String sigla;
    @Column(name = "simbolo", length = 5)
    private String simbolo;
    @Column(name = "emisor", length = 100)
    private String emisor;
}
