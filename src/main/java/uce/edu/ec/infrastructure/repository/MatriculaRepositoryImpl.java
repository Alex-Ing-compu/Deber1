package uce.edu.ec.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Matricula;

@ApplicationScoped
@Transactional
public class MatriculaRepositoryImpl implements PanacheRepositoryBase<Matricula, Integer> {

    public Matricula buscarPorCodigo(String codigo){
        return null; 
    }
}
