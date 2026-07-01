package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Mail;
import uce.edu.ec.domain.repository.MedirTiempo;

@ApplicationScoped
@Transactional
public class MailService {

    @MedirTiempo
    public void guardarMail(Mail mail) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo MAILSERVICE:" + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        mail.persist();

    }

    public Mail buscarMailPorId(Integer id) {

        return Mail.findById(id);

    }


}
