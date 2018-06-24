package com.fbfagostousa.resource;

import com.fbfagostousa.domain.CategoriaRestoranId;
import com.fbfagostousa.domain.Restoran;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restoran")
public class RestoranResource {

    @Autowired
    private RestoranService restoranService;

    @GetMapping("{restoranId}")
    public Restoran findById(@PathVariable Long restoranId) throws RestoranIdNotFoundException {
        return restoranService.findById(restoranId);
    }

    @GetMapping("{restoranId}/categorias")
    public List<CategoriaRestoranId>findCategoriasRestoranByRestoranId(@PathVariable Long restoranId) throws RestoranIdNotFoundException {
        return restoranService.findCategoriasRestoranByRestoranId(restoranId);
    }

    @GetMapping("/findAll")
    public List<Restoran> findAll(){
        return restoranService.findAll();
    }

}
