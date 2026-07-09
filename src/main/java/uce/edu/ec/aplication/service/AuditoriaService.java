package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Auditoria;
import uce.edu.ec.domain.repository.AuditoriaRepository;

@ApplicationScoped
public class AuditoriaService {
    @Inject
    private AuditoriaRepository ar;

    public void insertar(Auditoria auditoria){
        this.ar.insertar(auditoria);
    }
}
