package com.example.ProgresoEstudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.ProgresoEstudiante.model.entitie.ProgresoEstudiante;
import com.example.ProgresoEstudiante.model.request.ActualizarProgresoEstudiante;
import com.example.ProgresoEstudiante.model.request.AgregarProgresoEstudiante;
import com.example.ProgresoEstudiante.repository.ProgresoEstudianteRepository;

@Service
public class ProgresoEstudianteService {

    @Autowired
    private ProgresoEstudianteRepository repository;

    @Autowired
    @Qualifier("usuarioWebClient")
    private WebClient usuarioWebClient;

    // ==========================================
// 1. AGREGAR PROGRESO (POST)
// ==========================================
public ProgresoEstudiante agregarProgreso(AgregarProgresoEstudiante nuevoProgreso) {
    // Validación externa mediante WebClient
    try {
        usuarioWebClient.get()
                .uri("/usuarios/{idUsuario}", nuevoProgreso.getIdUsuario())
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al conectar con el servicio de usuarios o el alumno no existe.");
    }

    // Mapeo manual a la Entidad
    ProgresoEstudiante progreso = new ProgresoEstudiante();
    progreso.setIdUsuario(nuevoProgreso.getIdUsuario());
    
    // Asignación directa sin conversiones molestas
    progreso.setPorcentajeAvance(nuevoProgreso.getProgresoEstudiante()); 
    progreso.setEstado(nuevoProgreso.getEvaluacion());

    return repository.save(progreso);
}
    // ==========================================
    // 2. ACTUALIZAR PROGRESO (PUT)
    // ==========================================
    public ProgresoEstudiante actualizarProgreso(int idProgreso, ActualizarProgresoEstudiante actualizacion) {
        // Verificar primero que el registro local exista
        ProgresoEstudiante progreso = repository.findById(idProgreso)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Progreso no encontrado."));

        // Validación externa mediante WebClient
        try {
            usuarioWebClient.get()
                    .uri("/usuarios/{idUsuario}", actualizacion.idUsuario())
                    .retrieve()
                    .bodyToMono(Object.class)
                    .block();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al conectar con el servicio de usuarios o el alumno no existe.");
        }

        // Actualización de campos usando la sintaxis del Record
        progreso.setIdUsuario(actualizacion.idUsuario());
        progreso.setPorcentajeAvance(Double.valueOf(actualizacion.progresoEstudiante()));
        progreso.setEstado(actualizacion.evaluacion());

        return repository.save(progreso);
    }

    // ==========================================
    // 3. LISTAR TODOS LOS PROGRESOS (GET)
    // ==========================================
    public List<ProgresoEstudiante> listarTodos() {
        return repository.findAll();
    }

    // ==========================================
    // 4. OBTENER UN PROGRESO POR ID (GET /{id})
    // ==========================================
    public ProgresoEstudiante obtenerPorId(int idProgreso) {
        return repository.findById(idProgreso)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Progreso con ID " + idProgreso + " no encontrado."));
    }

    // ==========================================
    // 5. ELIMINAR PROGRESO (DELETE)
    // ==========================================
    public void eliminarProgreso(int idProgreso) {
        ProgresoEstudiante progreso = repository.findById(idProgreso)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No se puede eliminar. Progreso no encontrado."));
        
        repository.delete(progreso);
    }
}