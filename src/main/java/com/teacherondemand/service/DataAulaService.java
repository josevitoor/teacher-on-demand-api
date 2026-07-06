package com.teacherondemand.service;

import com.teacherondemand.entity.DataAula;
import com.teacherondemand.entity.DataAulaId;
import com.teacherondemand.repository.BaseRepository;
import com.teacherondemand.repository.DataAulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataAulaService extends BaseService<DataAula, DataAulaId> {

    private final DataAulaRepository repository;

    @Override
    protected BaseRepository<DataAula, DataAulaId> repository() {
        return repository;
    }

    public List<DataAula> getAgendaUsuario(Long idUsuario) {
        return repository
                .findByAulaContratoProfessorIdUsuarioOrAulaContratoContratanteIdUsuarioOrderByIdDataAulaAscAulaHoraInicioAsc(
                        idUsuario,
                        idUsuario
                );
    }
}
