package ar.edu.ies6.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Producto;
import ar.edu.ies6.repository.ProductoRepository;
import ar.edu.ies6.service.IProductoService;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("ServicioProductoBD")
public class ProductoServiceImp implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
        System.out.println("Producto guardado: " + producto.getCodigo());
    }

    @Override
    public void eliminarProducto(String codigo) {
        productoRepository.deleteById(codigo);
        System.out.println("Producto eliminado: " + codigo);
    }

    @Override
    public void modificarProducto(Producto productoModificado) {
        Optional<Producto> productoExistente = productoRepository.findById(productoModificado.getCodigo());
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoModificado.getNombre());
            producto.setDescripcion(productoModificado.getDescripcion());
            producto.setCategoria(productoModificado.getCategoria());
            producto.setProveedor(productoModificado.getProveedor());
            producto.setPrecio(productoModificado.getPrecio());
            productoRepository.save(producto);
            System.out.println("Producto modificado: " + producto.getCodigo());
        } else {
            System.out.println("Producto no encontrado: " + productoModificado.getCodigo());
        }
    }

    @Override
    public Producto consultarProducto(String codigo) {
        return productoRepository.findById(codigo).orElse(null);
    }

    @Override
    public List<Producto> ListarTodosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public List<Producto> ListarProductosActivos() {
        // Busca productos con estado activo
        return productoRepository.findAllByEstado(true);
    }
}

