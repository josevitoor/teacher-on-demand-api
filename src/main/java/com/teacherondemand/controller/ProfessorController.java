package com.teacherondemand.controller;

import com.teacherondemand.dto.response.ProfessorListResponse;
import com.teacherondemand.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorListResponse>> listar() {
        return ResponseEntity.ok(professorService.listarProfessores());
    }
}