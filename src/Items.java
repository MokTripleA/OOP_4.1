import processing.core.PApplet;

public abstract class Items implements Levelup {

    PApplet window;
    protected Levelup levelup;

    public void render(Hero hero, Start start) {
        levelup.render(hero, start);
    }
}
