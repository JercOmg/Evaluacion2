package com.example.parcial2.servicio;

import com.example.parcial2.model.UserE;
import com.example.parcial2.repositorio.UserRepositorio;
import com.example.parcial2.request.InicioSesion;
import com.example.parcial2.request.UserCrear;
import com.example.parcial2.type.type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicio {

    private final UserRepositorio userRepositorio;

    public UserServicio(UserRepositorio userRepositorio) {
        this.userRepositorio = userRepositorio;
    }

    public UserE createProfesor(UserCrear userCrear){
        if (!userCrear.getPassword().equals(userCrear.getPasswordConfirm())){
            throw new RuntimeException("las contraseñas no coinciden");
        }
        UserE user = new UserE();
        user.setName(userCrear.getName());
        user.setLastName(userCrear.getLastName());
        user.setEmail(userCrear.getEmail());
        user.setPassword(userCrear.getPassword());
        user.setRole(type.DOCENTE.name());
        return userRepositorio.save(user);
    }


    public UserE createEstudiante(UserCrear userCrear){
        if (!userCrear.getPassword().equals(userCrear.getPasswordConfirm())){
            throw new RuntimeException("las contraseñas no coinciden");
        }
        UserE user = new UserE();
        user.setName(userCrear.getName());
        user.setLastName(userCrear.getLastName());
        user.setEmail(userCrear.getEmail());
        user.setPassword(userCrear.getPassword());
        user.setRole(type.ESTUDIANTE.name());
        return userRepositorio.save(user);
    }


    public UserE findById(long id){
        return userRepositorio.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }


    public List<UserE> findAll(){
        return userRepositorio.findAll();
    }

    public void deleteById(long id){
        userRepositorio.deleteById(id);
    }

    public void signIn(InicioSesion inicioSesion){
        UserE user = userRepositorio.findByEmail(inicioSesion.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getPassword().equals(inicioSesion.getPassword())){
            throw new RuntimeException("Contraseña incorrecta");
        }
        if (!user.isStatus()){
            throw new RuntimeException("Usuario inactivo");
        }
    }
}
