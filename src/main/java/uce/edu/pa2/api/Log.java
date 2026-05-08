package uce.edu.pa2.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

@InterceptorBinding //Esta anotacion se utiliza para marcar una clase o metodo como un interceptor
                    //Un interceptor que se ejecuta a nivel de metodo o clase
@Target({ElementType.METHOD, ElementType.TYPE})   //Obejtivo, que esta anotacion trabaje a nivel de metodo.
                                // Para que esta construida se pueda aplicar a metodos o clases
                                //se utilza para clases o metodos que se quieren interceptar

@Retention(RetentionPolicy.RUNTIME) //Se utiliza para indicar que esta anotacion 
                                    // se va a mantener en tiempo de ejecucion
                                    
//Estamos declarando un interceptor
public @interface Log {

}
