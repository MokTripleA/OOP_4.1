import processing.core.PApplet;

public abstract class Creature {
    PApplet window;
    float xPos;
    float yPos;
    float health;
    float speed;
    float size;
    boolean alive;
    boolean attacking;
    int attack;
    int points;
    int range;


    Creature(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, int iPoints, int iRange) {
        window = iWindow;
        xPos = inputPositionX;
        yPos = inputPositionY;
        health = iHealth;
        speed = iSpeed;
        size = iSize;
        alive = iAlive;
        attack = iAttack;
        attacking = iAttacking;
        points = iPoints;
        range = iRange;
    }

    public abstract void render(Creature creature);

    public abstract void walk(float x, float y);

    public abstract void fight(Creature creature);
}
