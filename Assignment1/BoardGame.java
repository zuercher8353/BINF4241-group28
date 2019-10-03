import java.util.Scanner;

public class BoardGame {
        public static void main(String[] args) {

            int playerCount = 0;

            while(playerCount < 2 || playerCount > 4) {

                System.out.println("Your number of players: ");
                Scanner in = new Scanner(System.in);
                playerCount = in.nextInt();
            }


            Player[] players = new Player[playerCount];
            for (int i = 0; i < playerCount; i++) {

                System.out.println("Name of player Nr. "+ (i+1)+" :" );
                Scanner input = new Scanner(System.in);
                String playerName = input.nextLine();
                players[i] = new Player(playerName);
            }
        }
}


