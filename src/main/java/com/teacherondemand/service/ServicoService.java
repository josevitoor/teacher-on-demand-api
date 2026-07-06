package com.teacherondemand.service;

import com.teacherondemand.entity.Servico;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicoService extends BaseService<Servico, Long> {

    private final ServicoRepository repository;

    @Override
    protected BaseRepository<Servico, Long> repository() {
        return repository;
    }
}
