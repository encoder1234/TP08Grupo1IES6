package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.ies6.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {
    // Encuentra compras realizadas por  dni
    List<Compra> findAllByClienteDni(String clienteDni);

    // Encuentra compras usando código
    List<Compra> findAllByProductoCodigo(String productoCodigo);
}

