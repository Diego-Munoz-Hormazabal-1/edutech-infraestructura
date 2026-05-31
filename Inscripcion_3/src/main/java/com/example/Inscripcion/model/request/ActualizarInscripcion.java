package com.example.Inscripcion.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarInscripcion {
    @NotNull(message = "El ID de usuario no puede estar vacío")
    private Integer idUsuario;

    @NotNull(message = "El ID de curso no puede estar vacío")
    private Integer idCurso;

    @NotBlank(message = "El estado del pago no puede estar vacío")
    private String pagoInscripcion; 

    @NotBlank(message = "El cupón de descuento no puede estar vacío")
    private String cuponDescuento;  
}