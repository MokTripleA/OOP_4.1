import processing.core.PApplet;
import processing.core.PConstants;

public class Hero extends Creature {
    Hero(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iMass, float iSpeed, boolean iAlive, int iAttack, boolean iAttacking) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iMass, iSpeed, iAlive, iAttack, iAttacking);
    }

    int heroKills = 6;
    boolean ultimate = false;
    int diameter = 0;

    public void render(Creature gegner) {
        if (alive == true) {
            window.fill(0);
            window.noStroke();
            window.rect(xPos, yPos, 36, 36); //Character
        }
        if (alive == false) {
            window.textSize(50);
            window.textAlign(PConstants.CENTER);
            window.fill(255, 0, 0);
            window.text("GAME OVER", window.width / 2, window.height / 2);
            window.fill(100, 0, 0);
            window.text("GAME OVER", window.width / 2 + 1, window.height / 2 + 1);
        }
    }

    public void healthbar(Creature gegner) {
        if (alive == true) {
            if (health == 0) {
                alive = false;
            }
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(255, 0, 0); //Red
            window.rect(925, 600, 300, 25); //Healthbar Background
            window.fill(0, 255, 0); //Green
            window.rect(925, 600, health * 3, 25); //Healthbar Status
            window.fill(0); //Black
            window.textSize(15);
            window.text(health + "/" + "X", 1060, 617); //Healthbar Text
        }
        window.fill(100);
        window.rect(925, 500, 300, 25); //Ultimate Background
        window.fill(0, 0, 255);
        window.noStroke();
        window.rect(928, 503, heroKills * 30 - 5, 20); //Ultimate Status
        window.fill(0);
        window.text(heroKills + "/10 Ultimate", 1040, 517);
        window.stroke(0);
        if (heroKills >= 10) {
            heroKills = 10;
            ultimate = true;
            window.text("Ultimate is ready! Press X to use!", 980, 490);
        } else {
            window.text("Ultimate not ready yet.", 1000, 490);
        }
    }

    public void ultimate(Creature gegner) {
        if (ultimate) {
            if (window.keyPressed && window.key == 'x') {
                window.fill(0, 200, 0);
                window.ellipse(xPos, yPos, diameter, diameter);
            }
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
                }
            }
        } else {
            alive = false;
        }
    }

    public void fight(Creature enemy) {
        if (enemy.alive) {
            if (window.mousePressed) {
                if (window.mouseX < xPos && window.mouseY >= yPos && window.mouseY <= yPos + 36) {
                    window.line(xPos, yPos + 18, xPos - 36, yPos + 18);
                    if (xPos - 36 <= enemy.xPos + 36 && xPos - 36 >= enemy.xPos && yPos >= enemy.yPos - 5 && yPos + 36 <= enemy.yPos + 41) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY <= yPos) {
                    window.line(xPos + 18, yPos, xPos + 18, yPos - 36);
                    if (yPos - 36 <= enemy.yPos + 36 && yPos - 36 >= enemy.yPos && xPos >= enemy.xPos - 5 && xPos + 36 <= enemy.xPos + 41) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos && window.mouseY <= yPos + 36) {
                    window.line(xPos + 36, yPos + 18, xPos + 72, yPos + 18);
                    if (xPos + 72 >= enemy.xPos && xPos + 72 <= enemy.xPos + 36 && yPos >= enemy.yPos - 5 && yPos <= enemy.yPos + 41) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY > yPos) {
                    window.line(xPos + 18, yPos + 36, xPos + 18, yPos + 72);
                    if (yPos + 72 >= enemy.yPos && yPos + 72 <= enemy.yPos + 36 && xPos >= enemy.xPos - 5 && xPos <= enemy.xPos + 41) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                }
            } else {
                attacking = false;
            }
        }
    }
}
