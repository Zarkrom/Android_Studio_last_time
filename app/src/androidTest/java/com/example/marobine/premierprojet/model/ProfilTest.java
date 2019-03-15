package com.example.marobine.premierprojet.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfilTest {

    //Création profil
    private Profil profil = new Profil (59.9f, 1.69f,1);
    // résultat IMC attendu
    private float imc = 40;
    // message attendu
    private String message = "cas de poids idéal";

    // TODO: Faire 7 cas pour l'IMC
    // TODO: Faire 3 cas de poids idéal femme
    // TODO: Faire 3 cas de poids idéal homme

    @Test
    public void getResultatIMC() throws Exception {
        assertEquals("### message si erreur ###", imc, profil.getResultatIMC(), (float) 0.1);
    }

    @Test
    public void getMessage() throws {
        assertEquals(message, profil.getMessage());
    }

    @Test
    public void getPoids() {
    }

    @Test
    public void getTaille() {
    }

    @Test
    public void getSexe() {
    }

    @Test
    public void getResultatIMC1() {
    }

}