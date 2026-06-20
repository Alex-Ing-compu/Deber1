package ec.edu.uce.damain.repository;

import ec.edu.uce.damain.model.Materia;

public interface MateriaRepository {

    public void crear(Materia materia);

    public Materia consultarPorID(Integer id);

    

}
