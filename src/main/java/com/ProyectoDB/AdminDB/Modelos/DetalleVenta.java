package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "detalleventa")
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle;
    @Column(nullable = false)
    private Integer id_venta,id_producto,id_empledo,cantidad,subtotal;
}
