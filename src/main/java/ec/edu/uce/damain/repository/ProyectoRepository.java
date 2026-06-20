package ec.edu.uce.damain.repository;

import ec.edu.uce.damain.model.Proyecto;

public interface ProyectoRepository {

    public void crear(Proyecto proyecto);

    public Proyecto consultarProyectoPorID(Integer id);

}
