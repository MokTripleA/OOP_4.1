import processing.core.PApplet;
import processing.core.PConstants;

public final class Hero extends Creature {
    Hero(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, int iPoints, int iRange) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iSize, iAlive, iAttack, iAttacking, iPoints, iRange);
    }

    int heroKills = 0;
    int stamina = 10;
    int wave = 0;
    float diameter = 0;
    boolean ultimate = false;
    boolean gameOver = false;
    boolean circle = false;

    public void render(Creature enemy) {
        if (alive) {
            window.fill(0);
            window.noStroke();
            window.rect(xPos, yPos, 36, 36); //Character
            window.textSize(20);
            window.textAlign(PConstants.LEFT);
            window.text("Health: " + health, 1000, 130); //Show Stat-Health
            window.text("Attack: " + attack, 1000, 150); //Show Stat-Attack
            window.text("Speed: " + speed, 1000, 170); //Show Stat-Speed
        }
    }

    @Override
    public void walk(float x, float y) {
        if (alive) {
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
                gameOver = true;
            }
        }
    }

    public void fight(Creature enemy) {
        if (alive) {
            if (window.mousePressed) {
                if (enemy.alive && stamina > 1) {
                    if (window.mouseX <= xPos && window.mouseY >= yPos && window.mouseY <= yPos + 36) { //Fight LEFT
                        stamina = stamina - 1;
                        window.line(xPos, yPos + 18, xPos - range, yPos + 18);
                        if (xPos - 36 <= enemy.xPos + 36 && xPos - 36 >= enemy.xPos && yPos >= enemy.yPos - 5 && yPos + 36 <= enemy.yPos + 41) {
                            enemy.health -= attack;
                            attacking = true;
                            heroKills += 1;
                            points += 100;
                        }
                    } else if (window.mouseX <= xPos && window.mouseY <= yPos) { //Fight UP-LEFT
                        stamina = stamina - 1;
                        window.line(xPos, yPos, xPos - range / 2, yPos - range / 2);
                        if (xPos - 18 >= enemy.xPos && xPos - 18 <= enemy.xPos + 36 && yPos - 18 >= enemy.yPos && yPos - 18 <= enemy.yPos + 36) {
                            enemy.health -= attack;
                            attacking = true;
                            heroKills += 1;
                            points += 100;
                        }
                    } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY <= yPos) { //Fight UP
                        stamina = stamina - 1;
                        window.line(xPos + 18, yPos, xPos + 18, yPos - range);
                        if (yPos - 36 <= enemy.yPos + 36 && yPos - 36 >= enemy.yPos && xPos >= enemy.xPos - 5 && xPos + 36 <= enemy.xPos + 41) {
                            enemy.health -= attack;
                            attacking = true;
                            heroKills += 1;
                            points += 100;
                        }
                    } else if (window.mouseX >= xPos + 36 && window.mouseY <= yPos) { //Fight UP-RIGHT
                        stamina = stamina - 1;
                        window.line(xPos + 36, yPos, xPos + 36 + range / 2, yPos - range / 2);
                        if (xPos + 54 >= enemy.xPos && xPos + 54 <= enemy.xPos + 36 && yPos - 18 >= enemy.yPos && yPos - 18 <= enemy.yPos + 36) {
                            enemy.health -= attack;
                            attacking = true;
                            heroKills += 1;
                            points += 100;
                        }
                    } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos && window.mouseY <= yPos + 36) { //Fight RIGHT
                        stamina = stamina - 1;
                        window.line(xPos + 36, yPos + 18, xPos + 36 + range, yPos + 18);
                        if (xPos + 72 >= enemy.xPos && xPos + 72 <= enemy.xPos + 36 && yPos >= enemy.yPos - 5 && yPos <= enemy.yPos + 41) {
                            enemy.health -= attack;
                            attacking = true;
                            heroKills += 1;
                            points += 100;
                        }
                    } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos + 36) { //Fight DOWN-RIGHT
                        stamina = stamina - 1;
                        window.line(xPos + 36, yPos + 36, xPos + 36 + range / 2, yPos + 36 + range / 2);
                        if (xPos + 54 >= enemy.xPos && xPos + 54 <= enemy.xPos + 36 && yPos + 54 >= enemy.yPos && yPos + 54 <= enemy.yPos + 36) {
                            enemy.health -= attack;
                            attacking = true;
                            heroKills += 1;
                            points += 100;
                        }
                    } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY > yPos) { //Fight DOWN
                        stamina = stamina - 1;
                        window.line(xPos + 18, yPos + 36, xPos + 18, yPos + 36 + range);
                        if (yPos + 72 >= enemy.yPos && yPos + 72 <= enemy.yPos + 36 && xPos >= enemy.xPos - 5 && xPos <= enemy.xPos + 41) {
                            enemy.health -= attack;
                            attacking = true;
                            heroKills += 1;
                            points += 100;
                        }
                    } else if (window.mouseX <= xPos && window.mouseY >= yPos + 36) { //Fight DOWN-LEFT
                        stamina = stamina - 1;
                        window.line(xPos, yPos + 36, xPos - range / 2, yPos + 36 + range / 2);
                        if (xPos - 18 <= enemy.xPos + 36 && xPos - 18 >= enemy.xPos && yPos + 54 >= enemy.yPos && yPos <= enemy.yPos + 36) {
                            enemy.health -= attack;
                            attacking = true;
                            heroKills += 1;
                            points += 100;
                        }
                    }
                } else {
                    attacking = false;
                }
            }
        }
    }

    public void healthbar(Creature enemy) {
        if (alive) {
            if (health <= 0) {
                gameOver = true;
            }
            window.textAlign(PConstants.LEFT);
            window.textSize(15);
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(255, 0, 0); //Red
            window.rect(920, 600, 305, 25); //Healthbar Background
            window.noStroke();
            window.fill(0, 255, 0); //Green
            window.rect(923, 603, health * 3, 20); //Healthbar Status
            window.fill(0); //Black
            window.text(health + " / 100.0", 1040, 617); //Healthbar Text
        }
    }

    public void ultimate(Creature enemy) {
        if (alive) {
            window.textAlign(PConstants.LEFT);
            window.textSize(15);
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(100);
            window.rect(920, 550, 305, 25); //Ultimate Background
            window.fill(0, 0, 255);
            window.noStroke();
            window.rect(923, 553, heroKills * 30, 20); //Ultimate Status
            window.fill(0);
            window.text(heroKills + " / 10", 1060, 567);
            window.stroke(0);
            if (heroKills >= 10) {
                heroKills = 10;
                ultimate = true;
            } else {
                ultimate = false;
            }
        } else {
        }
        if (ultimate) {
            if (window.keyPressed && window.key == 'x') {
                circle = true;
                heroKills = 0;
            }
        }
        if (circle == true) {
            window.stroke(0);
            window.fill(0, 0, 255);
            window.ellipse(xPos + 18, yPos + 18, diameter, diameter);
            diameter += 5;
            if (xPos + 18 - diameter / 2 <= 0 || xPos + 18 + diameter / 2 >= 860 || yPos + 18 - diameter / 2 <= 0 || yPos + 18 + diameter / 2 >= 720) {
                circle = false;
            }
            if (enemy.xPos <= xPos + 18 + diameter / 2 && enemy.yPos >= yPos + 18 - diameter / 2 && enemy.yPos <= yPos + 18 + diameter / 2 || //Right ENEMY
                    enemy.xPos + 36 >= xPos + 18 - diameter / 2 && enemy.yPos >= yPos + 18 - diameter / 2 && enemy.yPos <= yPos + 18 + diameter / 2 || //Left ENEMY
                    enemy.yPos + 36 >= yPos + 18 - diameter / 2 && enemy.xPos >= xPos + 18 - diameter / 2 && enemy.xPos + 36 <= xPos + 18 + diameter / 2 || //Top ENEMY
                    enemy.yPos <= yPos + 18 + diameter / 2 && enemy.xPos >= xPos + 18 - diameter / 2 && enemy.xPos + 36 <= xPos + 18 + diameter / 2) { //Bottom ENEMY
                enemy.health -= attack * 5;
            }
        }
    }

    public void stamina() {
        if (alive) {
            window.textAlign(PConstants.LEFT);
            window.textSize(15);
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(100);
            window.rect(920, 500, 305, 25); //Stamina Background
            if (stamina >= 10) {
                stamina = 10;
                window.fill(255, 0, 0);
            } else if (stamina >= 5 && stamina < 7) {
                window.fill(246, 179, 63);
            } else if (stamina >= 7 && stamina < 10) {
                window.fill(226, 146, 6);
            } else {
                window.fill(255, 255, 0);
            }
            window.noStroke();
            window.rect(923, 503, stamina * 30, 20); //Stamina
            window.fill(0);
            window.text(stamina + " / 10", 1060, 517);
            window.stroke(0);
        }
        if (window.frameCount % 30 == 1) {
            stamina += 1;
        }
    }

    public void points() {
        if (alive) {
            window.textAlign(PConstants.LEFT);
            window.textSize(15);
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(0);
            window.text("Wave " + wave + " / 5", 30, 30);
            window.text("Points: " + points, 30, window.height - 15);
        }
    }

    public void reset() {
        alive = true;
        xPos = 750;
        yPos = 320;
    }
}
