package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.ies6.model.Compra;

public class AlmacenCompra {

    // Lista estática para almacenar las compras
    public static List<Compra> compras = new ArrayList<>();

    // Método para agregar una compra
    public static void agregarCompra(Compra compra) {
        compras.add(compra);
    }

    // Método para eliminar una compra por su ID
    public static void eliminarCompra(Long id) {
        compras.removeIf(compra -> compra.getId().equals(id));
    }

    // Método para obtener una compra por su ID
    public static Compra obtenerCompra(Long id) {
        return compras.stream()
                      .filter(compra -> compra.getId().equals(id))
                      .findFirst()
                      .orElse(null); // Devuelve null si no encuentra la compra
    }

    // Método para obtener todas las compras
    public static List<Compra> obtenerTodasCompras() {
        return new ArrayList<>(compras);
    }

    // Método para obtener compras por cliente (por ID)
    public static List<Compra> obtenerComprasPorCliente(Long clienteId) {
        return compras.stream()
                      .filter(compra -> compra.getCliente().getId().equals(clienteId))
                      .collect(Collectors.toList());
    }

    // Método para obtener compras por producto (por código)
    public static List<Compra> obtenerComprasPorProducto(String productoCodigo) {
        return compras.stream()
                      .filter(compra -> compra.getProducto().getCodigo().equals(productoCodigo))
                      .collect(Collectors.toList());
    }

    // Método para listar compras entre dos fechas (opcional)
    public static List<Compra> obtenerComprasPorRangoDeFechas(java.time.LocalDate inicio, java.time.LocalDate fin) {
        return compras.stream()
                      .filter(compra -> !compra.getFecha().isBefore(inicio) && !compra.getFecha().isAfter(fin))
                      .collect(Collectors.toList());
    }
}
