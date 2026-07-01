package com.teacherondemand.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateRequest {
    private String nome;
    private String senha;
    private String telefone;
}
