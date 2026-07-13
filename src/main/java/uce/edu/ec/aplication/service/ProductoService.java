package uce.edu.ec.aplication.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Producto;
import uce.edu.ec.domain.repository.Auditar;
import uce.edu.ec.infrastructure.repository.ProductoRepositoryImpl;

@ApplicationScoped
public class ProductoService {
    
    @Inject
    private ProductoRepositoryImpl psi;

    @Auditar
    @Transactional
    public void guardarProducto(Producto producto) throws InterruptedException{

        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo PRODUCTOSERVICE: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        producto.persist();
    }

    //Forma paralela 
    @Auditar
    public void guardarListaProductoParalela(List<Producto> lista) throws InterruptedException{
        lista.parallelStream().forEach(p-> {
            try {
                this.guardarProducto(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        );

    }

    //Forma secuencial 
    @Auditar 
    public void guardarListaProducto(List<Producto> listar) throws InterruptedException {
        for (Producto p : listar) {
            this.guardarProducto(p);
        }
    }

    public Producto buscarProductoporId(Integer id) {
        return Producto.findById(id);
    }
}