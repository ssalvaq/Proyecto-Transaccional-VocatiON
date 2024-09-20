-- Limpiar datos antiguos en las tablas
DELETE FROM asesorias;
DELETE FROM recursos_Premium;
DELETE FROM recursos;
DELETE FROM planes_Premium;
DELETE FROM compras;
DELETE FROM resultados_Carrera;
DELETE FROM resultados_Test;
DELETE FROM test_Vocacionales;
DELETE FROM carreras;
DELETE FROM expertos;
DELETE FROM estudiantes;
DELETE FROM usuarios;


-- Insertar datos en la tabla 'usuarios'
INSERT INTO usuarios (id, nombre, email, contraseña, direccion, telefono, tipo, created_at, updated_at, roles) VALUES
                                                                                                                   (1, 'Juan Pérez', 'juan.perez@example.com', 'contraseña123', 'Calle Falsa 123', '123456789', 'Estudiante', '2024-09-18 10:00:00', NULL, 'ESTUDIANTE'),
                                                                                                                   (2, 'Ana Gómez', 'ana.gomez@example.com', 'contraseña123', 'Avenida Siempre Viva 456', '987654321', 'Experto', '2024-09-18 10:00:00', NULL, 'EXPERTO'),
                                                                                                                   (3, 'Carlos Ruiz', 'carlos.ruiz@example.com', 'contraseña123', 'Boulevard del Valle 789', '456789123', 'Estudiante', '2024-09-18 10:00:00', NULL, 'ESTUDIANTE'),
                                                                                                                   (4, 'Laura Martínez', 'laura.martinez@example.com', 'contraseña123', 'Calle Nueva 101', '654321987', 'Experto', '2024-09-18 10:00:00', NULL, 'EXPERTO')
    ON CONFLICT (id) DO NOTHING;
