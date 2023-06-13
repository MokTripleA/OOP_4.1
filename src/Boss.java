import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Boss-Klasse als großer Endgegner
 */
public final class Boss extends Enemy {
    Boss(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, boolean iProtection, int iPoints, int iRange) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iSize, iAlive, iAttack, iAttacking, iProtection, iPoints, iRange);
    }

    public void ultimate(Hero hero, Enemy enemy) {
        if (window.frameCount % 500 == 0 && hero.wave == 5) {
            enemy.alive = true;
            enemy.speed = 1;
            enemy.health = 200;
            enemy.attack = 25;
        }
    }
}
