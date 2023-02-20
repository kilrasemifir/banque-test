package fr.banque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ICompteASeuilTest {
    ICompteASeuil compteASeuil;

    @BeforeEach
    void setUp() {
        compteASeuil = new CompteASeuil(1);
    }

    @Test
    @DisplayName("Doit pouvoir définir un seuil")
    void setSeuil() {
        double seuil = 100;
        compteASeuil.setSeuil(seuil);
        assertEquals(seuil, compteASeuil.getSeuil());
    }

    @Test
    @DisplayName("Doit pouvoir retirer de l'argent si le solde est supérieur au seuil")
    void retirer() {
        double montant = 100;
        compteASeuil.ajouter(montant);
        compteASeuil.retirer(montant);
        assertEquals(0, compteASeuil.getSolde());
    }

    @Test
    @DisplayName("Ne doit pas pouvoir retirer de l'argent si le solde est inférieur au seuil")
    void retirer2() {
        CompteASeuil compteASeuil = new CompteASeuil(1, 0);
        double montant = 100;
        compteASeuil.ajouter(montant);
        assertThrows(Exception.class, () -> {
            compteASeuil.retirer(montant*10);
        });
    }

    @Test
    @DisplayName("Doit afficher le seuil")
    void testToString() {
        double seuil = 100;
        compteASeuil.setSeuil(seuil);
        assertEquals("CompteASeuil{numero=1, seuil=" + seuil + ", solde=0.0}", compteASeuil.toString());
    }
}