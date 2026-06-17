package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Oficina;
import ec.edu.uce.damain.repository.OficinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OficinaService {

    @Inject
    private OficinaRepository oficinaRepository;

    @Inject 
    private ProfesorService profesorService;

    @Transactional
    public void crear(Oficina oficina){
        
        this.oficinaRepository.crear(oficina);
    }

}
