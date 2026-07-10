package uce.edu.ec;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.aplication.service.AuditoriaService;
import uce.edu.ec.aplication.service.EstudianteService;
import uce.edu.ec.aplication.service.FacturaService;
import uce.edu.ec.aplication.service.FacturaServiceCompletadoFuture;
import uce.edu.ec.aplication.service.FacturaServiceParalelo;
import uce.edu.ec.aplication.service.MatriculaService;
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
        private FacturaService fs;

        @Inject
        private MatriculaService ms;

        @Inject
        private FacturaServiceParalelo fsp;
        
        @Inject
        private FacturaServiceCompletadoFuture fsc;

        @Inject
        private EstudianteService es;

        @Inject
        private AuditoriaService as;

        @Inject
        private ReporteService rs;

        @Inject
        private ProductoService productoService;

        @Override
        public int run(String... args) throws Exception {
        
        System.out.println("Conectado a la BASE DE DATOS");
       
        //Deber : PARALLEL STREAM
        List<Producto> listaQuinientos = new ArrayList<>();

            for (int i = 1; i <= 500; i++) {
                Producto prod = new Producto();
                prod.setCodigo("PROD-" + String.format("%04d", i)); 
                prod.setNombre("Artículo Tecnológico " + i);
                prod.setPrecio(10.0 + (i * 0.5)); 
                prod.setStock(10 + i);
                prod.setFechaIngreso(LocalDate.now());

                listaQuinientos.add(prod); 
            }

            System.out.println("Lista de " + listaQuinientos.size() + " productos lista para enviar");
            this.productoService.guardarListaProducto(listaQuinientos);       

            System.out.println("Proceso finalizado");

            return 0;
        }
    }
}