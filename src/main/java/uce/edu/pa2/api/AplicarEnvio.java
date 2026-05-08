package uce.edu.pa2.api;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Priority(1)
public class AplicarEnvio implements ProcesoPedido{

    @Override
    public double aplicar(double valor) {
        System.out.println("Aplicando el costo del envio...");
        return valor + 5;
    }

}
