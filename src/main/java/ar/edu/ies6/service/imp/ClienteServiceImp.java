package ar.edu.ies6.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Cliente;
import ar.edu.ies6.service.IClienteService;

@Service
@Qualifier("ServicioClienteBD")
public class ClienteServiceImp implements IClienteService {

	@Override
	public void guardarCliente(Cliente cliente)  {
        ClienteRepository.save(Cliente);
        System.out.println("Producto guardado: " + Cliente.getCodigo());
    }
		// TODO Auto-generated method stub
		


	@Override
	public void eliminarCliente(long dni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCliente(Cliente clienteModificado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultarCliente(long dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> ListarTodosClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> ListarClienteActivos() {
		// TODO Auto-generated method stub
		return null;
	}

}
