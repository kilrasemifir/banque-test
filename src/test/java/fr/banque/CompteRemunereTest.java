package fr.banque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteRemunereTest {

    ICompteRemunere compte;

    @BeforeEach
    void setUp() {
        compte = new CompteRemunere(1, 0.1);
    }

    @Test
    @DisplayName("Le taux doit être positif")
    void setTaux() {
        double taux = -0.1;
        compte.setTaux(taux);
        assertEquals(0, compte.getTaux());
    }

    @Test
    @DisplayName("Le taux doit être inférieur à 1")
    void setTaux2() {
        double taux = 1.1;
        compte.setTaux(taux);
        assertEquals(1, compte.getTaux());
    }

    @Test
    @DisplayName("Le taux doit être supérieur à 0 et inférieur à 1")
    void setTaux3() {
        double taux = 0.5;
        compte.setTaux(taux);
        assertEquals(taux, compte.getTaux());
    }

    @Test
    @DisplayName("Les interets doivent être calculés solde*taux")
    void calculerInterets() {
        double solde = 100;
        double taux = 0.1;
        compte.ajouter(solde);
        compte.setTaux(taux);
        assertEquals(solde*taux, compte.calculerInterets());
    }

    @Test
    @DisplayName("Lors de l'ajout d'interets, le solde doit être augmenté")
    void verserInterets() {
        double solde = 100;
        double taux = 0.1;
        compte.ajouter(solde);
        compte.setTaux(taux);
        compte.verserInterets();

        assertEquals(Math.round(solde*(1+taux)), Math.round(compte.getSolde()));
    }

    @Test
    @DisplayName("ToString")
    void toStringTest() {
        String result = compte.toString();
        assertEquals("CompteRemunere{numero=1, taux=0.1, solde=0.0}", result);
    }
}