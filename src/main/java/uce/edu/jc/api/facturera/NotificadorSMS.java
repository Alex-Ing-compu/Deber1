package uce.edu.jc.api.facturera;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificadorSMS {

    public void enviar(String telefono, String mensaje) {
        System.out.println("Enviando SMS al número: " + telefono);
        System.out.println("Mensaje: " + mensaje);
    }

}
