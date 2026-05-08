package uce.edu.pa2.api;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Priority(2)
public class AplicarSeguro implements ProcesoPedido{

    @Override
    public double aplicar(double valor) {
        System.out.println("Aplicando seguro...");
        return valor + 2.5;
    }

}
