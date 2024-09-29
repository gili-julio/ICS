package com.giliardo.ICS.enums;

public enum NivelUsuario {
    ADMIN("admin"),
    MANAGER("manager"),
    USER("user");

    private String nivel;

    NivelUsuario(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }
}
