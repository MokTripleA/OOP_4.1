import processing.core.PApplet;
import processing.core.PImage;

public class Fenster extends PApplet {

    //PImage background, inventory, hero;
    Hero Held = new Hero(this, 430, 320, 10, 20, 1, true);
    Enemy[] Gegner = new Enemy[5];
    Level background = new Level(this, 860, 720);
    Startingscreen start = new Startingscreen(960, 540, false, this);

    @Override
    public void settings() {
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x] = new Enemy(this, random(0, 824), random(0, 684), 20, 10, 1, true);
        }
        size(1280, 720);
    }

    @Override
    public void draw() {
        background(200);
        background.generate(Held);
        stroke(0);
        strokeWeight(10);
        Held.render();
        Held.walk();
        for (int x = 0; x < Gegner.length; x++) {
            Held.fight(Gegner[x]);
        }
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x].render();
            Gegner[x].walk(Held.xPos, Held.yPos);
        }
    }
}
