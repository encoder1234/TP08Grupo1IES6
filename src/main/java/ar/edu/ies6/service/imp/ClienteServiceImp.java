package ar.edu.ies6.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Cliente;
import ar.edu.ies6.repository.ClienteRepository;
import ar.edu.ies6.service.IClienteService;

@Service
@Qualifier("ServicioClienteBD")
public class ClienteServiceImp implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        System.out.println("Cliente guardado: " + cliente.getDni());
    }

    @Override
    public void eliminarCliente(Long dni) {
        clienteRepository.deleteById(dni);
        System.out.println("Cliente eliminado con DNI: " + dni);
    }

    @Override
    public void modificarCliente(Cliente clienteModificado) {
        if (clienteRepository.existsById(clienteModificado.getDni())) {
            clienteRepository.save(clienteModificado);
            System.out.println("Cliente modificado con DNI: " + clienteModificado.getDni());
        } else {
            System.out.println("Cliente con DNI " + clienteModificado.getDni() + " no encontrado.");
        }
    }

    @Override
    public Cliente consultarCliente(Integer dni) {
        Optional<Cliente> cliente = clienteRepository.findById(dni);
        return cliente.orElse(null);
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public List<Cliente> listarClientesActivos() {
        // Esto asume que hay un atributo `estado` en la entidad Cliente
        return clienteRepository.findAllByEstado(true);
    }
}

