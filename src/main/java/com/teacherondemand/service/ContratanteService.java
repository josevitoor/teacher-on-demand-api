package com.teacherondemand.service;

import com.teacherondemand.entity.Contratante;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.ContratanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContratanteService extends BaseService<Contratante, Long> {

    private final ContratanteRepository repository;

    @Override
    protected BaseRepository<Contratante, Long> repository() {
        return repository;
    }
}
