package uce.edu.ec.infrastructure.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Estudiante;
import uce.edu.ec.domain.repository.EstudianteRepository;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {
    @Inject
    private EntityManager em;

    @Override
    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante);
    }

    @Override
    public Estudiante buscarPorId(Integer id) {
        return this.em.find(Estudiante.class, id);
    }

    @Override
    public void actulizar(Estudiante estudiante) {
        this.em.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.buscarPorId(id));
    }

}
