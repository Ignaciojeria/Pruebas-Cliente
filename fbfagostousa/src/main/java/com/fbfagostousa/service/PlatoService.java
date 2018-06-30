package com.fbfagostousa.service;

import com.fbfagostousa.domain.core.*;
import com.fbfagostousa.exception.CaracteristicasCategoriaNotFoundException;
import com.fbfagostousa.exception.PlatoIdAndRestoranIdNotFoundException;
import com.fbfagostousa.exception.PlatoIdNotFoundException;
import com.fbfagostousa.exception.RestoranIdNotFoundException;
import com.fbfagostousa.repository.PlatoRepository;
import com.fbfagostousa.service.builder.ValoracionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RestController
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private RestoranService restoranService;
    

    @Autowired
    private ValoracionService valoracionService;

    @Autowired
    private HistorialVotacionService historialVotacionService;

    public Plato findById(Long id) throws PlatoIdNotFoundException {
        Optional<Plato> optional= platoRepository.findById(id);
        if(!optional.isPresent())
            throw new PlatoIdNotFoundException("La plato con el id: ".concat(id.toString()).concat(" no existe"));

        return optional.get();
    }

    public  Plato findByIdAndRestoran(Long id,Long restoranId) throws PlatoIdAndRestoranIdNotFoundException, RestoranIdNotFoundException {
        Restoran restoran= restoranService.findById(restoranId);
        Optional<Plato> platoOptional=platoRepository.findByIdAndRestoran(id,restoran);
        if(!platoOptional.isPresent())
            throw new PlatoIdAndRestoranIdNotFoundException("El plato con id: ".concat(id.toString()).concat(" no existe en el restoran con id: ").concat(restoranId.toString()));
        return platoOptional.get();
    }

   // @Transactional
    public List<Valoracion> votarPorCaracteristicasDeCategoriaDeUnPlato(List<Valoracion> valoracionesRequest,Long platoId) throws PlatoIdNotFoundException, CaracteristicasCategoriaNotFoundException {
        List<Caracteristica> caracteristicas=new ArrayList<>();
        Plato plato= this.findById(platoId);
        List<Valoracion> valoraciones=new ArrayList<>();
        HistorialVotacion historialVotacion=new HistorialVotacion();
        historialVotacion.setPlato(plato);
        historialVotacion.setFechaVotacion(LocalDate.now());
        historialVotacion.setHoraVotacion(LocalTime.now());
        historialVotacion.setUsuario(null);
        final HistorialVotacion hitorialVotacionFinal=historialVotacionService.save(historialVotacion);

        valoracionesRequest.forEach(item->{
            caracteristicas.add(item.getCaracteristica());
            valoraciones.add(new ValoracionBuilder.Builder()
                                .setValor(item.getValor())
                                .setPlato(plato)
                                .setHistorialVotacion(hitorialVotacionFinal)
                                .setCaracteristica(item.getCaracteristica())
                                .build());
        });
        //Validamos caracteristicas de la categoria del plato

        this.validarCaracteristicasDelPlatoEnEvaluacion(caracteristicas,plato);

    return valoracionService.valorarPlato(valoraciones);
    }



    public void validarCaracteristicasDelPlatoEnEvaluacion(List<Caracteristica> caracteristicas, Plato plato) throws CaracteristicasCategoriaNotFoundException {
        if(!caracteristicas.containsAll(plato.getCategoria().getCaracteristicas())){
            String caracteristicasValidas=getStringCaracteristicasCategoriaPlato(plato);
            throw new CaracteristicasCategoriaNotFoundException("Las caracteristicas "+
                    "de la categoria del plato sobre el cual realzar"
                            .concat("la votacion erroneas; La lista de categorias ")
                            .concat("que contiene el plato sobre la cual realizar ")
                            .concat("una valoración son las siguientes: ")
                            .concat(caracteristicasValidas));
        }
    }

    private String getStringCaracteristicasCategoriaPlato(Plato plato){
        StringBuilder caracteristicas=new StringBuilder();
        plato.getCategoria().getCaracteristicas().forEach(item->{
            caracteristicas.append(item.getClave().concat(", "));
        });
        caracteristicas.append(".");
        return caracteristicas.toString();
    }



}
