package uce.edu.ec.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto extends PanacheEntityBase{
    
    @Id
    @SequenceGenerator(name = "seq_producto_generador", sequenceName = "seq_producto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto_generador")
    
    @Column(name="prod_id")
    private Integer id;
    @Column(name="prod_codigo")
    private String codigo;
    @Column(name="prod_nombre")
    private String nombre;
    @Column(name="prod_precio")
    private Double precio;
    @Column(name="prod_stock")
    private Integer stock;
    @Column(name="prod_fecha_ingreso")
    private LocalDate fechaIngreso;

    //seters y geters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    @Override
    public String toString() {
        return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", stock="
                + stock + ", fechaIngreso=" + fechaIngreso + "]";
    }

}
