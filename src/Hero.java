import processing.core.PApplet;

public class Hero extends Creature {
    Hero(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iMass, float iSpeed) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iMass, iSpeed);
    }

    @Override
    public void render() {
        window.fill(0);
        window.rect(xPos, yPos, 36, 36);
    }

    @Override
    public void walk() {
        if (xPos > 0 && xPos < 824 && yPos > 0 && yPos < 684) {
            if (window.keyPressed) {
                if (window.keyCode == 37) {
                    xPos -= 3.6 * speed;
                    System.out.println("LEFT");
                } else if (window.keyCode == 38) {
                    yPos -= 3.6 * speed;
                    System.out.println("UP");
                } else if (window.keyCode == 39) {
                    xPos += 3.6 * speed;
                    System.out.println("RIGHT");
                } else if (window.keyCode == 40) {
                    yPos += 3.6 * speed;
                    System.out.println("DOWN");
                } else {
                    System.out.println("No key pressed right now.");
                }
            }
        } else {
            xPos = 320;
            yPos = 320;
            System.out.println("Can't walk into barrier!");
        }
    }

    public void fight(float x, float y) {
    }
}
