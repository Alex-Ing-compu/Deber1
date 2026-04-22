package uce.edu.jc.api.ControVentas;

import jakarta.inject.Singleton;

@Singleton
public class ContadorVentas {

    private int total = 0;

    public int incrementar() {
        return ++total;
    }

    public int getTotal() {
        return total;
    }

    
}
