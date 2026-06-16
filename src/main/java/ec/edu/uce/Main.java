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

            // ciudadano
            System.out.println("Crear Ciudadano");

            // Creacion de un nuevo Estudiante
            Ciudadano ciudadano = new Ciudadano();
            ciudadano.setNombre("Jhon");
            LocalDate date = LocalDate.of(2000, 5, 10);
            LocalTime time = LocalTime.of(8, 30);
            ciudadano.setFechaNacimiento(LocalDateTime.of(date, time));
            // ciudadanoService.guardar(ciudadano);


            System.out.println("Creando empleado");
            Empleado empleado = new Empleado();
            empleado.setSalario(1500.00);
            empleado.setFechaIngreso(LocalDateTime.now());
            //empleado.setCuidadano(ciudadano);
            //this.empleadoService.guardar(empleado);




            //CIUDADANO 2 ---------------
            System.out.println("-------------CIUDADANO 2 ---------------");

            Ciudadano ciudadano2 = new Ciudadano();
            ciudadano2.setNombre("Nuevooo");
            LocalDate date2 = LocalDate.of(2005, 6, 5);
            LocalTime time2 = LocalTime.of(7, 30);
            ciudadano2.setFechaNacimiento(LocalDateTime.of(date2, time2));
            this.ciudadanoService.guardar(ciudadano2);
            
           // System.out.println(ciudadano2.getId());
            System.out.println("Creando empleado2");

            Empleado empleado2 = new Empleado();
            empleado2.setSalario(null);
            empleado2.setFechaIngreso(LocalDateTime.now());
            this.empleadoService.guardar(empleado2);


            return 0;
        }

    }
}