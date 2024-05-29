package com.elaparatoservice.service;

import com.elaparatoservice.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();


    public void saveVenta(Venta vent);


    //acá en la implementación se puede hacer por ejemplo borrado lógico
    public void deleteVenta(int id);


    public Venta findVenta(int id);

    public void editVenta(Venta vent);

}
