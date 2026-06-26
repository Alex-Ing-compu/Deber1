package uce.edu.ec.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Reporte;

@ApplicationScoped
@Transactional
public class ReporteRepositoryImpl implements PanacheRepositoryBase<Reporte, Integer> {
    
    public Reporte buscarPorId(Integer id){
        return Reporte.findById(id);
    }

}
