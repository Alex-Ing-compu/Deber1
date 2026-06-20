package ec.edu.uce;

import ec.edu.uce.aplication.service.AlumnoService;
import ec.edu.uce.aplication.service.MateriaService;
import ec.edu.uce.damain.model.Alumno;
import ec.edu.uce.damain.model.Materia;
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
        private AlumnoService alumnoService;

        @Inject
        private MateriaService materiaService;
        

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");

            /*
            Alumno a1 = new Alumno();
            a1.setNombre("Jhon");

            Materia m1 = new Materia();
            m1.setNombre("P.Avanzada");
            m1.setNumeroCreditos(4);
            
            Materia m2 = new Materia();
            m2.setNombre("P.Web");
            m2.setNumeroCreditos(6);

            List<Materia> listaMaterias = new ArrayList<>();
            listaMaterias.add(m1);
            listaMaterias.add(m2);

            a1.setMaterias(listaMaterias);
            this.alumnoService.crear(a1);
            */

            /*
            Materia m3 = new Materia();
            m3.setNombre("P.Distribuida");
            m3.setNumeroCreditos(6);


            Alumno a2 = new Alumno();
            a2.setNombre("Alex");
            a2.setMaterias(List.of(m3));

            Alumno a3 = new Alumno();
            a3.setNombre("Paul");
            a3.setMaterias(List.of(m3));    

            List<Alumno> alumnos = new ArrayList<>();
            alumnos.add(a2);
            alumnos.add(a3);

            m3.setAlumnos(alumnos);

            this.materiaService.crear(m3);
            */

            //crear una consulta una materia por su id

           System.out.println("Materias");
            Materia m = materiaService.consultarPorID(4);
            System.out.println(m);
 
            // Imprimir los alumnos de esa materia
 
            System.out.println("Alumnos de esa materia");
 
            for (Alumno p : m.getAlumnos()) {
                System.out.println(p);
            }
 
            //alumno por id query, imprimir todas la materias del alumno
            System.out.println("Alumno");
            Alumno a = alumnoService.consultarPorID(4);
            System.out.println(a);
 
            System.out.println("Materias del Alumno");
            for(Materia m1: a.getMaterias()){
                System.out.println(m1);
 
            }


            //impirmir los alumnos que estan en esa materia 

            return 0;
        }

    }
}