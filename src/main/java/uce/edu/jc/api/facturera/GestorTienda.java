package uce.edu.jc.api.facturera;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GestorTienda {

    @Inject
        private ServicioTienda servicioTienda;

        @Inject
        private GeneradorFactura generadorFactura;

        @Inject
        private ContadorVentas contadorVentas;

        public void realizarCompra(String producto, int cantidad) {
            
            System.out.println("********Nueva compra********");

            System.out.println(servicioTienda.procesarCompra(producto, cantidad));
            System.out.println(generadorFactura.getFactura());
            System.out.println("Total ventas: " + contadorVentas.incrementar());
        

    }
}

