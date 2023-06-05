import processing.core.PApplet;

public class Enemy extends Creature {
    Enemy(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, boolean iAlive, int iAttack, boolean iAttacking) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iAlive, iAttack, iAttacking);
    }

    boolean heroAlive;

    @Override
    public void render(Creature hero) {
            if (alive && hero.alive) {
                heroAlive = true;
                window.fill(255, 0, 0);
                window.noStroke();
                window.rect(xPos, yPos, 36, 36);
            } else {
            }
        }

    public void walk(float x, float y) {
        if (alive && heroAlive) {
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
        if (alive && heroAlive) {
            if (xPos >= hero.xPos && xPos <= hero.xPos + 36 && yPos >= hero.yPos - 18 && yPos <= hero.yPos + 18 ||
                    yPos >= hero.yPos - 36 && yPos <= hero.yPos + 36 && xPos >= hero.xPos - 18 && xPos <= hero.xPos + 18 ||
                    xPos <= hero.xPos + 36 && xPos >= hero.xPos - 36 && yPos >= hero.yPos - 18 && yPos <= hero.yPos + 18 ||
                    yPos <= hero.yPos + 36 && yPos >= hero.yPos - 18 && xPos >= hero.xPos - 18 && xPos <= hero.xPos + 18) {
                hero.health = hero.health - attack;
                alive = false;
            } else {
                attacking = false;
            }
        }
    }
}
