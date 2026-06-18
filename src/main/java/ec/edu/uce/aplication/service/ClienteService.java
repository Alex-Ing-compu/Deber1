package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Cliente;
import ec.edu.uce.infrastructure.repository.ClienteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteService {

    @Inject
    private ClienteRepositoryImpl clienteRepositoryImpl;
    
    @Transactional
    public void guardar(Cliente cliente){
        this.clienteRepositoryImpl.crear(cliente);
    }
}
