package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Reporte;

@Dependent
public class ReporteServiceTarea implements Runnable {

    private Reporte reporte;

    public void setReporte(Reporte reporte){
        
         this.reporte = reporte;
    }
    
    @Inject
    private ReporteService rs;

    @Override
    public void run() {
        System.out.println(this.rs);
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo ReportesServiceTarea:" + nombreHilo);
        this.rs.guardarReporte(reporte);
    }
    

}
