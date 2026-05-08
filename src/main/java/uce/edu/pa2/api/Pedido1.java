package uce.edu.pa2.api;

public class Pedido1 {

    private String cliente;
    private double total;

    public Pedido1(){

    }
    
    public Pedido1(String cliente, double total) {
        this.cliente = cliente;
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    



}
