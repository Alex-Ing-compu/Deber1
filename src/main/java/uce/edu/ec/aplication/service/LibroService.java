package uce.edu.ec.aplication.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Libro;
import uce.edu.ec.infrastructure.repository.LibroRepositoryImpl;

@ApplicationScoped
@Transactional
public class LibroService {

    @Inject
    private LibroRepositoryImpl lri;

    // Buscar todos
    public List<Libro> buscarTodos() {
        return lri.listAll();
    }

    // Crear
    public void crear(Libro libro) {
        lri.persist(libro);
    }

    // Buscar por id
    public Libro buscarPorId(Integer id) {
        return lri.findById(id);
    }

    // Actualizar
    public void actualizar(Libro libroNuevo, Integer id) {

        Libro libroBase = buscarPorId(id);

        libroBase.setTitulo(libroNuevo.getTitulo());
        libroBase.setAutor(libroNuevo.getAutor());
        libroBase.setPrecio(libroNuevo.getPrecio());

        
    }

    // Eliminar
    public void eliminar(Integer id) {
        lri.delete(buscarPorId(id));
    }

}