/**
 * Interface um Upgrade-Klassen darzustellen
 */
public interface Levelup {
    /**
     * Legt fest, welche Methode im Interface ausgefuehrt werden soll
     *
     * @param start Bezieht sich auf ein Objekt der Start-Klasse
     * @param hero  Bezieht sich auf ein Objekt der Hero-Klasse
     * @param enemy Bezieht sich auf ein Objekt der Enemy-Klasse
     */
    void render(Start start, Hero hero, Enemy enemy);
}
