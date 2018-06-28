package com.fbfagostousa.service;

import com.fbfagostousa.domain.core.PlatoRestoranId;
import com.fbfagostousa.domain.core.Restoran;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PlatoRestoranId> findPlatosRestoranByRestoranId(Long restoranId) throws RestoranIdNotFoundException {
        return  this.findById(restoranId).getplatos().stream().map(item -> new PlatoRestoranId(item.getPlato().getId(),item.getRestoran().getId(),item.getPuntaje())).collect(Collectors.toList());
    }

}
