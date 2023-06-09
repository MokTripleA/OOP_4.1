import processing.core.PApplet;

public class Fenster extends PApplet {

    int enemies = 5;
    int enemyHealth = 20;
    int enemyAttack = 20;
    float enemySpeed = 1;
    boolean anyEnemyAlive = true;

    Hero Held = new Hero(this, 750, 320, 100, 1, 32, true, 20, false, 0, 36);
    Minion[] Gegner = new Minion[enemies];
    Level background = new Level(this, 860, 720);
    Start start = new Start(this, true, false);
    Upgrade upgrade = new Upgrade(this);

    @Override
    public void settings() {
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x] = new Minion(this, random(0, 500), random(0, 720), enemyHealth, enemySpeed, 32, true, enemyAttack, false, 0, 0);
        }
        size(1280, 720);
    }

    @Override
    public void draw() {
        background.generate(Held);
        start.starting(Held);
        start.ending(Held);
        Held.walk(0, 0);
        Held.stamina();
        Held.points();
        for (int x = 0; x < Gegner.length; x++) {
            start.starting(Held);
            start.nextWave(Held, Gegner[x]);
            start.win(Held, Gegner[x]);
            Held.render(Gegner[x]);
            Held.healthbar(Gegner[x]);
            Held.ultimate(Gegner[x]);
            Held.fight(Gegner[x]);
            Gegner[x].fight(Held);
            Gegner[x].render(Held);
            if (Held.alive) {
                Gegner[x].walk(Held.xPos, Held.yPos);
            }
        }
        for (int y = 0; y < enemies; y++) {
            if (Gegner[y].alive) {
                anyEnemyAlive = true;
                break;
            } else {
                anyEnemyAlive = false;
            }
        }
        if (!anyEnemyAlive) {
            start.nextWave = true;
        }
        if (start.nextWave) {
            upgrade.render();
            if (keyPressed && key == 32) {
                start.nextWave = false;
                Held.reset();
                enemyHealth += 20;
                enemyAttack += 10;
                enemySpeed += 0.2;
                for (int z = 0; z < enemies; z++) {
                    Gegner[z] = null;
                }
                for (int z = 0; z < enemies; z++) {
                    Gegner[z] = new Minion(this, random(0, 500), random(0, 720), enemyHealth, enemySpeed, 32, true, enemyAttack, false, 0, 0);
                }
                Held.wave += 1;
                Held.points += 500;
            }
        }
    }
}