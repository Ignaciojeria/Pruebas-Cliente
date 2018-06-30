package com.fbfagostousa.service;
import com.fbfagostousa.domain.core.HistorialVotacion;
import com.fbfagostousa.repository.HistorialVotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialVotacionService {

    @Autowired
    private HistorialVotacionRepository historialVotacionRepository;

    public HistorialVotacion save(HistorialVotacion historialVotacion){
        return historialVotacionRepository.save(historialVotacion);
    }
}
