package com.fbfagostousa.service;

import com.fbfagostousa.domain.core.*;
import com.fbfagostousa.repository.CaracteristicaRepository;
import com.fbfagostousa.repository.CategoriaRepository;
import com.fbfagostousa.repository.PlatoRepository;
import com.fbfagostousa.repository.RestoranRepository;
import com.fbfagostousa.service.builder.PlatoBuilder;
import com.fbfagostousa.service.builder.RestoranBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class Fakemock {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    /*
    @Autowired
    private PlatoRestoranRepositoryDeprecated platoRestoranRepository;
    */

    @PostConstruct
    public void IngresarRestoranesyCategorias(){
        List<Caracteristica> caracteristicas=new ArrayList<>();
        Caracteristica caracteristica1=new Caracteristica();
        caracteristica1.setClave("Servicio de casa");
        Caracteristica caracteristica2=new Caracteristica();
        caracteristica2.setClave("Ambiente de casa");
        Caracteristica caracteristica3=new Caracteristica();
        caracteristica3.setClave("Sabor del plato");
        Caracteristica caracteristica4=new Caracteristica();
        caracteristica4.setClave("Presentación");
        Caracteristica caracteristica5=new Caracteristica();
        caracteristica5.setClave("Garzon");
        caracteristicas.add(caracteristica1);
        caracteristicas.add(caracteristica2);
        caracteristicas.add(caracteristica3);
        caracteristicas.add(caracteristica4);
        caracteristicas.add(caracteristica5);

        caracteristicas=caracteristicaRepository.saveAll(caracteristicas);

        Categoria categoria= new Categoria();
        categoria.setDescripion("Categoria Sopas");
        categoria.setCaracteristicas(caracteristicas);
        categoria=categoriaRepository.save(categoria);

        Restoran restoran1= new RestoranBuilder.Builder()
                                .setNombre("Aji seco")
                                .setDescripcion("Restoran Tradicional")
                                .build();

        Restoran restoran2= new RestoranBuilder.Builder()
                .setNombre("El Pollo Caballo")
                .setDescripcion("Restoran Tradicional")
                .build();

        Plato plato1 = new PlatoBuilder.Builder().setDescripcion("Sopa hecha con los más finos tomates del huerto")
                .setNombre("Tomato soup")
                .setRestoran(restoranRepository.save(restoran1))
                .setCategoria(categoria)
                .build();

        Plato plato2 =new PlatoBuilder.Builder().setDescripcion("Sopa hecha con carne de Vacuno")
                .setNombre("Cazuela de vacuno")
                .setRestoran(restoranRepository.save(restoran2))
                .setCategoria(categoria)
                .build();

        //SobreeEscribimos categoria con el retorno de su id.
        platoRepository.save(plato1);
        platoRepository.save(plato2);

    }


}
