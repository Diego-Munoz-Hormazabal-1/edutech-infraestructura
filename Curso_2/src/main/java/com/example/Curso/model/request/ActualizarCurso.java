package com.example.Curso.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarCurso {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombreCurso;

    @NotBlank(message = "El contenido no puede estar vacío")
    private String contenido;

    @NotBlank(message = "La asignatura no puede estar vacío")
    private String asignatura;

    @NotNull(message = "El ID de usuario no puede estar vacío")
    private Integer idUsuario; 
}