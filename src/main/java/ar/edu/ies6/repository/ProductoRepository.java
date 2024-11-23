package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, String> {
    // Encuentra productos según su estado 
    List<Producto> findAllByEstado(Boolean estado);
}

