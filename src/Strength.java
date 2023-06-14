import processing.core.PApplet;
import processing.core.PImage;

/**
 * Strength-Klasse zum Dekorieren der upgradeAttack-Klasse
 */
public class Strength extends Items {

    /**
     * Konstruktor fuer die Strength-Klasse
     *
     * @param iWindow  Legt fest, auf welches Draw-Fenster wir zugreifen moechten
     * @param iLevelup Bezieht sich auf das Levelup-Interface
     */
    public Strength(PApplet iWindow, Levelup iLevelup) {
        super(iLevelup);
        window = iWindow;
        levelup = iLevelup;
    }

    double rarity = Math.random() * 10;
    PImage strength;

    @Override
    public void render(Start start, Hero hero, Enemy enemy) {
        window.stroke(255);
        window.strokeWeight(5);
        window.fill(0);
        if (rarity <= 50) {
            window.stroke(0, 255, 0);
        } else if (rarity > 50 && rarity <= 75) {
            window.stroke(0, 0, 255);
        } else if (rarity > 75 && rarity <= 90) {
            window.stroke(204, 0, 204);
        } else if (rarity > 90 && rarity <= 100) {
            window.stroke(255, 0, 0);
        }
        if (window.mouseX >= 910 && window.mouseX <= 910 + 182 && window.mouseY >= window.height / 2 && window.mouseY <= window.height / 2 + 182) {
            if (rarity <= 50) {
                window.fill(0, 255, 0);
            } else if (rarity > 50 && rarity <= 75) {
                window.fill(0, 0, 255);
            } else if (rarity > 75 && rarity <= 90) {
                window.fill(204, 0, 204);
            } else if (rarity > 90 && rarity <= 100) {
                window.fill(255, 0, 0);
            }
            if (window.mousePressed) {
                if (rarity <= 50) {
                    hero.attack += 5;
                } else if (rarity > 50 && rarity <= 75) {
                    hero.attack += 10;
                } else if (rarity > 75 && rarity <= 90) {
                    hero.attack += 20;
                } else if (rarity > 90 && rarity <= 100) {
                    hero.attack += 50;
                }
            }
        }
        levelup.render(start, hero, enemy);
        strength = window.loadImage("Strength.png");
        window.image(strength, 910, (float) window.height / 2);
    }
}
