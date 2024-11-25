package com.ProyectoDB.AdminDB.Repositorios;

import com.ProyectoDB.AdminDB.Modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCategoria extends JpaRepository<Categoria,Integer> {
}
