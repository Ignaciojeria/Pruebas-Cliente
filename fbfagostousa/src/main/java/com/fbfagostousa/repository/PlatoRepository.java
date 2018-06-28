package com.fbfagostousa.repository;

import com.fbfagostousa.domain.core.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato,Long> {
}
