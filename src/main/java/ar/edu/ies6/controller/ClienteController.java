package ar.edu.ies6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Cliente;
import ar.edu.ies6.service.IClienteService;

@Controller
public class ClienteController {
@Autowired
Cliente unCliente;

@Qualifier("servicioClienteBD")
@Autowired
IClienteService clienteService;


    // Mostrar formulario para crear un cliente
    @GetMapping("/Cliente")
    public ModelAndView getIndexWithDocente() {
        ModelAndView transportador = new ModelAndView("formCliente");
        transportador.addObject("cliente", unCliente);  // Se pasa el objeto docente vacío
        transportador.addObject("band", false);          // 'band' se usa para el control de readonly en el legajo
        return transportador;
    }
 // Guardar un cliente (desde el formulario)
    @PostMapping("/guardarCliente")
    public String guardarDocentes(Cliente cliente) {
        clienteService.guardarCliente(cliente);  // Se guarda el docente
        return "redirect:/listadoClientes";  // Redirige a la lista de docentes después de guardar
    }
    
    @GetMapping("/listadoCliente")
    public ModelAndView getAllDocente() {
        ModelAndView transportador = new ModelAndView("listaCliente");
        transportador.addObject("listadoClientes", clienteService.listarTodosClientes());  // Se lista todos los docentes
   return transportador;
    }

    // Mostrar cliente para editar
    @GetMapping("/modificarCliente/{dni}")
    public ModelAndView ModificarCliente(@PathVariable(name = "dni") Integer dni) {
        ModelAndView modelView = new ModelAndView("formCliente");
        modelView.addObject("cliente",clienteService.consultarCliente(dni));  // Trae el docente por legajo para editar
        modelView.addObject("band", true);  // 'band' para permitir editar el legajo
        return modelView;
    }

    // Eliminar un cliente
    @GetMapping("/eliminarCliente/{legajo}")
    public String deleteCliente(@PathVariable(name = "dni") Integer dni) {
        clienteService.eliminarCliente(dni);  // Elimina el docente por legajo
        return "redirect:/listadoCliente";  // Redirige nuevamente a la lista de docentes
    }
}
