package uce.edu.ec;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.aplication.service.FacturaService;
import uce.edu.ec.domain.model.Factura;

@QuarkusMain
public class Main {
 
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }
 
    public static class App implements QuarkusApplication {
 
        @Inject
        private FacturaService fs;
 
        @Override
        public int run(String... args) throws Exception {
 
            System.out.println("Conexión a la base de datos POSTGRES!");

            Factura f1 = new Factura();
            f1.setFecha(LocalDate.of(2016, 10, 1));
            f1.setNumero("0001-0004");
            f1.setRuc("1727555789");
 
           // fs.guardar(f1);

 
            Factura f = fs.buscarPorId(1);
            System.out.println(f);
 
            return 0;
        }
    }
}