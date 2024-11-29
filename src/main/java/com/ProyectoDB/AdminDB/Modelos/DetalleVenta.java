package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name = "detalleventa")
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle;
    @Column(nullable = false)
    private Integer id_empledo,cantidad,subtotal;

    @ManyToMany
    @JoinTable( //CREACION DE TABLA INTERMEDIA NECESARIA PARA LA RELACION MUCHOS A MUCHOS
            name = "detalle_producto",
            joinColumns = @JoinColumn(name = "id_detalle"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )private List<Producto> productos;


    @OneToOne
    @JoinColumn(name = "id_venta",nullable = false)
    private Venta venta;
}
