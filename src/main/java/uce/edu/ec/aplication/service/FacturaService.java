package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Factura;
import uce.edu.ec.infrastructure.repository.FacturaRepositoryImpl;

@ApplicationScoped
@Transactional
public class FacturaService {
 
    @Inject
    private FacturaRepositoryImpl fr;
    public void guardar(Factura factura){
 
        this.fr.persist(factura);
    }
 
    public Factura buscarPorId(Integer id){
 
        return Factura.findById(id);
    }

 
}
 