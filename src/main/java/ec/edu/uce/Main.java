package ec.edu.uce;

import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.aplication.service.ClienteService;
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
        private ClienteService clienteService;

        @Inject
        private ProfesorService profesorService;

        @Inject
        private ProyectoService proyectoService;
        

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");

            //DEBER: ManyToMany

            Profesor profesor = new Profesor();
            profesor.setNombre("Jhon");
            profesor.setApellido("Cordova");
            profesor.setCiudad("Quito");
            profesor.setCorreo("jhon@uce.edu.ec");
            profesor.setEspecialidad("Sistemas");
            profesor.setEstado(true);
            profesor.setPais("Ecuador");
            profesor.setGenero("M");
            profesor.setSalario(2000.0);
            
            Proyecto proyecto = new Proyecto();
            proyecto.setNombre("AppFord");
            proyecto.setDescripcion("Aplicacion movil para mirar las ventas de carros");
            proyecto.setMonto(300.0);

            Proyecto proyecto2 = new Proyecto();
            proyecto2.setNombre("Things");
            proyecto2.setDescripcion("Aplicacion de escritorio para escuchar canciones");
            proyecto2.setMonto(500.0);
            
            this.proyectoService.guardar(proyecto);
            this.proyectoService.guardar(proyecto2);

            List<Proyecto> proyectos = new ArrayList<>();
            proyectos.add(proyecto);
            proyectos.add(proyecto2);

            profesor.setProyecto(proyectos);

            this.profesorService.guardar(profesor);



            /*
            //RALACION ONE TO MANY
            Cliente c = new Cliente();
            c.setNombre("Paul");
            c.setCedula("110285636");

            Pedido p = new Pedido();
            p.setTotal(Double.valueOf(10));
            p.setCliente(c);
            p.setFecha(LocalDate.of(2026, 06, 25));

            Pedido p2 = new Pedido();
            p2.setTotal(Double.valueOf(200));
            p2.setCliente(c);
            p2.setFecha(LocalDate.of(2026, 06, 6));

            List<Pedido> pedidos = new ArrayList<>();
            pedidos.add(p);
            pedidos.add(p2);

            c.setPedido(pedidos);

            this.clienteService.guardar(c);
            */
            


            return 0;
        }

    }
}