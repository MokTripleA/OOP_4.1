import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PConstants.SHIFT;

/**
 * Hero-Klasse als Child von Creature
 */
public final class Hero extends Creature {

    int heroKills = 0;
    int wave = 1;
    float percent;
    float fixedBar = 300;
    float fixedHealth = 100;
    float stamina = 10;
    float diameter = 0;
    boolean ultimate = false;
    boolean gameOver = false;
    boolean circle = false;

    Hero(PApplet iWindow, float inputPositionX, float inputPositionY, float iHealth, float iSpeed, float iSize, boolean iAlive, int iAttack, boolean iAttacking, boolean iProtection, int iPoints, int iRange) {
        super(iWindow, inputPositionX, inputPositionY, iHealth, iSpeed, iSize, iAlive, iAttack, iAttacking, iProtection, iPoints, iRange);
    }

    /**
     * Methode zum Malen des Wesens
     *
     * @param enemy Bezieht sich auf einen bestimmten Gegner
     */
    public void render(Creature enemy) {
        if (alive) {
            window.fill(0);
            window.noStroke();
            window.rect(xPos, yPos, 36, 36); //Character
            window.textSize(20);
            window.textAlign(PConstants.LEFT);
            window.text("Health: " + health, 880, 30); //Show Stat-Health
            window.text("Attack: " + attack, 880, 60); //Show Stat-Attack
            window.text("Speed: " + speed, 880, 90); //Show Stat-Speed
        }
    }

