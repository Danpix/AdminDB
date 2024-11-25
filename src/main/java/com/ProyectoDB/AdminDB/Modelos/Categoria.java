package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;
    @Column (length = 30, nullable = false)
    private String nombre_categoria;
    @Column (length = 100, nullable = false)
    private String descipcion;
}
