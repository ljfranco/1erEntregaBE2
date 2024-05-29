package com.elaparatoservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter @Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="venta_seq")
    @SequenceGenerator(name="venta_seq", sequenceName="venta_seq", allocationSize=1)
    @EqualsAndHashCode.Include()
    private int id_venta;
    private Date fecha;
    @ManyToMany (mappedBy = "listaVentas")
    private Set<Producto> listaProductos = new HashSet<>();


}
