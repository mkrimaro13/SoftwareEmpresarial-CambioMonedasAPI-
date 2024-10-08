package com.apimonedas.apimonedas.dominio;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data // Anotación de serialización, sirve para ahorrar la escritura manual del
      // Constructor, los Get y Set
@Entity // Se indica que es una entidad referente a la base de datos
@Table(name = "pais") // Se indica la tabla a la que va a hacer relación
public class Pais {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_pais")
    @GenericGenerator(name = "secuencia_pais", strategy = "increment")
    private long id;
    @Column(name = "pais", length = 100, unique = true)
    private String nombre;
    @Column(name = "codigoAlfa2")
    private String codigoAlfa2;
    @Column(name = "codigoAlfa3")
    private String codigoAlfa3;

    // Este es el campo que hace la intersección de las
    // tablas, en el primer parámetro se indica el nombre
    // del campo en la tabla pais y en el segundo parámetro
    // se indica a que campo de la tabla moneda se hace
    // referencia
    @ManyToOne // Cardinalidad
    @JoinColumn(name = "idmoneda", referencedColumnName = "id")
    private Moneda moneda;

}