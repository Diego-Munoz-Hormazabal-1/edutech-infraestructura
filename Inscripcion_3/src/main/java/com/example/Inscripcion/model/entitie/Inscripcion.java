package com.example.Inscripcion.model.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    @Column(name = "pago_inscripcion", nullable = false)
    private String pagoInscripcion; 

    @Column(name = "cupon_descuento", nullable = false)
    private String cuponDescuento;  

    @Column(name = "estado", nullable = false)
    private String estado;
}