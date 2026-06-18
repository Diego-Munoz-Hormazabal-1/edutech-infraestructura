CREATE DATABASE IF NOT EXISTS edutech_usuarios;
CREATE DATABASE IF NOT EXISTS edutech_cursos;
CREATE DATABASE IF NOT EXISTS edutech_inscripciones;
CREATE DATABASE IF NOT EXISTS edutech_progreso;

CREATE USER IF NOT EXISTS 'full_stack_1'@'%' IDENTIFIED BY 'Tav_2026.@';
GRANT ALL PRIVILEGES ON edutech_usuarios.* TO 'full_stack_1'@'%';
GRANT ALL PRIVILEGES ON edutech_cursos.* TO 'full_stack_1'@'%';
GRANT ALL PRIVILEGES ON edutech_inscripciones.* TO 'full_stack_1'@'%';
GRANT ALL PRIVILEGES ON edutech_progreso.* TO 'full_stack_1'@'%';
FLUSH PRIVILEGES;