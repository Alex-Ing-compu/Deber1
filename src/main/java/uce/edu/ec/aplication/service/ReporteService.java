package uce.edu.ec.aplication.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Reporte;
import uce.edu.ec.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl rri;

    public List<Reporte> buscarTodos(){
        return (List<Reporte>) this.rri.findAll();
    }


    public void crear(Reporte reporte){
        this.rri.persist(reporte);
    }

    public Reporte buscarPorId(Integer id){
        return this.rri.findById(id);
    }

    public void actualizar(Reporte reporteAc, Integer id){
        Reporte reporteBase = this.buscarPorId(id);
        reporteBase.setDescripcion(reporteAc.getDescripcion());
        reporteBase.setFecha(reporteAc.getFecha());
        reporteBase.setTitulo(reporteAc.getTitulo());
        reporteBase.setFormato(reporteAc.getFormato());

        //No hace falta realizar explicitamente un update

    }

     public void actualizar2(Reporte reporte){
        Reporte reporteBase = this.buscarPorId(reporte.getId());
        
    }


    public void eliminar(Integer id){
        this.rri.delete(this.buscarPorId(id));
    }
 
}