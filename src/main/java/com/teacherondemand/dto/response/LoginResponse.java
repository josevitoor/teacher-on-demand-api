package com.teacherondemand.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private Long usuarioId;

    private String nome;

    private String email;

    private boolean professor;

    private boolean contratante;

    private boolean pessoaFisica;

    private boolean instituicaoEnsino;
}