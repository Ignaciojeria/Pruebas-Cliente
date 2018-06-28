package com.fbfagostousa.repository;


import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.core.PlatoRestoran;
import com.fbfagostousa.domain.core.PlatoRestoranId;
import com.fbfagostousa.domain.core.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatoRestoranRepository extends JpaRepository<PlatoRestoran, PlatoRestoranId> {

    Optional<PlatoRestoran> findByRestoranAndPlato(Restoran restoran, Plato plato);

    Optional<PlatoRestoran> findById(PlatoRestoranId platoRestoranId);

}
