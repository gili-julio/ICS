package com.giliardo.ICS.DTO;

import com.giliardo.ICS.enums.NivelUsuario;

public record RegisterRequestDTO(
        String nome, String email,
        String senha, NivelUsuario nivel, String cargo) {
}
