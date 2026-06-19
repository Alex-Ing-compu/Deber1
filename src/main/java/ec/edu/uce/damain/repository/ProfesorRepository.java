package ec.edu.uce.damain.repository;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.damain.model.Profesor;

public interface ProfesorRepository {

    //metodo crear - para el one to many
    void crear(Profesor profesor);

    Profesor seleccionarPorId(Integer id);

    void actualizar(Profesor profesor);

    void eliminar(Integer id);


    public List<Profesor> seleccionarTodos();
    public Profesor seleccionarPorCorreo(String correo);
    public List<Profesor> seleccionarPorEspecialidad(String especialidad);
    public List<Profesor> seleccionarPorRangoSalarial(BigDecimal min, BigDecimal max);

    // --- NUEVOS MÉTODOS BASADOS EN TUS ATRIBUTOS ---
    public List<Profesor> seleccionarPorPais(String pais);
    public List<Profesor> seleccionarActivos();

    public List<Profesor> seleccionarPorApellidoLike(String texto);
    public List<Profesor> seleccionarPorDominioCorreo(String dominio);

    //NamedQuery

    public List<Profesor> seleccionarPorGenero(String genero);

    public List<Profesor> seleccionarPorGeneroTyped(String genero);

    public List<Profesor> seleccionarPorPaisNamed(String pais);

    public Long contar();

    //NativeQuery
    List<Profesor> seleccionarPorPaisNative(String pais);
    List<Profesor> seleccionarActivosNative();
    List<Profesor> seleccionarPorEspecialidadNative(String especialidad);


    //CRITERIAN QUERY
    public List<Profesor> seleccionarTodosCriteriaProfesor();
    public List<Profesor> seleccionarPorApellido(String apellido);
    public List<Profesor> seleccionarDinamicoCriteria(String apellido, String especialidad);


}
