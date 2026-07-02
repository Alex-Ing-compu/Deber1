package uce.edu.ec.aplication.service;

import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Mail;

public class MailServiceTarea implements Runnable{

    @Inject
    private MailService ms;

    private Mail mail;

    public MailServiceTarea(Mail mail, MailService mailService){
        this.mail = mail;
        this.ms = mailService;
    }


    @Override
    //metodo que se va ejecutar en un hilo en especifico 
    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo MailServiceTarea::::::" + nombreHilo);
        this.ms.guardarMail(this.mail);
    }

}
