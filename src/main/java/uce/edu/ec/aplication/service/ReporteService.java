package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.domain.repository.MedirTiempo;

@ApplicationScoped
@Transactional
public class ReporteService {

    @MedirTiempo
    public void guardarReporte(Reporte reporte) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo REPORTESERVICE:" + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        reporte.persist();

    }

    public Reporte buscarReporteporId(Integer id) {

        return Reporte.findById(id);

    }

}
