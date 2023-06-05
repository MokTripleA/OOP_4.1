import processing.core.PApplet;

public class Fenster extends PApplet {

    Hero Held = new Hero(this, 100, 320, 100, 1, true, 10, false);
    Enemy[] Gegner = new Enemy[5];
    Level background = new Level(this, 860, 720);
    Start start = new Start(this, true);

    @Override
    public void settings() {
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x] = new Enemy(this, random(200, 824), random(0, 684), 20, 1, true, 20, false);
        }
        size(1280, 720);
    }

    @Override
    public void draw() {
        start.starting(Held);
        start.ending(Held);
        background.generate(Held);
        Held.walk(0, 0);
        Held.stamina();
        for (int x = 0; x < Gegner.length; x++) {
            Held.render(Gegner[x]);
            Gegner[x].render(Held);
            Gegner[x].walk(Held.xPos, Held.yPos);
            Held.healthbar(Gegner[x]);
            Held.ultimate(Gegner[x]);
            Held.fight(Gegner[x]);
            Gegner[x].fight(Held);
        }
        if (frameCount % 30 == 1) {
            Held.stamina += 1;
        }
    }
}
