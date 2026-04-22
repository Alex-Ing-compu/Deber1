package uce.edu.jc.api.facturera;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicioTienda {

    public String procesarCompra(String producto, int cantidad) {
        
        return "Compra procesada: " + cantidad + " unidades de " + producto;
        
    }
}
