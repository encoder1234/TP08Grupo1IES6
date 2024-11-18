package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Producto;
import ar.edu.ies6.service.IProductoService;

public class ProductoController {
	
	@Controller 
	public class AlumnoController {
		@Autowired
		Producto unProducto;
		@Qualifier("servicioProductoBD")
		@Autowired
		IProductoService productoService;
	@GetMapping("/Grupo1")
	public String getIndex() {
	    System.out.println("esta pasando por aqui");
	    return "grupo1";
	}
	@GetMapping("/Producto")
	public ModelAndView getIndexWithAlumno() {
		//transporte hacia la vista
	ModelAndView Transportador = new ModelAndView("formProducto");
	Transportador.addObject("producto", unProducto);
	Transportador.addObject("band", false);
	return Transportador;
	}
	@GetMapping("/listadoProductos")
	public ModelAndView getAllProducto() {
		//transporte hacia la vista
	ModelAndView Transportador = new ModelAndView("listaProductos");
	Transportador.addObject("listadoProductos",productoService.);
	return Transportador;
	}
	//guardar
	@PostMapping("/guardarAlumno")
	public ModelAndView guardarAlumno(Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		ModelAndView Transportador = new ModelAndView("listaAlumnos");
		Transportador.addObject("listadoAlumnos",alumnoService.ListarAlumnosActivos());
		return Transportador;
	}
	//eliminar
	@GetMapping ("/eliminarAlumno/{dni}")
	public ModelAndView deleteAlumno (@PathVariable (name="dni") String dni){
		alumnoService.eliminarAlumno(dni);
		//mostrar el nuevo listado
		 ModelAndView modelView = new ModelAndView ("listaAlumnos");
		 modelView.addObject("listadoAlumnos",alumnoService.ListarAlumnosActivos());
		 return modelView;
	}
	//modificar
	@GetMapping ("/modificarAlumno/{dni}")
	public ModelAndView ModificarAlumno(@PathVariable (name="dni") String dni) {
		//el parametro de ModelAndView es una vista HTML
		ModelAndView modelView = new ModelAndView ("formAlumno");
		modelView.addObject("alumno",alumnoService.consultarAlumno(dni));
		modelView.addObject("band", true);
		return modelView;
	}
	}

}
