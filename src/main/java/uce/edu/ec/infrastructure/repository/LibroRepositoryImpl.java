package uce.edu.ec.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Libro;

@ApplicationScoped
@Transactional
public class LibroRepositoryImpl implements PanacheRepositoryBase<Libro, Integer>{


}
