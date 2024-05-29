package com.elaparatoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="producto_seq")
    @SequenceGenerator(name="producto_seq", sequenceName="producto_seq", allocationSize=1)
    @EqualsAndHashCode.Include()
    private int id;
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="producto_lista_ventas", joinColumns = @JoinColumn(name="lista_productos_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="lista_ventas_id_venta", referencedColumnName = "id_venta"))
    @JsonIgnore //importante agregar para evitar errores de formato en la response
    private Set<Venta> listaVentas = new HashSet<>();

    public Producto() {
    }

    public Producto(int id, String nombre, String descripcion, int precio, int cantidad, Set<Venta> listaVentas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.listaVentas = listaVentas;
    }

    public void addVenta(Venta venta){
        this.listaVentas.add(venta);
        venta.getListaProductos().add(this);
    }

    public void removeVenta(Venta venta){
        this.listaVentas.remove(venta);
        venta.getListaProductos().remove(this);
    }



}
