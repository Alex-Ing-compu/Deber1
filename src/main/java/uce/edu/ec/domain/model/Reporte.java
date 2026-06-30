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
@Table(name = "reporte")        
public class Reporte extends PanacheEntityBase {
    
    @Id
    @SequenceGenerator(name = "seq_reporte_generador", sequenceName = "seq_reporte", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reporte_generador")

    @Column(name = "repor_id")
    private Integer id;
    @Column(name = "repor_titulo")
    private String titulo;
    @Column(name = "repor_autor")
    private String autor;
    @Column(name = "repor_tipo")
    private String tipo;
    @Column(name = "repor_descripcion")
    private String descripcion;
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "repor_fecha_generacion")
    private LocalDate fechaGeneracion;

    //getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    @Override
    public String toString() {
        return "Reporte [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", tipo=" + tipo
                + ", fechaGeneracion=" + fechaGeneracion + "]";
    }

}
