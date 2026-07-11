package uce.edu.ec.aplication.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.domain.repository.Auditar;
import uce.edu.ec.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl rsi;
    
    @Auditar
    @Transactional
    public void guardarReporte(Reporte reporte) throws InterruptedException {
 
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo REPORTESERVICE:" + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        Thread.sleep(0);
 
        reporte.persist();
 
    }

    //otro
     @Auditar
    public void guardarListadeReporteParalela(List<Reporte> lista) throws InterruptedException{
       
       
        lista.parallelStream().forEach(rep ->{
            //Aqui programo toda la logica que quiero que se aplique a cada item de la lista
            try {
                this.guardarReporte(rep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
 
    }


    @Auditar
    public void guardarListadeReporte(List<Reporte> listar) throws InterruptedException{
       
        for(Reporte p : listar){
            this.guardarReporte(p);
 
        }
 
    }
 
    public Reporte buscarReporteporId(Integer id) {
 
        return Reporte.findById(id);
 
    }
 
}