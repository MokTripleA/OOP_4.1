import processing.core.PApplet;

/**
 * upgradeSpeed-Klasse zum Dekorieren
 */
public class upgradeSpeed implements Levelup {

    PApplet window;

    /**
     * Konstruktor fuer die upgradeSpeed-Klasse
     *
     * @param iWindow
     */
    upgradeSpeed(PApplet iWindow) {
        window = iWindow;
    }

    /**
     * Methode zum Darstellen des Gerüsts fuer das Speed-Upgrade
     *
     * @param start Bezieht sich auf ein Objekt der Start-Klasse
     * @param hero  Bezieht sich auf ein Objekt der Hero-Klasse
     * @param enemy Bezieht sich auf ein Objekt der Enemy-Klasse
     */
    @Override
    public void render(Start start, Hero hero, Enemy enemy) {
        window.rect(546, (float) window.height / 2, 182, 182);
    }
}
