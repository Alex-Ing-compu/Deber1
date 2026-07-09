package uce.edu.ec.aplication.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.ec.domain.repository.Archivo;

@Archivo
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class ArchivoInterceptor {

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {

        Object resultado = context.proceed();

        String nombreMetodo = context.getMethod().getName();
        String fecha = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String registro = String.format(
                "%s - Método: %s%n",
                fecha,
                nombreMetodo);

        Files.write(
                Paths.get("auditoria.txt"),
                registro.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

        return resultado;

    }

}
