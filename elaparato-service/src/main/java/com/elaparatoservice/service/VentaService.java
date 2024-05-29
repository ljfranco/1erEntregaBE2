package com.elaparatoservice.service;

import com.elaparatoservice.model.Producto;
import com.elaparatoservice.model.Venta;
import com.elaparatoservice.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoService prodServ;


    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        Venta savedVenta =  ventaRepo.save(venta);
        Set<Producto> productos = new HashSet<>(venta.getListaProductos());
        productos.forEach(producto -> {
            Producto productUpdated = prodServ.findProducto(producto.getId());
            productUpdated.addVenta(savedVenta);
            prodServ.editProducto(productUpdated);
        });

    }

    @Override
    public void deleteVenta(int id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(int id) {
       return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Venta vent) {
        // Obtener la venta existente de la base de datos
        Venta existingVenta = ventaRepo.findById(vent.getId_venta()).orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));
        // Limpiar las Relaciones Existentes
        for (Producto prod : existingVenta.getListaProductos()) {
            Producto productUpdated = prodServ.findProducto(prod.getId());
            productUpdated.getListaVentas().remove(existingVenta);
            prodServ.editProducto(productUpdated);
        }
        //Añadir nuevos productos y actualizar la relacion
        for (Producto prod : vent.getListaProductos()) {
            Producto productUpdated = prodServ.findProducto(prod.getId());
            if (productUpdated.getListaVentas() == null) {
                productUpdated.setListaVentas(new HashSet<>());
            }
            productUpdated.getListaVentas().add(existingVenta);
            prodServ.editProducto(productUpdated);
        }
        //Actualizar la venta
        ventaRepo.save(vent);
    }

    }
