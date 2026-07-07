package com.teacherondemand.service;

import com.teacherondemand.entity.AulaUnica;
import com.teacherondemand.repository.AulaUnicaRepository;
import com.teacherondemand.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AulaUnicaService extends BaseService<AulaUnica, Long> {

    private final AulaUnicaRepository repository;

    @Override
    protected BaseRepository<AulaUnica, Long> repository() {
        return repository;
    }
}
