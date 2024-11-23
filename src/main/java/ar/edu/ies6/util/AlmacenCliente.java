package ar.edu.ies6.util;

import ar.edu.ies6.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class AlmacenCliente {
	//metodos

    // almacen clientes
    public static List<Cliente> clientes = new ArrayList<>();

    //agregar un cliente
    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // eliminar cliente por dni
    public static void eliminarCliente(Long dni) {
        clientes.removeIf(cliente -> cliente.getDni().equals(dni));
    }

    //obtener cliente por dni
    public static Cliente obtenerCliente(Long dni) {
        return clientes.stream()
                       .filter(cliente -> cliente.getDni().equals(dni))
                       .findFirst()
                       .orElse(null);
    }

    //obtener todos los clientes
    public static List<Cliente> obtenerTodosClientes() {
        return new ArrayList<>(clientes);
    }

    // listar clientes activos
    public static List<Cliente> obtenerClientesActivos() {
        return clientes; 
    }
}
