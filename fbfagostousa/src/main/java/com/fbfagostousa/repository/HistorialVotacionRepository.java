package com.fbfagostousa.repository;

import com.fbfagostousa.domain.core.HistorialVotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialVotacionRepository extends JpaRepository<HistorialVotacion,Long> {
}
