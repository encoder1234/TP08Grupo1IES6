package ar.edu.ies6.service;

import java.util.List;

import ar.edu.ies6.model.Cliente;

public interface IClienteService {
	 // CRUD para Cliente
    void guardarCliente(Cliente cliente);
    void eliminarCliente(long dni);
    void modificarCliente(Cliente clienteModificado);
    Cliente consultarCliente(long dni);
    List<Cliente> ListarTodosClientes();
    List<Cliente> ListarClienteActivos();
}
