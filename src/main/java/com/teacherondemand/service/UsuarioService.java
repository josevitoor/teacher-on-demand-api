package com.teacherondemand.service;

import com.teacherondemand.config.SecurityProperties;
import com.teacherondemand.constant.TipoUsuarioEnum;
import com.teacherondemand.dto.request.UsuarioCreateRequest;
import com.teacherondemand.dto.request.UsuarioUpdateRequest;
import com.teacherondemand.entity.*;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseService<Usuario, Long> {

    private final UsuarioRepository repository;
    private final Md5Service md5Service;
    private final ProfessorService professorService;
    private final PessoaFisicaService pessoaFisicaService;
    private final InstituicaoEnsinoService instituicaoEnsinoService;
    private final ContratanteService contratanteService;

    @Override
    protected BaseRepository<Usuario, Long> repository() {
        return repository;
    }

    public Optional<Usuario> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Transactional
    public Usuario create(UsuarioCreateRequest request) {
        Usuario usuario = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .telefone(request.getTelefone())
                .senha(md5Service.encrypt(request.getSenha()))
                .build();

        usuario = save(usuario);

        if (request.getTipos().contains(TipoUsuarioEnum.PROFESSOR)) {
            Professor professor = Professor.builder()
                    .usuario(usuario)
                    .cpf(request.getCpf())
                    .dataNascimento(request.getDataNascimento())
                    .valorHoraAula(request.getValorHoraAula())
                    .build();

            professorService.save(professor);
        }

        Contratante contratante = null;

        if (request.getTipos().contains(TipoUsuarioEnum.PESSOA_FISICA) || request.getTipos().contains(TipoUsuarioEnum.INSTITUICAO_ENSINO)) {

            contratante = Contratante.builder()
                    .usuario(usuario)
                    .build();

            contratante = contratanteService.save(contratante);
        }

        if (request.getTipos().contains(TipoUsuarioEnum.PESSOA_FISICA)) {
            PessoaFisica pessoaFisica = PessoaFisica.builder()
                    .contratante(contratante)
                    .cpf(request.getCpf())
                    .dataNascimento(request.getDataNascimento())
                    .build();

            pessoaFisicaService.save(pessoaFisica);
        }

        if (request.getTipos().contains(TipoUsuarioEnum.INSTITUICAO_ENSINO)) {
            InstituicaoEnsino instituicao = InstituicaoEnsino.builder()
                    .contratante(contratante)
                    .cnpj(request.getCnpj())
                    .build();

            instituicaoEnsinoService.save(instituicao);
        }

        return usuario;
    }

    public Usuario update(Long id, UsuarioUpdateRequest usuario) {
        Usuario entity = getById(id);

        entity.setNome(usuario.getNome());
        entity.setTelefone(usuario.getTelefone());

        if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
            entity.setSenha(md5Service.encrypt(usuario.getSenha()));
        }

        return save(entity);
    }
}