package com.fbfagostousa.service;

import com.fbfagostousa.domain.core.Valoracion;
import com.fbfagostousa.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionService {

    @Autowired
    private ValoracionRepository valoracionRepository;

    public List<Valoracion> valorarPlato(List<Valoracion> valoraciones){
        return valoracionRepository.saveAll(valoraciones);
    }

}
