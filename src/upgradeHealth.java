import processing.core.PApplet;

public class upgradeHealth implements Levelup {

    PApplet window;

    upgradeHealth(PApplet iWindow){
        window = iWindow;
    }

    @Override
    public void render(Hero hero, Start start) {
        window.rect(182, window.height / 2, 182, 182);
    }
}
