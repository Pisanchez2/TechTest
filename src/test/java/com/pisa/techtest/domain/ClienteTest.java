package com.pisa.techtest.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testClienteInitialization() {
        String identificacion = "123456789";
        String nombre = "Pablo Sanchez";
        String genero = "M";
        int edad = 30;
        String direccion = "Av. Las Nubes";
        String telefono = "0987654321";
        String contraseña = "1545";
        boolean estado = true;

        Cliente cliente = new Cliente(identificacion, nombre, genero, edad, direccion, telefono, contraseña, estado);

        assertEquals(identificacion, cliente.getIdentificacion());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(genero, cliente.getGenero());
        assertEquals(edad, cliente.getEdad());
        assertEquals(direccion, cliente.getDireccion());
        assertEquals(telefono, cliente.getTelefono());
        assertEquals(contraseña, cliente.getContraseña());
        assertEquals(estado, cliente.isEstado());

        cliente.setCuentas(new ArrayList<>());
        assertNotNull(cliente.getCuentas());
        assertTrue(cliente.getCuentas().isEmpty());
    }
}