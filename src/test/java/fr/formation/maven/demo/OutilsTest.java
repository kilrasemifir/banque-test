package fr.formation.maven.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutilsTest {

    @Test
    void miseEnForme() {
        // GIVEN
        String message = "Hello World";
        String nom = "Toto";
        // WHEN
        String result = Outils.miseEnForme(message, nom);
        // THEN
        assertEquals("[Toto]: Hello World", result);
    }
}