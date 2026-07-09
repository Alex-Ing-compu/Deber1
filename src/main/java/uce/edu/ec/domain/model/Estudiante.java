package uce.edu.ec.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
    @Id
    @SequenceGenerator(name="seq_estudiante_generador", sequenceName="seq_estudiante", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_estudiante_generador")

    @Column(name="estu_id")
    private Integer id;
    @Column(name="estu_nombre")
    private String nombre;
    @Column(name="estu_apellido")
    private String apellido;
    @Column(name="estu_fecha_nacimineto")
    private LocalDate fechaNacimineto;
    @Column(name="estu_genero")
    private String genero;

    //setter y getters
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(LocalDate fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimineto="
                + fechaNacimineto + ", genero=" + genero + "]";
    }


    
    
}
