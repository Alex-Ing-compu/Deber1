package uce.edu.ec;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.aplication.service.AuditoriaService;
import uce.edu.ec.aplication.service.EstudianteService;
import uce.edu.ec.aplication.service.FacturaService;
import uce.edu.ec.aplication.service.FacturaServiceCompletadoFuture;
import uce.edu.ec.aplication.service.FacturaServiceParalelo;
import uce.edu.ec.aplication.service.MatriculaService;
import uce.edu.ec.domain.model.Estudiante;

@QuarkusMain
public class Main {
 
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }
 
    public static class App implements QuarkusApplication {

        @Inject
        private FacturaService fs;

        @Inject
        private MatriculaService ms;

        @Inject
        private FacturaServiceParalelo fsp;
        
        @Inject
        private FacturaServiceCompletadoFuture fsc;

        @Inject
        private EstudianteService es;

        @Inject
        private AuditoriaService as;

        @Override
        public int run(String... args) throws Exception {
        
        System.out.println("Conectado a la BASE DE DATOS");
        Estudiante estu = new Estudiante();
        estu.setNombre("Andyy");
        estu.setApellido("Aguas");
        estu.setFechaNacimineto(LocalDate.now());
        estu.setGenero("M");
        this.es.guardar(estu);
        
        //actualizar
        Estudiante estuAc = this.es.buscarPorId(3);
        estuAc.setNombre("Ale_");
        //this.es.actualizar(estuAc);
        
        //eliminar
        Integer eliminar = 2;
        //Estudiante estudiante = this.es.buscarPorId(eliminar);    
        //this.es.eliminar(eliminar);
        
        

            return 0;
        }
    }
}