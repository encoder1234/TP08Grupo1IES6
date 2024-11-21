package ar.edu.ies6.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Compra;
import ar.edu.ies6.service.ICompraService;
import ar.edu.ies6.service.IProductoService;

@Service
@Qualifier("ServicioCompraBD")

public class CompraServiceImp implements ICompraService {

	@Override
	public void guardarCompra(Compra compra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCompra(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compra consultarCompra(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> listarTodasLasCompras() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> obtenerComprasPorCliente(Long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> obtenerComprasPorProducto(String productoCodigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object obtenerCompraPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
