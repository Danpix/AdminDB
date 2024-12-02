package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria,Integer> {


    @Query("SELECT c.nombrecategoria FROM Producto p JOIN p.categoria c WHERE c.idcategoria = :idcategoria")
    List<String> findNombreCategoriaByIdCategoria(@Param("id_categoria") Integer idCategoria);
}
