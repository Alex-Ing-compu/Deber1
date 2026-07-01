package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.HistorialAcademico;
import uce.edu.ec.domain.repository.MedirTiempo;

@ApplicationScoped
@Transactional
public class AcademicoService {

    @MedirTiempo
    public void actualizarHistorial(HistorialAcademico historial) {
        System.out.println("Nombre del hilo ACADEMICO SERVICE: " + Thread.currentThread().getName());
        System.out.println("ID Hilo: " + Thread.currentThread().threadId());
        historial.persist();
    }
}
