package com.fbfagostousa.repository;

import com.fbfagostousa.domain.CategoriaRestoran;
import com.fbfagostousa.domain.CategoriaRestoranId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CategoriaRestoranRepository extends JpaRepository<CategoriaRestoran,CategoriaRestoranId>{
}