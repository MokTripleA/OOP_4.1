import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Minion-Klasse als kleine Gegner
 */
public final class Minion extends Enemy {
    Minion(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, boolean iProtection, int iPoints, int iRange) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iSize, iAlive, iAttack, iAttacking, iProtection, iPoints, iRange);
    }
}
