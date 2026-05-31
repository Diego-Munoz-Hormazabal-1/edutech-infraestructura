package com.example.ProgresoEstudiante.repository;

import org.springframework.stereotype.Repository;

import com.example.ProgresoEstudiante.model.entitie.ProgresoEstudiante;

@Repository
public interface ProgresoEstudianteRepository extends org.springframework.data.jpa.repository.JpaRepository<ProgresoEstudiante, Integer> {
}