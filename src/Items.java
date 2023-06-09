import processing.core.PApplet;

public abstract class Items implements Levelup {

    PApplet window;

    private Levelup levelup;

    @Override
    public void render() {
        levelup.render();

    }

}
