package uce.edu.pa2.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProcesadorPedidoService {

      @Inject
    private Instance<ProcesoPedido> procesos;

    public void procesar(Pedido1 pedido1) {

        System.out.println("Cliente: " + pedido1.getCliente());

        double total = pedido1.getTotal();

        for(ProcesoPedido proceso : procesos){

            total = proceso.aplicar(total);

        }

        pedido1.setTotal(total);

        System.out.println("Total final: " + pedido1.getTotal());

    }

}
