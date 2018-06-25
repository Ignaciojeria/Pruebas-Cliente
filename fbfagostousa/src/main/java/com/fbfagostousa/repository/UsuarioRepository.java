package com.fbfagostousa.repository;

import com.fbfagostousa.domain.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("select usuario from Usuario usuario where usuario.token.valorToken = ?1")
    Optional<Usuario> findByValorToken(String valorToken);

    Optional<Usuario> findByEmail(String email);
}
