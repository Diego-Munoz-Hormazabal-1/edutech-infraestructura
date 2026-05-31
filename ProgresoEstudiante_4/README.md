# Microservicio: ProgresoEstudiante_4 

Este microservicio se encarga de monitorear y registrar el avance académico de los estudiantes en sus respectivos cursos, permitiendo un seguimiento detallado del rendimiento.

##  Funcionalidades
A través de `ProgresoEstudianteService`, el sistema gestiona:
* **Seguimiento de Avance:** Registro porcentual del progreso del alumno.
* **Evaluación de Estado:** Clasificación del estado académico (Evaluación).
* **Integración con Usuarios:** Validación obligatoria mediante `WebClient` para asegurar que el progreso se asigne a un alumno existente en el sistema.
* **Conversión de Datos:** Manejo de tipos de datos complejos y mapeo desde Records de Java.

##  Instrucciones de Maven (Requisito Examen)
Comandos para la gestión del proyecto:

### Ejecutar Pruebas y Test
Para verificar los cálculos de avance y la conectividad:
```bash
./mvnw test