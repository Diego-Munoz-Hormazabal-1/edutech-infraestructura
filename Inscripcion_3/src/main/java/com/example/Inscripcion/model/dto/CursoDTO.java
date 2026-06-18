package com.example.Inscripcion.model.dto;

public record CursoDTO(
    Integer idCurso,
    String nombreCurso,
    String contenido,
    String instructor
) {}