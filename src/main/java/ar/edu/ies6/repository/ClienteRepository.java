package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer> {
    // busca clientes segun su estado 
    List<Cliente> findAllByEstado(Boolean estado);
}