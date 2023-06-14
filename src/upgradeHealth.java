import processing.core.PApplet;

/**
 * upgradeHealth-Klasse zum Dekorieren
 */
public class upgradeHealth implements Levelup {

    PApplet window;

    upgradeHealth(PApplet iWindow) {
        window = iWindow;
    }

    /**
     * Methode zum Darstellen des Gerüsts fuer das Health-Upgrade
     *
     * @param start Bezieht sich auf ein Objekt der Start-Klasse
     * @param hero  Bezieht sich auf ein Objekt der Hero-Klasse
     * @param enemy Bezieht sich auf ein Objekt der Enemy-Klasse
     */
    @Override
    public void render(Start start, Hero hero, Enemy enemy) {
        window.rect(182, (float) window.height / 2, 182, 182);
    }
}
