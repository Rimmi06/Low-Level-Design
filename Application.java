package SnakesLadder;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter board Size");
        int boardSize = scan.nextInt();

        System.out.println("Enter number of players");
        int noOfPlayers = scan.nextInt();
        Game game = new Game(boardSize);
        for(int i =0;i<noOfPlayers;i++){
            System.out.println("Enter player name");
            String name = scan.next();
            Player player = new Player(name);
            game.addPlayer(player);
        }
        game.playGame();
    }
}
