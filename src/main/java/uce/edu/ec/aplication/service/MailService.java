package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Mail;
import uce.edu.ec.infrastructure.repository.MailRepositoryImpl;

@ApplicationScoped
@Transactional
public class MailService {

    @Inject
    private MailRepositoryImpl mr;

    public void enviarMail(Mail mail){
        mr.persist(mail);
    }

    public Mail buscarPorRemitente(String remitente){
        return Mail.find("remitente", remitente).firstResult();
    }


}
