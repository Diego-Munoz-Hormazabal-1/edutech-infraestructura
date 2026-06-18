# Microservicio: Inscripcion_3 

Este microservicio gestiona el proceso de matrícula e inscripción de los alumnos en los diferentes cursos, actuando como orquestador entre el servicio de Usuarios y el de Cursos.

##  Funcionalidades
A través de `InscripcionService`, el sistema asegura:
* **Control de Matrículas:** Registro de inscripciones con estado inicial "ACTIVA".
* **Validación Cruzada:** Uso de `WebClient` con `@Qualifier("usuarioWebClient")` para verificar la existencia del usuario en el puerto 5000 antes de procesar la inscripción o actualización.
* **Gestión de Pagos:** Registro de montos de inscripción y aplicación de cupones de descuento.
* **CRUD Completo:** Endpoints para listar, buscar por ID, actualizar y dar de baja inscripciones.

##  Instrucciones de Maven (Requisito Examen)
Comandos esenciales para el mantenimiento del microservicio:

### Ejecutar Pruebas y Test
Valida la conectividad y las reglas de negocio de las inscripciones:
```bash
./mvnw test