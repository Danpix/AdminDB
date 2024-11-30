package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    @Column(nullable = false)
    private Integer unidades_existencia,precio_compra,precio_venta;
    @Column(name = "nombre_producto",nullable = false, length = 30)
    private String nombreproducto;

    @ManyToMany(mappedBy = "productos")
    private List<DetalleVenta>detalleVentas;

    @ManyToOne
    @JoinColumn(name = "id_categoria",nullable = false)
    private Categoria categoria;

    @ManyToMany
    @JoinTable( //CREACION DE TABLA INTERMEDIA NECESARIA PARA LA RELACION MUCHOS A MUCHOS
            name = "pedido_producto",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )private List<Pedido> pedido;
}
