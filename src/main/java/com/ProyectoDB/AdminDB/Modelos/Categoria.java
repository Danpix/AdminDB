package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idcategoria;
    @Column (name = "nombre_categoria", length = 30, nullable = false)
    private String nombrecategoria;
    @Column (length = 100, nullable = false)
    private String descipcion;

    @OneToMany(mappedBy = "categoria")
    private List<Producto>productos;
}
