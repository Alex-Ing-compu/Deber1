package uce.edu.jc.api.ControVentas;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        ServicioTienda servicio;

        @Inject
        GeneradorFactura factura1;

        @Inject
        GeneradorFactura factura2;

        @Inject
        ContadorVentas contador;

        @Inject
        GestorTienda gestor;

        @Override
        public int run(String... args) {

            System.out.println("=== APPLICATION ===");
            System.out.println(servicio.procesarCompra("LAPTOP", 1));
            System.out.println(servicio.procesarCompra("Mouse", 1));
            

            System.out.println("\n=== DEPENDENT ===");
            System.out.println(factura1.getFactura());
            System.out.println(factura2.getFactura());

            System.out.println("\n=== SINGLETON ===");
            System.out.println(contador.incrementar());
            System.out.println(contador.incrementar());

            System.out.println("\nVENTAS TOTALES : -->" + contador.getTotal());


            System.out.println("\nDESDE OTRA CLASE GESTOR DE TIENDA");
            gestor.realizarCompra("Teclado", 1);
            gestor.realizarCompra("Teclado", 1);    

            

            return 0;

        }
    }

}
