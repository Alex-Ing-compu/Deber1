package uce.edu.ec.aplication.service;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Factura;
import uce.edu.ec.domain.model.Mail;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.domain.repository.MedirTiempo;
import uce.edu.ec.infrastructure.repository.FacturaRepositoryImpl;

@ApplicationScoped
@Transactional
public class FacturaServiceParalelo {

    @Inject
    private FacturaRepositoryImpl fr;

    @Inject
    private ReporteService rs;

    @Inject
    private MailService ms;


    @MedirTiempo
    public void guardar(Factura factura) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo FACTURASERVICEPARALELA:" + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.fr.persist(factura);

        //de aqui mando a ejecutar lo que yo quiero hacer y en paralelo

        ExecutorService excecuteService = Executors.newFixedThreadPool(2);

        Reporte r = new Reporte();
        r.setTitulo("Reporte sobre la Factura");
        r.setFormato("PDF");
        r.setDescripcion("El siguiente reporte se da sobre las ventas obtenidas");
        r.setFecha(LocalDate.now());
        ReporteServiceTarea reporteTarea = new ReporteServiceTarea(r,rs);
        excecuteService.submit(reporteTarea);
        //this.rs.guardarReporte(r);



        Mail m = new Mail();
        m.setAsunto("Factura");
        m.setDestinatario("jacordovat@uce.edu.es");
        m.setFechaenvio(LocalDate.now());
        
        MailServiceTarea mailTarea = new MailServiceTarea(m, ms);
        excecuteService.submit(mailTarea);
        //this.ms.guardarMail(m);

        //cerrar el proceso de ejecucion, indicando que no voy a enviar mas tareas.
        //debo crear una clase para cada tarea independiente 
        excecuteService.shutdown();

        try {
            Thread.sleep(30000);
        } catch (Exception e) {
        }
        
        

    }

}
