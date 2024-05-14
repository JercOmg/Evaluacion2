package com.example.parcial2.controlador;

import com.example.parcial2.model.UserE;
import com.example.parcial2.request.UserCrear;
import com.example.parcial2.servicio.UserServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControlador {

    private final UserServicio userServicio;

    public UserControlador(UserServicio userServicio) {
        this.userServicio = userServicio;
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        userServicio.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public void findById(@PathVariable long id){
        userServicio.findById(id);
    }

    @GetMapping("/all")
    public List<UserE> findAll(){
        return userServicio.findAll();
    }

    @PostMapping("/crear/profesor")
    public void createProfesor(@RequestBody UserCrear userCrear){
        userServicio.createProfesor(userCrear);
    }

    @PostMapping("/crear/estudiante")
    public void createEstudiante(@RequestBody UserCrear userCrear){
        userServicio.createEstudiante(userCrear);
    }
}
