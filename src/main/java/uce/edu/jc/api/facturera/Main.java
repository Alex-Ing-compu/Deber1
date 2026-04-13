package uce.edu.jc.api.facturera;

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
        private FacturaService facturaService;

        @Override
        public int run(String... args) {

            Factura factura = new Factura(
                    "Ana Pérez",
                    "Laptop",
                    1200.00,
                    "0999999999");

            facturaService.registrar(factura);

            return 0;
        }
    }

}
