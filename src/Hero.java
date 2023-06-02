import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Hero extends Creature {
    Hero(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iMass, float iSpeed, boolean iAlive, int iAttack, boolean iAttacking) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iMass, iSpeed, iAlive, iAttack, iAttacking);
    }

    int schmerzen = 0;

    @Override
    public void render() {
        if (alive == true) {
            window.fill(0);
            window.noStroke();
            window.rect(xPos, yPos, 36, 36); //Character
        } else {
        }
    }

    public void healthbar(Creature gegner) {
        int length = 300;

        window.stroke(0);
        window.strokeWeight(5);
        window.fill(0, 255, 0); //Green
        window.rect(930, 600, length, 25); //Healthbar
        window.fill(0); //Black
        window.textSize(15);
        window.text(health + "/" + "X", 1060, 617); //Healthbar Text


        if (gegner.attacking == true) {
            schmerzen = schmerzen - gegner.attack;
            window.fill(255, 0, 0);
            window.rect(1230, 600, schmerzen * 3, 50);
            window.noStroke();
            System.out.println(schmerzen);
        }
    }

    @Override
    public void walk() {
        if (xPos > 0 && xPos < 824 && yPos > 0 && yPos < 684) {
            if (window.keyPressed) {
                if (window.keyCode == 37 || window.key == 'a') {
                    xPos -= 3.6 * speed;
                } else if (window.keyCode == 38 || window.key == 'w') {
                    yPos -= 3.6 * speed;
                } else if (window.keyCode == 39 || window.key == 'd') {
                    xPos += 3.6 * speed;
                } else if (window.keyCode == 40 || window.key == 's') {
                    yPos += 3.6 * speed;
                } else {
                    System.out.println("No key pressed right now.");
                }
            }
        } else {
            xPos = 430;
            yPos = 320;
            System.out.println("Now you can walk into barrier!");
        }
    }

    public void fight(Creature enemy) {
        if (window.mousePressed) {
            if (window.mouseX < xPos && window.mouseY >= yPos && window.mouseY <= yPos + 36) {
                window.line(xPos, yPos + 18, xPos - 36, yPos + 18);
                if (xPos - 36 <= enemy.xPos + 36 && xPos - 36 >= enemy.xPos && yPos >= enemy.yPos && yPos + 36 <= enemy.yPos + 36) {
                    enemy.alive = false;
                    attacking = true;
                }
            } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY <= yPos) {
                window.line(xPos + 18, yPos, xPos + 18, yPos - 36);
                if (yPos - 36 <= enemy.yPos + 36 && yPos - 36 >= enemy.yPos && xPos >= enemy.xPos && xPos + 36 <= enemy.xPos + 36) {
                    enemy.alive = false;
                }
            } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos && window.mouseY <= yPos + 36) {
                window.line(xPos + 36, yPos + 18, xPos + 72, yPos + 18);
                if (xPos + 72 >= enemy.xPos && xPos + 72 <= enemy.xPos + 36 && yPos >= enemy.yPos && yPos <= enemy.yPos + 36) {
                    enemy.alive = false;
                    attacking = true;
                }
            } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY > yPos) {
                window.line(xPos + 18, yPos + 36, xPos + 18, yPos + 72);
                if (yPos + 72 >= enemy.yPos && yPos + 72 <= enemy.yPos + 36 && xPos >= enemy.xPos && xPos <= enemy.xPos + 36) {
                    enemy.alive = false;
                    attacking = true;
                }
            }
        } else {
            attacking = false;
        }
    }
}
