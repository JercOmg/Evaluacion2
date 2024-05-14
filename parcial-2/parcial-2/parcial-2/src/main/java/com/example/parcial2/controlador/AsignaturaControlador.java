package com.example.parcial2.controlador;

import com.example.parcial2.model.Asignatura;
import com.example.parcial2.request.CrearAsignatura;
import com.example.parcial2.servicio.AsignaturaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/asignatura")
@RestController
public class AsignaturaControlador {

    private final AsignaturaServicio asignaturaServicio;

    public AsignaturaControlador(AsignaturaServicio asignaturaServicio) {
        this.asignaturaServicio = asignaturaServicio;
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        asignaturaServicio.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public void findById(@PathVariable long id){
        asignaturaServicio.findById(id);
    }

    @GetMapping("/all")
    public List<Asignatura> findAll(){
        return asignaturaServicio.findAll();
    }

    @PostMapping("/save")
    public void created(@RequestBody CrearAsignatura crearAsignatura){
        asignaturaServicio.created(crearAsignatura);
    }
}
