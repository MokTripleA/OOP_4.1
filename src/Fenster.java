import processing.core.PApplet;

/**
 * Fenster-Klasse um Processing Funktionen auszufuehren
 */
public class Fenster extends PApplet {

    final int enemies = 5;
    int enemyHealth = 100;
    int enemyAttack = 15;
    float enemySpeed = 10;
    boolean anyEnemyAlive = true;
    boolean runOnce = false;

    Hero held = new Hero(this, 750, 320, 100, 30, 36, true, 25, false, false, 0, 36);
    Minion[] gegner = new Minion[enemies];
    Boss dickerGegner = new Boss(this, 200, 320, 1000, 5, 50, false, 80, false, false, 0, 0);
    Level level = new Level(this, 860, 720);
    Start start = new Start(this, true, false, false, false);
    Levelup life = new Life(this, new upgradeHealth(this));
    Levelup strength = new Strength(this, new upgradeAttack(this));
    Levelup speed = new Speed(this, new upgradeSpeed(this));

    /**
     * Festlegen der Laenge und Breite des draw-Fensters
     * Minion-Array mit Werten fuellen
     */
    @Override
    public void settings() {
        for (int x = 0; x < gegner.length; x++) {
            gegner[x] = new Minion(this, random(0, 500), random(0, 720), enemyHealth, enemySpeed, 36, true, enemyAttack, false, false, 0, 0);
        }
        size(1280, 720);
    }

    /**
     * Draw-Methode wird wiederholt mit frameRate = 60/s ausgefuehrt
     */
    @Override
    public void draw() {
        level.generate(held);
        start.starting(held);
        start.ending(held);
        start.win(held, dickerGegner);
        held.walk(0, 0, held);
        held.fight(dickerGegner);
        held.stamina();
        held.points();
        dickerGegner.render(held);
        dickerGegner.fight(held);
        dickerGegner.walk(held.xPos, held.yPos, held);
        dickerGegner.ultimate(held, gegner[0]);
        dickerGegner.resurrection(held);
        for (int x = 0; x < gegner.length; x++) {
            held.healthbar(start, gegner[x], dickerGegner);
            start.starting(held);
            start.nextWave(held, gegner[x]);
            held.render(gegner[x]);
            held.fight(gegner[x]);
            held.ultimate(gegner[x]);
            gegner[x].render(held);
            gegner[x].fight(held);
            gegner[x].walk(held.xPos, held.yPos, held);
        }

        //Anfang - Check if any enemy alive:

        for (int y = 0; y < enemies; y++) {
            if (gegner[y].alive) {
                anyEnemyAlive = true;
                break;
            } else {
                anyEnemyAlive = false;
            }
        }
        if (!anyEnemyAlive && !start.win && !dickerGegner.alive) {
            if (frameCount % 60 == 1) {
                start.nextWave = true;
            }
        }

        //Anfang - Choose upgrade, update Healthbar


        if (start.nextWave) {
            if (held.health < 100) {
                held.health = 100;
            }
            if (held.wave < 5) {
                if (runOnce) {
                    life = new Life(this, new upgradeHealth(this));
                    speed = new Speed(this, new upgradeSpeed(this));
                    strength = new Strength(this, new upgradeAttack(this));
                    runOnce = false;
                }
                for (int x = 0; x < gegner.length; x++) {
                    life.render(start, held, gegner[x]);
                    speed.render(start, held, gegner[x]);
                    strength.render(start, held, gegner[x]);
                }
            }
            if (mouseX >= 182 && mouseX <= 182 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182 ||
                    mouseX >= 546 && mouseX <= 546 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182 ||
                    mouseX >= 910 && mouseX <= 910 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182) {
                if (mousePressed) {
                    held.wave += 1;
                    held.points += 500;
                    held.reset();
                    enemyHealth += 100;
                    enemyAttack += 10;
                    enemySpeed += 0.25;

                    if (held.wave < 5) {
                        for (int z = 0; z < enemies; z++) {
                            gegner[z] = new Minion(this, random(0, 500), random(0, 720), enemyHealth, enemySpeed, 32, true, enemyAttack, false, false, 0, 0);
                        }
                    } else if (held.wave == 5) {
                        dickerGegner.alive = true;
                    }
                    held.update();
                    start.nextWave = false;
                    runOnce = true;
                }
            }
        }
    }
}