    /**
     * Methode, um das Wesen zu bewegen
     *
     * @param x    Dieser Parameter hat hier keine Funktion
     * @param y    Dieser Parameter hat hier keine Funktion
     * @param hero Wird genutzt um zu ueberpruefen, ob der Held noch am Leben ist oder nicht
     */
    @Override
    public void walk(float x, float y, Hero hero) {
        if (alive && hero.alive) {
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

    /**
     * Methode, damit das Wesen kaempfen kann
     *
     * @param enemy Bezieht sich auf einen bestimmten Minion
     */
    public void fight(Creature enemy) {
        window.stroke(0);
        window.strokeWeight(5);
        if (alive && stamina > 1 && enemy.alive && window.mousePressed) {
            if (window.mouseX <= xPos && window.mouseY >= yPos && window.mouseY <= yPos + 36) { //Fight LEFT
                stamina = stamina - 0.2f;
                window.line(xPos, yPos + size / 2, xPos - range, yPos + size / 2);
                if (xPos - range <= enemy.xPos + enemy.size && xPos - range >= enemy.xPos && yPos >= enemy.yPos - 5 && yPos + size <= enemy.yPos + enemy.size + 5) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX <= xPos && window.mouseY <= yPos) { //Fight UP-LEFT
                stamina = stamina - 0.2f;
                window.line(xPos, yPos, xPos - (float) range / 2, yPos - (float) range / 2);
                if (xPos - (float) range / 2 >= enemy.xPos && xPos - (float) range / 2 <= enemy.xPos + enemy.size && yPos - (float) range / 2 >= enemy.yPos && yPos - (float) range / 2 <= enemy.yPos + enemy.size) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX >= xPos && window.mouseX <= xPos + size && window.mouseY <= yPos) { //Fight UP
                stamina = stamina - 0.2f;
                window.line(xPos + 18, yPos, xPos + 18, yPos - range);
                if (yPos - range <= enemy.yPos + enemy.size && yPos - range >= enemy.yPos && xPos >= enemy.xPos - 5 && xPos + size <= enemy.xPos + enemy.size + 5) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX >= xPos + size && window.mouseY <= yPos) { //Fight UP-RIGHT
                stamina = stamina - 0.2f;
                window.line(xPos + 36, yPos, xPos + 36 + (float) range / 2, yPos - (float) range / 2);
                if (xPos + size + (float) range / 2 >= enemy.xPos && xPos + size + (float) range / 2 <= enemy.xPos + enemy.size && yPos - (float) range / 2 >= enemy.yPos && yPos - (float) range / 2 <= enemy.yPos + enemy.size) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos && window.mouseY <= yPos + 36) { //Fight RIGHT
                stamina = stamina - 0.2f;
                window.line(xPos + size, yPos + size / 2, xPos + 36 + range, yPos + size / 2);
                if (xPos + size + range >= enemy.xPos && xPos + size + range <= enemy.xPos + enemy.size && yPos >= enemy.yPos - 5 && yPos <= enemy.yPos + enemy.size + 5) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos + 36) { //Fight DOWN-RIGHT
                stamina = stamina - 0.2f;
                window.line(xPos + size, yPos + size, xPos + size + (float) range / 2, yPos + size + (float) range / 2);
                if (xPos + size + (float) range / 2 >= enemy.xPos && xPos + size + (float) range / 2 <= enemy.xPos + enemy.size && yPos + size + (float) range / 2 >= enemy.yPos && yPos + size + (float) range / 2 <= enemy.yPos + enemy.size) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX >= xPos && window.mouseX <= xPos + 36 && window.mouseY > yPos) { //Fight DOWN
                stamina = stamina - 0.2f;
                window.line(xPos + size / 2, yPos + size, xPos + size / 2, yPos + size + range);
                if (yPos + size + range >= enemy.yPos && yPos + size + range <= enemy.yPos + enemy.size && xPos >= enemy.xPos - 5 && xPos <= enemy.xPos + enemy.size + 5) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX <= xPos && window.mouseY >= yPos + 36) { //Fight DOWN-LEFT
                stamina = stamina - 0.2f;
                window.line(xPos, yPos + size, xPos - (float) range / 2, yPos + size + (float) range / 2);
                if (xPos - (float) range / 2 <= enemy.xPos + enemy.size && xPos - (float) range / 2 >= enemy.xPos && yPos + size + (float) range / 2 >= enemy.yPos && yPos <= enemy.yPos + enemy.size) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            }
        } else {
            attacking = false;
        }
    }


    /**
     * Methode zum Darstellen der Healthbar
     *
     * @param start  Bezieht sich auf die Start-Klasse
     * @param minion Bezieht sich auf einen bestimmten Minion
     * @param boss   Bezieht sich auf einen bestimmten Boss
     */
    public void healthbar(Start start, Enemy minion, Enemy boss) {
        if (minion.attacking || boss.attacking || window.mousePressed && start.nextWave) {
            percent = health / fixedHealth;
            fixedBar = 300 * percent;
        }
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
            window.rect(923, 603, fixedBar, 20); //Healthbar Status
            window.fill(0); //Black
            window.text(health + " / " + fixedHealth, 1040, 617); //Healthbar Text
        }
    }

    /**
     * Methode zum Darstellen und Nutzen der Ultimate
     *
     * @param enemy Bezieht sich auf ein Objekt der Enemy-Klasse
     */
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
        if (circle) {
            window.stroke(0);
            window.fill(0, 0, 255);
            window.ellipse(xPos + size / 2, yPos + size / 2, diameter, diameter);
            diameter += 5;
            if (xPos + size / 2 - diameter / 2 <= 0 || xPos + size / 2 + diameter / 2 >= 860 || yPos + size / 2 - diameter / 2 <= 0 || yPos + size / 2 + diameter / 2 >= 720) {
                circle = false;
            }
            if (enemy.xPos <= xPos + size / 2 + diameter / 2 && enemy.yPos >= yPos + size / 2 - diameter / 2 && enemy.yPos <= yPos + size / 2 + diameter / 2 || //Right ENEMY
                    enemy.xPos + size >= xPos + size / 2 - diameter / 2 && enemy.yPos >= yPos + size / 2 - diameter / 2 && enemy.yPos <= yPos + size / 2 + diameter / 2 || //Left ENEMY
                    enemy.yPos + size >= yPos + size / 2 - diameter / 2 && enemy.xPos >= xPos + size / 2 - diameter / 2 && enemy.xPos + size <= xPos + size / 2 + diameter / 2 || //Top ENEMY
                    enemy.yPos <= yPos + size / 2 + diameter / 2 && enemy.xPos >= xPos + size / 2 - diameter / 2 && enemy.xPos + size <= xPos + size / 2 + diameter / 2) { //Bottom ENEMY
                enemy.health -= attack * 5;
            }
        }
    }

    /**
     * Methode zum Darstellen der Stamina
     */
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
            window.text((int) stamina + " / 10", 1060, 517);
            window.stroke(0);
        }
        if (window.frameCount % 30 == 1) {
            stamina += 1;
        }
    }

    /**
     * Methode zum Darstellen der Punkte des Spielers
     */
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

    /**
     * Methode zum Resetten des Helden, dabei bleibt angriff, health und speed gleich, nur die Position und der alive-Status verändert sich
     */
    public void reset() {
        alive = true;
        xPos = 750;
        yPos = 320;
    }

    /**
     * Methode zum Updaten der Healthbar
     */
    public void update() {
        percent = 1;
        fixedHealth = health;
    }
}
