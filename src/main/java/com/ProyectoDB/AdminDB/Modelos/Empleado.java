package com.ProyectoDB.AdminDB.Modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empleado")
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empleado;
    @Column(length = 13, nullable = false)
    private String rfc_emp;
    @Column(length = 30, nullable = false)
    private String username,apellidos_empleado;
    @Column(length = 10, nullable = false)
    private String password;
    @Column(length = 40, nullable = false)
    private String puesto_emp;
}
