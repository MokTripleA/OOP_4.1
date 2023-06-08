import processing.core.PApplet;

public class Fenster extends PApplet {

    int Enemies = 5;

    Hero Held = new Hero(this, 100, 320, 100, 1, 32, true, 20, false, 0, 36);
    Minion[] Gegner = new Minion[Enemies];
    Level background = new Level(this, 860, 720);
    Start start = new Start(this, true, false, false);
    Levelup levelup = new Levelup(this);

    @Override
    public void settings() {
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x] = new Minion(this, random(200, 824), random(0, 684), 20, 1, 32, true, 20, false, 0, 0);
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
            start.nextWave(Held, Gegner[x]);
            levelup.levelup(start);
            Held.render(Gegner[x]);
            Gegner[x].render(Held);
            Gegner[x].walk(Held.xPos, Held.yPos);
            Held.healthbar(Gegner[x]);
            Held.ultimate(Gegner[x]);
            Held.fight(Gegner[x]);
            Gegner[x].fight(Held);
            if (Held.heroKills == Enemies) {
                start.nextWave = true;
                Enemies += 2;
            }
            if (!Gegner[0].alive && !start.starting) {
                if (!Gegner[1].alive) {
                    if (!Gegner[2].alive) {
                        if (!Gegner[3].alive) {
                            if (!Gegner[4].alive) {
                                if (frameCount % 60 == 0) {
                                    start.nextWave = true;
                                }
                            }
                        }
                    }
                }
            }
            Held.points();
        }
    }
}