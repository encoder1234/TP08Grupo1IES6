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

    @Qualifier("servicioClienteBD")  // Debe coincidir con el nombre registrado en la implementación del servicio
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/Cliente")
    public ModelAndView getIndexWithDocente() {
        ModelAndView transportador = new ModelAndView("formClientes");
        transportador.addObject("cliente", unCliente);
        transportador.addObject("band", false);
        return transportador;
    }

    @PostMapping("/guardarCliente")
    public ModelAndView  guardarDocentes(Cliente cliente) {
        clienteService.guardarCliente(cliente);
        ModelAndView transportador = new ModelAndView("listaClientes");
        transportador.addObject("listadoClientes", clienteService.listarTodosClientes());
        return transportador;
    }

    @GetMapping("/listadoCliente")
    public ModelAndView getAllDocente() {
        ModelAndView transportador = new ModelAndView("listaCliente");
        transportador.addObject("listadoClientes", clienteService.listarTodosClientes());
        return transportador;
    }

    @GetMapping("/modificarCliente/{dni}")
    public ModelAndView ModificarCliente(@PathVariable(name = "dni") String dni) {
        ModelAndView modelView = new ModelAndView("formCliente");
        modelView.addObject("cliente", clienteService.consultarCliente(dni));
        modelView.addObject("band", true);
        return modelView;
    }

    @GetMapping("/eliminarCliente/{dni}")
    public String deleteCliente(@PathVariable(name = "dni") String dni) {
        clienteService.eliminarCliente(dni);
        return "redirect:/listadoCliente";
    }
}
