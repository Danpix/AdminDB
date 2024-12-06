package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Venta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioVenta extends JpaRepository<Venta,Integer> {
    List<Venta> findAll();
    @Transactional
    void deleteByFolioventa(Integer id);
}
