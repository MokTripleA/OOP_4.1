import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Hero-Klasse als Child von Creature
 */
public final class Hero extends Creature {

    /**
     * @param heroKills Indikator fuer Kills, fuer jeden gemachten Kill steigt heroKills um 1
     * @param wave Sagt aus in welcher Welle sich der Spieler befindet
     * @param percent Beschreibt den prozentualen Abzug des Originallebens, wenn der Gegner den Spieler angreif
     * @param fixedBar Legt eine feste Laenge fuer die Healthbar fest
     * @param fixedHealth Kopiert den Healthwert am Anfang der Runde um einen "Original-Wert" für die percent-Berechnung zu haben
     * @param stamina Wert um festzulegen, ob der Held gerade schlagen kann, oder nicht
     * @param diameter Wert für die Groeße der Ultimate
     * @param ultimate Sagt aus, ob man die Ultimate nutzen kann, oder nicht
     * @param gameOver Sagt aus, ob der Held besiegt ist, oder nicht
     * @param circle Sagt aus, ob der Kreis der Ultimate waechst oder nicht
     */

    int heroKills = 0;
    int wave = 4;
    float percent;
    float fixedBar = 300;
    float fixedHealth;
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
            window.text("Attack: " + attack, 880, 50); //Show Stat-Attack
            window.text("Speed: " + speed, 880, 70); //Show Stat-Speed
        }
    }

    /**
     * Methode, um das Wesen zu bewegen
     *
     * @param x Dieser Parameter hat hier keine Funktion
     * @param y Dieser Parameter hat hier keine Funktion
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
                if (xPos - 36 <= enemy.xPos + 36 && xPos - 36 >= enemy.xPos && yPos >= enemy.yPos - 5 && yPos + 36 <= enemy.yPos + 41) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX <= xPos && window.mouseY <= yPos) { //Fight UP-LEFT
                stamina = stamina - 0.2f;
                window.line(xPos, yPos, xPos - range / 2, yPos - range / 2);
                if (xPos - 18 >= enemy.xPos && xPos - 18 <= enemy.xPos + 36 && yPos - 18 >= enemy.yPos && yPos - 18 <= enemy.yPos + 36) {
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
                if (yPos - 36 <= enemy.yPos + 36 && yPos - 36 >= enemy.yPos && xPos >= enemy.xPos - 5 && xPos + 36 <= enemy.xPos + 41) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX >= xPos + size && window.mouseY <= yPos) { //Fight UP-RIGHT
                stamina = stamina - 0.2f;
                window.line(xPos + 36, yPos, xPos + 36 + range / 2, yPos - range / 2);
                if (xPos + 54 >= enemy.xPos && xPos + 54 <= enemy.xPos + 36 && yPos - 18 >= enemy.yPos && yPos - 18 <= enemy.yPos + 36) {
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
                if (xPos + 72 >= enemy.xPos && xPos + 72 <= enemy.xPos + 36 && yPos >= enemy.yPos - 5 && yPos <= enemy.yPos + 41) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX >= xPos + 36 && window.mouseY >= yPos + 36) { //Fight DOWN-RIGHT
                stamina = stamina - 0.2f;
                window.line(xPos + size, yPos + size, xPos + size + range / 2, yPos + size + range / 2);
                if (xPos + 54 >= enemy.xPos && xPos + 54 <= enemy.xPos + 36 && yPos + 54 >= enemy.yPos && yPos + 54 <= enemy.yPos + 36) {
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
                if (yPos + 72 >= enemy.yPos && yPos + 72 <= enemy.yPos + 36 && xPos >= enemy.xPos - 5 && xPos <= enemy.xPos + 41) {
                    enemy.health -= attack;
                    attacking = true;
                    points += 100;
                    if (enemy.health <= 0) {
                        heroKills += 1;
                    }
                }
            } else if (window.mouseX <= xPos && window.mouseY >= yPos + 36) { //Fight DOWN-LEFT
                stamina = stamina - 0.2f;
                window.line(xPos, yPos + size, xPos - range / 2, yPos + size + range / 2);
                if (xPos - 18 <= enemy.xPos + 36 && xPos - 18 >= enemy.xPos && yPos + 54 >= enemy.yPos && yPos <= enemy.yPos + 36) {
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
     * @param start Bezieht sich auf die Start-Klasse
     * @param minion Bezieht sich auf einen bestimmten Minion
     * @param boss Bezieht sich auf einen bestimmten Boss
     */
    public void healthbar(Start start, Enemy minion, Enemy boss) {
        if (start.nextWave || start.starting) {
            if (!start.nextWave || !start.starting) {
                fixedHealth = health;
            }
        }
        if (minion.attacking || boss.attacking) {
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
            window.text(health + " / 100.0", 1040, 617); //Healthbar Text
        }
    }

    /**
     * Methode zum Darstellen und Zuenden der Ultimate
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
            /**
             * Sobald der Spieler 10 oder mehr heroKills hat, ist ultimate = true
             */
            if (heroKills >= 10) {
                heroKills = 10;
                ultimate = true;
            } else {
                ultimate = false;
            }
        } else {
        }
        /**
         * Ist ultimate = true, dann kann man mit dem x-Key einen circle an der x- und y-Pos des Helden wachsen lassen
         */
        if (ultimate) {
            if (window.keyPressed && window.key == 'x') {
                circle = true;
                heroKills = 0;
            }
        }
        if (circle == true) {
            window.stroke(0);
            window.fill(0, 0, 255);
            window.ellipse(xPos + size / 2, yPos + size / 2, diameter, diameter);
            diameter += 5;
            /**
             * Beruehrt der Rand des Circles einen Gegner, so kriegt dieser Schaden in Höhe des hero.Attack * 5
             */
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
}
