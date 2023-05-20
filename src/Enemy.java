import processing.core.PApplet;

public class Enemy extends Creature {
    Enemy(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iMass, float iSpeed) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iMass, iSpeed);
    }

    @Override
    public void walk() {
    }

    @Override
    public void fight() {
    }
}
