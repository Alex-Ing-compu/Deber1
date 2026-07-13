package uce.edu.ec;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.aplication.service.ProductoService;
import uce.edu.ec.aplication.service.ReporteService;
import uce.edu.ec.domain.model.Producto;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private ReporteService rs;

        @Inject
        private ProductoService productoService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conectado a la BASE DE DATOS");

            List<Producto> listap = new ArrayList<>();
            for (int i = 0; i < 500000; i++) {
                Producto p1 = new Producto();
                p1.setCodigo("PROD-" + i);
                p1.setNombre("Producto de prueba " + i);
                p1.setPrecio(10.50 + i);
                p1.setStock(100);
                p1.setFechaIngreso(java.time.LocalDate.now());
                listap.add(p1);
            }

            //sin paralelo
            this.productoService.guardarListaProducto(listap); //2374781ms = 39.5 min

            //con paralelo
            this.productoService.guardarListaProductoParalela(listap); //867902ms 14.4 min



            /* 
            // sin paralelo
            this.rs.guardarListadeReporte(lista);// 11280ms //10061ms

            // con paralelo
            // this.rs.guardarListadeReporteParalela(lista);//2554ms //4342
            */

            
            return 0;
        }
    }
}