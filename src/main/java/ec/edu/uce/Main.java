package ec.edu.uce;

import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.aplication.service.ClienteService;
import ec.edu.uce.aplication.service.ProfesorService;
import ec.edu.uce.damain.model.Horario;
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
        private ClienteService clienteService;

        @Inject
        private ProfesorService profesorService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");

            //DEBER: ONE TO MANY
            Profesor profesor = new Profesor();
            profesor.setNombre("Alex");
            profesor.setApellido("Cordova");
            profesor.setCiudad("Quito");
            profesor.setCorreo("ale@uce.edu.ec");
            profesor.setEspecialidad("Sistemas");
            profesor.setEstado(true);
            profesor.setPais("Ecuador");
            profesor.setGenero("M");
            profesor.setSalario(2000.0);
            
            
            Horario horario = new Horario();
            horario.setDia("Jueves");
            horario.setHora("6:00 am");
            horario.setProfesor(profesor);
            
            Horario horario2 = new Horario();
            horario2.setDia("Martes");
            horario2.setHora("10:00 am");
            horario2.setProfesor(profesor);

            Horario horario3 = new Horario();
            horario3.setDia("Viernes");
            horario3.setHora("11:00 am");
            horario3.setProfesor(profesor);


            List<Horario> horarios = new ArrayList<>();
            horarios.add(horario);
            horarios.add(horario2);
            horarios.add(horario3);
            

            profesor.setHorario(horarios);

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