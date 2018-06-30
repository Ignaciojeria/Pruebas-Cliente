package com.fbfagostousa.repository;

import com.fbfagostousa.domain.core.HistorialVotacion;
import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistorialVotacionRepository extends JpaRepository<HistorialVotacion,Long> {
    Optional<HistorialVotacion> findFirstByUsuarioAndPlato(Usuario usuario, Plato plato);
}
