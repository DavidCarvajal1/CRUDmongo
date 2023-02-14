package org.example;

import org.example.DAL.CRUD;

public class Main {
    public static void main(String[] args) {
        CRUD.abrirConexion();
        CRUD.insertar();
    }
}