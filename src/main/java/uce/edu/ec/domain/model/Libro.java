package uce.edu.ec.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="libro")
public class Libro extends PanacheEntityBase{

     @Id
    @SequenceGenerator(name = "seq_libro_generador", sequenceName = "seq_libro", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro_generador")

    @Column(name = "libr_id")
    private Integer id;

    @Column(name = "libr_titulo")
    private String titulo;

    @Column(name = "libr_autor")
    private String autor;

    @Column(name = "libr_precio")
    private Double precio;

    //geters y seters
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    

}
