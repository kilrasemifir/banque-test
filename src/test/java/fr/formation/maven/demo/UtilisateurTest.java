package fr.formation.maven.demo;

import jdk.jshell.execution.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurTest {
    Utilisateur utilisateur;

    @BeforeEach
    void beforeEach(){
        this.utilisateur = new Utilisateur();
    }

    @Test
    void setNom() {
        String nom = "TrucMuCh";
        // When
        utilisateur.setNom(nom);
        // Then
        assertEquals("trucmuch", utilisateur.getNom());
    }

    @Test
    void setPrenom() {

        String prenom = "MichMich";

        utilisateur.setPrenom(prenom);

        assertEquals("michmich", utilisateur.getPrenom());
    }
}