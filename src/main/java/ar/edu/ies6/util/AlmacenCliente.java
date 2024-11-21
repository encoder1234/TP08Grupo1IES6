package ar.edu.ies6.util;

import ar.edu.ies6.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class AlmacenCliente {

    // Lista estática para almacenar los clientes
    public static List<Cliente> clientes = new ArrayList<>();

    // Método para agregar un cliente
    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para eliminar un cliente por su dni
    public static void eliminarCliente(Long dni) {
        clientes.removeIf(cliente -> cliente.getDni().equals(dni));
    }

    // Método para obtener un cliente por su dni
    public static Cliente obtenerCliente(Long dni) {
        return clientes.stream()
                       .filter(cliente -> cliente.getDni().equals(dni))
                       .findFirst()
                       .orElse(null); // Devuelve null si no encuentra el cliente
    }

    // Método para obtener todos los clientes
    public static List<Cliente> obtenerTodosClientes() {
        return new ArrayList<>(clientes);
    }

    // Método para listar clientes activos
    public static List<Cliente> obtenerClientesActivos() {
        // Este método filtraría a los clientes activos, suponiendo que existe algún campo de "estado" o similar
        return clientes; // Suponiendo que todos son activos por ahora
    }
}
