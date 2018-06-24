package com.fbfagostousa.service;

import com.fbfagostousa.domain.Categoria;
import com.fbfagostousa.domain.CategoriaRestoran;
import com.fbfagostousa.domain.CategoriaRestoranId;
import com.fbfagostousa.domain.Restoran;
import com.fbfagostousa.exception.CategoriaIdAndRestoranIdNotFoundException;
import com.fbfagostousa.exception.CategoriaIdNotFoundException;
import com.fbfagostousa.exception.CategoriaRestoranIdNotFoundException;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.repository.CategoriaRestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaRestoranService {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private CategoriaRestoranRepository categoriaRestoranRepository;

    public CategoriaRestoranId findCategoriaRestoranIdByCategoriaAndRestoran( Long categoriaId,
                                                                              Long restoranId) throws RestoranIdNotFoundException, CategoriaIdNotFoundException, CategoriaIdAndRestoranIdNotFoundException {

        Restoran restoran= restoranService.findById(restoranId);

        Categoria categoria=categoriaService.findById(categoriaId);

        Optional<CategoriaRestoran> categoriaRestoranOptional=categoriaRestoranRepository.findByRestoranAndCategoria(restoran,categoria);

        if(!categoriaRestoranOptional.isPresent())
            throw new CategoriaIdAndRestoranIdNotFoundException("El restoran con id "+restoranId +" no tiene dentro de sus categorias a la categoria con id: "+categoriaId);

        CategoriaRestoran categoriaRestoran = categoriaRestoranOptional.get();

        CategoriaRestoranId categoriaRestoranId=categoriaRestoran.getId();
        categoriaRestoranId.setPuntajeTransiente(categoriaRestoran.getPuntaje());
        return categoriaRestoranId;
    }

    public CategoriaRestoranId votarPorCategoriaDeUnRestoran( Long categoriaId, Long restoranId) throws RestoranIdNotFoundException, CategoriaIdNotFoundException, CategoriaRestoranIdNotFoundException, CategoriaIdAndRestoranIdNotFoundException {
        CategoriaRestoranId categoriaRestoranId= this.findCategoriaRestoranIdByCategoriaAndRestoran(categoriaId,restoranId);
        Optional<CategoriaRestoran> categoriaRestoranOptional= categoriaRestoranRepository.findById(categoriaRestoranId);
        if(!categoriaRestoranOptional.isPresent())
            throw new CategoriaRestoranIdNotFoundException("La categoria con id: ".concat(categoriaId.toString()).concat(" y retoran id: ".concat(restoranId.toString()).concat("no existe")) );

        CategoriaRestoran categoriaRestoran=categoriaRestoranOptional.get();

        categoriaRestoran.setPuntaje(categoriaRestoran.getPuntaje()+1);

        categoriaRestoranId= categoriaRestoranRepository.save(categoriaRestoran).getId();

        categoriaRestoranId.setPuntajeTransiente(categoriaRestoran.getPuntaje());

        return  categoriaRestoranId;
    }


}
