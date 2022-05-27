package SnakesLadder;

public class Player {
    private String name;
    private int position;
    private boolean won;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWon() {
        return won;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.won = false;
    }

}
