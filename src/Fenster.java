import processing.core.PApplet;

public class Fenster extends PApplet {

    Hero Held = new Hero(this, 430, 320, 100, 20, 1, true, 10, false);
    Enemy[] Gegner = new Enemy[5];
    Level background = new Level(this, 860, 720);

    @Override
    public void settings() {
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x] = new Enemy(this, random(0, 824), random(0, 684), 20, 10, 1, true, 20, false);
        }
        size(1280, 720);
    }

    @Override
    public void draw() {
        background(200);
        stroke(0);
        strokeWeight(10);
        background.generate(Held);
        Held.render();
        Held.walk();
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x].render();
            Gegner[x].walk(Held.xPos, Held.yPos);
            Held.healthbar(Gegner[x]);
        }
        for (int x = 0; x < Gegner.length; x++) {
            Held.fight(Gegner[x]);
            Gegner[x].fight(Held);
        }
    }
}
