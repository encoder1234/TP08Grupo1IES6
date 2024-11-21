package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Compra;
import ar.edu.ies6.service.ICompraService;

import java.util.List;

@Controller
public class CompraController {

    @Autowired
    private ICompraService compraService;

    // Página principal de compras
    @GetMapping("/compras")
    public ModelAndView getComprasIndex() {
        ModelAndView transportador = new ModelAndView("listaCompras");
        List<Compra> listadoCompras = compraService.listarTodasLasCompras();
        transportador.addObject("listadoCompras", listadoCompras);
        return transportador;
    }

    // Formulario para registrar una nueva compra
    @GetMapping("/nuevaCompra")
    public ModelAndView getFormularioNuevaCompra() {
        ModelAndView transportador = new ModelAndView("formCompra");
        transportador.addObject("compra", new Compra());
        transportador.addObject("band", false); // Indica si es creación o modificación
        return transportador;
    }

    // Guardar una nueva compra
    @PostMapping("/guardarCompra")
    public ModelAndView guardarCompra(@ModelAttribute Compra compra) {
        compraService.guardarCompra(compra);
        ModelAndView transportador = new ModelAndView("listaCompras");
        transportador.addObject("listadoCompras", compraService.listarTodasLasCompras());
        return transportador;
    }

    // Eliminar una compra por su ID
    @GetMapping("/eliminarCompra/{id}")
    public ModelAndView eliminarCompra(@PathVariable(name = "id") Long id) {
        compraService.eliminarCompra(id);
        ModelAndView transportador = new ModelAndView("listaCompras");
        transportador.addObject("listadoCompras", compraService.listarTodasLasCompras());
        return transportador;
    }

    // Modificar una compra
    @GetMapping("/modificarCompra/{id}")
    public ModelAndView modificarCompra(@PathVariable(name = "id") Long id) {
        ModelAndView transportador = new ModelAndView("formCompra");
        transportador.addObject("compra", compraService.obtenerCompraPorId(id));
        transportador.addObject("band", true); // Indica que es modificación
        return transportador;
    }

    // Listar compras por cliente
    @GetMapping("/compras/cliente/{clienteId}")
    public ModelAndView obtenerComprasPorCliente(@PathVariable(name = "clienteId") Long clienteId) {
        ModelAndView transportador = new ModelAndView("listaCompras");
        transportador.addObject("listadoCompras", compraService.obtenerComprasPorCliente(clienteId));
        return transportador;
    }

    // Listar compras por producto
    @GetMapping("/compras/producto/{productoCodigo}")
    public ModelAndView obtenerComprasPorProducto(@PathVariable(name = "productoCodigo") String productoCodigo) {
        ModelAndView transportador = new ModelAndView("listaCompras");
        transportador.addObject("listadoCompras", compraService.obtenerComprasPorProducto(productoCodigo));
        return transportador;
    }
}
