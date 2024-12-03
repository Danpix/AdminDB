package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadosServicio {
    @Autowired
    private RepositorioEmpleado repositorioEmpleado;
    public boolean validarUsuario(String username, String password) {
        return repositorioEmpleado.findByUsernameAndPassword(username, password).isPresent();
    }
    public List<Empleado> MostrarTodos(){
        return repositorioEmpleado.findAll();
    }
}
