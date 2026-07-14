package uce.edu.ec.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import uce.edu.ec.aplication.service.ReporteService;
import uce.edu.ec.domain.model.Reporte;

@Path("/reportes")
public class ReporteResource {
    
    @Inject
    private ReporteService rs;

    public Reporte buscarPorId(Integer id){
        return this.rs.buscarPorId(id);
    }
}
