package uce.edu.ec.domain.model;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.ec.domain.repository.MedirTiempo;

@Interceptor
@MedirTiempo // Vincula este interceptor con la anotación anterior
@Priority(Interceptor.Priority.APPLICATION)
public class MedirInterceptor {

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {
        
        long inicio = System.currentTimeMillis();
        
        try {
            
            return context.proceed(); 
        } finally {
            long fin = System.currentTimeMillis();
            long tiempoTotal = fin - inicio;
            
            System.out.println(">>> [TEMPORIZADOR] " 
                + context.getMethod().getDeclaringClass().getSimpleName() + "." 
                + context.getMethod().getName() + " tardó " + tiempoTotal + " ms.");
        }
    }

}
