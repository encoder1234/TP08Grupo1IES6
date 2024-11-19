package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Producto;
import ar.edu.ies6.service.IProductoService;

@Controller
public class ProductoController {

    @Autowired
    private Producto unProducto;

    @Qualifier("ServicioProductoBD")
    @Autowired
    private IProductoService productoService;

    // Página principal o ruta básica
    @GetMapping("/Grupo1")
    public String getIndex() {
        System.out.println("Esta pasando por aquí");
        return "grupo1";
    }

    // Formulario para crear o modificar un producto
    @GetMapping("/Producto")
    public ModelAndView getIndexWithProducto() {
        ModelAndView transportador = new ModelAndView("formProducto");
        transportador.addObject("producto", unProducto);
        transportador.addObject("band", false); // Bandera para indicar si es creación o modificación
        return transportador;
    }

    // Listar todos los productos
    @GetMapping("/listadoProductos")
    public ModelAndView getAllProductos() {
        ModelAndView transportador = new ModelAndView("listaProductos");
        transportador.addObject("listadoProductos", productoService.ListarTodosProductos());
        return transportador;
    }

    // Guardar un producto
    @PostMapping("/guardarProducto")
    public ModelAndView guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardarProducto(producto);
        ModelAndView transportador = new ModelAndView("listaProductos");
        transportador.addObject("listadoProductos", productoService.ListarTodosProductos());
        return transportador;
    }

    // Eliminar un producto por su código
    @GetMapping("/eliminarProducto/{codigo}")
    public ModelAndView deleteProducto(@PathVariable(name = "codigo") String codigo) {
        productoService.eliminarProducto(codigo);
        ModelAndView transportador = new ModelAndView("listaProductos");
        transportador.addObject("listadoProductos", productoService.ListarTodosProductos());
        return transportador;
    }

    // Modificar un producto
    @GetMapping("/modificarProducto/{codigo}")
    public ModelAndView modificarProducto(@PathVariable(name = "codigo") String codigo) {
        ModelAndView transportador = new ModelAndView("formProducto");
        transportador.addObject("producto", productoService.consultarProducto(codigo));
        transportador.addObject("band", true); // Bandera para indicar que es modificación
        return transportador;
    }
}
