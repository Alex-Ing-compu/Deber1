package uce.edu.ec.web.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.aplication.service.ReporteService;
import uce.edu.ec.domain.model.Reporte;

@Path("/reportes")
public class ReporteResource {
    
    @Inject
    private ReporteService rs;

    // http://localhost:8080/reportes/todos
    // http://localhost:8080/reportes/porId/1

    @Path("/porId/{id1}")
    @GET
    public Reporte buscarPorId(@PathParam("id1") Integer id){
        return this.rs.buscarPorId(id);
    }

    @Path("/todos")
    @GET
    public List<Reporte> buscarTodos(){
        return this.rs.buscarTodos();
    }

    @Path("/guardar")
    @POST
    public void guardar(Reporte reporte){
        this.rs.crear(reporte);
    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Reporte reporteNuevo, @PathParam("id") Integer id){
        this.rs.actualizar(reporteNuevo, id);
    }

    @Path("/eliminar/{id}")
    @POST
    public void eliminar(@PathParam("id")Integer id){
        this.rs.eliminar(id); 
    }

}
