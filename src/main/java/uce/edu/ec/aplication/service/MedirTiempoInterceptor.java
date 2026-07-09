package uce.edu.ec.aplication.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.ec.domain.model.Auditoria;
import uce.edu.ec.domain.repository.Auditar;


@Auditar
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class MedirTiempoInterceptor {

    @Inject
    private AuditoriaService as;

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {

        long inicio = System.currentTimeMillis();

        try {

            return context.proceed();

        } finally {

            long fin = System.currentTimeMillis();
            long timepoTotal = fin - inicio;

            // captura de informacion
            String nombreMetodo = context.getMethod().getName();
            String argumentos = Arrays.toString(context.getParameters());

            
            // creamos al entidad
            Auditoria audi = new Auditoria();
            audi.setNombreMetodo(nombreMetodo);
            audi.setArgumentos(argumentos);
            audi.setFechaHoraEjecucion(LocalDateTime.now());
            audi.setTiempoEjecucion(timepoTotal);

            this.as.insertar(audi);

             
            // auditoria
            System.out.println("____AUDITORÍA ____");
            System.out.println("Nombre del metodo : " + nombreMetodo);
            System.out.println("Argumentos: " + argumentos);
            System.out.println("Tiempo de ejecución: " + timepoTotal + " ms");
            System.out.println("_______________");

        }
    }

}
