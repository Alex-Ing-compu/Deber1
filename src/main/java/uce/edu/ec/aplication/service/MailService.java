package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Mail;
import uce.edu.ec.domain.repository.MedirTiempo;
import uce.edu.ec.infrastructure.repository.MailRepositoryImpl;

@ApplicationScoped
@Transactional
public class MailService {

    @Inject
    private MailRepositoryImpl mr;

    @MedirTiempo
    public void enviarMail(Mail mail){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo MailService" + nombreHilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.mr.persist(mail);

    }

    public Mail buscarPorRemitente(String remitente){
        // return this.mailRepositoryImpl.findById(id);
        return Mail.find("remitente", remitente).firstResult();
    }


}
