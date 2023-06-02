import processing.core.PApplet;

public class Creature {
    PApplet window;
    float xPos;
    float yPos;
    float health;
    float mass;
    float speed;
    boolean alive;
    int attack;
    boolean attacking = false;


    Creature(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iMass, float iSpeed, boolean iAlive, int iAttack, boolean iAttacking) {
        window = iWindow;
        xPos = inputPositionX;
        yPos = inputPositionY;
        health = iHealth;
        mass = iMass;
        speed = iSpeed;
        alive = iAlive;
        attack = iAttack;
        attacking = iAttacking;
    }

    public void render() {
    }

    public void walk() {
    }

    public void fight() {
    }
}
