import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Enemy-Klasse um jegliche Form von Gegner darzustellen
 */
public class Enemy extends Creature {

    Enemy(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, boolean iProtection, int iPoints, int iRange) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iSize, iAlive, iAttack, iAttacking, iProtection, iPoints, iRange);
    }

    /**
     * Methode zum Darstellen des Wesens
     *
     * @param hero Bezieht sich auf ein Objekt aus der Hero-Klasse
     */
    @Override
    public void render(Creature hero) {
        if (health <= 0) {
            alive = false;
        }
        if (alive && hero.alive) {
            window.stroke(0);
            window.strokeWeight(3);
            window.fill(255, 0, 0);
            window.rectMode(PConstants.CORNER);
            window.rect(xPos, yPos, size, size);
            window.textAlign(PConstants.CENTER);
            window.textSize(18);
            window.fill(0);
            window.text((int) health, xPos + size / 2, yPos + size / 2);
            window.noStroke();
        } else {
        }
    }

    /**
     * Methode, damit die Gegner den Helden "verfolgen" muessen
     *
     * @param x    x-Position die verfolgt werden soll
     * @param y    y-Position die verfolgt werden soll
     * @param hero Bezieht sich auf ein Objekt der Hero-Klasse
     */
    public void walk(float x, float y, Hero hero) {
        if (alive && hero.alive) {
            if (xPos + size / 2 != x + 18 && yPos + size / 2 != y + 18) {
                if (xPos + size / 2 < x + 18) {
                    xPos += speed / 10;
                }
                if (xPos + size / 2 > x + 18) {
                    xPos -= speed / 10;
                }
                if (yPos + size / 2 < y + 18) {
                    yPos += speed / 10;
                }
                if (yPos + size / 2 > y + 18) {
                    yPos -= speed / 10;
                }
            } else if (xPos + size / 2 == x + 18 && yPos + size / 2 == y + 18) {
            }
        }
    }

    /**
     * Methode, damit die Gegner dem Helden jedesmal Schaden zufuegen, sobald sie diesen beruehren
     *
     * @param hero Bezieht sich auf ein Objekt der Hero-Klasse
     */
    public void fight(Creature hero) {
        if (alive && !protection) {
            if (xPos < hero.xPos + hero.size &&
                    xPos + size > hero.xPos &&
                    yPos < hero.yPos + hero.size &&
                    yPos + size > hero.yPos
            ) {
                hero.health = hero.health - attack;
                hero.points -= 250;
                attacking = true;
                protection = true;

            }
        } else {
            if (protection && window.frameCount % 50 == 1) {
                protection = false;
            }
            attacking = false;
        }
    }
}
