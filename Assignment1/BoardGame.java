import java.util.Scanner;

public class BoardGame {
        public static void main(String[] args) {


            Scanner in = new Scanner(System.in);
            int playerCount = in.nextInt();
            System.out.println("Your number of players: "+ playerCount);

            Player players[playerCount];
            for (int i = 0; i <= playerCount; i++) {

                System.out.println("Your number of players: "+ playerCount);
                Scanner input = new Scanner(System.in);
                String playerName = input.nextLine();
                players[i] = new Player(playerName);
            }
        }
}


