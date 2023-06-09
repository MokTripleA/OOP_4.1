import processing.core.PApplet;
import processing.core.PConstants;

public final class Boss extends Enemy {
    Boss(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, int iPoints, int iRange) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iSize, iAlive, iAttack, iAttacking, iPoints, iRange);
    }

    @Override
    public void render(Creature hero) {
        if (health <= 0) {
            alive = false;
        }
        if (alive && hero.alive) {
            window.fill(255, 0, 0);
            window.noStroke();
            window.rectMode(PConstants.CORNER);
            window.text("Health +" + health, xPos, yPos - 20);
            window.rect(xPos + -18, yPos - 30, health * 3, 10);
            window.rectMode(PConstants.CORNER);
            window.rect(xPos, yPos, size, size);
        } else {
        }
    }
}
