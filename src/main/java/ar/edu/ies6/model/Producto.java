package ar.edu.ies6.model;

import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Component
@Entity
public class Producto {
	@Id
private String codigo;
	@Column
private String nombre;
	@Column
private String descripcion;
	@Column
private String categoria;
	@Column
private String proveedor;
	@Column
private Double precio;
	 @OneToMany(mappedBy = "producto")
	    private List<Compra> compras;
	 @Lob
	 @Column(columnDefinition="LONGTEXT")
private String foto;

public Producto() {
	// TODO Auto-generated constructor stub
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public String getProveedor() {
	return proveedor;
}

public void setProveedor(String proveedor) {
	this.proveedor = proveedor;
}

public Double getPrecio() {
	return precio;
}

public void setPrecio(Double precio) {
	this.precio = precio;
}

public List<Compra> getCompras() {
	return compras;
}

public void setCompras(List<Compra> compras) {
	this.compras = compras;
}

public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}

}


