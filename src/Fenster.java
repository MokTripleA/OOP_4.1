import processing.core.PApplet;
import processing.core.PImage;

public class Fenster extends PApplet {

    PImage background, inventory, hero;


    @Override
    public void settings() {
        background = loadImage("background.png");
        inventory = loadImage("inventory.png");
        hero = loadImage("hero_standing.png");
        size(1280, 720);
    }

    @Override
    public void draw() {
        background(200);
        image(background, 0, 0);
        image(inventory, 720, 0);
        image(hero, 360, 360);
    }
}
