import processing.core.PApplet;

/**
 * upgradeAttack-Klasse zum Dekorieren
 */
public class upgradeAttack implements Levelup {

    PApplet window;

    /**
     * Konstruktor fuer die upgradeAttack-Klasse
     * @param iWindow Legt fest, auf welches Draw-Fenster wir zugreifen moechten
     */
    upgradeAttack(PApplet iWindow) {
        window = iWindow;
    }

    /**
     * Methode zum Darstellen des Gerüsts fuer das Attack-Upgrade
     *
     * @param start Bezieht sich auf ein Objekt der Start-Klasse
     * @param hero  Bezieht sich auf ein Objekt der Hero-Klasse
     * @param enemy Bezieht sich auf ein Objekt der Enemy-Klasse
     */
    @Override
    public void render(Start start, Hero hero, Enemy enemy) {
        window.rect(910, (float) window.height / 2, 182, 182);
    }
}
