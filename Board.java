package SnakesLadder;

import java.util.*;

public class Board {

    private int size;
    private int start;
    private int end;
    private List<Snakes> snakes;
    private List<Ladders> ladders;

    public Board(int size) {
        this.size = size;
        this.start = 1;
        this.end = start + size -1;
        this.snakes = new ArrayList<>((int)size/30);
        this.ladders = new ArrayList<>((int)size/30);
        initBoard();
    }
    public List<Snakes> getSnakes() {
        return snakes;
    }

    public List<Ladders> getLadders() {
        return ladders;
    }
    public int getEnd() {
        return end;
    }
    public int getSize() {
        return size;
    }
    public int getStart() {
        return start;
    }

    private void initBoard(){
        System.out.println("Intializing Board...");
        Random random = new Random();
        Set<String> slSet = new HashSet<>();
        int limit = (int)size/30;
        System.out.println("Assembling "+limit+" Snakes...");
        for(int i =0;i< limit;i++){
            while(true){
                int head = random.nextInt(getSize() + 1 - getStart())+ getStart();
                int tail = random.nextInt(getSize() + 1 - getStart())+ getStart();
                if(tail >= head)
                    continue;
                String sePair = String.valueOf(head) + tail;
                if(!slSet.contains(sePair)){
                    Snakes snake = new Snakes(head, tail);
                    snakes.add(snake);
                    slSet.add(sePair);
                    break;
                }
            }
        }
        System.out.println("Assembling "+limit+" Ladders...");
        for(int i =0;i< limit;i++) {
            while (true) {
                int start = random.nextInt(getSize() + 1 - getStart()) + getStart();
                int end = random.nextInt(getSize() + 1 - getStart()) + getStart();
                if (start >= end)
                    continue;
                String sePair = String.valueOf(start) + end;
                if (!slSet.contains(sePair)) {
                    Ladders ladder = new Ladders(start, end);
                    ladders.add(ladder);
                    slSet.add(sePair);
                    break;
                }
            }
        }
    }
}


