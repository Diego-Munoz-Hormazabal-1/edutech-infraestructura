package com.example.Inscripcion.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarInscripcion {

    @NotNull(message = "El ID de usuario no puede estar vacío")
    private Integer idUsuario;

    @NotNull(message = "El ID de curso no puede estar vacío")
    private Integer idCurso; // Lo necesitas para que viaje por WebClient a buscar el curso

    @NotBlank(message = "El estado del pago no puede estar vacío")
    private String pagoInscripcion; // Mismo nombre que en tu entidad

    @NotBlank(message = "El cupón de descuento no puede estar vacío")
    private String cuponDescuento;  // Mismo nombre que en tu entidad
}