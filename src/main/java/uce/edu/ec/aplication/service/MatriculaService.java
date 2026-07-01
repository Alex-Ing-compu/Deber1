package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.HistorialAcademico;
import uce.edu.ec.domain.model.Matricula;
import uce.edu.ec.domain.model.Notificacion;
import uce.edu.ec.domain.model.Pago;
import uce.edu.ec.domain.repository.MedirTiempo;
import uce.edu.ec.infrastructure.repository.MatriculaRepositoryImpl;

@ApplicationScoped
@Transactional
public class MatriculaService {

    @Inject
    private MatriculaRepositoryImpl matriculaRepository;

    @Inject
    private PagoService pagoService;

    @Inject
    private AcademicoService academicoService;

    @Inject
    private NotificacionService notificacionService;

    @MedirTiempo
    public void matricularEstudiante(Matricula matricula) {
        
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo MATRICULASERVICE (Principal): " + nombreHilo);
        System.out.println("ID Hilo Principal: " + Thread.currentThread().threadId());

        this.matriculaRepository.persist(matricula);

        // --- LLAMADA A LOS 4 MÉTODOS INTERNOS ---

        //Pago de la matrícula
        Pago pago = new Pago();
        pago.setMonto(45.50);
        pago.setEstado("APROBADO");
        this.pagoService.procesarPago(pago);

        //historial del alumno
        HistorialAcademico hist = new HistorialAcademico();
        hist.setDescripcion("Estudiante matriculado en el periodo actual");
        this.academicoService.actualizarHistorial(hist);

        //notificación en BD
        Notificacion notif = new Notificacion();
        notif.setMensaje("Su matrícula ha sido procesada con éxito.");
        this.notificacionService.registrarNotificacionEnBase(notif);

        // Simular envío de comprobante por Email
        this.notificacionService.enviarComprobanteEmail(matricula.getCedulaEstudiante());
    }

    public Matricula buscarPorId(Integer id) {
        return Matricula.findById(id);
    }
}
