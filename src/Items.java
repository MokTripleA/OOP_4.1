import processing.core.PApplet;

public abstract class Items implements Levelup {

    PApplet window;
    protected Levelup levelup;

    public Items(Levelup levelup) {
        this.levelup = levelup;
    }

    public void render(Hero hero, Start start) {
        levelup.render(hero, start);
    }
}
