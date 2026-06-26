package uce.edu.ec.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Mail;

//ayudame creando el repositorio de la entidad mail panache
@ApplicationScoped
@Transactional
public class MailRepositoryImpl implements PanacheRepositoryBase<Mail, Integer> {
    
    public Mail buscarPorRemitente(String remitente){

        return find("remitente = ?1", remitente).firstResult();
    }

}
