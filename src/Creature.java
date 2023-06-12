import processing.core.PApplet;

/**
 * Creature-Klasse als Parent für jedes Wesen im Spiel
 */
public abstract class Creature {
    /**
     * Legt fest, auf welches Draw-Fenster wir zugreifen möchten
     */
    PApplet window;
    /**
     * Beschreibt die Position auf der x-Achse
     */
    float xPos;
    /**
     * Beschreibt die Position auf der y-Achse
     */
    float yPos;
    /**
     * Beschreibt wie viel Leben das Wesen hat
     */
    float health;
    /**
     * Beschreibt mit wie viel Pixeln pro Draw-Durchlauf sich das Wesen bewegen kann
     */
    float speed;
    /**
     * Beschreibt die Groeße in x- und y-Richtung
     */
    float size;
    /**
     * Sagt aus, ob das Wesen noch am Leben ist und beispielsweise Methoden ausfuehren kann
     */
    boolean alive;
    /**
     * Sagt aus, ob das Wesen gerade angreift oder nicht
     */
    boolean attacking;
    /**
     * Legt einen Wert fest, welcher anderen Wesen beim Angriff von health abgezogen wird
     */
    int attack;
    /**
     * Legt fest, wie viele Punkte der Hero hat, für Minion und Boss hat diese Variable nichts auszusagen
     */
    int points;
    /**
     * Legt die Range fest, mit der der Hero angreifen kann, fuer Minion und Boss hat diese Variable nichts auszusagen
     */
    int range;

    /**
     * Konstruktor zum Erschaffen der Wesen
     *
     * @param iWindow
     * @param inputPositionX
     * @param inputPositionY
     * @param iHealth
     * @param iSpeed
     * @param iSize
     * @param iAlive
     * @param iAttack
     * @param iAttacking
     * @param iPoints
     * @param iRange
     */
    Creature(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, int iPoints, int iRange) {
        window = iWindow;
        xPos = inputPositionX;
        yPos = inputPositionY;
        health = iHealth;
        speed = iSpeed;
        size = iSize;
        alive = iAlive;
        attack = iAttack;
        attacking = iAttacking;
        points = iPoints;
        range = iRange;
    }

    /**
     * Methode zum Malen des Wesens
     *
     * @param creature
     */
    public abstract void render(Creature creature);

    /**
     * Methode, um das Wesen zu bewegen
     *
     * @param x
     * @param y
     * @param hero
     */
    public abstract void walk(float x, float y, Hero hero);

    /**
     * Methode, damit das Wesen kämpfen kann
     *
     * @param creature
     */
    public abstract void fight(Creature creature);
}
