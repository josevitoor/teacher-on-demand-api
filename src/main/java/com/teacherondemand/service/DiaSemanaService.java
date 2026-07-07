package com.teacherondemand.service;

import com.teacherondemand.entity.DiaSemana;
import com.teacherondemand.entity.DiaSemanaId;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.DiaSemanaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaSemanaService extends BaseService<DiaSemana, DiaSemanaId> {

    private final DiaSemanaRepository repository;

    @Override
    protected BaseRepository<DiaSemana, DiaSemanaId> repository() {
        return repository;
    }

    public List<DiaSemana> findByAulaMensal(Long idTipoServico) {
        return repository.findByAulaMensalIdTipoServico(idTipoServico);
    }
}
