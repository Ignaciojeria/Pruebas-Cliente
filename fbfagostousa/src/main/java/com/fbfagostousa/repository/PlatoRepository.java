package com.fbfagostousa.repository;

import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.core.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatoRepository extends JpaRepository<Plato,Long> {

    Optional<Plato> findByIdAndRestoran(Long id,Restoran restoran);
}
