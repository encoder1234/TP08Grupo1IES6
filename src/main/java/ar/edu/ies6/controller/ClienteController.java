package ar.edu.ies6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ar.edu.ies6.model.Cliente;
import ar.edu.ies6.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    // Mostrar formulario para crear un cliente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formulario-cliente"; // Vista del formulario (HTML)
    }

    // Guardar un cliente (desde el formulario)
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes"; // Redirige a la lista de clientes
    }

    // Listar todos los clientes
    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        model.addAttribute("clientes", clientes);
        return "lista-clientes"; // Vista de la lista (HTML)
    }

    // Mostrar cliente para editar
    @GetMapping("/editar/{dni}")
    public String mostrarFormularioEditarCliente(@PathVariable Long dni, Model model) {
        Cliente cliente = clienteService.consultarCliente(dni);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "formulario-cliente"; // Reutiliza el formulario
        } else {
            return "redirect:/clientes"; // Redirige si no se encuentra el cliente
        }
    }

    // Eliminar un cliente
    @GetMapping("/eliminar/{dni}")
    public String eliminarCliente(@PathVariable Long dni) {
        clienteService.eliminarCliente(dni);
        return "redirect:/clientes"; // Redirige a la lista después de eliminar
    }
}
