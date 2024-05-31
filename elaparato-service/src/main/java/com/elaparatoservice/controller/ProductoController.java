package com.elaparatoservice.controller;
import com.elaparatoservice.model.Producto;
import com.elaparatoservice.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elaparato/productos")
public class ProductoController {

    @Autowired
    private IProductoService prodServ;

    //crear un nuevo producto
    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_Repositor') or hasRole('ROLE_Administrador')")
    public String createProducto(@RequestBody Producto prod) {
        prodServ.saveProducto(prod);
        return "Producto creado correctamente";
    }

    //obtener todos los productos
    @GetMapping("/getall")
    @PreAuthorize("hasRole('ROLE_Repositor') or hasRole('ROLE_Administrador')")
    public List<Producto> getProductos () {
        return prodServ.getProductos();
    }

   //Modificar los datos de un producto
    @PutMapping("/edit")
    @PreAuthorize("hasRole('ROLE_Repositor') or hasRole('ROLE_Administrador')")
    public String editProducto(@RequestBody Producto prod) {
        prodServ.editProducto(prod);
        return "Producto editado correctamente";
    }
}
