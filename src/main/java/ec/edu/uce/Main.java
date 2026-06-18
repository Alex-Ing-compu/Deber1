package ec.edu.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.aplication.service.ClienteService;
import ec.edu.uce.damain.model.Cliente;
import ec.edu.uce.damain.model.Pedido;
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

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");

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


            return 0;
        }

    }
}