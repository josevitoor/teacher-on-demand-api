package com.teacherondemand.service;

import com.teacherondemand.dto.request.LoginRequest;
import com.teacherondemand.dto.response.LoginResponse;
import com.teacherondemand.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioService usuarioService;
    private final ProfessorService professorService;
    private final ContratanteService contratanteService;
    private final PessoaFisicaService pessoaFisicaService;
    private final InstituicaoEnsinoService instituicaoEnsinoService;
    private final Md5Service md5Service;

    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioService
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));

        String senhaCriptografada =
                md5Service.encrypt(request.getSenha());

        if (!senhaCriptografada.equals(usuario.getSenha())) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        Long id = usuario.getIdUsuario();

        return LoginResponse.builder()
                .usuarioId(id)
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .professor(professorService.exists(id))
                .contratante(contratanteService.exists(id))
                .pessoaFisica(pessoaFisicaService.exists(id))
                .instituicaoEnsino(instituicaoEnsinoService.exists(id))
                .build();
    }
}