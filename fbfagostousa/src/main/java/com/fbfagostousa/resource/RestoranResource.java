package com.fbfagostousa.resource;

import com.fbfagostousa.domain.CategoriaRestoranId;
import com.fbfagostousa.domain.Restoran;
import com.fbfagostousa.exception.CategoriaIdAndRestoranIdNotFoundException;
import com.fbfagostousa.exception.CategoriaIdNotFoundException;
import com.fbfagostousa.exception.CategoriaRestoranIdNotFoundException;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.service.CategoriaRestoranService;
import com.fbfagostousa.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restoran")
public class RestoranResource {

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private CategoriaRestoranService categoriaRestoranService;

    @GetMapping("{restoranId}")
    public Restoran findById(@PathVariable Long restoranId) throws RestoranIdNotFoundException {
        return restoranService.findById(restoranId);
    }

    @GetMapping("{restoranId}/categorias")
    public List<CategoriaRestoranId>findCategoriasRestoranByRestoranId(@PathVariable Long restoranId) throws RestoranIdNotFoundException {
        return restoranService.findCategoriasRestoranByRestoranId(restoranId);
    }

    @GetMapping("{restoranId}/categorias/{categoriaId}")
    public CategoriaRestoranId findCategoriaRestoranIdByCategoriaAndRestoran(@PathVariable Long restoranId,@PathVariable Long categoriaId) throws RestoranIdNotFoundException, CategoriaIdNotFoundException, CategoriaIdAndRestoranIdNotFoundException {
        return categoriaRestoranService.findCategoriaRestoranIdByCategoriaAndRestoran(categoriaId,restoranId);
    }

    @PostMapping("{restoranId}/categorias/{categoriaId}")
    public CategoriaRestoranId votarPorCategoriaDeUnRestoran(@PathVariable Long restoranId,@PathVariable Long categoriaId) throws CategoriaRestoranIdNotFoundException, RestoranIdNotFoundException, CategoriaIdNotFoundException, CategoriaIdAndRestoranIdNotFoundException {
        return categoriaRestoranService.votarPorCategoriaDeUnRestoran(categoriaId,restoranId);
    }

    @GetMapping("/findAll")
    public List<Restoran> findAll(){
        return restoranService.findAll();
    }

}
