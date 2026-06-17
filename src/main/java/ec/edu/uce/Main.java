package ec.edu.uce;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import ec.edu.uce.aplication.service.CiudadanoService;
import ec.edu.uce.aplication.service.EmpleadoService;
import ec.edu.uce.aplication.service.EstudianteService;
import ec.edu.uce.aplication.service.OficinaService;
import ec.edu.uce.aplication.service.ProfesorService;
import ec.edu.uce.damain.model.Ciudadano;
import ec.edu.uce.damain.model.Empleado;
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
        private EmpleadoService empleadoService;

        @Inject
        private OficinaService oficinaService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");

            // Tarea 12
            System.out.println("TAREA 12");
            Profesor p = new Profesor();
            p.setNombre("Acely");
            p.setApellido("Perez");
            p.setEspecialidad("Arquitectura");
            p.setCorreo("acely@uce.edu.ec");
            p.setCiudad("Quito");
            p.setPais("Ecuador");
            p.setGenero("F");
            p.setEstado(true);
            p.setSalario(120.00);

            Oficina o = new Oficina();
            o.setNumero(111);
            o.setBloque("A2");

            o.setProfesor(p);

            this.oficinaService.crear(o);

            return 0;
        }

    }
}