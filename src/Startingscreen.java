import processing.core.PApplet;

public class Startingscreen {

    int width;
    int height;
    boolean starting;
    PApplet window;

    Startingscreen(int iWidth, int iHeight, boolean iStarting, PApplet iWindow) {
        width = iWidth;
        height = iHeight;
        starting = iStarting;
        window = iWindow;
    }

    public void starting(Creature creature) {
        if (starting = true) {
            creature.alive = false;
            window.stroke(0);
            window.strokeWeight(10);
            window.fill(139, 69, 19);
            window.rect(160, 90, width, height);
            window.fill(0);
            window.textSize(25);
            window.text("Yeoraujen", 400, 120);
        }
        else {
            creature.alive = true;
        }
    }
}
