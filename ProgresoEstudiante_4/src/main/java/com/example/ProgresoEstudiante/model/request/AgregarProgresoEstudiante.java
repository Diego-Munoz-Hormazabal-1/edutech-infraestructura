package com.example.ProgresoEstudiante.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarProgresoEstudiante {

    @NotNull(message = "El id de usuario no puede ser nulo")
    private Integer idUsuario;

    
    private Double progresoEstudiante;

    @NotBlank(message = "La evaluación no puede estar vacía")
    private String evaluacion;
}