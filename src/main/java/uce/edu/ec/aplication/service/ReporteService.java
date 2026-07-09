package uce.edu.ec.aplication.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.domain.repository.Auditar;


@ApplicationScoped
@Transactional
public class ReporteService {

    @Auditar
    public void guardarReporte(Reporte reporte) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo REPORTESERVICE:" + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        try{
            Thread.sleep(3000);
        } catch(Exception e){

        }
        
        reporte.persist();

    }

    @Auditar
    public void guardarListaReporte(List<Reporte> lista){
        for(Reporte p: lista){
            this.guardarReporte(p);
        }
    }

    public Reporte buscarReporteporId(Integer id) {

        return Reporte.findById(id);

    }

}
