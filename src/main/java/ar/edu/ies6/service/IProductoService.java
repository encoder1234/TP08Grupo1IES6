package ar.edu.ies6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Producto;

public interface IProductoService {
	@Service
	public interface IAlumnoService {
		//crud
		public void guardarProducto(Producto producto);
		public void eliminarProducto(String codigo);
		public void modificarProducto(Producto productoModificado);
		public Producto consultarProducto(String codigo);
		public List<Producto> ListarTodosProductos();
		public List<Producto> ListarProductosActivos();
	}

}
