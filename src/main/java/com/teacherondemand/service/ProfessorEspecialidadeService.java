package com.teacherondemand.service;

import com.teacherondemand.entity.ProfessorEspecialidade;
import com.teacherondemand.entity.ProfessorEspecialidadeId;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.ProfessorEspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorEspecialidadeService extends BaseService<ProfessorEspecialidade, ProfessorEspecialidadeId> {

    private final ProfessorEspecialidadeRepository repository;

    @Override
    protected BaseRepository<ProfessorEspecialidade, ProfessorEspecialidadeId> repository() {
        return repository;
    }

    public List<ProfessorEspecialidade> findByProfessorId(Long idProfessor) {
        return repository.findByProfessorIdUsuario(idProfessor);
    }
}