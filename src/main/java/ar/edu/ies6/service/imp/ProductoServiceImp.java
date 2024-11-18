package ar.edu.ies6.service.imp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Producto;
import ar.edu.ies6.service.IProductoService;
import ar.edu.ies6.util.AlmacenProducto;

@Service
@Qualifier("ServicioAlumnoBDArrayList")
public class ProductoServiceImp implements IProductoService {

	    @Override
	    public void guardarProducto(Producto producto) {
	        AlmacenProducto.productos.add(producto);
	        System.out.println("Producto agregado: " + producto.getCodigo());
	    }

	    @Override
	    public void eliminarAlumno(String dni) {
	        Optional<Alumno> alumnoAEliminar = AlmacenAlumnos.alumnos.stream()
	                .filter(alumno -> alumno.getDni().equals(dni))
	                .findFirst();
	        
	        alumnoAEliminar.ifPresent(alumno -> AlmacenAlumnos.alumnos.remove(alumno));
	    }

	    @Override
	    public void modificarAlumno(Alumno alumnoModificado) {
	        // Buscar el alumno por DNI y actualizar los datos
	        Optional<Alumno> alumnoExistente = AlmacenAlumnos.alumnos.stream()
	                .filter(alumno -> alumno.getDni().equals(alumnoModificado.getDni()))
	                .findFirst();

	        alumnoExistente.ifPresent(alumno -> {
	            alumno.setNombre(alumnoModificado.getNombre());
	            alumno.setApellido(alumnoModificado.getApellido());
	            alumno.setEstado(alumnoModificado.isEstado());
	        });
	    }

	    @Override
	    public Alumno consultarAlumno(String dni) {
	        // Buscar un alumno por dni
	        return AlmacenAlumnos.alumnos.stream()
	                .filter(alumno -> alumno.getDni().equals(dni))
	                .findFirst()
	                .orElse(null); // devuleve nada
	    }

	    @Override
	    public List<Alumno> ListarTodosAlumnos() {
	        return AlmacenAlumnos.alumnos;
	    }

	    @Override
	    public List<Alumno> ListarAlumnosActivos() {
	        // Filtra solo los alumnos activos
	        return AlmacenAlumnos.alumnos.stream()
	                .filter(Alumno::isEstado) // Verifica of/on
	                .toList();
	    }
	}

}
