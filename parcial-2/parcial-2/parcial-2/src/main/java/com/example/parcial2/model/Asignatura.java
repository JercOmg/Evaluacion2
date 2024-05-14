package com.example.parcial2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    private long profesorId;
    @Column(length = 30, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String descripcion;
    private long salon;
    private LocalDateTime inicioClases;
    private LocalDateTime finClases;
    private boolean estado;

}
