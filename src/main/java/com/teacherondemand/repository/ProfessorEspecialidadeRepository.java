package com.teacherondemand.repository;

import com.teacherondemand.entity.ProfessorEspecialidade;
import com.teacherondemand.entity.ProfessorEspecialidadeId;

import java.util.List;

public interface ProfessorEspecialidadeRepository extends BaseRepository<ProfessorEspecialidade, ProfessorEspecialidadeId> {
    List<ProfessorEspecialidade> findByProfessorIdUsuario(Long idProfessor);
}
