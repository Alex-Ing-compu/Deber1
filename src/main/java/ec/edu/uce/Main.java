package ec.edu.uce;

import java.util.List;

import ec.edu.uce.aplication.service.EstudianteService;
import ec.edu.uce.aplication.service.ProfesorService;
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

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");

            /*
            System.out.println("CRITERIA QUERY");
            List<Estudiante> estudiante = estudianteService.seleccionarTodosCriteria();
            for (Estudiante p : estudiante) {
                System.out.println(p);
            }

            System.out.println("Criteria query : nombre");
            List<Estudiante> estu = estudianteService.seleccionarTodosCriteriaNombre("Alex");
            for (Estudiante elem : estu) {
                System.out.println(elem);   
            }

            //Dinamica con cieteria 4 formas---------
            System.out.println("1 .-Criteria query : nombre y  apellido" );
            List<Estudiante> estu1 = estudianteService.seleccionarDinamicoCriteria("Alex", "Cordova");
            for (Estudiante elem : estu1) {
                System.out.println(elem);   
            }

            System.out.println("2.-Criteria query : nombre y  apellido" );
            List<Estudiante> estu2 = estudianteService.seleccionarDinamicoCriteria("Alex", null);
            for (Estudiante elem : estu2) {
                System.out.println(elem);   
            }

            System.out.println("3.-Criteria query : nombre y  apellido" );
            List<Estudiante> estu3 = estudianteService.seleccionarDinamicoCriteria(null, "Cordova");
            for (Estudiante elem : estu3) {
                System.out.println(elem);   
            }

            System.out.println("4.-Criteria query : nombre y  apellido" );
            List<Estudiante> estu4 = estudianteService.seleccionarDinamicoCriteria(null, null);
            for (Estudiante elem : estu4) {
                System.out.println(elem);   
            }
            */     

            //CRITERIA QUERY
            System.out.println("Criteria: SELECCIONAR");
            List<Profesor> profe1 = profesorService.seleccionarTodosCriteriaProfesores();
            for (Profesor elem : profe1) {
                System.out.println(elem);
            }

            System.out.println("Selecionar por apellido");
            List<Profesor> profe2 = profesorService.seleccionarPorApellido("Escola");
            for(Profesor elem : profe2){
                System.out.println(elem);
            }

            //Dinamica con cieteria 4 formas con PROFESOR
            System.out.println("1 .-Criteria query : nombre y  especialidad" );
            List<Profesor> profe3 = profesorService.seleccionarDinamicoCriteria("Valladares", "Arquitectura");
            for (Profesor elem : profe3) {
                System.out.println(elem);
            }

            System.out.println("2 .-Criteria query : nombre y  null" );
            List<Profesor> profe4 = profesorService.seleccionarDinamicoCriteria("Valladares", null);
            for (Profesor elem : profe4) {
                System.out.println(elem);
            }

            System.out.println("3 .-Criteria query : null y  especialidad" );
            List<Profesor> profe5 = profesorService.seleccionarDinamicoCriteria(null, "Arquitectura");
            for (Profesor elem : profe5) {
                System.out.println(elem);
            }

            System.out.println("4 .-Criteria query : null y  null" );
            List<Profesor> profe6 = profesorService.seleccionarDinamicoCriteria(null, null);
            for (Profesor elem : profe6) {
                System.out.println(elem);
            }




            return 0;
        }

    }
}