import processing.core.PApplet;

public class Enemy extends Creature {
    Enemy(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iMass, float iSpeed) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iMass, iSpeed);
    }

    @Override
    public void render() {
        window.fill(255, 0, 0);
        window.noStroke();
        window.rect(xPos, yPos, 36, 36);
    }

    public void walk(float x, float y) {
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
            System.out.println("Hero's attacked!");
        }
    }

    @Override
    public void fight() {
    }
}
