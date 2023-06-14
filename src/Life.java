import processing.core.PApplet;
import processing.core.PImage;

import java.lang.Math;

/**
 * Life-Klasse zum Dekorieren der upgradeHealth-Klasse
 */
public class Life extends Items {

    /**
     * Konstruktor fuer die Life-Klasse
     *
     * @param iWindow  Legt fest, auf welches Draw-Fenster wir zugreifen moechten
     * @param iLevelup Bezieht sich auf das Levelup-Interface
     */
    public Life(PApplet iWindow, Levelup iLevelup) {
        super(iLevelup);
        window = iWindow;
        levelup = iLevelup;
    }

    double rarity = Math.random() * 100;
    PImage life;

    /**
     * Methode zum Generieren der Dekoration für das Health-Upgrade
     *
     * @param start Bezieht sich auf ein Objekt der Start-Klasse
     * @param hero  Bezieht sich auf ein Objekt der Hero-Klasse
     * @param enemy Bezieht sich auf ein Objekt der Enemy-Klasse
     */
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
        if (window.mouseX >= 182 && window.mouseX <= 182 + 182 && window.mouseY >= window.height / 2 && window.mouseY <= window.height / 2 + 182) {
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
                    hero.health += 25;
                } else if (rarity > 50 && rarity <= 75) {
                    hero.health += 50;
                } else if (rarity > 75 && rarity <= 90) {
                    hero.health += 100;
                } else if (rarity > 90 && rarity <= 100) {
                    hero.health += 250;
                }
            }
        }
        levelup.render(start, hero, enemy);
        life = window.loadImage("Life.png");
        window.image(life, 182, (float) window.height / 2);
    }
}
