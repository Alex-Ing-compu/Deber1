package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.damain.model.Materia;
import ec.edu.uce.damain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Materia materia) {
        this.em.persist(materia);
    }

    @Override
    public Materia consultarPorID(Integer id) {
        return this.em.find(Materia.class, id);
        
    }

}
