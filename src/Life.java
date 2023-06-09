public class Life extends Items{


    Life(Levelup levelup) {
    }

    @Override
    public void render() {
        window.stroke(255);
        window.strokeWeight(5);
        window.fill(0);
        window.rect(182, window.height / 2, 182, 182);
        window.fill(0, 255, 0);
        window.rect(546, window.height / 2, 182, 182);
        window.fill(0);
        window.rect(910, window.height / 2, 182, 182);
    }
}
