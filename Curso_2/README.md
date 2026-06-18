# Microservicio: Curso_2 

Este microservicio gestiona el catálogo de cursos disponibles, los instructores asignados y la vinculación con contenidos educativos externos.

##  Funcionalidades
A través de `CursoService`, el sistema permite:
* **Gestión de Catálogo:** CRUD completo para la entidad Curso.
* **Validación Externa:** Implementa `WebClient` para validar que el contenido educativo exista en un servicio externo antes de permitir el registro o actualización.
* **Asignación de Instructores:** Control de quién imparte cada curso y su relación con el usuario creador.

##  Instrucciones de Maven (Requisito Examen)
Utilice estos comandos para la gestión del ciclo de vida del desarrollo:

### Ejecutar Pruebas y Test
Para validar la lógica de creación de cursos y las integraciones:
```bash
./mvnw test