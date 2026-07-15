package uce.edu.ec.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import uce.edu.ec.aplication.service.LibroService;
import uce.edu.ec.domain.model.Libro;

@Path("/libros")
public class LibroResource {

    @Inject
    private LibroService ls;

    public Libro buscarPorId(Integer id){
        return this.ls.buscarPorId(id);
    }

}
