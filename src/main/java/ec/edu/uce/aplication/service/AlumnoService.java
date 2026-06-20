package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Alumno;
import ec.edu.uce.damain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AlumnoService {

    @Inject
    private AlumnoRepository alumnoRepository;


    public void crear(Alumno alumno){
        this.alumnoRepository.crear(alumno);
    }

    public Alumno consultarPorID(Integer id){
        return this.alumnoRepository.consultarAlumnoPorID(id);
    }
    
}
