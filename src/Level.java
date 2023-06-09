import processing.core.PApplet;

/**
 * Level-Klasse zum Darstellen der "Spiel-Ebene"
 */
public class Level extends PApplet {

    PApplet window;
    int width;
    int height;

    /**
     * Konstruktor fuer die Level-Klasse
     *
     * @param iWindow Legt fest, auf welches Draw-Fenster wir zugreifen moechten
     * @param iWidth  Setzt die Weite des Level-Fensters fest
     * @param iHeight Setzt die Hoehe des Level-Fensters fest
     */
    Level(PApplet iWindow, int iWidth, int iHeight) {
        window = iWindow;
        width = iWidth;
        height = iHeight;
    }

    /**
     * Methode zum Generieren der Spiel-Ebene
     *
     * @param hero Bezieht sich auf ein Objekt der Hero-Klasse
     */
    public void generate(Creature hero) {
        if (hero.alive) {
            window.textSize(15);
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(200);
            window.rect(0, 0, window.width, window.height);
            window.fill(0, 200, 0);
            window.rect(0, 0, this.width, this.height);
        } else {
        }
    }
}
