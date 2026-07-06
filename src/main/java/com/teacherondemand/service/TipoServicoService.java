package com.teacherondemand.service;

import com.teacherondemand.entity.TipoServico;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.TipoServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoServicoService extends BaseService<TipoServico, Long> {

    private final TipoServicoRepository repository;

    @Override
    protected BaseRepository<TipoServico, Long> repository() {
        return repository;
    }
}
