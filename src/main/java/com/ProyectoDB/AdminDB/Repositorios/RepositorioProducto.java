package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Producto;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RepositorioProducto extends JpaRepository<Producto,Integer> {

    List<Producto> findAll();

    List<Producto> findByNombreproductoContaining(String nombre_producto);
}
