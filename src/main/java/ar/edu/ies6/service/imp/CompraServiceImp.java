package ar.edu.ies6.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Compra;
import ar.edu.ies6.repository.CompraRepository;
import ar.edu.ies6.service.ICompraService;

@Service
@Qualifier("ServicioCompraBD")
public class CompraServiceImp implements ICompraService {

    @Autowired
    private CompraRepository compraRepository;  

    @Override
    public void guardarCompra(Compra compra) {
        compraRepository.save(compra);  
    }

    @Override
    public void eliminarCompra(Long id) {
        compraRepository.deleteById(id); 
    }

    @Override
    public Compra consultarCompra(Long id) {
        return compraRepository.findById(id).orElse(null); 
    }

    @Override
    public List<Compra> listarTodasLasCompras() {
        return (List<Compra>) compraRepository.findAll();
    }

    @Override
    public List<Compra> obtenerComprasPorCliente(Long clienteId) {
        return compraRepository.findAllByClienteDni(clienteId.toString());  
    }

    @Override
    public List<Compra> obtenerComprasPorProducto(String productoCodigo) {
        return compraRepository.findAllByProductoCodigo(productoCodigo); 
    }

    @Override
    public Object obtenerCompraPorId(Long id) {
        return compraRepository.findById(id).orElse(null); 
    }
}

