package uce.edu.ec.web.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.aplication.service.LibroService;
import uce.edu.ec.domain.model.Libro;

@Path("/libros")
public class LibroResource {

    @Inject
    private LibroService ls;

    @Path("/porId/{id}")
    @GET
    public Libro buscarPorId(@PathParam("id") Integer id){
        return this.ls.buscarPorId(id);
    }

    @Path("/todos")
    @GET
    public List<Libro> buscarTodos(){
        return this.ls.buscarTodos();

    }

    @Path("/guardar")
    @POST
    public void guardarLibro(Libro libro){
        this.ls.crear(libro);
    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Libro libro,@PathParam("id") Integer id){
        this.ls.actualizar(libro,id);
    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam("id") Integer id){
        this.ls.eliminar(id);
    }
    
}
