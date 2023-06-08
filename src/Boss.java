import processing.core.PApplet;

public class Boss extends Enemy {
    Boss(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, int iPoints, int iRange) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iSize, iAlive, iAttack, iAttacking, iPoints, iRange);
    }

    @Override
    public void render(Creature hero) {
        if (alive && hero.alive) {
            window.fill(255, 0, 0);
            window.noStroke();
            window.rect(xPos, yPos, size, size);
        } else {
        }
    }
}
