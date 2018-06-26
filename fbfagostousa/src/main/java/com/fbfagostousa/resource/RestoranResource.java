package com.fbfagostousa.resource;

import com.fbfagostousa.domain.core.CategoriaRestoranId;
import com.fbfagostousa.domain.core.Restoran;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.exception.CategoriaIdAndRestoranIdNotFoundException;
import com.fbfagostousa.exception.CategoriaIdNotFoundException;
import com.fbfagostousa.exception.CategoriaRestoranIdNotFoundException;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.service.CategoriaRestoranService;
import com.fbfagostousa.service.RestoranService;
import com.fbfagostousa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restoran")
public class RestoranResource {

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private CategoriaRestoranService categoriaRestoranService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("{restoranId}")
    public Restoran findById(@PathVariable Long restoranId) throws RestoranIdNotFoundException {
        return restoranService.findById(restoranId);
    }

    @GetMapping("{restoranId}/categorias")
    public List<CategoriaRestoranId>findCategoriasRestoranByRestoranId(@PathVariable Long restoranId) throws RestoranIdNotFoundException {
        return restoranService.findCategoriasRestoranByRestoranId(restoranId);
    }

    //El codigo QR redireccionaría por get a esta ruta (restoran + categoría!!)
    @GetMapping("{restoranId}/categorias/{categoriaId}")
    public CategoriaRestoranId findCategoriaRestoranIdByCategoriaAndRestoran(@PathVariable Long restoranId,@PathVariable Long categoriaId) throws RestoranIdNotFoundException, CategoriaIdNotFoundException, CategoriaIdAndRestoranIdNotFoundException {
        return categoriaRestoranService.findCategoriaRestoranIdByCategoriaAndRestoran(categoriaId,restoranId);
    }

    @PostMapping("{restoranId}/categorias/{categoriaId}/login/{email}")
    public Usuario asd(@PathVariable String email,@PathVariable Long restoranId, @PathVariable Long categoriaId){
        return usuarioService.IngresarConEmailPosicionadoEnLaCategoriaDeUnRestoranPorSuCodigoQr(email,categoriaId,restoranId);
    }

    /*Deprecated! Se debe votar por sus sub-categorías!!
    @PostMapping("{restoranId}/categorias/{categoriaId}")
    public CategoriaRestoranId votarPorCategoriaDeUnRestoran(@PathVariable Long restoranId,@PathVariable Long categoriaId) throws CategoriaRestoranIdNotFoundException, RestoranIdNotFoundException, CategoriaIdNotFoundException, CategoriaIdAndRestoranIdNotFoundException {
        return categoriaRestoranService.votarPorCategoriaDeUnRestoran(categoriaId,restoranId);
    }*/

    @GetMapping("/findAll")
    public List<Restoran> findAll(){
        return restoranService.findAll();
    }

}
