package fr.banque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client;
    int numero = 1;
    String nom = "Jean";
    String prenom = "Michmich";
    int age = 20;

    @BeforeEach
    void setUp() {
        client = new Client(numero, nom, prenom, age);
    }

    @Test
    @DisplayName("Doit retourner le numéro du client")
    void getNumero() {
        assertEquals(numero, client.getNumero());
    }

    @Test
    @DisplayName("Peut define le nom du client")
    void setNom() {
        String nom = "Michel";
        client.setNom(nom);
        assertEquals(nom, client.getNom());
    }

    @Test
    @DisplayName("Peut define le prénom du client")
    void setPrenom() {
        String prenom = "Jean";
        client.setPrenom(prenom);
        assertEquals(prenom, client.getPrenom());
    }

    @Test
    @DisplayName("Peut define l'age du client")
    void setAge() {
        int age = 30;
        client.setAge(age);
        assertEquals(age, client.getAge());
    }

    @Test
    @DisplayName("Doit retourner un compte du client en fonction de son numéro")
    void getCompte() {
        Compte compte = new Compte(1, 100);
        client.ajouterCompte(compte);
        assertEquals(compte, client.getCompte(1));
    }

    @Test
    @DisplayName("Doit retourner une exception si le compte n'existe pas")
    void getCompteNull() {
        assertThrows(BanqueException.class, () -> client.getCompte(1));
    }

    @Test
    @DisplayName("Doit pouvoir ajouter un compte au client s'il y a de la place")
    void ajouterCompte() {
        Compte compte = new Compte(1, 100);
        client.ajouterCompte(compte);
        assertEquals(compte, client.getCompte(1));
    }

    @Test
    @DisplayName("Ne doit pas pouvoir ajouter un compte au client s'il n'y a pas de la place")
    void ajouterComptePasDePlace() {
        for (int i = 0; i < 5; i++) {
            client.ajouterCompte(new Compte(i, 100));
        }
        assertThrows(BanqueException.class, () -> client.ajouterCompte(new Compte(5)));
    }
    @Test
    @DisplayName("ToString retourne le nom et le prénom du client")
    void testToString() {
        String expected = "Client{numero=1, nom='Jean', prenom='Michmich', age=20, comptes=[null, null, null, null, null]}";
        String actual = client.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Doit ajouter un compte au client")
    void ajouterComptev2() {
        Compte compte = new Compte(1, 100);
        client.ajouterComptev2(compte);
        assertEquals(compte, client.getCompte(1));
    }

    @Test
    @DisplayName("Ne doit pas pouvoir ajouter un compte au client s'il n'y a pas de la place")
    void ajouterCompteV2PasDePlace() {
        for (int i = 0; i < 6; i++) {
            client.ajouterComptev2(new Compte(i, 100));
        }
        assertThrows(Exception.class,()-> client.getCompte(5) );
    }
}