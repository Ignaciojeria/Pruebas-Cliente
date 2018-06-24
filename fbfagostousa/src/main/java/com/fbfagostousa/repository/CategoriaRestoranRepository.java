package com.fbfagostousa.repository;


import com.fbfagostousa.domain.core.Categoria;
import com.fbfagostousa.domain.core.CategoriaRestoran;
import com.fbfagostousa.domain.core.CategoriaRestoranId;
import com.fbfagostousa.domain.core.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRestoranRepository extends JpaRepository<CategoriaRestoran, CategoriaRestoranId> {

    Optional<CategoriaRestoran> findByRestoranAndCategoria(Restoran restoran, Categoria categoria);

    Optional<CategoriaRestoran> findById(CategoriaRestoranId categoriaRestoranId);

}
