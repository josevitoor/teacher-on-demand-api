package com.teacherondemand.service;

import com.teacherondemand.entity.Aula;
import com.teacherondemand.repository.AulaRepository;
import com.teacherondemand.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AulaService extends BaseService<Aula, Long> {

    private final AulaRepository repository;

    @Override
    protected BaseRepository<Aula, Long> repository() {
        return repository;
    }
}
