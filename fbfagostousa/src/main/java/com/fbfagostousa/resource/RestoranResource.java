package com.fbfagostousa.resource;

import com.fbfagostousa.domain.core.PlatoRestoranIdDeprecated;
import com.fbfagostousa.domain.core.Restoran;
import com.fbfagostousa.domain.users.Usuario;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.service.PlatoRestoranService;
import com.fbfagostousa.service.RestoranService;
import com.fbfagostousa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restoran")
public class RestoranResource {

    @Autowired
    private RestoranService restoranService;

    @Autowired
    private PlatoRestoranService platoRestoranService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("{restoranId}")
    public Restoran findById(@PathVariable Long restoranId) throws RestoranIdNotFoundException {
        return restoranService.findById(restoranId);
    }

    /*
    @GetMapping("{restoranId}/platos")
    public List<PlatoRestoranIdDeprecated>findPlatosRestoranByRestoranId(@PathVariable Long restoranId) throws RestoranIdNotFoundException {
        return restoranService.findPlatosRestoranByRestoranId(restoranId);
    }*/

    //El codigo QR redireccionaría por get a esta ruta (restoran + plato!!)
    /*
    @GetMapping("{restoranId}/platos/{platoId}")
    public PlatoRestoranIdDeprecated findPlatoRestoranIdByPlatoAndRestoran(@PathVariable Long restoranId, @PathVariable Long platoId) throws RestoranIdNotFoundException, PlatoIdNotFoundException, PlatoIdAndRestoranIdNotFoundException {
        return platoRestoranService.findPlatoRestoranIdByPlatoAndRestoran(platoId,restoranId);
    }*/

    @PostMapping("{restoranId}/platos/{platoId}/login/{email}")
    public Usuario asd(@PathVariable String email,@PathVariable Long restoranId, @PathVariable Long platoId){
        return usuarioService.IngresarConEmailPosicionadoEnElPlatoDeUnRestoranPorSuCodigoQr(email,platoId,restoranId);
    }

    /*Deprecated! Se debe votar por sus sub-categorías!!
    @PostMapping("{restoranId}/platos/{platoId}")
    public PlatoRestoranIdDeprecated votarPorCategoriaDeUnRestoran(@PathVariable Long restoranId,@PathVariable Long platoId) throws PlatoRestoranIdNotFoundException, RestoranIdNotFoundException, PlatoIdNotFoundException, PlatoIdAndRestoranIdNotFoundException {
        return categoriaRestoranService.votarPorCategoriaDeUnRestoran(platoId,restoranId);
    }*/

    @GetMapping("/findAll")
    public List<Restoran> findAll(){
        return restoranService.findAll();
    }

}
