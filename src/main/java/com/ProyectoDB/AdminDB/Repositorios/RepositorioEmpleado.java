package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado,Integer> {
    Optional<Empleado>findByUsernameAndPassword(String nombre,String Contraseña);

    Optional<Empleado>findByIdempleado(Integer Idempleado);

    List<Empleado> findAll();
    @Transactional
    void deleteByIdempleado(Integer id);


}
