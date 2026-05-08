package uce.edu.pa2.api;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Priority(3)
public class ValidarStock implements ProcesoPedido{

    @Override
    public double aplicar(double valor) {
        System.out.println("Validando Stock...");
        return valor;
    }

}
