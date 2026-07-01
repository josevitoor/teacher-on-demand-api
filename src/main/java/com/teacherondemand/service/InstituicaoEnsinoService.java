package com.teacherondemand.service;

import com.teacherondemand.entity.InstituicaoEnsino;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.InstituicaoEnsinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstituicaoEnsinoService extends BaseService<InstituicaoEnsino, Long> {

    private final InstituicaoEnsinoRepository repository;

    @Override
    protected BaseRepository<InstituicaoEnsino, Long> repository() {
        return repository;
    }
}