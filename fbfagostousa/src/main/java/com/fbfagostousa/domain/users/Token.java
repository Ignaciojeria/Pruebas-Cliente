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
    private Long restoranId;

    @Column
    private Long categoriaId;

    @Column
    private LocalDate fechaCreacionToken;

    @Column
    private LocalTime horaCreacionToken;

    public Token(){
        //Encriptamos el valor del token con la Clase Encrypting del paquete users
        this.setValue(new Encrypting().encryptInBase64UrlSafe(Long.toString(new Date().getTime())));
    }

    public Token(Long restoranId, Long categoriaId){
        this.restoranId=restoranId;
        this.categoriaId=categoriaId;
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

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    private void setValue(String value){
        this.fechaCreacionToken=LocalDate.now();
        this.horaCreacionToken=LocalTime.now();
        this.valorToken=value;
    }
}