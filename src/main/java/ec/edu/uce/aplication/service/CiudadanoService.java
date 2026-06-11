package ec.edu.uce.aplication.service;
import ec.edu.uce.damain.model.Ciudadano;
import ec.edu.uce.damain.repository.CiudadanoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CiudadanoService {

    @Inject
    private CiudadanoRepository ciudadanoRepository;

    public void guardar(Ciudadano ciudadano) {
        this.ciudadanoRepository.crear(ciudadano);

    }

}
