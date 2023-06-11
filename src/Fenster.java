import processing.core.PApplet;

public class Fenster extends PApplet {

    int enemies = 5;
    int enemyHealth = 20;
    int enemyAttack = 20;
    float enemySpeed = 1;
    boolean anyEnemyAlive = true;
    boolean runOnce = false;

    Hero held = new Hero(this, 750, 320, 100, 1, 36, true, 20, false, 0, 36);
    Minion[] gegner = new Minion[enemies];
    Boss dickerGegner = new Boss(this, 200, 320, 1000, 0.5f, 128, false, 80, false, 0, 0);
    Level level = new Level(this, 860, 720);
    Start start = new Start(this, true, false, false);
    Levelup life = new Life(this, new upgradeHealth(this));
    Levelup strength = new Strength(this, new upgradeAttack(this));
    Levelup speed = new Speed(this, new upgradeSpeed(this));

    @Override
    public void settings() {
        for (int x = 0; x < gegner.length; x++) {
            gegner[x] = new Minion(this, random(0, 500), random(0, 720), enemyHealth, enemySpeed, 36, true, enemyAttack, false, 0, 0);
        }
        size(1280, 720);
    }

    @Override
    public void draw() {
        level.generate(held);
        start.starting(held);
        start.ending(held);
        held.walk(0, 0);
        held.fight(dickerGegner);
        held.stamina();
        held.points();
        dickerGegner.render(held);
        dickerGegner.fight(held);
        dickerGegner.walk(held.xPos, held.yPos);
        for (int x = 0; x < gegner.length; x++) {
            start.starting(held);
            start.nextWave(held, gegner[x]);
            start.win(held, gegner[x]);
            held.render(gegner[x]);
            held.healthbar(gegner[x]);
            held.ultimate(gegner[x]);
            held.fight(gegner[x]);
            gegner[x].render(held);
            gegner[x].fight(held);
            if (held.alive) {
                gegner[x].walk(held.xPos, held.yPos);
            }
        }


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


        if (start.nextWave) {
            if (runOnce && held.wave < 5) {
                life = new Life(this, new upgradeHealth(this));
                speed = new Speed(this, new upgradeSpeed(this));
                strength = new Strength(this, new upgradeAttack(this));
                runOnce = false;
            }
            life.render(held, start);
            speed.render(held, start);
            strength.render(held, start);
            if (mouseX >= 182 && mouseX <= 182 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182 ||
                    mouseX >= 546 && mouseX <= 546 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182 ||
                    mouseX >= 910 && mouseX <= 910 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182) {
                if (mousePressed) {
                    held.wave += 1;
                    held.points += 500;
                    held.reset();
                    enemyHealth += 20;
                    enemyAttack += 10;
                    enemySpeed += 0.2;
                    for (int z = 0; z < enemies; z++) {
                        gegner[z].alive = false;
                    }
                    if (held.wave < 5) {
                        for (int z = 0; z < enemies; z++) {
                            gegner[z] = new Minion(this, random(0, 500), random(0, 720), enemyHealth, enemySpeed, 32, true, enemyAttack, false, 0, 0);
                        }
                    } else if (held.wave == 5) {
                        dickerGegner.alive = true;
                    }
                    start.nextWave = false;
                    runOnce = true;
                }
            }
        }
        System.out.println(held.wave);
    }
//Draw ends here
}