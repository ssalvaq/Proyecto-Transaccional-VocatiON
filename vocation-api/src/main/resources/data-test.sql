-- Llenado de la tabla 'Usuario'
INSERT INTO Usuario (id, nombre, email, contraseña, direccion, telefono, tipo, fecha_creacion) VALUES
                                                                                                   (1, 'Juan Pérez', 'juan.perez@gmail.com', 'password123', 'Calle Falsa 123', '5551234567', 'Estudiante', '2023-09-13'),
                                                                                                   (2, 'Ana García', 'ana.garcia@gmail.com', 'securepassword', 'Avenida Real 456', '5559876543', 'Estudiante', '2023-09-13'),
                                                                                                   (3, 'Carlos López', 'carlos.lopez@gmail.com', 'anotherpass', 'Calle Siempre Viva 742', '5551122334', 'Experto', '2023-09-13'),
                                                                                                   (4, 'María Sánchez', 'maria.sanchez@gmail.com', 'mypassword', 'Boulevard Central 789', '5554433221', 'Experto', '2023-09-13');

-- Llenado de la tabla 'Experto'
INSERT INTO Experto (id, especializacion, bio) VALUES
                                                   (3, 'Ingeniería de Software', 'Experto en desarrollo de software con más de 10 años de experiencia.'),
                                                   (4, 'Psicología', 'Psicóloga con especialización en orientación vocacional.');

-- Llenado de la tabla 'Estudiante'
INSERT INTO Estudiante (id, nivel_academico, intereses) VALUES
                                                            (1, 'Secundaria Completa', 'Tecnología, Matemáticas'),
                                                            (2, 'Universitario', 'Arte, Diseño gráfico');

-- Llenado de la tabla 'Carrera'
INSERT INTO Carrera (id, nombre, descripcion, campo_estudio, duracion) VALUES
                                                                           (1, 'Ingeniería de Software', 'Carrera enfocada en el desarrollo y mantenimiento de sistemas de software.', 'Tecnología', 5),
                                                                           (2, 'Diseño Gráfico', 'Carrera centrada en la creación de contenido visual para medios digitales e impresos.', 'Arte', 4);

-- Llenado de la tabla 'Test_vocacional'
INSERT INTO Test_vocacional (id, titulo, descripcion, fecha_creacion) VALUES
                                                                          (1, 'Test de intereses profesionales', 'Evaluación para identificar áreas de interés laboral.', '2024-01-01'),
                                                                          (2, 'Test de habilidades cognitivas', 'Test para medir habilidades de razonamiento lógico y crítico.', '2024-02-01');

-- Llenado de la tabla 'Resultado_test'
INSERT INTO Resultado_test (id, test_id, estudiante_id, fecha_realizacion) VALUES
                                                                               (1, 1, 1, '2024-03-01'),
                                                                               (2, 2, 2, '2024-03-05');

-- Llenado de la tabla 'Resultado_carrera'
INSERT INTO Resultado_carrera (resultado_test_id, carrera_id, puntuacion) VALUES
                                                                              (1, 1, 85.5),
                                                                              (2, 2, 92.0);

-- Llenado de la tabla 'Plan_premium'
INSERT INTO Plan_premium (id, nombre, descripcion, precio, duracion) VALUES
                                                                         (1, 'Plan Estándar', 'Acceso a recursos educativos básicos.', 9.99, 30),
                                                                         (2, 'Plan Premium', 'Acceso a todos los recursos educativos y asesorías ilimitadas.', 29.99, 30);

-- Llenado de la tabla 'Recurso_educativo'
INSERT INTO Recurso_educativo (id, titulo, descripcion, tipo) VALUES
                                                                  (1, 'Guía de carreras tecnológicas', 'Recurso educativo para aprender sobre carreras en tecnología.', 'Artículo'),
                                                                  (2, 'Tutorial de diseño gráfico', 'Guía paso a paso para mejorar habilidades de diseño.', 'Video');
