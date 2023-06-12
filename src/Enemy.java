import processing.core.PApplet;
import processing.core.PConstants;

public class Enemy extends Creature {
    {
        if (window.frameCount % 60 == 1) {
            attacking = false;
        }
    }

    Enemy(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, int iPoints, int iRange) {
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

    public void walk(float x, float y) {
        if (alive) {
            if (xPos + size / 2 != x + 18 && yPos + size / 2 != y + 18) {
                if (xPos + size / 2 < x + 18) {
                    xPos += speed;
                }
                if (xPos + size / 2 > x + 18) {
                    xPos -= speed;
                }
                if (yPos + size / 2 < y + 18) {
                    yPos += speed;
                }
                if (yPos + size / 2 > y + 18) {
                    yPos -= speed;
                }
            } else if (xPos + size / 2 == x + 18 && yPos + size / 2 == y + 18) {
            }
        }
    }

    public void fight(Creature hero) {
        if (alive && !attacking) {
            if (xPos < hero.xPos + hero.size &&
                    xPos + size > hero.xPos &&
                    yPos < hero.yPos + hero.size &&
                    yPos + size > hero.yPos
            ) {
                hero.health = hero.health - attack;
                hero.points -= 50;
                attacking = true;
            } else {
                attacking = false;
            }
        }
    }
}
