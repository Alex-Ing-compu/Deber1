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
@Table(name = "matricula")
public class Matricula extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "seq_matricula_generador", sequenceName = "seq_matricula", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_matricula_generador")
    
    @Column(name = "matri_id")
    private Integer id;

    @Column(name = "matri_codigo")
    private String codigo;

    @Column(name = "matri_cedula_estudiante")
    private String cedulaEstudiante;

    @Column(name = "matri_fecha")
    private LocalDate fecha;

    //geters y setters
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

    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Matricula [id=" + id + ", codigo=" + codigo + ", cedulaEstudiante=" + cedulaEstudiante + ", fecha="
                + fecha + "]";
    }

    

}
