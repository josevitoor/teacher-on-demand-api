package com.teacherondemand.repository;

import com.teacherondemand.entity.Aula;

import java.util.List;

public interface AulaRepository extends BaseRepository<Aula, Long> {
    List<Aula> findByContratoProfessorIdUsuarioOrContratoContratanteIdUsuarioOrderByIdAulaDesc(
            Long idProfessor,
            Long idContratante
    );
}

