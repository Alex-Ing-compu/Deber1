package ec.edu.uce.damain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {

    @Id
    @SequenceGenerator(name="seq_horario_generador", sequenceName="seq_horario", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="seq_horario_generador")

    @Column(name="hora_id")
    private Integer id;
    @Column(name="hora_dia")
    private String dia;
    @Column(name="hora_hora")
    private String hora;

    @ManyToOne
    private Profesor profesor;
    
    //GET Y SET

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }


}
