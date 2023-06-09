import processing.core.PApplet;

/**
 * Boss-Klasse als großer Endgegner
 */
public final class Boss extends Enemy {
    Boss(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, boolean iProtection, int iPoints, int iRange) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iSize, iAlive, iAttack, iAttacking, iProtection, iPoints, iRange);
    }

    /**
     * Methode zum Darstellen der Ultimate des Bosses
     *
     * @param hero  Bezieht sich auf ein Objekt der Hero-Klasse
     * @param enemy Bezieht sich auf ein Objekt der Enemy-Klasse
     */
    public void ultimate(Hero hero, Enemy enemy) {
        if (window.frameCount % 250 == 0 && hero.wave == 5) {
            enemy.alive = true;
            enemy.speed = 10;
            enemy.health = 250;
            enemy.attack = 20;
        }
    }

    /**
     * Methode zum Erstellen eines mehrfachen Bosskampfes
     *
     * @param hero Bezieht sich auf ein Objekt der Hero-Klasse
     */
    public void resurrection(Hero hero) {
        if (!alive && hero.wave == 5 && points < 3) {
            xPos = window.random(200, 620);
            yPos = window.random(200, 520);
            points += 1;
            size *= 1.3;
            health += 2000 * points;
            speed *= 1.3;
            alive = true;
        }
    }
}
