package com.teacherondemand.service;

import com.teacherondemand.entity.Contrato;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContratoService extends BaseService<Contrato, Long> {

    private final ContratoRepository repository;

    @Override
    protected BaseRepository<Contrato, Long> repository() {
        return repository;
    }
}
