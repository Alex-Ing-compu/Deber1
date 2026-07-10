package uce.edu.ec.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Producto;

@ApplicationScoped
@Transactional
public class ProductoRepositoryImpl implements PanacheRepositoryBase<Producto, Inject>{

}
