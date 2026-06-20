package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Proyecto;
import ec.edu.uce.damain.repository.ProyectoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProyectoService {

    @Inject
    private ProyectoRepository proyectoRepository;

     @Transactional
    public void guardar(Proyecto proyecto) {
        this.proyectoRepository.crear(proyecto);
    }

    public Proyecto consultarProyectoPorId(Integer id){
        return this.proyectoRepository.consultarProyectoPorID(id);
    }
    
}
