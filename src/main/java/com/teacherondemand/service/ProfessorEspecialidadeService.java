package com.teacherondemand.service;

import com.teacherondemand.entity.ProfessorEspecialidade;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.ProfessorEspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorEspecialidadeService extends BaseService<ProfessorEspecialidade, Long> {

    private final ProfessorEspecialidadeRepository repository;

    @Override
    protected BaseRepository<ProfessorEspecialidade, Long> repository() {
        return repository;
    }
}