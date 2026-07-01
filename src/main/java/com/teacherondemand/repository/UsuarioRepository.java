package com.teacherondemand.repository;

import com.teacherondemand.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}