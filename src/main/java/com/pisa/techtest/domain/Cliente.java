package com.pisa.techtest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Persona {

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuenta> cuentas;

    public Cliente(String identificacion, String nombre, String genero, int edad, String direccion, String telefono,
                   String contraseña, boolean estado) {
        super(identificacion, nombre, genero, edad, direccion, telefono);
        this.contraseña = contraseña;
        this.estado = estado;
    }
}
