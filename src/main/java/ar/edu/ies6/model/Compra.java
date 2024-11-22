package ar.edu.ies6.model;

import jakarta.persistence.*;
import ar.edu.ies6.model.Cliente;
import ar.edu.ies6.model.Producto;
import java.time.LocalDate;

@Entity
public class Compra {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_dni", referencedColumnName = "dni")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column
    private LocalDate fecha;

    @Column
    private Integer cantidad;

    public Compra() {
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
