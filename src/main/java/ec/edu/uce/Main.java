package ec.edu.uce;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import ec.edu.uce.aplication.service.CiudadanoService;
import ec.edu.uce.aplication.service.EstudianteService;
import ec.edu.uce.aplication.service.OficinaService;
import ec.edu.uce.aplication.service.ProfesorService;
import ec.edu.uce.damain.model.Ciudadano;
import ec.edu.uce.damain.model.Oficina;
import ec.edu.uce.damain.model.Profesor;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;


@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private EstudianteService estudianteService;

        @Inject
        private ProfesorService profesorService;

        @Inject
        private CiudadanoService ciudadanoService;

        @Inject
        private OficinaService oficinaService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");

            //ciudadano
            System.out.println("Crear Ciudadano");
 
             
            //Creacion de un nuevo Estudiante
            Ciudadano ciudadano = new Ciudadano();
            ciudadano.setNombre("Jhon");
            LocalDate date = LocalDate.of(2000, 5, 10);
            LocalTime time = LocalTime.of(8, 30);
            ciudadano.setFechaNacimiento(LocalDateTime.of(date, time));
           // ciudadanoService.guardar(ciudadano);


            //crear profesor

            Profesor profesor = new Profesor();
            profesor.setNombre("Cristian");
            profesor.setApellido("Velez");
            profesor.setEspecialidad("Matematica");
            profesor.setCorreo("cristian@uce.edu.ec");
            profesor.setCiudad("Quito");
            profesor.setPais("Ecuador");
            profesor.setGenero("M");
            profesor.setEstado(true);
            profesor.setSalario(1400.0);
    
            this.profesorService.guardar(profesor);


            //crear oficina
            System.out.println("Creando una Oficina");
            Oficina ofi = new Oficina();
            ofi.setNumero(202);
            ofi.setBloque("Bloque A2");
           
            ofi.setProfesor(profesor);

            this.oficinaService.crear(ofi);
            System.out.println(profesor);
            System.out.println(ofi);
           

            return 0;
        }
    

    }
}