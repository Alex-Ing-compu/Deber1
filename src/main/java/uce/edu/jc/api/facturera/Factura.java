package uce.edu.jc.api.facturera;

public class Factura {
    private String cliente;
    private String producto;
    private double total;
    private String telefono;

    public Factura() {
    }

    public Factura(String cliente, String producto, double total, String telefono) {
        this.cliente = cliente;
        this.producto = producto;
        this.total = total;
        this.telefono = telefono;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}