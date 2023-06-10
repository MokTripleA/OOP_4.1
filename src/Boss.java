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
            window.noStroke();
            window.fill(255, 0, 0);
            window.rectMode(PConstants.CORNER);
            window.rect(xPos, yPos, size, size);
            window.textAlign(PConstants.CENTER);
            window.textSize(18);
            window.fill(0);
            window.text((int) health, xPos + 18, yPos + 18);
        } else {
        }
    }
}
