package com.fbfagostousa.service;

import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.core.PlatoRestoran;
import com.fbfagostousa.domain.core.PlatoRestoranId;
import com.fbfagostousa.domain.core.Restoran;
import com.fbfagostousa.repository.PlatoRepository;
import com.fbfagostousa.repository.PlatoRestoranRepository;
import com.fbfagostousa.repository.RestoranRepository;
import com.fbfagostousa.service.builder.PlatoBuilder;
import com.fbfagostousa.service.builder.RestoranBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Fakemock {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private PlatoRestoranRepository platoRestoranRepository;

    @PostConstruct
    public void IngresarRestoranesyCategorias(){

        Plato plato1 = new PlatoBuilder.Builder().setDescripcion("Atiende a las personas del restoran")
                                                            .setNombre("Garzon del restoran")
                                                            .build();

        Plato plato2 =new PlatoBuilder.Builder().setDescripcion("Plato tradicional")
                                                            .setNombre("Tradicional")
                                                            .build();

        //SobreeEscribimos categoria con el retorno de su id.
        plato1 = platoRepository.save(plato1);

       // plato1= categoriaRepository.save(plato2);




        Restoran restoran1= new RestoranBuilder.Builder()
                                .setNombre("Aji seco")
                                .setDescripcion("Restoran Tradicional")
                                .build();

        Restoran restoran2= new RestoranBuilder.Builder()
                .setNombre("El Pollo Caballo")
                .setDescripcion("Restoran Tradicional")
                .build();


        restoran1= restoranRepository.save(restoran1);

        restoran2= restoranRepository.save(restoran2);



        PlatoRestoran platoRestoran =new PlatoRestoran();

        PlatoRestoranId platoRestoranId = new PlatoRestoranId(plato1.getId(),restoran1.getId());
        platoRestoran.setPuntaje(0L);
        platoRestoran.setRestoran(restoran1);
        platoRestoran.setPlato(plato1);
        platoRestoran.setId(platoRestoranId);


        platoRestoranRepository.save(platoRestoran);

    }


}
