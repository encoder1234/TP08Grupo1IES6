package ar.edu.ies6.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
        transportador.addObject("band", false); 
        return transportador;
    }

    // Listar todos los productos
    @GetMapping("/listadoProductos")
    public ModelAndView getAllProductos() {
        ModelAndView transportador = new ModelAndView("listaProductos");
        transportador.addObject("listadoProductos", productoService.ListarTodosProductos());
        return transportador;
    }

    // Guardar un producto, incluyendo la foto con @PostMapping
    @PostMapping(value = "/guardarProducto", consumes = "multipart/form-data")
    public ModelAndView guardarProducto(@ModelAttribute Producto producto, @RequestParam("file") MultipartFile foto) {
        ModelAndView transportador = new ModelAndView();

        try {
            // Validar si el archivo no está vacío
            if (!foto.isEmpty()) {
                // Convertir la imagen a Base64
                String fotoBase64 = Base64.getEncoder().encodeToString(foto.getBytes());
                producto.setFoto(fotoBase64);
            } else {
                producto.setFoto(null); // Si no hay foto, establecerla como null
            }

            // Guardar el producto
            productoService.guardarProducto(producto);

            // Redirigir a la lista de productos
            transportador.setViewName("redirect:/listadoProductos"); // Redirige a la ruta correcta
        } catch (Exception e) {
            e.printStackTrace();
            transportador.setViewName("error"); // Configura una vista de error si es necesario
            transportador.addObject("error", "No se pudo guardar el producto.");
        }

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
        transportador.addObject("band", true); 
        return transportador;
    }
}

