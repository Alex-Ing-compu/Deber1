package uce.edu.jc.api.facturera;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FacturaService {

    @Inject
    private NotificadorSMS notificadorSMS;

    public void registrar(Factura factura){

        System.out.println("Registrando factura...");
        System.out.println("Cliente: " + factura.getCliente());
        System.out.println("Producto: " + factura.getProducto());
        System.out.println("Total: " + factura.getTotal());

        System.out.println("Guardando en base de datos...");

        // Uso de DI
        notificadorSMS.enviar(factura.getTelefono(), "Factura generada correctamente");

    }
}
