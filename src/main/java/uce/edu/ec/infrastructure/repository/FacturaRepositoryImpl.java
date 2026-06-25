package uce.edu.ec.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Factura;

@ApplicationScoped
@Transactional
public class FacturaRepositoryImpl implements PanacheRepositoryBase<Factura, Integer> {
    
    public Factura buscarPorNumero(String numero){
        return null;
    }
 
 
}