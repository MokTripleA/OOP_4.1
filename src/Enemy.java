import processing.core.PApplet;
import processing.core.PConstants;

public class Enemy extends Creature {
    Enemy(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, int iPoints, int iRange) {
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
            window.rect(xPos + -18, yPos - 30, health * 3, 10);
            window.rectMode(PConstants.CORNER);
            window.rect(xPos, yPos, size, size);
        } else {
        }
    }

    public void walk(float x, float y) {
        if (alive) {
            if (xPos != x && yPos != y) {
                if (xPos < x) {
                    xPos += speed;
                }
                if (xPos > x) {
                    xPos -= speed;
                }
                if (yPos < y) {
                    yPos += speed;
                }
                if (yPos > y) {
                    yPos -= speed;
                }
            } else if (xPos == x && yPos == y) {
            }
        }
    }

    public void fight(Creature hero) {
        if (alive) {
            if (xPos >= hero.xPos && xPos <= hero.xPos + 36 && yPos >= hero.yPos - 18 && yPos <= hero.yPos + 18 ||
                    yPos >= hero.yPos - 36 && yPos <= hero.yPos + 36 && xPos >= hero.xPos - 18 && xPos <= hero.xPos + 18 ||
                    xPos <= hero.xPos + 36 && xPos >= hero.xPos - 36 && yPos >= hero.yPos - 18 && yPos <= hero.yPos + 18 ||
                    yPos <= hero.yPos + 36 && yPos >= hero.yPos - 18 && xPos >= hero.xPos - 18 && xPos <= hero.xPos + 18) {
                hero.health = hero.health - attack;
                hero.points -= 50;
                attacking = true;
                alive = false;
            } else {
                attacking = false;
            }
        }
    }
}
