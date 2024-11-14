package ar.edu.ies6.model;

public class Producto {
private String codigo;
private String nombre;
private String descripcion;
private String categoria;
private String proveedor;
private Double precio;

public Producto() {
	// TODO Auto-generated constructor stub
}

public String getCodigo() {
	return codigo;
}

public String getNombre() {
	return nombre;
}

public String getDescripcion() {
	return descripcion;
}

public String getCategoria() {
	return categoria;
}

public String getProveedor() {
	return proveedor;
}

public Double getPrecio() {
	return precio;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public void setProveedor(String proveedor) {
	this.proveedor = proveedor;
}

public void setPrecio(Double precio) {
	this.precio = precio;
}

}
