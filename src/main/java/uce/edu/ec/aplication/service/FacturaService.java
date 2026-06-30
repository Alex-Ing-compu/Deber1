package uce.edu.ec.aplication.service;

import java.time.LocalDate;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Factura;
import uce.edu.ec.domain.model.Mail;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.infrastructure.repository.FacturaRepositoryImpl;

@ApplicationScoped
@Transactional
public class FacturaService {
 
    @Inject
    private FacturaRepositoryImpl fr;

    
    public void guardar(Factura factura){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo FacturaService" + nombreHilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.fr.persist(factura);
    }
 
    public Factura buscarPorId(Integer id){
        // return this.facturaRespositoryImpl.findById(id);
        return Factura.findById(id);
    }

    @Inject
    private MailService mailService;

    @Inject
    public ReporteService reporteService;


    public void guardarF(Factura factura){
        this.fr.persist(factura);

        Reporte repo = new Reporte();
        repo.setAutor("Andy");
        repo.setTitulo("Reporte");
        repo.setDescripcion("autos vendidos: 3");
        repo.setFechaGeneracion(LocalDate.now());       
        this.reporteService.guardar(repo);


        Mail mail = new Mail();
        mail.setRemitente("Andy");
        mail.setDestinatario("Paul");
        
        mail.setAsunto("se vendio tre autos");
        mail.setFechaEnvio(LocalDate.now());
        this.mailService.enviarMail(mail);
    }

 
}
 