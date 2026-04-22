package uce.edu.jc.api.facturera;

import jakarta.enterprise.context.Dependent;

@Dependent
public class GeneradorFactura {

    private String codigo = "FAC - " + Math.random();

    String getFactura() {
        return "Factura generada:" + codigo;
    }
}
