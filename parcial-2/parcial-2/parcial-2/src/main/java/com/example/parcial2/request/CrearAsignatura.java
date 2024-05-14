package com.example.parcial2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearAsignatura {

    private long profesorid;
    private String nombre;
    private String descripcion;
    private long salon;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
}
