package com.fbfagostousa.repository;

import com.fbfagostousa.domain.users.Autorizacion;
import com.fbfagostousa.domain.users.Role;
import com.fbfagostousa.domain.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutorizacionRepository extends JpaRepository<Autorizacion,Long> {
    @Query("select autorizacion.role from Autorizacion autorizacion where autorizacion.usuario = ?1")
    List<Role> findRoleByUsuario(Usuario usuario);
}
