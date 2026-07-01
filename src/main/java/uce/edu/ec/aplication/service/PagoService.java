package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Pago;
import uce.edu.ec.domain.repository.MedirTiempo;

@ApplicationScoped
@Transactional
public class PagoService {

    @MedirTiempo
    public void procesarPago(Pago pago) {
        System.out.println("Nombre del hilo PAGO SERVICE: " + Thread.currentThread().getName());
        System.out.println("ID Hilo: " + Thread.currentThread().threadId());
        pago.persist();
    }

}
