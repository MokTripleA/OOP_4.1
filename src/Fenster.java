import processing.core.PApplet;

public class Fenster extends PApplet {

    //PImage background, inventory, hero;
    Hero Held = new Hero(this, 430, 320, 10, 20, 1);
    Enemy[] Gegner = new Enemy[5];

    @Override
    public void settings() {
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x] = new Enemy(this, random(0, 824), random(0, 684), 20, 10, 1);
        }
        //background = loadImage("background.png");
        //inventory = loadImage("inventory.png");
        //hero = loadImage("hero_standing.png");
        size(1280, 720);
    }

    @Override
    public void draw() {
        background(200);
        stroke(0);
        strokeWeight(10);
        line(0, 0, 860, 0);
        line(0, 0, 0, 720);
        line(0, 720, 860, 720);
        line(860, 0, 860, 720);
        Held.render();
        Held.walk();
        for (int x = 0; x < Gegner.length; x++) {
            Gegner[x].render();
            Gegner[x].walk(Held.xPos, Held.yPos);
        }
        //image(background, 0, 0);
        //image(inventory, 720, 0);
        //image(hero, 360, 360);
    }
}
