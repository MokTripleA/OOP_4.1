import processing.core.PApplet;
import processing.core.PImage;

public class Speed extends Items {

    public Speed(PApplet iWindow, Levelup iLevelup) {
        super(iLevelup);
        window = iWindow;
        levelup = iLevelup;
    }

    double rarity = Math.random() * 10;
    PImage speed;

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
        if (window.mouseX >= 546 && window.mouseX <= 546 + 182 && window.mouseY >= window.height / 2 && window.mouseY <= window.height / 2 + 182) {
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
                    hero.speed += 0.3;
                } else if (rarity > 4 && rarity <= 6) {
                    hero.speed += 0.5;
                } else if (rarity > 6 && rarity <= 9) {
                    hero.speed += 1;
                } else if (rarity > 9 && rarity <= 10) {
                    hero.speed += 3;
                }
            }
        }
        levelup.render(hero, start);
        speed = window.loadImage("Speed.png");
        window.image(speed, 546, window.height / 2);
    }
}
