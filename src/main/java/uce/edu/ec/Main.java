package uce.edu.ec;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.aplication.service.FacturaService;
import uce.edu.ec.aplication.service.MatriculaService;
import uce.edu.ec.domain.model.Matricula;

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
 
        @Override
        public int run(String... args) throws Exception {
            
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("Nombre del hilo MAIN:" + nombreHilo);
            System.out.println("ID: " + Thread.currentThread().threadId());

            //Matricula
            Matricula m1 = new Matricula();
            m1.setFecha(LocalDate.now());
            m1.setCodigo("MAT-2026-001");
            m1.setCedulaEstudiante("1009586079"); 

            ms.matricularEstudiante(m1);

            // Matricula m = ms.buscarPorId(1);
            // System.out.println(m);


             /* 
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("Nombre del hilo MAIN:" + nombreHilo);
            System.out.println("ID: "+ Thread.currentThread().threadId());

            Factura f1 = new Factura();
            f1.setFecha(LocalDate.now());
            f1.setNumero("0001-9999");
            f1.setRuc("1727556");

            fs.guardar(f1);
            
            //Factura f = fs.buscarPorId(3);
            //System.out.println(f);

            */
 
            return 0;
        }
    }
}