package com.teacherondemand.repository;

import com.teacherondemand.entity.DiaSemana;
import com.teacherondemand.entity.DiaSemanaId;

import java.util.List;

public interface DiaSemanaRepository extends BaseRepository<DiaSemana, DiaSemanaId> {
    List<DiaSemana> findByAulaMensalIdTipoServico(Long idTipoServico);
}
