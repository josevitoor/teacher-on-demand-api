package com.teacherondemand.service;

import com.teacherondemand.entity.PacoteAula;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.PacoteAulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacoteAulaService extends BaseService<PacoteAula, Long> {

    private final PacoteAulaRepository repository;

    @Override
    protected BaseRepository<PacoteAula, Long> repository() {
        return repository;
    }
}