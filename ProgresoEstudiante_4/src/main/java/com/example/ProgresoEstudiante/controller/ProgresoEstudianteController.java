package com.example.ProgresoEstudiante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProgresoEstudiante.model.entitie.ProgresoEstudiante;
import com.example.ProgresoEstudiante.model.request.ActualizarProgresoEstudiante;
import com.example.ProgresoEstudiante.model.request.AgregarProgresoEstudiante;
import com.example.ProgresoEstudiante.service.ProgresoEstudianteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/progresos")
public class ProgresoEstudianteController {

    @Autowired
    private ProgresoEstudianteService service;

    // 1. OBTENER TODOS LOS PROGRESOS (El que te daba el error 404)
    @GetMapping
    public ResponseEntity<List<ProgresoEstudiante>> listarTodos() {
        List<ProgresoEstudiante> progresos = service.listarTodos();
        return ResponseEntity.ok(progresos);
    }

    // 2. OBTENER UN PROGRESO ESPECÍFICO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ProgresoEstudiante> obtenerPorId(@PathVariable int id) {
        ProgresoEstudiante progreso = service.obtenerPorId(id);
        return ResponseEntity.ok(progreso);
    }

    // 3. CREAR UN NUEVO AVANCE / PROGRESO
    @PostMapping
    public ResponseEntity<ProgresoEstudiante> crear(@Valid @RequestBody AgregarProgresoEstudiante request) {
        ProgresoEstudiante nuevoProgreso = service.agregarProgreso(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProgreso);
    }

    // 4. ACTUALIZAR UN AVANCE / PROGRESO EXISTENTE
    @PutMapping("/{id}")
    public ResponseEntity<ProgresoEstudiante> actualizar(
            @PathVariable int id, 
            @Valid @RequestBody ActualizarProgresoEstudiante request) {
        ProgresoEstudiante progresoActualizado = service.actualizarProgreso(id, request);
        return ResponseEntity.ok(progresoActualizado);
    }

    // 5. ELIMINAR UN PROGRESO (Opcional, pero ideal para completar el CRUD)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        service.eliminarProgreso(id);
        return ResponseEntity.noContent().build();
    }
}