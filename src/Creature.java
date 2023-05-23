import processing.core.PApplet;

public class Creature {
    PApplet window;
    float xPos;
    float yPos;
    float health;
    float mass;
    float speed;


    Creature(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iMass, float iSpeed) {
        window = iWindow;
        xPos = inputPositionX;
        yPos = inputPositionY;
        health = iHealth;
        mass = iMass;
        speed = iSpeed;
    }

    public void render() {
    }

    public void walk() {
    }

    public void fight() {
    }
}
