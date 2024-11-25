package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Repositorios.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosServicio {
    @Autowired
    private RepositorioEmpleado repositorioEmpleado;
    public boolean validarUsuario(String username, String password) {
        return repositorioEmpleado.findByUsernameAndPassword(username, password).isPresent();
    }
}
