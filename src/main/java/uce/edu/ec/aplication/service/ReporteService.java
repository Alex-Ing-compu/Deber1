package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl rr;

    public void guardar(Reporte reporte){
        rr.persist(reporte);
    }

    public Reporte buscarPorAutor(String autor){
        return Reporte.find("autor", autor).firstResult();
    }
    
    public Reporte buscarPorId(Integer id){
        return Reporte.findById(id);
    }

}
