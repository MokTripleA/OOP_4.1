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
     * @param hero
     * @param start
     */
    @Override
    public void render(Hero hero, Start start) {
        window.rect(182, window.height / 2, 182, 182);
    }
}
