package com.fbfagostousa.repository;

import com.fbfagostousa.domain.core.Caracteristica;
import com.fbfagostousa.domain.core.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    Optional<Categoria> findByCaracteristicas(List<Caracteristica> caracteristicas);
}
