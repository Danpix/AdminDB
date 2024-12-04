package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Cliente;
import com.ProyectoDB.AdminDB.Modelos.Proveedor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioProveedor extends JpaRepository<Proveedor,Integer> {
    List<Proveedor> findAll();

    @Transactional
    void deleteByIdproveedor(Integer id);

    Optional<Proveedor> findByIdproveedor(Integer Id);
}
