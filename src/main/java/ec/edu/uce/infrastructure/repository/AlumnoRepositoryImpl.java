package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.damain.model.Alumno;
import ec.edu.uce.damain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AlumnoRepositoryImpl implements AlumnoRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Alumno alumno) {
        this.em.persist(alumno);
    }

    @Override
    public Alumno consultarAlumnoPorID(Integer nombre) {
        return this.em.find(Alumno.class, nombre);
    }

}
