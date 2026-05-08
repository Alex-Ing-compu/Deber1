package uce.edu.pa2.api;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Log
@Interceptor
@Priority(2)
public class LogInterceptor {
    @AroundInvoke //Este metodo se utilizara para ejecutar al rededor de la ejecucion del metodo 
                  //Se va ejecutar al rededor del metodo de negocio
    public Object medir(InvocationContext contex) throws Exception{

        System.out.println("Se ejecuto Log antes del metodo");
        System.out.println("Interceptado el metodo:" + contex.getMethod().getName());

        Object[] args = contex.getParameters();
        for(int i=0 ; i<args.length; i++){
            System.out.println("Argumento: " + args[i]);
            Object obj = args[i];
            Venta venta = (Venta)obj;
            System.out.println(venta.getCliente());
            System.out.println(venta.getTotal());
            
        }

        Object resultado = contex.proceed();
        
        return resultado;

    }

}
