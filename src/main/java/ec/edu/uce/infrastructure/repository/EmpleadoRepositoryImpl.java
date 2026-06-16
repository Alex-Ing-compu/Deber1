package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.damain.model.Empleado;
import ec.edu.uce.damain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EmpleadoRepositoryImpl implements EmpleadoRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Empleado empleado) {
        this.em.persist(empleado);
    }

}
