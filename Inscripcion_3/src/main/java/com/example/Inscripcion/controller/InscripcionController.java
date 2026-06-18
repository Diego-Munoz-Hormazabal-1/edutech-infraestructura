package com.example.Inscripcion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; // <-- Asegúrate de agregar esta importación
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inscripcion.model.entitie.Inscripcion;
import com.example.Inscripcion.model.request.AgregarInscripcion;
import com.example.Inscripcion.model.request.ActualizarInscripcion; // <-- Importamos tu request de actualización
import com.example.Inscripcion.service.InscripcionService;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService service;

    @GetMapping
    public List<Inscripcion> listar() {
        return service.obtenerTodosLosInscripcion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(service.obtenerInscripcionPorID(id));
    }

    @PostMapping
    public ResponseEntity<Inscripcion> crear(@RequestBody AgregarInscripcion nuevaInscripcion) {
        return ResponseEntity.ok(service.agregarInscripcion(nuevaInscripcion));
    }

    // 🛠️ AGREGA ESTE MÉTODO PARA SOLUCIONAR EL ERROR 405
    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> actualizar(@PathVariable int id, @RequestBody ActualizarInscripcion actualizacion) {
        return ResponseEntity.ok(service.actualizarInscripcion(id, actualizacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        return ResponseEntity.ok(service.eliminarInscripcion(id));
    }
}