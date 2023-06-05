import processing.core.PApplet;
import processing.core.PConstants;

public class Start {

    PApplet window;
    boolean starting;

    Start(PApplet iWindow, boolean iStarting) {
        window = iWindow;
        starting = iStarting;
    }

    public void starting(Creature creature) {
        if (starting) {
            creature.alive = false;
            window.background(0);
            window.textSize(30);
            window.textAlign(PConstants.CENTER);
            window.fill(100);
            window.text("Blackbox Adventures", window.width / 2 + 1, 120 + 1);
            window.text("Press SPACE to start", window.width / 2 + 1, window.height / 2 + 1);
            window.fill(255);
            window.text("Blackbox Adventures", window.width / 2, 120);
            window.text("Press SPACE to start", window.width / 2, window.height / 2);
            window.textAlign(PConstants.LEFT);
            if (window.keyPressed) {
                if (window.key == 32) {
                    starting = false;
                    creature.alive = true;
                }
            }
        }
    }

    public void ending(Hero hero) {
        if (hero.gameOver) {
            hero.alive = false;
            window.background(0);
            window.textSize(30);
            window.textAlign(PConstants.CENTER);
            window.fill(102, 0, 0);
            window.text("GAME OVER", window.width / 2 + 1, 120 + 1);
            window.text("Press SPACE to restart or ESCAPE to exit!", window.width / 2 + 1, window.height / 2 + 1);
            window.fill(255, 0, 0);
            window.text("GAME OVER", window.width / 2, 120);
            window.text("Press SPACE to restart or ESCAPE to exit!", window.width / 2, window.height / 2);
            window.textAlign(PConstants.LEFT);
        }
    }
}
