package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Cliente;
import ar.edu.ies6.service.IClienteService;

@Controller
public class ClienteController {

    @Autowired
    private Cliente unCliente;

    @Qualifier("servicioClienteBD")
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/Cliente")
    public ModelAndView getFormCliente() {
        ModelAndView transportador = new ModelAndView("formCliente");
        transportador.addObject("cliente", unCliente);
        transportador.addObject("band", false);
        return transportador;
    }

    @PostMapping("/guardarCliente")
    public ModelAndView guardarCliente(Cliente cliente) {
        clienteService.guardarCliente(cliente);
        ModelAndView transportador = new ModelAndView("listaClientes");
        transportador.addObject("listadoClientes", clienteService.listarTodosClientes());
        return transportador;
    }

    @GetMapping("/listadoClientes")
    public ModelAndView getListadoClientes() {
        ModelAndView transportador = new ModelAndView("listaClientes");  
        transportador.addObject("listadoClientes", clienteService.listarTodosClientes());
        return transportador;
    }


    @GetMapping("/modificarCliente/{dni}")
    public ModelAndView modificarCliente(@PathVariable(name = "dni") String dni) {
        ModelAndView modelView = new ModelAndView("formCliente");
        modelView.addObject("cliente", clienteService.consultarCliente(dni));
        modelView.addObject("band", true);
        return modelView;
    }

    @GetMapping("/eliminarCliente/{dni}")
    public String eliminarCliente(@PathVariable(name = "dni") String dni) {
        clienteService.eliminarCliente(dni);
        return "redirect:/listadoClientes";
    }
}

