package com.example.Curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Curso.model.entitie.Curso;
import com.example.Curso.model.request.ActualizarCurso;
import com.example.Curso.model.request.AgregarCurso;
import com.example.Curso.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    

    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCursoPorID(int idCurso) {
        return cursoRepository.findById(idCurso)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado."));
    }

    /*
     * ========================================
     * AGREGAR CURSO
     * ========================================
     */
    public Curso agregarCurso(AgregarCurso nuevoCurso) {
        Curso curso = new Curso();
        curso.setNombreCurso(nuevoCurso.getNombreCurso());
        curso.setContenido(nuevoCurso.getContenido());
        curso.setAsignatura(nuevoCurso.getAsignatura());
        curso.setIdUsuario(nuevoCurso.getIdUsuario()); 
        return cursoRepository.save(curso);
    }

    /*
     * ========================================
     * ACTUALIZAR CURSO
     * ========================================
     */
    public Curso actualizarCurso(ActualizarCurso actualizarCurso, int idCurso) {
        Curso cursoExistente = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontrado"));

        

        cursoExistente.setNombreCurso(actualizarCurso.getNombreCurso());
        cursoExistente.setContenido(actualizarCurso.getContenido());
        cursoExistente.setAsignatura(actualizarCurso.getAsignatura());
        cursoExistente.setIdUsuario(actualizarCurso.getIdUsuario()); 

        return cursoRepository.save(cursoExistente);
    } 

    /*
     * ========================================
     * ELIMINAR CURSO
     * ========================================
     */
    public String eliminarCurso(int idCurso) {
        if (cursoRepository.existsById(idCurso)) {
            cursoRepository.deleteById(idCurso);
            return "Curso eliminado correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el curso para eliminar.");
        }
    }

    
} 