import processing.core.PApplet;

/**
 * upgradeSpeed-Klasse zum Dekorieren
 */
public class upgradeSpeed implements Levelup {

    PApplet window;

    upgradeSpeed(PApplet iWindow) {
        window = iWindow;
    }

    /**
     * Methode zum Darstellen des Gerüsts fuer das Attack-Upgrade
     *
     * @param hero
     * @param start
     */
    @Override
    public void render(Hero hero, Start start) {
        window.rect(546, window.height / 2, 182, 182);
    }
}
