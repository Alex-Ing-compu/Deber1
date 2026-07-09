package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Notificacion;
import uce.edu.ec.domain.repository.Auditar;


@ApplicationScoped
@Transactional
public class NotificacionService {

    @Auditar
    public void registrarNotificacionEnBase(Notificacion notificacion) {
        System.out.println("Nombre del hilo NOTIFICACIONSERVICE (Persistencia): " + Thread.currentThread().getName());
        System.out.println("ID Hilo: " + Thread.currentThread().threadId());
        notificacion.persist();

    }

    @Auditar
    public void enviarComprobanteEmail(String cedula) {
        System.out.println("Nombre del hilo NOTIFICACIONSERVICE (Envío Email): " + Thread.currentThread().getName());
        System.out.println("ID Hilo: " + Thread.currentThread().threadId());
        
        System.out.println("Email enviado al estudiante con cédula: " + cedula);
    }
}
