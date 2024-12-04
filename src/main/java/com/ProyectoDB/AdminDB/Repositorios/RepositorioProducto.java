package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Cliente;
import com.ProyectoDB.AdminDB.Modelos.Producto;
import com.ProyectoDB.AdminDB.Modelos.Proveedor;
import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface RepositorioProducto extends JpaRepository<Producto,Integer> {

    List<Producto> findAll();

    List<Producto> findByNombreproductoContainingIgnoreCase(String nombre_producto);

    Optional<Producto> findByIdproducto(Integer idProducto);

    @Transactional
    void deleteByIdproducto(Integer id);



}
