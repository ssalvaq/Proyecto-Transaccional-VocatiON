-- Limpiar datos antiguos en las tablas
DELETE FROM usuarios;
DELETE FROM estudiantes;
DELETE FROM expertos;
DELETE FROM carreras;
DELETE FROM test_Vocacionales;
DELETE FROM resultados_Test;
DELETE FROM resultados_Carrera;
DELETE FROM compras;
DELETE FROM planes_Premium;
DELETE FROM recursos;
DELETE FROM recursos_Premium;
DELETE FROM asesorias;

-- Insertar datos en la tabla 'usuarios'
INSERT INTO usuarios (id, nombre, email, contraseña, direccion, telefono, tipo, created_at, updated_at, roles) VALUES
                                                                                                                   (1, 'Juan Pérez', 'juan.perez@example.com', 'contraseña123', 'Calle Falsa 123', 123456789, 'Estudiante', '2024-09-18 10:00:00', NULL, 'ESTUDIANTE'),
                                                                                                                   (2, 'Ana Gómez', 'ana.gomez@example.com', 'contraseña123', 'Avenida Siempre Viva 456', 987654321, 'Experto', '2024-09-18 10:00:00', NULL, 'EXPERTO'),
                                                                                                                   (3, 'Carlos Ruiz', 'carlos.ruiz@example.com', 'contraseña123', 'Boulevard del Valle 789', 456789123, 'Estudiante', '2024-09-18 10:00:00', NULL, 'ESTUDIANTE'),
                                                                                                                   (4, 'Laura Martínez', 'laura.martinez@example.com', 'contraseña123', 'Calle Nueva 101', 654321987, 'Experto', '2024-09-18 10:00:00', NULL, 'EXPERTO')
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'estudiantes'
INSERT INTO estudiantes (id, nivel_academico, intereses, created_at, updated_at)
VALUES
    (1, 'Universitario', 'Tecnología, Matemáticas', '2024-09-18 10:00:00', NULL),
    (3, 'Secundaria', 'Ciencias, Literatura', '2024-09-18 10:00:00', NULL)
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'expertos'
INSERT INTO expertos (id, especializacion, bio, created_at, updated_at, payment_status)
VALUES
    (2, 'Desarrollo de Software', 'Experto en programación y desarrollo de software.', '2024-09-18 10:00:00', NULL, 'PAGADO'),
    (4, 'Psicología Educativa', 'Especialista en orientación vocacional y psicológica.', '2024-09-18 10:00:00', NULL, 'PENDIENTE')
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'carreras'
INSERT INTO carreras (id, nombre, descripcion, campo_estudio, duracion, created_at, updated_at)
VALUES
    (1, 'Ingeniería en Sistemas', 'Carrera orientada a la programación y desarrollo de sistemas.', 'Tecnología', 4, '2024-09-18 10:00:00', NULL),
    (2, 'Psicología', 'Estudio del comportamiento humano y procesos mentales.', 'Ciencias Sociales', 5, '2024-09-18 10:00:00', NULL),
    (3, 'Arquitectura', 'Diseño y construcción de edificios y estructuras.', 'Arte', 5, '2024-09-18 10:00:00', NULL),
    (4, 'Medicina', 'Estudio de la salud y tratamiento de enfermedades.', 'Ciencias de la Salud', 6, '2024-09-18 10:00:00', NULL)
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'test_Vocacionales'
INSERT INTO test_Vocacionales (id, titulo, descripcion, created_at, updated_at, estudiante_id)
VALUES
    (1, 'Test de Orientación Profesional', 'Evaluación de habilidades y preferencias profesionales.', '2024-09-18 10:00:00', NULL, 1),
    (2, 'Test de Habilidades Académicas', 'Evaluación de habilidades en áreas académicas.', '2024-09-18 10:00:00', NULL, 3)
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'resultados_Test'
INSERT INTO resultados_Test (id, created_at, test_id)
VALUES
    (1, '2024-09-18 10:00:00', 1),
    (2, '2024-09-18 10:00:00', 2)
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'resultados_Carrera'
INSERT INTO resultados_Carrera (resultado_test_id, carrera, puntuacion, created_at)
VALUES
    (1, 1, 85.0, '2024-09-18 10:00:00'),
    (1, 2, 70.0, '2024-09-18 10:00:00'),
    (2, 3, 80.0, '2024-09-18 10:00:00'),
    (2, 4, 90.0, '2024-09-18 10:00:00')
    ON CONFLICT (resultado_test_id, carrera) DO NOTHING;

-- Insertar datos en la tabla 'compras'
INSERT INTO compras (id, total, paymentstatus, created_at, usuario_id)
VALUES
    (1, 99.99, 'COMPLETADO', '2024-09-18 10:00:00', 1),
    (2, 149.99, 'PENDIENTE', '2024-09-18 10:00:00', 3)
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'planes_Premium'
INSERT INTO planes_Premium (id, nombre, descripcion, precio, duracion, created_at, updated_at, usuario_id, compra_id)
VALUES
    (1, 'Plan Premium Básico', 'Acceso a recursos educativos premium.', 49.99, 30, '2024-09-18 10:00:00', NULL, 1, 1),
    (2, 'Plan Premium Avanzado', 'Acceso a todos los recursos y asesorías.', 99.99, 60, '2024-09-18 10:00:00', NULL, 3, 2)
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'recursos'
INSERT INTO recursos (id, titulo, descripcion, tipo, created_at, updated_at, usuario_id)
VALUES
    (1, 'Guía de Programación en Java', 'Guía completa para aprender Java.', 'Tutorial', '2024-09-18 10:00:00', NULL, 1),
    (2, 'Manual de Psicología Infantil', 'Manual sobre psicología infantil.', 'Libro', '2024-09-18 10:00:00', NULL, 4),
    (3, 'Curso de Diseño de Interiores', 'Curso sobre diseño y decoración de interiores.', 'Curso', '2024-09-18 10:00:00', NULL, 1),
    (4, 'Guía de Primeros Auxilios', 'Guía completa sobre primeros auxilios.', 'Tutorial', '2024-09-18 10:00:00', NULL, 3)
    ON CONFLICT (id) DO NOTHING;

-- Insertar datos en la tabla 'recursos_Premium'
INSERT INTO recursos_Premium (recurso_educativo_id, plan_premium_id, nombre, descripcion, tipo, added_date)
VALUES
    (1, 1, 'Guía Premium de Java', 'Versión premium de la guía de Java.', 'Tutorial', '2024-09-18 10:00:00'),
    (2, 2, 'Manual Avanzado de Psicología Infantil', 'Versión avanzada del manual de psicología infantil.', 'Libro', '2024-09-18 10:00:00'),
    (3, 2, 'Curso Avanzado de Diseño de Interiores', 'Versión avanzada del curso de diseño de interiores.', 'Curso', '2024-09-18 10:00:00'),
    (4, 1, 'Guía Avanzada de Primeros Auxilios', 'Versión avanzada de la guía de primeros auxilios.', 'Tutorial', '2024-09-18 10:00:00')
    ON CONFLICT (recurso_educativo_id, plan_premium_id) DO NOTHING;

-- Insertar datos en la tabla 'asesorias'
INSERT INTO asesorias (experto_id, usuario_id, duracion)
VALUES
    (2, 1, 1.5),
    (4, 3, 2.0),
    (2, 3, 1.0),
    (4, 1, 1.0)
    ON CONFLICT (experto_id, usuario_id) DO NOTHING;


