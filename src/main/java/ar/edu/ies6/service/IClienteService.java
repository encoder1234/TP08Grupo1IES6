package ar.edu.ies6.service;

import java.util.List;
import ar.edu.ies6.model.Cliente;

public interface IClienteService {
    // CRUD para Cliente
    void guardarCliente(Cliente cliente);
    void eliminarCliente(Long dni);
    void modificarCliente(Cliente clienteModificado);
    Cliente consultarCliente(Long dni);
    List<Cliente> listarTodosClientes();
    List<Cliente> listarClientesActivos();
}
