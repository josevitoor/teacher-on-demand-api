package com.teacherondemand.service;

import com.teacherondemand.entity.Pagamento;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService extends BaseService<Pagamento, Long> {

    private final PagamentoRepository repository;

    @Override
    protected BaseRepository<Pagamento, Long> repository() {
        return repository;
    }
}
