package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "proveedor")
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;
    @Column(length = 30,nullable = false)
    private String nombre_prov,email_prov;
    @Column(length = 10,nullable = false)
    private String telefono_prov;
}
