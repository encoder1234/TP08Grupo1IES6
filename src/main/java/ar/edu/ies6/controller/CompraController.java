package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Compra;
import ar.edu.ies6.model.Producto;
import ar.edu.ies6.repository.ProductoRepository;
import ar.edu.ies6.service.IClienteService;
import ar.edu.ies6.service.ICompraService;

import java.util.List;

@Controller
public class CompraController {
	 @Autowired
	 Producto unaCompra;
	 @Autowired
	 ProductoRepository productorepository;
	 @Autowired
	 IClienteService clienteService;

    @Autowired
    private ICompraService compraService;

    // Página principal de compras
    @GetMapping("/listadoCompras")
    public ModelAndView getComprasIndex() {
        ModelAndView transportador = new ModelAndView("listaCompras");
        List<Compra> listadoCompras = compraService.listarTodasLasCompras();
        transportador.addObject("listadoCompras", listadoCompras);
        return transportador;
    }

    // Formulario para registrar una nueva compra
    @GetMapping("/Compras")
    public ModelAndView getIndexWithCompra() {
        ModelAndView transportador = new ModelAndView("formCompra");
        transportador.addObject("compra", new Compra());
        transportador.addObject("listadoProductos", productorepository.findAll()); 
        transportador.addObject("listaClientes", clienteService.listarTodosClientes());
        transportador.addObject("band", false); 
        return transportador;//
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
        transportador.addObject("band", true); 
        return transportador;
    }

    // Listar compras por cliente
    @GetMapping("/compras/cliente/{clienteId}")
    public ModelAndView obtenerComprasPorCliente(@PathVariable(name = "clienteId") Long clienteId) {
        ModelAndView transportador = new ModelAndView("compraCliente");
        transportador.addObject("listadoProductos", productorepository.findAll()); 
        transportador.addObject("listaClientes", clienteService.listarTodosClientes());
        transportador.addObject("listadoCompras", compraService.obtenerComprasPorCliente(clienteId));
        return transportador;
    }

    // Listar compras por producto
    @GetMapping("/compras/producto/{productoCodigo}")
    public ModelAndView obtenerComprasPorProducto(@PathVariable(name = "productoCodigo") String productoCodigo) {
        ModelAndView transportador = new ModelAndView("compraProducto");
        transportador.addObject("listadoProductos", productorepository.findAll()); 
        transportador.addObject("listaClientes", clienteService.listarTodosClientes());
        transportador.addObject("listadoCompras", compraService.obtenerComprasPorProducto(productoCodigo));
        return transportador;
    }
}
