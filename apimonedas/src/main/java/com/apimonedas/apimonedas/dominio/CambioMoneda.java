package com.apimonedas.apimonedas.dominio;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "cambiomoneda") // Se indica la tabla a la que va a hacer relación
public class CambioMoneda {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CambioMoneda_secuencia")
    @GenericGenerator(name = "CambioMoneda_secuencia", strategy = "increment")
    private long id;

    @ManyToOne // Cardinalidad
    @JoinColumn(name = "idmoneda", referencedColumnName = "id")
    private Moneda moneda;

    @Column(name = "valor")
    private double valor;

    @Column(name="fecha")
    private Date fecha;
}
