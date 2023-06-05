import processing.core.PApplet;

public class Hero extends Creature {
    Hero(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, boolean iAlive, int iAttack, boolean iAttacking) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iAlive, iAttack, iAttacking);
    }

    int heroKills = 0;
    int stamina = 10;
    boolean ultimate = false;
    boolean gameOver = false;

    public void render(Creature enemy) {
        if (alive) {
            window.fill(0);
            window.noStroke();
            window.rect(xPos, yPos, 36, 36); //Character
        }
    }

    public void healthbar(Creature enemy) {
        if (alive) {
            if (health == 0) {
                gameOver = true;
            }
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(255, 0, 0); //Red
            window.rect(925, 600, 300, 25); //Healthbar Background
            window.noStroke();
            window.fill(0, 255, 0); //Green
            window.rect(928, 603, health * 3 - 5, 20); //Healthbar Status
            window.fill(0); //Black
            window.textSize(15);
            window.text(health + " / 100.0", 1040, 617); //Healthbar Text
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

    public void ultimate(Creature enemy) {
        if (alive) {
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(100);
            window.rect(925, 550, 300, 25); //Ultimate Background
            window.fill(0, 0, 255);
            window.noStroke();
            window.rect(928, 553, heroKills * 30, 20); //Ultimate Status
            window.fill(0);
            window.text(heroKills + " / 10", 1060, 567);
            window.stroke(0);
            if (heroKills >= 10) {
                heroKills = 10;
                ultimate = true;
            }
        } else {
        }
    }

    public void stamina() {
        if (alive) {
            window.stroke(0);
            window.strokeWeight(5);
            window.fill(100);
            window.rect(925, 500, 300, 25); //Stamina Background
            if (stamina >= 10) {
                stamina = 10;
                window.fill(255, 0, 0);
            } else {
                window.fill(255, 255, 0);
            }
            window.noStroke();
            window.rect(928, 503, stamina * 30, 20); //Stamina
            window.fill(0);
            window.text(stamina + " / 10", 1060, 517);
            window.stroke(0);
        }
    }

    public void fight(Creature enemy) {
        if (window.mousePressed) {
            if (enemy.alive && stamina > 0) {
                if (window.mouseX <= xPos && window.mouseY >= yPos && window.mouseY <= yPos + 36) { //Fight LEFT
                    stamina = stamina - 1;
                    window.line(xPos, yPos + 18, xPos - 36, yPos + 18);
                    if (xPos - 36 <= enemy.xPos + 36 && xPos - 36 >= enemy.xPos && yPos >= enemy.yPos - 5 && yPos + 36 <= enemy.yPos + 41) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX <= xPos && window.mouseY <= yPos) { //Fight UP-LEFT
                    stamina = stamina - 1;
                    window.line(xPos, yPos, xPos - 18, yPos - 18);
                    if (xPos - 18 >= enemy.xPos && xPos - 18 <= enemy.xPos + 36 && yPos - 18 >= enemy.yPos && yPos - 18 <= enemy.yPos + 36) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY <= yPos) { //Fight UP
                    stamina = stamina - 1;
                    window.line(xPos + 18, yPos, xPos + 18, yPos - 36);
                    if (yPos - 36 <= enemy.yPos + 36 && yPos - 36 >= enemy.yPos && xPos >= enemy.xPos - 5 && xPos + 36 <= enemy.xPos + 41) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX >= xPos + 36 && window.mouseY <= yPos) { //Fight UP-RIGHT
                    stamina = stamina - 1;
                    window.line(xPos + 36, yPos, xPos + 54, yPos - 18);
                    if (xPos + 54 >= enemy.xPos && xPos + 54 <= enemy.xPos + 36 && yPos - 18 >= enemy.yPos && yPos - 18 <= enemy.yPos + 36) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos && window.mouseY <= yPos + 36) { //Fight RIGHT
                    stamina = stamina - 1;
                    window.line(xPos + 36, yPos + 18, xPos + 72, yPos + 18);
                    if (xPos + 72 >= enemy.xPos && xPos + 72 <= enemy.xPos + 36 && yPos >= enemy.yPos - 5 && yPos <= enemy.yPos + 41) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos + 36) { //Fight DOWN-RIGHT
                    stamina = stamina - 1;
                    window.line(xPos + 36, yPos + 36, xPos + 54, yPos + 54);
                    if (xPos + 54 >= enemy.xPos && xPos + 54 <= enemy.xPos + 36 && yPos + 54 >= enemy.yPos && yPos + 54 <= enemy.yPos + 36) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY > yPos) { //Fight DOWN
                    stamina = stamina - 1;
                    window.line(xPos + 18, yPos + 36, xPos + 18, yPos + 72);
                    if (yPos + 72 >= enemy.yPos && yPos + 72 <= enemy.yPos + 36 && xPos >= enemy.xPos - 5 && xPos <= enemy.xPos + 41) {
                        enemy.alive = false;
                        attacking = true;
                        heroKills += 1;
                    }
                } else if (window.mouseX <= xPos && window.mouseY >= yPos + 36) { //Fight DOWN-LEFT
                    stamina = stamina - 1;
                    window.line(xPos, yPos + 36, xPos - 18, yPos + 54);
                    if (xPos - 18 <= enemy.xPos + 36 && xPos - 18 >= enemy.xPos && yPos + 54 >= enemy.yPos && yPos <= enemy.yPos + 36) {
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
