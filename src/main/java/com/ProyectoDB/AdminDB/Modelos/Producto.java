package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    @Column(nullable = false)
    private Integer id_categoria,unidades_existencia,precio_compra,precio_venta;
    @Column(nullable = false, length = 30)
    private String nombre_producto;

}
