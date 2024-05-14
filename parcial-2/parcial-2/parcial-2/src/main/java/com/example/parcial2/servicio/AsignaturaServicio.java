package com.example.parcial2.servicio;

import com.example.parcial2.model.Asignatura;
import com.example.parcial2.model.UserE;
import com.example.parcial2.repositorio.AsignaturaRepositorio;
import com.example.parcial2.repositorio.UserRepositorio;
import com.example.parcial2.request.CrearAsignatura;
import com.example.parcial2.type.type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServicio {

    private final AsignaturaRepositorio asignaturaRepositorio;
    private final UserRepositorio userRepositorio;

    public AsignaturaServicio(AsignaturaRepositorio asignaturaRepositorio, UserRepositorio userRepositorio) {
        this.asignaturaRepositorio = asignaturaRepositorio;
        this.userRepositorio = userRepositorio;
    }

    public void deleteById(long id){
        asignaturaRepositorio.deleteById(id);
    }

    public void findById(long id) {
        asignaturaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Asignatura not found"));
    }

    public List<Asignatura> findAll(){
        return asignaturaRepositorio.findAll();
    }

    public Asignatura created(CrearAsignatura crearAsignatura){
        if (crearAsignatura.getHoraInicio().isAfter(crearAsignatura.getHoraFin())){
            throw new RuntimeException("La hora de inicio no puede ser mayor a la hora de fin");
        }
        UserE user = userRepositorio.findById(crearAsignatura.getProfesorid()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getRole().equals(type.DOCENTE.name())){
            throw new RuntimeException("El usuario no es un profesor");
        }
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(crearAsignatura.getNombre());
        asignatura.setDescripcion(crearAsignatura.getDescripcion());
        asignatura.setInicioClases(crearAsignatura.getHoraInicio());
        asignatura.setFinClases(crearAsignatura.getHoraFin());
        asignatura.setProfesorId(user.getId());
        return asignaturaRepositorio.save(asignatura);
    }
}
