package fr.banque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteASeuilRemunereTest {
    CompteASeuilRemunere compte;

    @BeforeEach
    void setUp() {
        compte = new CompteASeuilRemunere(1, 0.1);
    }

    @Test
    @DisplayName("Doit pouvoir définir un seuil")
    void setSeuil() {
        double seuil = 100;
        compte.setSeuil(seuil);
        assertEquals(seuil, compte.getSeuil());
    }

    @Test
    @DisplayName("Doit pouvoir retirer de l'argent si le solde est supérieur au seuil")
    void retirer() {
        double montant = 100;
        compte.ajouter(montant);
        compte.retirer(montant);
        assertEquals(0, compte.getSolde());
    }

    @Test
    @DisplayName("Ne doit pas pouvoir retirer de l'argent si le solde est inférieur au seuil")
    void retirer2() {
        double montant = 100;
        compte.ajouter(montant);
        assertThrows(Exception.class, () -> {
            compte.retirer(montant*10);
        });
    }
}