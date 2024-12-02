package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Producto;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RepositorioProducto extends JpaRepository<Producto,Integer> {

    List<Producto> findAll();

    List<Producto> findByNombreproductoContainingIgnoreCase(String nombre_producto);

    List<Producto> findByIdproducto(Integer idProducto);
}
