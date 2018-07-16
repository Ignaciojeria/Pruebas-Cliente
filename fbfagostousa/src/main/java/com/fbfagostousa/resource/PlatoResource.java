package com.fbfagostousa.resource;

import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.domain.core.Valoracion;
import com.fbfagostousa.exception.*;
import com.fbfagostousa.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoResource {
    @Autowired
    private PlatoService platoService;

    @PostMapping("{platoId}/votar")
    public List<Valoracion> votarPorCaracteristicasDeCategoriaDeUnPlato(@RequestBody List<Valoracion> valoracionesRequest, @PathVariable Long platoId, @RequestHeader HttpHeaders headers) throws PlatoIdNotFoundException, AuthorizationHeaderBadRequestException, HistorialVotacionUsuarioAndPlatoFoundException, CaracteristicasCategoriaNotFoundException, UsuarioFieldsNotFoundException {
        return platoService.votarPorCaracteristicasDeCategoriaDeUnPlato(valoracionesRequest,platoId,headers);
    }

    @GetMapping("{platoId}")
    public Plato findById(@PathVariable Long platoId) throws PlatoIdNotFoundException {
        return platoService.findById(platoId);
    }
}
