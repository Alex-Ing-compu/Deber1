package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Mail;

@Dependent
public class MailServiceTarea implements Runnable{

    @Inject
    private MailService ms;

    private Mail mail;

    public void setMail(Mail mail){
        this.mail = mail;
    }

    @Override
    //metodo que se va ejecutar en un hilo en especifico 
    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo MailServiceTarea::::::" + nombreHilo);
        this.ms.guardarMail(this.mail);
    }

}
