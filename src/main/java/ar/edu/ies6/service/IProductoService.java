package ar.edu.ies6.service;

import java.util.List;

import ar.edu.ies6.model.Producto;

public interface IProductoService {
    // CRUD para Producto
    void guardarProducto(Producto producto);
    void eliminarProducto(String codigo);
    void modificarProducto(Producto productoModificado);
    Producto consultarProducto(String codigo);
    List<Producto> ListarTodosProductos();
    List<Producto> ListarProductosActivos();
}

