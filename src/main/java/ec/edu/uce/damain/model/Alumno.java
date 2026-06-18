package ec.edu.uce.damain.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="alumno")
@Entity
public class Alumno {

    @Id
    @SequenceGenerator(name = "seq_alumno_generador", sequenceName = "seq_alumno", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alumno_generador")


    @Column(name="alum_id")
    private Integer id;

    @Column(name="alum_nombre")
    private  String nombre;

    @ManyToAny
    @JoinTable(name="alumno_materia", joinColumns=@JoinColumn(name="alma_id_alumno"),inverseJoinColumns=@JoinColumn(name="alma_id_materia"))//tabla  de rompimiento
    private List<Materia> matierias;


    //GET Y SET

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


    public List<Materia> getMatierias() {
        return matierias;
    }

    public void setMatierias(List<Materia> matierias) {
        this.matierias = matierias;
    }


    

}
