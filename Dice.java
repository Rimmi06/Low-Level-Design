package SnakesLadder;


import java.util.Random;

public class Dice {
    public Dice(int maxValue, int minValue, int currentValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.currentValue = currentValue;
    }

    private int maxValue;
    private int minValue;

    private int currentValue;
    Random random = new Random();

    protected int roll(){
        System.out.println("Rolling your chances to win.....");
        return random.nextInt(maxValue + 1 - minValue) + minValue;
    }
}
