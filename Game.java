package SnakesLadder;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    private Queue<Player> players;
    private Board board;
    private Dice dice;

    public Game(int boardSize) {
        this.players = new ArrayDeque<>();
        this.board = new Board(boardSize);
        this.dice = new Dice(6,1,2);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void playGame(){
        Scanner sc = new Scanner(System.in);
        while (true){
            Player player = players.poll();
            System.out.println(player.getName() + " wants to Roll Dice? Y/N");
            String output = sc.next();
            if(output.equalsIgnoreCase("Y")) {
                int val = dice.roll();
                int newPosition = player.getPosition() + val;
                if(newPosition > board.getEnd()){ // dont update to new position
                    player.setPosition(player.getPosition());
                    players.offer(player);
                }else{
                    player.setPosition(getNewPosition(newPosition, player));
                    if(player.getPosition() == board.getEnd()){
                        player.setWon(true);
                        System.out.println("Player "+ player.getName() +" has Won");
                    }else{
                        System.out.println("Player "+ player.getName() +" moved to "+ newPosition);
                        players.offer(player);
                    }
                }
            }else {
                System.out.println("Player "+ player.getName() +" skipped the roll. ");
                players.offer(player);
            }
            if (players.size() <2){
                break;
            }
        }
    }

    private int getNewPosition(int newPosition, Player player){
        for(Snakes sn: board.getSnakes()){
            if(sn.getHead() == newPosition){
                System.out.println("Player "+ player.getName() +" got bit by snake :( ");
                return sn.getTail();
            }
        }
        for(Ladders ldd: board.getLadders()){
            if(ldd.getStart() == newPosition){
                System.out.println("Player "+ player.getName() +" got ladder !! ");
                return ldd.getEnd();
            }
        }
        return  newPosition;
    }


}
