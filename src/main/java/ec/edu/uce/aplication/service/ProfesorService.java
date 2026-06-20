package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Profesor;
import ec.edu.uce.damain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProfesorService {

    @Inject
    private ProfesorRepository profesorRepository;

    /*
    //one to many
    @Transactional
    public void guardar(Profesor profesor) {
        this.profesorRepository.crear(profesor);
    }
    */    

    //many to many
    @Transactional
    public void guardar(Profesor profesor) {
        this.profesorRepository.crear(profesor);
    }

    public Profesor consultarProfesorPorId(Integer id){
        return this.profesorRepository.consultarProfesorPorId(id);
    }

   

}
