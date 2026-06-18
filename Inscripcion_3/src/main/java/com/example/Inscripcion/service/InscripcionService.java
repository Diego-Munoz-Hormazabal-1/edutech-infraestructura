package com.example.Inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.Inscripcion.model.entitie.Inscripcion;
import com.example.Inscripcion.model.request.ActualizarInscripcion;
import com.example.Inscripcion.model.request.AgregarInscripcion;
import com.example.Inscripcion.repository.InscripcionRepository;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    @Qualifier("usuarioWebClient") 
    private WebClient usuarioWebClient;

    // LISTAR TODAS LAS INSCRIPCIONES
    public List<Inscripcion> obtenerTodosLosInscripcion() {
        return inscripcionRepository.findAll();
    }

    // OBTENER INSCRIPCIÓN POR ID
    public Inscripcion obtenerInscripcionPorID(int idInscripcion) {
        return inscripcionRepository.findById(idInscripcion)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscripción no encontrada."));
    }

    // AGREGAR INSCRIPCIÓN
    public Inscripcion agregarInscripcion(AgregarInscripcion nuevaInscripcion) {

        // ... Toda tu lógica de validación con WebClient queda exactamente igual ...

        // Mapear DTO a Entidad 
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setIdUsuario(nuevaInscripcion.getIdUsuario());
        inscripcion.setIdCurso(nuevaInscripcion.getIdCurso());
        inscripcion.setPagoInscripcion(nuevaInscripcion.getPagoInscripcion());
        inscripcion.setCuponDescuento(nuevaInscripcion.getCuponDescuento());
        
      
        inscripcion.setEstado("ACTIVA"); 

        return inscripcionRepository.save(inscripcion);
    }



    // ELIMINAR INSCRIPCIÓN
    public String eliminarInscripcion(int idInscripcion) {
        if (inscripcionRepository.existsById(idInscripcion)) {
            inscripcionRepository.deleteById(idInscripcion);
            return "Inscripción eliminada correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se encontró la inscripción a eliminar.");
        }
    }

    public Inscripcion actualizarInscripcion(int idInscripcion, ActualizarInscripcion actualizacion) {
    // 1. Buscar si existe
    Inscripcion inscripcion = obtenerInscripcionPorID(idInscripcion);

    // 2. Validar el usuario con WebClient (Puerto 5000)
    try {
        usuarioWebClient.get()
                .uri("/usuarios/{idUsuario}", actualizacion.getIdUsuario())
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al conectar con el servicio de usuarios o el usuario no existe.");
    }

    // 3. Asignación directa y simple
    inscripcion.setIdUsuario(actualizacion.getIdUsuario());
    inscripcion.setIdCurso(actualizacion.getIdCurso());
    inscripcion.setPagoInscripcion(actualizacion.getPagoInscripcion());
    inscripcion.setCuponDescuento(actualizacion.getCuponDescuento());

    return inscripcionRepository.save(inscripcion);
    }
}