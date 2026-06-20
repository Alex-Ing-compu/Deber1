package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.damain.model.Proyecto;
import ec.edu.uce.damain.repository.ProyectoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProyectoRepositoryImpl implements ProyectoRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Proyecto proyecto) {
        this.em.persist(proyecto);
    }

    @Override
    public Proyecto consultarProyectoPorID(Integer id) {
        return this.em.find(Proyecto.class, id);
    }

   

}
