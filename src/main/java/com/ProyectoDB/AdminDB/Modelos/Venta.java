package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "venta")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folio_venta")
    private Integer folioventa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "id_empleado",nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable = false, referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToOne
    private DetalleVenta detalleVenta;
}
