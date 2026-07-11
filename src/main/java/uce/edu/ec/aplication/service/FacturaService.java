package uce.edu.ec.aplication.service;

import java.time.LocalDate;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Factura;
import uce.edu.ec.domain.model.Mail;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.domain.repository.Auditar;
import uce.edu.ec.infrastructure.repository.FacturaRepositoryImpl;

@ApplicationScoped
@Transactional
public class FacturaService {
 
    
    @Inject
    private FacturaRepositoryImpl fr;

    @Inject
    private ReporteService rs;
    @Inject
    private MailService ms;

    @Auditar
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

        Mail m = new Mail();
        m.setAsunto("Factura");
        m.setDestinatario("jacordovat@uce.edu.es");
        m.setFechaenvio(LocalDate.now());
        this.ms.guardarMail(m);

    }


    public Factura buscarPorId(Integer id) {

        return Factura.findById(id);
    }
 
}
 