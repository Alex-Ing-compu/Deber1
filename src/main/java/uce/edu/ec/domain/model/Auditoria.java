package uce.edu.ec.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="auditoria")
public class Auditoria {
    @Id
    @SequenceGenerator(name="seq_auditoria_generador", sequenceName="seq_auditoria", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_auditoria_generador")

    @Column(name="audi_id")
    private Integer id;
    @Column(name="audi_nombre_metodo")
    private String nombreMetodo;
    @Column(name="audi_argumentos")
    private String argumentos;
    @Column(name="audi_fecha_hora_ejecucion")
    private LocalDateTime fechaHoraEjecucion;
    @Column(name="audi_tiempo_ejecucion")
    private Long tiempoEjecucion;

    //getter y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public String getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(String argumentos) {
        this.argumentos = argumentos;
    }

    
    public Long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    @Override
    public String toString() {
        return "Auditoria [id=" + id + ", nombreMetodo=" + nombreMetodo + ", argumentos=" + argumentos
                + ", fechaHoraEjecucion=" + fechaHoraEjecucion + ", tiempoEjecucion=" + tiempoEjecucion + "]";
    }

    public LocalDateTime getFechaHoraEjecucion() {
        return fechaHoraEjecucion;
    }

    public void setFechaHoraEjecucion(LocalDateTime fechaHoraEjecucion) {
        this.fechaHoraEjecucion = fechaHoraEjecucion;
    }

    
    
}
