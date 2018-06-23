package com.fbfagostousa.service;

import com.fbfagostousa.domain.Categoria;
import com.fbfagostousa.domain.CategoriaRestoran;
import com.fbfagostousa.domain.CategoriaRestoranId;
import com.fbfagostousa.domain.Restoran;
import com.fbfagostousa.repository.CategoriaRepository;
import com.fbfagostousa.repository.CategoriaRestoranRepository;
import com.fbfagostousa.repository.RestoranRepository;
import com.fbfagostousa.service.builder.CategoriaBuilder;
import com.fbfagostousa.service.builder.RestoranBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class Fakemock {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private CategoriaRestoranRepository categoriaRestoranRepository;

    @PostConstruct
    public void IngresarRestoranesyCategorias(){

        Categoria categoria1= new CategoriaBuilder.Builder().setDescripcion("Atiende a las personas del restoran")
                                                            .setNombre("Garzon del restoran")
                                                            .build();

        Categoria categoria2=new CategoriaBuilder.Builder().setDescripcion("Categoria tradicional")
                                                            .setNombre("Tradicional")
                                                            .build();

        //SobreeEscribimos categoria con el retorno de su id.
        categoria1= categoriaRepository.save(categoria1);

       // categoria1= categoriaRepository.save(categoria2);




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



        CategoriaRestoran categoriaRestoran=new CategoriaRestoran();

        CategoriaRestoranId categoriaRestoranId= new CategoriaRestoranId(categoria1.getId(),restoran1.getId());
        categoriaRestoranId.setPuntaje(0L);
        categoriaRestoran.setRestoran(restoran1);
        categoriaRestoran.setCategoria(categoria1);
        categoriaRestoran.setId(categoriaRestoranId);


        categoriaRestoranRepository.save(categoriaRestoran);

    }


}
