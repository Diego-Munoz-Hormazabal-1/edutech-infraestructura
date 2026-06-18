package com.example.Curso.model.entitie;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "curso")
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(name = "nombre_curso", nullable = false)
    private String nombreCurso;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "asignatura", nullable = false)
    private String asignatura;

    //id del profesor
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
}
