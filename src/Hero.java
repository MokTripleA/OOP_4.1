import processing.core.PApplet;

public class Hero extends Creature {
    Hero(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iMass, float iSpeed) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iMass, iSpeed);
    }

    @Override
    public void walk() {
    }

    @Override
    public void fight() {
    }
}
