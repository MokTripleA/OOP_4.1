import processing.core.PApplet;

/**
 * Fenster-Klasse um Processing Funktionen auszufuehren
 */
public class Fenster extends PApplet {

    /**
     * @param enemies Setzt die Laenge des Minion-Arrays fest
     * @param enemyHealth Setzt den Startwert fuer health der Minions
     * @param enemyAttack Setzt den Startwert fuer attack der Minions
     * @param enemySpeed Setzt den Startwert fuer speed der Minions
     * @param anyEnemyAlive Sagt aus, ob noch Gegner leben, oder nicht
     * @param runOnce Wird genutzt, um die Items im Upgrade-Menue zu refreshen
     */
    int enemies = 1;
    int enemyHealth = 50;
    int enemyAttack = 15;
    float enemySpeed = 1;
    boolean anyEnemyAlive = true;
    boolean runOnce = false;

    Hero held = new Hero(this, 750, 320, 100, 1, 36, true, 20, false, false, 0, 54);
    Minion[] gegner = new Minion[enemies];
    Boss dickerGegner = new Boss(this, 200, 320, 1000, 0.5f, 128, false, 80, false, false, 0, 0);
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
        held.walk(0, 0, held);
        held.fight(dickerGegner);
        held.stamina();
        held.points();
        dickerGegner.render(held);
        dickerGegner.fight(held);
        dickerGegner.walk(held.xPos, held.yPos, held);
        dickerGegner.ultimate(held, gegner[0]);
        /**
         * for-Schleife um Gegner[x] anzusprechen
         */
        for (int x = 0; x < gegner.length; x++) {
            held.healthbar(start, gegner[x], dickerGegner);
            start.starting(held);
            start.nextWave(held, gegner[x]);
            start.win(held, gegner[x]);
            held.render(gegner[x]);
            held.fight(gegner[x]);
            held.ultimate(gegner[x]);
            gegner[x].render(held);
            gegner[x].fight(held);
            gegner[x].walk(held.xPos, held.yPos, held);
        }

/**
 * Ueberpruefen, ob irgendein Gegner[x] noch alive ist
 * Falls nicht, ist anyEnemyAlive = false und start.nextWave = true
 */
        for (int y = 0; y < enemies; y++) {
            if (gegner[y].alive) {
                anyEnemyAlive = true;
                break;
            } else {
                anyEnemyAlive = false;
            }
        }

        /**
         * Ein wenig Delay einbauen, damit man nicht direkt auf die Upgrades klicken kann
         */
        if (!anyEnemyAlive && !start.win && !dickerGegner.alive) {
            if (frameCount % 60 == 1) {
                start.nextWave = true;
            }
        }

        if (start.nextWave) {
            if (held.health < 100) {
                held.health = 100;
            }
            /**
             * Upgrades werden neu "ausgewuerfelt" solange man noch vor Welle fuenf ist
             */
            if (runOnce && held.wave < 5) {
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

            /**
             * Falls der Mauszeiger im Bereich der Upgrades ist
             */
            if (mouseX >= 182 && mouseX <= 182 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182 ||
                    mouseX >= 546 && mouseX <= 546 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182 ||
                    mouseX >= 910 && mouseX <= 910 + 182 && mouseY >= height / 2 && mouseY <= height / 2 + 182) {
                if (mousePressed) {
                    held.wave += 1;
                    held.points += 500;
                    held.reset();

                    /**
                     * Nach jeder Welle werden Werte fuer health, attack & speed erhoeht
                     */
                    enemyHealth += 100;
                    enemyAttack += 10;
                    enemySpeed += 0.25;

                    /**
                     * Resetten von Gegner[x] bzw. Gegner[z] mit neuen Werten fuer health, attack & speed bis Welle fuenf
                     */
                    if (held.wave < 5) {
                        for (int z = 0; z < enemies; z++) {
                            gegner[z] = new Minion(this, random(0, 500), random(0, 720), enemyHealth, enemySpeed, 32, true, enemyAttack, false, false, 0, 0);
                        }

                        /**
                         * Boss einfuehren, falls Welle fuenf ist
                         */
                    } else if (held.wave == 5) {
                        dickerGegner.alive = true;
                    }
                    /**
                     * Upgrades neu auswuerfeln nach jeder Welle
                     */
                    start.nextWave = false;
                    runOnce = true;
                }
            }
        }
    }
//Draw ends here
}