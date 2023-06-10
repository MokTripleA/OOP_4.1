import processing.core.PApplet;

public class upgradeSpeed implements Levelup {

    PApplet window;

    upgradeSpeed(PApplet iWindow){
        window = iWindow;
    }

    @Override
    public void render(Hero hero, Start start) {
        window.rect(546, window.height / 2, 182, 182);
    }
}
