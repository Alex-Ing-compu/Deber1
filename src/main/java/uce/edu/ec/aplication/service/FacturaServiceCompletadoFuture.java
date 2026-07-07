package uce.edu.ec.aplication.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

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
public class FacturaServiceCompletadoFuture {

    @Inject
    private FacturaRepositoryImpl fr;

    @Inject
    private MailService ms;

    @Inject
    private ReporteService rs;

    @MedirTiempo
    public void guardar(Factura factura) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo FACTURASERVICE:" + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.fr.persist(factura);

        Reporte r = new Reporte();
        r.setTitulo("Reporte sobre la Factura");
        r.setFormato("PDF");
        r.setDescripcion("El siguiente reporte se da sobre las ventas obtenidas");
        r.setFecha(LocalDate.now());
        //this.rs.guardarReporte(r);

        CompletableFuture<Void> completableReporte = CompletableFuture.runAsync(()->this.rs.guardarReporte(r));

        Mail m = new Mail();
        m.setAsunto("Factura");
        m.setDestinatario("jacordovat@uce.edu.es");
        m.setFechaenvio(LocalDate.now());
        //this.ms.guardarMail(m);

        CompletableFuture<Void> completableMail = CompletableFuture.runAsync(()->this.ms.guardarMail(m));

        CompletableFuture.allOf(completableReporte, completableMail).join();


    }


    public Factura buscarPorId(Integer id) {

        return Factura.findById(id);
    }
  
}
