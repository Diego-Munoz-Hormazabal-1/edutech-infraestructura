package com.example.Curso.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // Agregado para mejores respuestas
import org.springframework.web.bind.annotation.*;

import com.example.Curso.model.entitie.Curso;
import com.example.Curso.model.request.ActualizarCurso;
import com.example.Curso.model.request.AgregarCurso;
import com.example.Curso.service.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("cursos") 
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("")
    public List<Curso> obtenerTodosLosCursos() {
        return cursoService.obtenerTodosLosCursos();
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable int idCurso) {
        // Usar ResponseEntity es una buena práctica para devolver códigos de estado claros
        return ResponseEntity.ok(cursoService.obtenerCursoPorID(idCurso));
    }

    @PostMapping("")
    public ResponseEntity<Curso> agregarCurso(@Valid @RequestBody AgregarCurso nuevoCurso) {
        // Retornamos 201 Created al crear un recurso
        return new ResponseEntity<>(cursoService.agregarCurso(nuevoCurso), HttpStatus.CREATED);
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<Curso> actualizarCurso(
            @PathVariable int idCurso,
            @Valid @RequestBody ActualizarCurso actualizar) {
        
        return ResponseEntity.ok(cursoService.actualizarCurso(actualizar, idCurso));
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<String> eliminarCurso(@PathVariable int idCurso) {
        String mensaje = cursoService.eliminarCurso(idCurso);
        return ResponseEntity.ok(mensaje);
    }
}
