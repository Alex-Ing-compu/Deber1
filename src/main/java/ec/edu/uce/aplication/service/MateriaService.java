package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Materia;
import ec.edu.uce.damain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MateriaService {

    @Inject
    private MateriaRepository materiaRepository ;

    @Transactional
    public void crear(Materia materia){
        this.materiaRepository.crear(materia);
    }

    @Transactional
    public Materia consultarPorID(Integer id) {
        return this.materiaRepository.consultarPorID(id);
    }

}
