package com.ProyectoDB.AdminDB.Servicios;

import com.ProyectoDB.AdminDB.Modelos.Empleado;
import com.ProyectoDB.AdminDB.Repositorios.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void eliminarEmpleado(Integer id){
        repositorioEmpleado.deleteByIdempleado(id);
    }
    public void GuardarEmpleados(Empleado empleado){
        repositorioEmpleado.save(empleado);
    }

    public Empleado modificarUsuario(Integer idempleado, String nuevoNombre, String apellido,String Contraseña,String rfc) {
        // Buscar el usuario por idempleado
        Optional<Empleado> usuarioOptional = repositorioEmpleado.findByIdempleado(idempleado);

        if (usuarioOptional.isPresent()) {
            // Si el usuario existe, actualiza los campos
            Empleado empleado = usuarioOptional.get();
            empleado.setUsername(nuevoNombre);
            empleado.setApellidos_empleado(apellido);
            empleado.setPassword(Contraseña);
            empleado.setRfc_emp(rfc);
            return repositorioEmpleado.save(empleado); // Guarda los cambios
        } else {
            throw new IllegalArgumentException("El usuario con idempleado " + idempleado + " no existe.");
        }
    }
}
