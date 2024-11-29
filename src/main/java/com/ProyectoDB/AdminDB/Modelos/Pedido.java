package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "pedido")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    @Column(nullable = false)
    private Integer cantidad_producto,precio_unitario,subtotal;

    @ManyToOne
    @JoinColumn(name = "id_proveedor",nullable = false)
    private Proveedor proveedor;



    @ManyToMany(mappedBy = "pedido")
    private List<Producto> productos;
}
