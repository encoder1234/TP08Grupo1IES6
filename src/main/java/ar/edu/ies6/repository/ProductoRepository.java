package ar.edu.ies6.repository;

public interface ProductoRepository  extends CrudRepository <Producto, String>{
		List <Producto> findByEstado(Boolean estado);

}
