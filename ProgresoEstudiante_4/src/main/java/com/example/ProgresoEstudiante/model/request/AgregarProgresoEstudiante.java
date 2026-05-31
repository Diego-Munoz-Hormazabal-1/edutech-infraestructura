package com.example.ProgresoEstudiante.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarProgresoEstudiante {

    @NotNull(message = "El id de usuario no puede ser nulo")
    private Integer idUsuario;

    @NotBlank(message = "El progreso del estudiante no puede estar vacío")
    private String progresoEstudiante;

    @NotBlank(message = "La evaluación no puede estar vacía")
    private String evaluacion;
}