package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.damain.model.Oficina;
import ec.edu.uce.damain.repository.OficinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class OficinaRepositoryImpl implements OficinaRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Oficina oficina) {
        this.em.persist(oficina);
    }

}
