package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.domain.repository.MedirTiempo;
import uce.edu.ec.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl rr;

    @MedirTiempo
    public void guardar(Reporte reporte){
       String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo ReporteService" + nombreHilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.rr.persist(reporte);
    }

    public Reporte buscarPorAutor(String autor){
        return Reporte.find("autor", autor).firstResult();
    }
    
    public Reporte buscarPorId(Integer id){
        //return this.reporteRepositoryImpl.findById(id);
        return Reporte.findById(id);
    }

}
