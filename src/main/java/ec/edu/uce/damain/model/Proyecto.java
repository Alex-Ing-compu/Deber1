package ec.edu.uce.damain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="proyecto")
public class Proyecto {

    @Id
    @SequenceGenerator(name="seq_proyecto_generador",sequenceName="seq_proyecto",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_proyecto_generador")

    @Column(name="proye_id")
    private Integer id;
    @Column(name="proyec_nombre")
    private String nombre;
    @Column(name="proyec_descripcion")
    private String descripcion;
    @Column(name="proyec_monto")
    private Double monto;

    //many to many
    @ManyToMany(mappedBy="proyecto")
    private List<Profesor> profesor;


    //get y set
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public List<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesor> profesor) {
        this.profesor = profesor;
    }




    
}
