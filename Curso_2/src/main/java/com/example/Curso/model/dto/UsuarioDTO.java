package com.example.Curso.model.dto;

public record UsuarioDTO(
    Integer idUsuario,
    String nombre,
    String email,
    String rol
) {}