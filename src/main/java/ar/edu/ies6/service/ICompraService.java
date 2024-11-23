package ar.edu.ies6.service;

import java.util.List;
import ar.edu.ies6.model.Compra;

public interface ICompraService {
    // CRUD para Compra
    void guardarCompra(Compra compra);
    void eliminarCompra(Long id);
    Compra consultarCompra(Long id);
    List<Compra> listarTodasLasCompras();
    List<Compra> obtenerComprasPorCliente(Long clienteId);
    List<Compra> obtenerComprasPorProducto(String productoCodigo);
	Object obtenerCompraPorId(Long id);
}