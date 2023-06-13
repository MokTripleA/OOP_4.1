import processing.core.PApplet;

/**
 * Creature-Klasse als Parent für jedes Wesen im Spiel
 */
public abstract class Creature {

    PApplet window;
    float xPos;
    float yPos;
    float health;
    float speed;
    float size;
    boolean alive;
    boolean attacking;
    boolean protection;
    int attack;
    int points;
    int range;

    /**
     * Konstruktor zum Erschaffen der Wesen
     *
     * @param iWindow        Legt fest, auf welches Draw-Fenster wir zugreifen möchten
     * @param inputPositionX Beschreibt die Position auf der x-Achse
     * @param inputPositionY Beschreibt die Position auf der y-Achse
     * @param iHealth        Indikator fuer das Leben des jeweiligen Wesens
     * @param iSpeed         Beschreibt mit wie viel Pixeln pro Draw-Durchlauf sich das Wesen bewegen kann
     * @param iSize          Beschreibt die Groeße des Wesens in x- und y-Richtung in Pixel
     * @param iAlive         Sagt aus, ob das Wesen noch am Leben ist und beispielsweise Methoden ausfuehren kann
     * @param iAttack        Legt einen Wert fest, welcher anderen Wesen beim Angriff von health abgezogen wird
     * @param iAttacking     Sagt aus, ob das Wesen gerade angreift oder nicht
     * @param iProtection    Sagt aus, ob die Gegner den Helden angreifen koennen oder nicht
     * @param iPoints        Legt fest, wie viele Punkte der Hero hat, für Minion und Boss hat diese Variable nichts auszusagen
     * @param iRange         Legt die Range fest, mit der der Hero angreifen kann, fuer Minion und Boss hat diese Variable nichts auszusagen
     */
    Creature(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, boolean iProtection, int iPoints, int iRange) {
        window = iWindow;
        xPos = inputPositionX;
        yPos = inputPositionY;
        health = iHealth;
        speed = iSpeed;
        size = iSize;
        alive = iAlive;
        attack = iAttack;
        attacking = iAttacking;
        protection = iProtection;
        points = iPoints;
        range = iRange;
    }

    /**
     * Methode zum Malen des Wesens
     *
     * @param creature Entscheidet, welche Creature gezeichnet wird
     */
    public abstract void render(Creature creature);

    /**
     * Methode, um das Wesen zu bewegen
     *
     * @param x Beliebige Position auf der x-Achse
     * @param y Beliebige Position auf der y-Achse
     * @param hero Bezieht sich auf das einzige Objekt aus der Helden-Klasse
     */
    public abstract void walk(float x, float y, Hero hero);

    /**
     * Methode, damit das Wesen kämpfen kann
     *
     * @param creature Entscheidet, welche Creature bekaempft wird
     */
    public abstract void fight(Creature creature);
}
