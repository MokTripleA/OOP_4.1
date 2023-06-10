import processing.core.PApplet;
import processing.core.PImage;

import java.lang.Math;

public class Life extends Items {


    public Life(PApplet iWindow, Levelup iLevelup) {
        super(iLevelup);
        window = iWindow;
        levelup = iLevelup;
    }

    double rarity = Math.random() * 10;
    PImage life;

    @Override
    public void render(Hero hero, Start start) {
        window.stroke(255);
        window.strokeWeight(5);
        window.fill(0);
        if (rarity <= 4) {
            window.stroke(0, 255, 0);
        } else if (rarity > 4 && rarity <= 6) {
            window.stroke(0, 0, 255);
        } else if (rarity > 6 && rarity <= 9) {
            window.stroke(204, 0, 204);
        } else if (rarity > 9 && rarity <= 10) {
            window.stroke(255, 0, 0);
        }
        if (window.mouseX >= 182 && window.mouseX <= 182 + 182 && window.mouseY >= window.height / 2 && window.mouseY <= window.height / 2 + 182) {
            if (rarity <= 4) {
                window.fill(0, 255, 0);
            } else if (rarity > 4 && rarity <= 6) {
                window.fill(0, 0, 255);
            } else if (rarity > 6 && rarity <= 9) {
                window.fill(204, 0, 204);
            } else if (rarity > 9 && rarity <= 10) {
                window.fill(255, 0, 0);
            }
            if (window.mousePressed) {
                if (rarity <= 4) {
                    hero.health += 20;
                } else if (rarity > 4 && rarity <= 6) {
                    hero.health += 40;
                } else if (rarity > 6 && rarity <= 9) {
                    hero.health += 60;
                } else if (rarity > 9 && rarity <= 10) {
                    hero.health += 100;
                }
            }
        }
        levelup.render(hero, start);
        life = window.loadImage("Life.png");
        window.image(life, 182, window.height / 2);
    }
}
