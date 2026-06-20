package ec.edu.uce.damain.repository;

import ec.edu.uce.damain.model.Profesor;

public interface ProfesorRepository {

    /*
    //metodo crear - para el one to many
    public void crear(Profesor profesor);
    */

    //metodo cerar - el many to many
    public void crear(Profesor profesor);

    public Profesor consultarProfesorPorId(Integer id);


}
