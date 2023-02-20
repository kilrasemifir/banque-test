package fr.dessin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void setX() {
        // Given
        Point2D point2D = new Point2D();
        int x = 5;

        // When
        point2D.setX(x);

        // Then
        assertEquals(x, point2D.getX());
    }

    @Test
    void setY() {
        // Given
        Point2D point2D = new Point2D();
        int y = 5;

        // Then
        point2D.setY(y);

        // Given
        assertEquals(y, point2D.getY());
    }

    @Test
    void getCompteur() {
        // Given

        // When
        int before = Point2D.getCompteur();
        Point2D point2D = new Point2D();
        int result = Point2D.getCompteur();

        // Then
        assertEquals(before+1, result);
    }

    @Test
    @DisplayName("Doit incrémenter X en fonction du paramètre dX")
    void translaterX() {
        // Given
        int dX = 3;
        int dY = -8;
        Point2D point2D = new Point2D();

        // When
        point2D.translater(dX, dY);

        // Then
        assertEquals(dX, point2D.getX());
    }

    @Test
    @DisplayName("Doit incrémenter Y en fonction du paramètre dY")
    void translaterY() {
        // Given
        int dX = 3;
        int dY = -8;
        Point2D point2D = new Point2D();

        // When
        point2D.translater(dX, dY);

        // Then
        assertEquals(dY, point2D.getY());
    }

    @Test
    void dumpTest(){
        Point2D point2D = new Point2D();
        point2D.afficher();
    }
}