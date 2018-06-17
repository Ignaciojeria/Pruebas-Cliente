package com.fbfagostousa.repository;

import com.fbfagostousa.domain.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran,Long> {
}
