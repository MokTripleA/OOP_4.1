import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * Start-Klasse fuer alle Screens außer des Spiel-Screens
 */
public class Start {

    PApplet window;
    /**
     * Falls true, dann wird der Start-Screen angezeigt
     */
    boolean starting;
    /**
     * Falls true, dann wird der Nächste-Welle-Screen angezeigt
     */
    boolean nextWave;
    /**
     * Falls true, dann wird der Win-Screen angezeigt
     */
    boolean win;
    /**
     * Falls true, dann wird der Rules-Screen angezeigt
     */
    boolean rules = false;

    Start(PApplet iWindow, boolean iStarting, boolean iNextWave, boolean iWin) {
        window = iWindow;
        starting = iStarting;
        nextWave = iNextWave;
        win = iWin;
    }

    /**
     * Methode zum Darstellen des Start-Screens
     *
     * @param creature
     */
    public void starting(Creature creature) {
        if (starting && !rules) {
            creature.alive = false;
            window.background(0);
            window.textSize(30);
            window.textAlign(PConstants.CENTER);
            window.fill(100);
            window.text("Blackbox Adventures", window.width / 2 + 1, 120 + 1);
            window.fill(255);
            window.text("Blackbox Adventures", window.width / 2, 120);
            window.stroke(255);
            window.fill(0);
            window.rect(window.width / 2 - 100, window.height / 2 - 100, 200, 100);
            window.rect(window.width / 2 - 100, window.height / 2 + 50, 200, 100);
            window.fill(255);
            window.text("START", window.width / 2, window.height / 2 - 40);
            window.text("RULES", window.width / 2, window.height / 2 + 110);
            if (window.mouseX >= window.width / 2 - 100 && window.mouseX <= window.width / 2 + 100 && window.mouseY >= window.height / 2 - 100 && window.mouseY <= window.height / 2) {
                window.fill(255);
                window.rect(window.width / 2 - 100, window.height / 2 - 100, 200, 100);
                window.fill(0);
                window.text("START", window.width / 2, window.height / 2 - 40);
                if (window.mousePressed) {
                    creature.alive = true;
                    starting = false;
                }
            } else if (window.mouseX >= window.width / 2 - 100 && window.mouseX <= window.width / 2 + 100 && window.mouseY >= window.height / 2 + 50 && window.mouseY <= window.height / 2 + 150) {
                window.fill(255);
                window.rect(window.width / 2 - 100, window.height / 2 + 50, 200, 100);
                window.fill(0);
                window.text("RULES", window.width / 2, window.height / 2 + 110);
                if (window.mousePressed) {
                    rules = true;
                }
            }
        } else if (rules) {
            rules();
        }
    }

    /**
     * Methode zum Darstellen des Ending-Screens
     *
     * @param hero
     */
    public void ending(Hero hero) {
        if (hero.gameOver && !nextWave) {
            hero.alive = false;
            window.background(0);
            window.textSize(30);
            window.textAlign(PConstants.CENTER);
            window.fill(102, 0, 0);
            window.text("GAME OVER", window.width / 2 + 1, 120 + 1);
            window.text("Press ESCAPE to exit!", window.width / 2 + 1, window.height / 2 + 1);
            window.fill(255, 0, 0);
            window.text("GAME OVER", window.width / 2, 120);
            window.text("Press ESCAPE to exit!", window.width / 2, window.height / 2);
            window.textAlign(PConstants.LEFT);
            if (window.keyPressed && window.key == 32) {
                starting = true;
                hero.gameOver = false;
            }
        }
    }

    /**
     * Methode zum Darstellen des Nächste-Welle-Screens
     *
     * @param hero
     * @param enemy
     */
    public void nextWave(Hero hero, Enemy enemy) {
        if (nextWave && !hero.gameOver && hero.wave <= 4) {
            hero.alive = false;
            enemy.alive = false;
            window.background(0);
            window.textSize(30);
            window.textAlign(PConstants.CENTER);
            window.fill(76, 135, 0);
            window.text("WAVE COMPLETED", window.width / 2 + 1, 120 + 1);
            window.text("CHOOSE your UPGRADE!", window.width / 2 + 1, 300 + 1);
            window.fill(128, 255, 0);
            window.text("WAVE COMPLETED", window.width / 2, 120);
            window.text("CHOOSE your UPGRADE!", window.width / 2, 300);
            window.textAlign(PConstants.LEFT);
            window.fill(0);
        }
    }

    /**
     * Methode zum Darstellen des Win-Screens
     *
     * @param hero
     * @param enemy
     */
    public void win(Hero hero, Enemy enemy) {
        if (hero.wave > 5) {
            win = true;
            nextWave = false;
            hero.gameOver = false;
            hero.alive = false;
            enemy.alive = false;
            window.background(0);
            window.textSize(30);
            window.textAlign(PConstants.CENTER);
            window.fill(76, 135, 0);
            window.text("YOU WON!", window.width / 2 + 1, 120 + 1);
            window.text("Press ESCAPE to exit!", window.width / 2 + 1, 300 + 1);
            window.fill(128, 255, 0);
            window.text("YOU WON!", window.width / 2, 120);
            window.text("Press ESCAPE to exit!", window.width / 2, 300);
            window.textAlign(PConstants.LEFT);
            window.fill(0);
        }
    }

    /**
     * Methode zum Darstellen der Regeln
     */
    public void rules() {
        PImage img;
        img = window.loadImage("Rules.png");
        window.image(img, 0, 0);

        if (window.keyPressed && window.key == 32) {
            rules = false;
        }
    }
}
