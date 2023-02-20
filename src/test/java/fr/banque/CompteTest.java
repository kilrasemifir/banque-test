package fr.banque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test de la classe Compte")
class CompteTest {

    Compte compte;
    int numero = 1;

    @BeforeEach
    void setUp() {
         compte = new Compte(numero);
    }

    @Test
    @DisplayName("Doit posséder un numéro de compte")
    void getNumero() {
        // given
        Compte compte1 = new Compte(1);
        // When
        int numero = compte1.getNumero();
        //Then
        assertEquals(1, numero);
    }

    @Test
    @DisplayName("Doit posséder un solde initialisé à 0")
    void getSolde() {
        assertEquals(0, compte.getSolde());
    }

    @Test
    @DisplayName("Doit pouvoir déposer de l'argent")
    void ajouter() {
        // Given
        double montant = 100;

        // When
        compte.ajouter(montant);

        // Then
        assertEquals(montant, compte.getSolde());
    }

    @Test
    @DisplayName("Doit pouvoir retirer de l'argent")
    void retirer() {
        // Given
        double montant = 100;

        // When
        compte.retirer(montant);

        // Then
        assertEquals(-100, compte.getSolde());
    }

    @Test
    @DisplayName("Ne doit pas pouvoir déposer de l'argent négatif")
    void ajouterNegatif() {
        // Given
        double montant = -100;

        // When
        compte.ajouter(montant);

        // Then
        assertEquals(0, compte.getSolde());
    }

    @Test
    @DisplayName("Doit pouvoir definir un solde")
    void testSolde() {
        // Given
        double montant = 100;

        // When
        compte.setSolde(montant);

        // Then
        assertEquals(montant, compte.getSolde());
    }

    @Test
    @DisplayName("ToString doit retourner le numéro et le solde")
    void testToString() {
        // Given
        double montant = 100;
        compte.setSolde(montant);

        // When
        String result = compte.toString();

        // Then
        assertEquals("Compte{numero=1, solde=100.0}", result);
    }
}