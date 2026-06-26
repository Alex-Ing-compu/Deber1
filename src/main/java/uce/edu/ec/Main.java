package uce.edu.ec;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.aplication.service.FacturaService;
import uce.edu.ec.aplication.service.MailService;
import uce.edu.ec.aplication.service.ReporteService;
import uce.edu.ec.domain.model.Factura;
import uce.edu.ec.domain.model.Mail;
import uce.edu.ec.domain.model.Reporte;

@QuarkusMain
public class Main {
 
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }
 
    public static class App implements QuarkusApplication {
 
        @Inject
        private FacturaService fs;

        @Inject
        private MailService ms;

        @Inject
        private ReporteService rs;
 
        @Override
        public int run(String... args) throws Exception {
 
            System.out.println("Conexión a la base de datos POSTGRES!");

            Factura f1 = new Factura();
            f1.setFecha(LocalDate.of(2016, 10, 1));
            f1.setNumero("0001-0004");
            f1.setRuc("1727555789");
 
           // fs.guardar(f1);

 
            //Factura f = fs.buscarPorId(1);
            //System.out.println(f);

            //Tarea
            //MAIL
            System.out.println("Enviando correo...");
            Mail m1 = new Mail();
            m1.setRemitente("ale@uce.edu.ec");
            m1.setDestinatario("jane@uce.edu.ec");
            m1.setAsunto("Hola como estas, buen dia");
            m1.setFechaEnvio(LocalDate.of(2023, 10, 5));

            //this.ms.enviarMail(m1);

            Mail m = this.ms.buscarPorRemitente("ale@uce.edu.ec");
            System.out.println(m);

            //REPORTE
            System.out.println("Generando reporte...");
            Reporte r1 = new Reporte();
            r1.setTitulo("Informe de ventas");
            r1.setAutor("ale@uce.edu.ec");
            r1.setTipo("Ventas");
            r1.setFechaGeneracion(LocalDate.now());

            //this.rs.guardar(r1);

            Reporte r = this.rs.buscarPorAutor("ale@uce.edu.ec");
            System.out.println(r);

 
            return 0;
        }
    }
}