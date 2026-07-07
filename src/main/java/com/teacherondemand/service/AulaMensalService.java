package com.teacherondemand.service;

import com.teacherondemand.entity.AulaMensal;
import com.teacherondemand.repository.AulaMensalRepository;
import com.teacherondemand.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AulaMensalService extends BaseService<AulaMensal, Long> {

    private final AulaMensalRepository repository;

    @Override
    protected BaseRepository<AulaMensal, Long> repository() {
        return repository;
    }
}
