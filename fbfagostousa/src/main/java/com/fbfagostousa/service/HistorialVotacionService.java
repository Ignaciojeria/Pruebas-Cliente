package com.fbfagostousa.service;
import com.fbfagostousa.domain.core.HistorialVotacion;
import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.exception.HistorialVotacionUsuarioAndPlatoFoundException;
import com.fbfagostousa.repository.HistorialVotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialVotacionService {

    @Autowired
    private HistorialVotacionRepository historialVotacionRepository;

    public HistorialVotacion save(HistorialVotacion historialVotacion, Usuario usuario, Plato plato) throws HistorialVotacionUsuarioAndPlatoFoundException {
        if(historialVotacionRepository.findFirstByUsuarioAndPlato(usuario,plato).isPresent())
           throw new HistorialVotacionUsuarioAndPlatoFoundException("El usuario con email ".concat( usuario.getEmail()).concat(" ya ha realizado una votacion sobre el plato con id: ".concat(plato.getId().toString())));
        return historialVotacionRepository.save(historialVotacion);
    }
}
