package com.giliardo.ICS.DTO;

import com.giliardo.ICS.enums.NivelUsuario;

public record RegisterDTO(String nome, String email, String senha, NivelUsuario nivel, String cargo) {

}
