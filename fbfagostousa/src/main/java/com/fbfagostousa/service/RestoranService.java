package com.fbfagostousa.service;

import com.fbfagostousa.domain.CategoriaRestoranId;
import com.fbfagostousa.domain.Restoran;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestoranService {

    @Autowired
    private RestoranRepository restoranRepository;

    public Restoran findById(Long id) throws RestoranIdNotFoundException {
       Optional<Restoran> optional=  restoranRepository.findById(id);
       if(!optional.isPresent())
           throw new RestoranIdNotFoundException("El restoran con id: ".concat(id.toString()).concat(" no encontrado"));

       return optional.get();
    }

    public List<Restoran> findAll(){
        return restoranRepository.findAll();
    }

    public List<CategoriaRestoranId> findCategoriasRestoranByRestoranId(Long restoranId) throws RestoranIdNotFoundException {
        List<CategoriaRestoranId> categoriaRestoranIds=new ArrayList<>();
        this.findById(restoranId).getCategorias().forEach(item->categoriaRestoranIds.add(item.getId()));
        return categoriaRestoranIds;
    }

}
