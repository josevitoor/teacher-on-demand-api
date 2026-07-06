package com.teacherondemand.service;

import com.teacherondemand.dto.response.ProfessorListResponse;
import com.teacherondemand.entity.Professor;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService extends BaseService<Professor, Long> {

    private final ProfessorRepository repository;
    private final ProfessorEspecialidadeService professorEspecialidadeService;

    @Override
    protected BaseRepository<Professor, Long> repository() {
        return repository;
    }

    public List<ProfessorListResponse> listarProfessores() {
        return getAll()
                .stream()
                .map(this::toListResponse)
                .toList();
    }

    private ProfessorListResponse toListResponse(Professor professor) {
        List<String> especialidades = professorEspecialidadeService
                .findByProfessorId(professor.getIdUsuario())
                .stream()
                .map(e -> e.getId().getEspecialidade())
                .toList();

        return ProfessorListResponse.builder()
                .idProfessor(professor.getIdUsuario())
                .nome(professor.getUsuario().getNome())
                .email(professor.getUsuario().getEmail())
                .valorHoraAula(professor.getValorHoraAula())
                .especialidades(especialidades)
                .build();
    }
}