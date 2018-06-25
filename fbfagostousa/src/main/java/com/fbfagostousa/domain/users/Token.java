package com.fbfagostousa.domain.users;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Embeddable
public class Token {

    @Column
    private String valorToken;

    @Column
    private LocalDate fechaCreacionToken;

    @Column
    private LocalTime horaCreacionToken;

    public Token(){
        //Encriptamos el valor del token con la Clase Encrypting del paquete users
        this.setValue(new Encrypting().encryptInBase64UrlSafe(Long.toString(new Date().getTime())));
    }

    public String getValorToken() {
        return valorToken;
    }


    public void setValorToken(String valorToken) {
        this.valorToken = valorToken;
    }

    public LocalDate getFechaCreacionToken() {
        return fechaCreacionToken;
    }

    public void setFechaCreacionToken(LocalDate fechaCreacionToken) {
        this.fechaCreacionToken = fechaCreacionToken;
    }

    public LocalTime getHoraCreacionToken() {
        return horaCreacionToken;
    }

    public void setHoraCreacionToken(LocalTime horaCreacionToken) {
        this.horaCreacionToken = horaCreacionToken;
    }

    private void setValue(String value){
        this.fechaCreacionToken=LocalDate.now();
        this.horaCreacionToken=LocalTime.now();
        this.valorToken=value;
    }
}
