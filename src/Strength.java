import processing.core.PApplet;
import processing.core.PImage;

public class Strength extends Items {

    public Strength(PApplet iWindow, Levelup iLevelup) {
        super(iLevelup);
        window = iWindow;
        levelup = iLevelup;
    }

    double rarity = Math.random() * 10;
    PImage strength;

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
        if (window.mouseX >= 910 && window.mouseX <= 910 + 182 && window.mouseY >= window.height / 2 && window.mouseY <= window.height / 2 + 182) {
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
                    hero.attack += 5;
                } else if (rarity > 4 && rarity <= 6) {
                    hero.attack += 10;
                } else if (rarity > 6 && rarity <= 9) {
                    hero.attack += 20;
                } else if (rarity > 9 && rarity <= 10) {
                    hero.attack += 40;
                }
            }
        }
        levelup.render(hero, start);
        strength = window.loadImage("Strength.png");
        window.image(strength, 910, window.height / 2);
    }
}
