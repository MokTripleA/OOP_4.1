import processing.core.PApplet;

public class Creature {
    PApplet window;
    float xPos;
    float yPos;
    float health;
    float speed;
    boolean alive;
    int attack;
    boolean attacking;


    Creature(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, boolean iAlive, int iAttack, boolean iAttacking) {
        window = iWindow;
        xPos = inputPositionX;
        yPos = inputPositionY;
        health = iHealth;
        speed = iSpeed;
        alive = iAlive;
        attack = iAttack;
        attacking = iAttacking;
    }

    public void render(Creature creature) {
    }

    public void walk(float x, float y) {
    }

    public void fight(Creature creature) {
    }
}
