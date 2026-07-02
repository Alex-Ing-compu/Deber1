package uce.edu.ec.aplication.service;

import uce.edu.ec.domain.model.Reporte;

public class ReporteServiceTarea implements Runnable {

    private Reporte reporte;

    //@Inject
    private ReporteService rs;

    public ReporteServiceTarea(Reporte reporte, ReporteService reporteService) {
        this.reporte = reporte;
        this.rs = reporteService;
    }

    @Override
    public void run() {
        System.out.println(this.rs);
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo ReportesServiceTarea:" + nombreHilo);
        this.rs.guardarReporte(reporte);
    }
    

}
