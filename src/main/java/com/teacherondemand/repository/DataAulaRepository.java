package com.teacherondemand.repository;

import com.teacherondemand.entity.DataAula;
import com.teacherondemand.entity.DataAulaId;

import java.util.List;

public interface DataAulaRepository extends BaseRepository<DataAula, DataAulaId> {

    List<DataAula> findByAulaIdAulaOrderByIdDataAulaAsc(Long idAula);
}
