package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.ies6.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {
    // Encuentra compras realizadas por un cliente específico
    List<Compra> findAllByClienteId(Long clienteId);

    // Encuentra compras relacionadas con un producto específico
    List<Compra> findAllByProductoCodigo(String productoCodigo);
}