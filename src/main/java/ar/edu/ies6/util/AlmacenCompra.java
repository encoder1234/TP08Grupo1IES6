package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.ies6.model.Compra;

public class AlmacenCompra {

    // almacenar las compras
    public static List<Compra> compras = new ArrayList<>();

    // agregar una compra
    public static void agregarCompra(Compra compra) {
        compras.add(compra);
    }

    // eliminar una compra por Dni
    public static void eliminarCompra(Long dni) {
        compras.removeIf(compra -> compra.getId().equals(dni));
    }

    // obtener compra por dni
    public static Compra obtenerCompra(Long dni) {
        return compras.stream()
                      .filter(compra -> compra.getId().equals(dni))
                      .findFirst()
                      .orElse(null);
    }

    //obtener todas las compras
    public static List<Compra> obtenerTodasCompras() {
        return new ArrayList<>(compras);
    }

    // obtener compras por cliente 
    public static List<Compra> obtenerComprasPorCliente(Long clienteDni) {
        return compras.stream()
                      .filter(compra -> compra.getCliente().getDni().equals(clienteDni))
                      .collect(Collectors.toList());
    }

    // obtener compras por producto
    public static List<Compra> obtenerComprasPorProducto(String productoCodigo) {
        return compras.stream()
                      .filter(compra -> compra.getProducto().getCodigo().equals(productoCodigo))
                      .collect(Collectors.toList());
    }

    // Método para listar compras entre dos fechas
    public static List<Compra> obtenerComprasPorRangoDeFechas(java.time.LocalDate inicio, java.time.LocalDate fin) {
        return compras.stream()
                      .filter(compra -> !compra.getFecha().isBefore(inicio) && !compra.getFecha().isAfter(fin))
                      .collect(Collectors.toList());
    }
}
