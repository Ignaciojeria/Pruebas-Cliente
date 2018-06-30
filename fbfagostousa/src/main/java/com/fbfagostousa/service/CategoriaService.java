package com.fbfagostousa.service;

import com.fbfagostousa.domain.core.Caracteristica;
import com.fbfagostousa.domain.core.Categoria;
import com.fbfagostousa.domain.core.Plato;
import com.fbfagostousa.exception.CaracteristicasCategoriaNotFoundException;
import com.fbfagostousa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
   // la categoria del plato sobre la cual realizar una valoración erroneas

    @Autowired
    private CategoriaRepository categoriaRepository;

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
