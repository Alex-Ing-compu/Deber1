package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Oficina;
import ec.edu.uce.damain.repository.OficinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OficinaService {

    @Inject
    private OficinaRepository oficinaRepository;

    public void crear(Oficina oficina){
        this.oficinaRepository.crear(oficina);
    }


}
