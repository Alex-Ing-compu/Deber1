package uce.edu.ec;

import java.util.ArrayList;
import java.util.List;

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
import uce.edu.ec.aplication.service.ReporteService;
import uce.edu.ec.domain.model.Reporte;

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

        @Inject
        private ReporteService rs;

        @Override
        public int run(String... args) throws Exception {
        
        System.out.println("Conectado a la BASE DE DATOS");
        
        List<Reporte> lista = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Reporte r1 = new Reporte();
            r1.setDescripcion("nuevo reporte");
            r1.setTitulo("Texto de prueba" + i);
            lista.add(r1);
        }

        this.rs.guardarListaReporte(lista);
        

            return 0;
        }
    }
}