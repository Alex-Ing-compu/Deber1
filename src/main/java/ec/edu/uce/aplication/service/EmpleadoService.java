package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Empleado;
import ec.edu.uce.damain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped

public class EmpleadoService {

    @Inject
    private EmpleadoRepository empleadoRepository;

    @Inject
    private CiudadanoService ciudadanoService;
    
    @Transactional
    public void guardar(Empleado empleado) {
        /* 
         Ciudadano ciudadano2 = new Ciudadano();
           ciudadano2.setNombre("PAULLL");
           LocalDate date2 = LocalDate.of(2004, 5, 10);
           LocalTime time2 = LocalTime.of(8, 30);
           ciudadano2.setFechaNacimiento(LocalDateTime.of(date2, time2));
           this.ciudadanoService.guardar(ciudadano2);

           ciudadano2.setNombre("Alexxxxxx");

           */
           this.empleadoRepository.crear(empleado);

           //Transaccion
           //Es un conjunto de intrucciones que se ejecuta de manera completa o no se ejecuta ninguna
           //de las intrucciones
           //todo lo que esta en la base de datos debe estar en el service
    }
}
