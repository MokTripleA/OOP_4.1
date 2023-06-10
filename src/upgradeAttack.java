import processing.core.PApplet;

public class upgradeAttack implements Levelup {

    PApplet window;

    upgradeAttack(PApplet iWindow){
        window = iWindow;
    }

    @Override
    public void render(Hero hero, Start start) {
        window.rect(910, window.height / 2, 182, 182);
    }
}
