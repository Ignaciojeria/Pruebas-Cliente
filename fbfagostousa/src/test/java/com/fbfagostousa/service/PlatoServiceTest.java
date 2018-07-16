package com.fbfagostousa.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")//Indicamos que el perfil activo es test!
public class PlatoServiceTest {

    //Inyecta el mock del servicio
    @Autowired
    private Fakemock fackeMock;

    //Antes de votar inicializamos la data de contexto h2 del fichero yml
    @Before
    public void initData(){
    fackeMock.IngresarRestoranesyCategorias();
    }

    @Test
    public void votar(){

    }

    @Before
    public void antesDeVotar(){
        System.out.println("Me he ejecutado antes de votar");
    }

    @After
    public void despuesDeVotar(){
        System.out.println("He votado satisfactoriamente");
    }
}
