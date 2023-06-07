import processing.core.PApplet;

public class Minion extends Enemy{
    Minion(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, boolean iAlive, int iAttack, boolean iAttacking, int iPoints) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iAlive, iAttack, iAttacking, iPoints);
    }

    @Override
    public void render(Creature hero) {
        if (alive && hero.alive) {
            heroAlive = true;
            window.fill(255, 0, 0);
            window.noStroke();
            window.rect(xPos, yPos, 32, 32);
        } else {
        }
    }
}
