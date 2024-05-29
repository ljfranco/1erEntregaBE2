package com.elaparatoservice.controller;

import com.elaparatoservice.model.Venta;
import com.elaparatoservice.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {


    @Autowired
    private IVentaService ventServ;

    //crear una nueva venta
    @PostMapping("/ventas/create")
    @PreAuthorize("hasRole('ROLE_Vendedor') or hasRole('ROLE_Administrador')")
    public String createVentao(@RequestBody Venta vent) {
        ventServ.saveVenta(vent);
        return "Venta creada correctamente";
    }

    //obtener todas las ventas
    @GetMapping("/ventas/getall")
    @PreAuthorize("hasRole('ROLE_Vendedor') or hasRole('ROLE_Administrador')")
    public List<Venta> getVentas () {
        return ventServ.getVentas();
    }

    //Modificar los datos de una venta
    @PutMapping("/ventas/edit")
    @PreAuthorize("hasRole('ROLE_Vendedor') or hasRole('ROLE_Administrador')")
    public String editVenta(@RequestBody Venta vent) {
        ventServ.editVenta(vent);
        return "Venta editada correctamente";
    }


}
