package com.teacherondemand.controller;

import com.teacherondemand.dto.request.AgendamentoCreateRequest;
import com.teacherondemand.dto.response.AgendaResponse;
import com.teacherondemand.entity.Contrato;
import com.teacherondemand.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Contrato> criar(
            @RequestBody AgendamentoCreateRequest request) {

        return ResponseEntity.ok(agendaService.criar(request));
    }

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<Contrato> aprovar(
            @PathVariable Long id) {

        return ResponseEntity.ok(agendaService.aprovar(id));
    }

    @PutMapping("/{id}/recusar")
    public ResponseEntity<Contrato> recusar(
            @PathVariable Long id) {

        return ResponseEntity.ok(agendaService.recusar(id));
    }
}