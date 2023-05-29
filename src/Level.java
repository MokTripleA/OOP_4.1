import processing.core.PApplet;

public class Level extends PApplet {

    PApplet window;
    int width;
    int height;

    Level(PApplet iWindow, int iWidth, int iHeight) {
        window = iWindow;
        width = iWidth;
        height = iHeight;
    }

    public void generate() {
        window.fill(0, 200, 0);
        window.rect(0, 0, this.width, this.height);
    }
}
