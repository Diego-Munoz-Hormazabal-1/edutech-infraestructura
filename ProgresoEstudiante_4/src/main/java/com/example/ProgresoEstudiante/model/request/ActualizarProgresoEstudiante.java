package com.example.ProgresoEstudiante.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarProgresoEstudiante(
    @NotNull(message = "El id de usuario no puede ser nulo")
    Integer idUsuario,

    @NotBlank(message = "El progreso del estudiante no puede estar vacío")
    String progresoEstudiante, 

    @NotBlank(message = "La evaluacion no puede estar vacía")
    String evaluacion
) {}