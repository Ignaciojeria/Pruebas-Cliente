package com.fbfagostousa.repository;

import com.fbfagostousa.domain.core.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion,Long> {

}
