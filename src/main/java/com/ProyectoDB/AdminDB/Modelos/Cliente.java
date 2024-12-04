package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name = "cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idcliente;
    @Column(length = 30, nullable = false)
    private String nombre_cliente,apellidos_cliente;
    @Column(length = 15, nullable = false)
    private String telefono_cliente;
    @Column(length = 50)
    private String email_cliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venta> ventas;

}
