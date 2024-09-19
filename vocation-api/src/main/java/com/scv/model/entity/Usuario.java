package com.scv.model.entity;

import com.scv.model.enums.Roles;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "contraseña", nullable = false, length = 50)
    private String  contraseña;
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Column(name = "telefono", nullable = false)
    private int telefono;
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Roles roles;

    @OneToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_usuario_usuario"))
    private Estudiante estudiante;

    @OneToOne
    @JoinColumn(name = "experto_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_usuario_experto"))
    private Experto experto;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Asesoria> asesorias;
}
