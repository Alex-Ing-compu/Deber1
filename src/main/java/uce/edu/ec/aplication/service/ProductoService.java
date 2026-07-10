package uce.edu.ec.aplication.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Producto;
import uce.edu.ec.domain.repository.Auditar;

@ApplicationScoped
public class ProductoService {
    
    @Inject
    private ProductoService ps;

    @Auditar
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void guardarProducto(Producto producto) {

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo PRODUCTOSERVICE: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        try {
            Thread.sleep(3000); 
        } catch (Exception e) {
            System.err.println("Error en sleep: " + e.getMessage());
        }
        
        producto.persist();
    }

    @Transactional 
    public void guardarListaProducto(List<Producto> lista) {
        for (Producto p : lista) {
            this.ps.guardarProducto(p);
        }
    }

    public Producto buscarProductoporId(Integer id) {
        return Producto.findById(id);
    }
}