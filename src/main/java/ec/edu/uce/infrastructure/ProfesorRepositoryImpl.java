package ec.edu.uce.infrastructure;

import ec.edu.uce.damain.model.Profesor;
import ec.edu.uce.damain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    /* one to many
    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
    }
    */

    //many to many
    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
    }

    @Override
    public Profesor consultarProfesorPorId(Integer id) {
        return this.em.find(Profesor.class, id);
    }

    

}
