package com.teacherondemand.service;

import com.teacherondemand.entity.Documento;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentoService extends BaseService<Documento, Long> {

    private final DocumentoRepository repository;

    @Override
    protected BaseRepository<Documento, Long> repository() {
        return repository;
    }
}
