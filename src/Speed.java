import processing.core.PApplet;
import processing.core.PImage;

/**
 * Speed-Klasse zum Dekorieren der upgradeSpeed-Klasse
 */
public class Speed extends Items {

    /**
     * Konstruktor fuer die Speed-Klasse
     *
     * @param iWindow  Legt fest, auf welches Draw-Fenster wir zugreifen moechten
     * @param iLevelup Bezieht sich auf das Levelup-Interface
     */
    public Speed(PApplet iWindow, Levelup iLevelup) {
        super(iLevelup);
        window = iWindow;
        levelup = iLevelup;
    }

    double rarity = Math.random() * 10;
    PImage speed;

    /**
     * Methode zum Darstellen der Rarität des Upgrades, je nach Rarity wird ein bestimmter Rahmen eingefuegt
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
        if (window.mouseX >= 546 && window.mouseX <= 546 + 182 && window.mouseY >= window.height / 2 && window.mouseY <= window.height / 2 + 182) {
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
                    hero.speed += 0.1;
                    enemy.speed -= 0.1;
                } else if (rarity > 50 && rarity <= 75) {
                    hero.speed += 0.3;
                    enemy.speed -= 0.3;
                } else if (rarity > 75 && rarity <= 90) {
                    hero.speed += 0.7;
                    enemy.speed -= 0.7;
                } else if (rarity > 90 && rarity <= 100) {
                    hero.speed += 1;
                    enemy.speed -= 1;
                }
            }
        }
        levelup.render(start, hero, enemy);
        speed = window.loadImage("Speed.png");
        window.image(speed, 546, (float) window.height / 2);
    }
}
