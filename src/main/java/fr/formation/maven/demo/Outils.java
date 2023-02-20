package fr.formation.maven.demo;

public class Outils {

    public static void afficher(String message, String nom){
        System.out.println("["+nom+"]:"+message);
    }

    public static String miseEnForme(String message, String nom){
        return "["+nom+"]: "+message;
    }
}
