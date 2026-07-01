package com.teacherondemand.service;

import com.teacherondemand.entity.PessoaFisica;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.PessoaFisicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaFisicaService extends BaseService<PessoaFisica, Long> {

    private final PessoaFisicaRepository repository;

    @Override
    protected BaseRepository<PessoaFisica, Long> repository() {
        return repository;
    }
}