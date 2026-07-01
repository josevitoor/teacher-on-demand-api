package com.teacherondemand.service;

import com.teacherondemand.entity.Professor;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService extends BaseService<Professor, Long> {

    private final ProfessorRepository repository;

    @Override
    protected BaseRepository<Professor, Long> repository() {
        return repository;
    }
}