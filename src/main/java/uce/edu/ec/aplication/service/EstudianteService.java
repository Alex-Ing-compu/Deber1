package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Estudiante;
import uce.edu.ec.domain.repository.Archivo;
import uce.edu.ec.domain.repository.Auditar;
import uce.edu.ec.domain.repository.EstudianteRepository;


@ApplicationScoped
public class EstudianteService {
    @Inject
    private EstudianteRepository er;

    @Auditar
    @Archivo
    public void guardar(Estudiante estudiante){
        this.er.crear(estudiante);
    }

    @Auditar
    public Estudiante buscarPorId(Integer id){
        return this.er.buscarPorId(id);
    }

    @Auditar
    public void actualizar(Estudiante estudiante){
        this.er.actulizar(estudiante);
    }

    @Auditar
    public void eliminar(Integer id){
        this.er.eliminar(id);
    }
}
