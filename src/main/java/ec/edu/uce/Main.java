package ec.edu.uce;

import ec.edu.uce.aplication.service.AlumnoService;
import ec.edu.uce.aplication.service.MateriaService;
import ec.edu.uce.aplication.service.ProfesorService;
import ec.edu.uce.aplication.service.ProyectoService;
import ec.edu.uce.damain.model.Profesor;
import ec.edu.uce.damain.model.Proyecto;
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
        private ProfesorService profesorService;

        @Inject
        private ProyectoService proyectoService;

        @Inject
        private AlumnoService alumnoService;

        @Inject
        private MateriaService materiaService;
        

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");
            /*
            Profesor p1 = new Profesor();
            p1.setNombre("Mateo");
            p1.setApellido("Andrade");
            p1.setCiudad("Quito");
            p1.setCorreo("mateo@uce.edu.ec");
            p1.setEspecialidad("Sistemas");
            p1.setEstado(true);
            p1.setPais("Ecuador");
            p1.setGenero("M");
            p1.setSalario(2000.0);

            Proyecto pr1 = new Proyecto();
            pr1.setNombre("AppFord");
            pr1.setDescripcion("Aplicacion movil para mirar las ventas de carros");
            pr1.setMonto(300.0);

            Proyecto pr2 = new Proyecto();
            pr2.setDescripcion("Aplicacion movil para mirar las ventas de carros");
            pr2.setDescripcion("Aplicacion movil para mirar las ventas de carros");
            pr2.setMonto(300.0);

            

            List<Proyecto> listaProyecto = new ArrayList<>();
            listaProyecto.add(pr1);
            listaProyecto.add(pr2);

            p1.setProyecto(listaProyecto);
            this.profesorService.guardar(p1);
            */
        
            /*
            Proyecto pr3 = new Proyecto();
            pr3.setNombre("MovieSork");
            pr3.setDescripcion("App de peliculas gratis");
            pr3.setMonto(800.0);

            Profesor p2 = new Profesor();
            p2.setNombre("Stalin");
            p2.setApellido("Andrade");
            p2.setCiudad("Quito");
            p2.setCorreo("stalin@uce.edu.ec");
            p2.setEspecialidad("Sistemas");
            p2.setEstado(true);
            p2.setPais("Ecuador");
            p2.setGenero("M");
            p2.setSalario(20440.0);

            p2.setProyecto(List.of(pr3));

            Profesor p3 = new Profesor();
            p3.setNombre("Kenn");
            p3.setApellido("Bailon");
            p3.setCiudad("Quito");
            p3.setCorreo("mateo@uce.edu.ec");
            p3.setEspecialidad("Sistemas");
            p3.setEstado(true);
            p3.setPais("Ecuador");
            p3.setGenero("M");
            p3.setSalario(120.0);

            p3.setProyecto(List.of(pr3));


            List<Profesor> profesores = new ArrayList<>();
            profesores.add(p2);
            profesores.add(p3);

            pr3.setProfesor(profesores);

            this.profesorService.guardar(p3);
            */

            System.out.println("Consultando el proyecto por ID:");
            Proyecto proyec = proyectoService.consultarProyectoPorId(3);
            System.out.println(proyec);


            System.out.println("Profesores de ese proyecto");

            for (Profesor p : proyec.getProfesor()) {
                System.out.println(p);
            }

            
            System.out.println("Consultando el Profesor por ID");
            Profesor profesor = profesorService.consultarProfesorPorId(3);
            System.out.println(profesor);

            System.out.println("Proyectos del Profesor");
            for(Proyecto e: profesor.getProyecto()){
                System.out.println(e);
            }

            return 0;
        }

    }
}