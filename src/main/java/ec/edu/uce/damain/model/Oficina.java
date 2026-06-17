package ec.edu.uce.damain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="oficina")
public class Oficina {

    @Id
    @SequenceGenerator(name="seq_oficina_generador", sequenceName="seq_oficina", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_oficina_generador")

    @Column(name="ofi_id")
    private Integer id;

    @Column(name="ofi_numero")
    private Integer numero;

    @Column(name="ofi_bloque")
    private String bloque;


    //Transacciones 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ofi_profesor")
    private Profesor profesor;


    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    
    //getters y setters

     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

   
    //to string 
     @Override
    public String toString() {
        return "Oficina [id=" + id + ", numero=" + numero + ", bloque=" + bloque + "]";
    }

    
    
}
