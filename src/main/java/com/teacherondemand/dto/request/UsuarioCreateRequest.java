package com.teacherondemand.dto.request;

import com.teacherondemand.constant.TipoUsuarioEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UsuarioCreateRequest {
    private List<TipoUsuarioEnum> tipos;

    private String nome;
    private String email;
    private String senha;
    private String telefone;

    private String cpf;
    private LocalDate dataNascimento;
    private BigDecimal valorHoraAula;

    private String cnpj;

    private List<String> especialidades;

    private String documentoTipo;
    private String documentoArquivo;
}
