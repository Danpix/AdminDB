package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface RepositorioEmpleado extends JpaRepository<Empleado,Integer> {
    Optional<Empleado>findByUsernameAndPassword(String nombre,String Contraseña);

}
