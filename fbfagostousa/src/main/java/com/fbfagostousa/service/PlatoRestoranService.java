package com.fbfagostousa.service;

import com.fbfagostousa.repository.PlatoRestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoRestoranService {

    @Autowired
    private PlatoService platoService;

    @Autowired
    private RestoranService restoranService;
/*
    @Autowired
    private PlatoRestoranRepository platoRestoranRepository;
*/
    /*

    public PlatoRestoranIdDeprecated findPlatoRestoranIdByPlatoAndRestoran(Long PlatoId,
                                                                         Long restoranId) throws RestoranIdNotFoundException, PlatoIdNotFoundException, PlatoIdAndRestoranIdNotFoundException {

        Restoran restoran= restoranService.findById(restoranId);

        Plato plato = platoService.findById(PlatoId);

        Optional<PlatoRestoranDeprecated> platoRestoranOptional= platoRestoranRepository.findByRestoranAndPlato(restoran, plato);

        if(!platoRestoranOptional.isPresent())
            throw new PlatoIdAndRestoranIdNotFoundException("El restoran con id "+restoranId +" no tiene dentro de sus Platos a la plato con id: "+PlatoId);

        PlatoRestoranDeprecated platoRestoran = platoRestoranOptional.get();

        PlatoRestoranIdDeprecated platoRestoranId = platoRestoran.getId();
       // platoRestoranId.setPuntajeTotalTransiente(platoRestoran.getPuntaje());
        return platoRestoranId;
    }*/
/*
    public PlatoRestoranIdDeprecated votarPorPlatoDeUnRestoran(Long PlatoId, Long restoranId) throws RestoranIdNotFoundException, PlatoIdNotFoundException, PlatoRestoranIdNotFoundException, PlatoIdAndRestoranIdNotFoundException {
        PlatoRestoranIdDeprecated platoRestoranId = this.findPlatoRestoranIdByPlatoAndRestoran(PlatoId,restoranId);
        Optional<PlatoRestoranDeprecated> PlatoRestoranOptional= platoRestoranRepository.findById(platoRestoranId);
        if(!PlatoRestoranOptional.isPresent())
            throw new PlatoRestoranIdNotFoundException("La Plato con id: ".concat(PlatoId.toString()).concat(" y retoran id: ".concat(restoranId.toString()).concat("no existe")) );

        PlatoRestoranDeprecated platoRestoran =PlatoRestoranOptional.get();

        platoRestoran.setPuntaje(platoRestoran.getPuntaje()+1);

        platoRestoranId = platoRestoranRepository.save(platoRestoran).getId();

        platoRestoranId.setPuntajeTotalTransiente(platoRestoran.getPuntaje());

        return platoRestoranId;
    }
    */


}
