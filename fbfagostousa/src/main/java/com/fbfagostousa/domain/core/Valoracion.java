package com.fbfagostousa.domain.core;

import com.fbfagostousa.domain.users.Usuario;

import javax.persistence.*;
import java.util.List;

@Entity
public class Valoracion {

    /** La valoracion se hace sobre la caracteristica de la categoria de un plato la a partir de lógica de negocio
     * podremos ver si la caracteroistica de la categoría de ese plato existe para poder registrar la valoración */

    @Id
    private Long id;

    @ManyToOne
    private Plato plato;

    @ManyToOne
    private Caracteristica caracteristica;

    @ManyToOne
    private Usuario usuario;

    @Column
    private Long valor;


    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }



    /*
    @ManyToOne
    private PlatoRestoranDeprecated platoRestoranDeprecated;
*/
}
