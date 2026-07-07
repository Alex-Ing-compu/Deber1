package uce.edu.ec;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.aplication.service.FacturaService;
import uce.edu.ec.aplication.service.FacturaServiceCompletadoFuture;
import uce.edu.ec.aplication.service.FacturaServiceParalelo;
import uce.edu.ec.aplication.service.MatriculaService;
import uce.edu.ec.domain.model.Factura;

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

        @Override
        public int run(String... args) throws Exception {
       
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("Nombre del hilo MAIN:" + nombreHilo);
            System.out.println("ID: "+ Thread.currentThread().threadId());

            Factura f1 = new Factura();
            f1.setFecha(LocalDate.now());
            f1.setNumero("0001-9999");
            f1.setRuc("1727556");

            fsc.guardar(f1);
            
            
 
            return 0;
        }
    }
}