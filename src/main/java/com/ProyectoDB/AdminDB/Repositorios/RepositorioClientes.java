package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Cliente;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioClientes extends JpaRepository<Cliente,Integer> {
    List<Cliente> findAll();

    @Transactional
    void deleteByIdcliente(Integer id);

    Optional<Cliente>findByIdcliente(Integer Id);
}
