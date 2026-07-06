package com.teacherondemand.controller;

import com.teacherondemand.dto.response.AgendaResponse;
import com.teacherondemand.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<AgendaResponse>> getAgendaUsuario(
            @PathVariable Long idUsuario) {

        return ResponseEntity.ok(
                agendaService.getAgendaUsuario(idUsuario));
    }
}