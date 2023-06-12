import processing.core.PApplet;

/**
 * upgradeAttack-Klasse zum Dekorieren
 */
public class upgradeAttack implements Levelup {

    PApplet window;

    upgradeAttack(PApplet iWindow) {
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
        window.rect(910, window.height / 2, 182, 182);
    }
}
