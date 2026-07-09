package uce.edu.ec.domain.repository;

import uce.edu.ec.domain.model.Estudiante;

public interface EstudianteRepository {

    public void crear(Estudiante estudiante);
    public Estudiante buscarPorId(Integer id);
    public void actulizar(Estudiante estudiante);
    public void eliminar(Integer id);

}
