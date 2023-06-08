import processing.core.PApplet;

public class Fenster extends PApplet {

    int Enemies = 5;

    Hero Held = new Hero(this, 750, 320, 100, 1, 32, true, 20, false, 0, 36);
    Minion[] Gegner = new Minion[Enemies];
    Level background = new Level(this, 860, 720);
    Start start = new Start(this, true, false, false);

    @Override
    public void settings() {
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x] = new Minion(this, random(0, 500), random(0, 720), 20, 1, 32, true, 20, false, 0, 0);
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
        for (int x = 0; x < Gegner.length; x++) {
            start.starting(Held);
            start.nextWave(Held, Gegner[x]);
            Held.render(Gegner[x]);
            Held.healthbar(Gegner[x]);
            Held.ultimate(Gegner[x]);
            Held.fight(Gegner[x]);
            Gegner[x].render(Held);
            Gegner[x].fight(Held);
            if (Held.alive) {
                Gegner[x].walk(Held.xPos, Held.yPos);
            }
            Held.points();
        }
    }
}