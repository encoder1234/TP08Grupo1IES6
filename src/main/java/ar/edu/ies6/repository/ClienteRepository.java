package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {
    // Método  para buscar clientes según su nombre
    List<Cliente> findAllByNombre(String nombre);
    List<Cliente> findAllByEstado(boolean b);
}
