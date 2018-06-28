package com.fbfagostousa.service;

import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.core.PlatoRestoran;
import com.fbfagostousa.domain.core.PlatoRestoranId;
import com.fbfagostousa.domain.core.Restoran;
import com.fbfagostousa.exception.PlatoIdAndRestoranIdNotFoundException;
import com.fbfagostousa.exception.PlatoIdNotFoundException;
import com.fbfagostousa.exception.PlatoRestoranIdNotFoundException;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.repository.PlatoRestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlatoRestoranService {

    @Autowired
    private PlatoService platoService;

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private PlatoRestoranRepository platoRestoranRepository;

    public PlatoRestoranId findPlatoRestoranIdByPlatoAndRestoran(Long PlatoId,
                                                                         Long restoranId) throws RestoranIdNotFoundException, PlatoIdNotFoundException, PlatoIdAndRestoranIdNotFoundException {

        Restoran restoran= restoranService.findById(restoranId);

        Plato plato = platoService.findById(PlatoId);

        Optional<PlatoRestoran> platoRestoranOptional= platoRestoranRepository.findByRestoranAndPlato(restoran, plato);

        if(!platoRestoranOptional.isPresent())
            throw new PlatoIdAndRestoranIdNotFoundException("El restoran con id "+restoranId +" no tiene dentro de sus Platos a la plato con id: "+PlatoId);

        PlatoRestoran platoRestoran = platoRestoranOptional.get();

        PlatoRestoranId platoRestoranId = platoRestoran.getId();
        platoRestoranId.setPuntajeTransiente(platoRestoran.getPuntaje());
        return platoRestoranId;
    }

    public PlatoRestoranId votarPorPlatoDeUnRestoran(Long PlatoId, Long restoranId) throws RestoranIdNotFoundException, PlatoIdNotFoundException, PlatoRestoranIdNotFoundException, PlatoIdAndRestoranIdNotFoundException {
        PlatoRestoranId platoRestoranId = this.findPlatoRestoranIdByPlatoAndRestoran(PlatoId,restoranId);
        Optional<PlatoRestoran> PlatoRestoranOptional= platoRestoranRepository.findById(platoRestoranId);
        if(!PlatoRestoranOptional.isPresent())
            throw new PlatoRestoranIdNotFoundException("La Plato con id: ".concat(PlatoId.toString()).concat(" y retoran id: ".concat(restoranId.toString()).concat("no existe")) );

        PlatoRestoran platoRestoran =PlatoRestoranOptional.get();

        platoRestoran.setPuntaje(platoRestoran.getPuntaje()+1);

        platoRestoranId = platoRestoranRepository.save(platoRestoran).getId();

        platoRestoranId.setPuntajeTransiente(platoRestoran.getPuntaje());

        return platoRestoranId;
    }


}
