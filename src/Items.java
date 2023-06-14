import processing.core.PApplet;

/**
 * Item-Klasse zum Darstellen der Upgradeflaechen, die dekorierbar sind
 */
public abstract class Items implements Levelup {

    /**
     * @param window Legt fest, auf welches Draw-Fenster wir zugreifen moechten
     * @param levelup Bezieht sich auf das Interface Levelup
     */
    PApplet window;
    protected Levelup levelup;

    /**
     * Konstruktor für die Items-Klasse
     * @param levelup Bezieht sich auf das Interface Levelup
     */
    public Items(Levelup levelup) {
        this.levelup = levelup;
    }

    public void render(Start start, Hero hero, Enemy enemy) {
        levelup.render(start, hero, enemy);
    }
}
