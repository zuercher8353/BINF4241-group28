public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.createPlayers();
        game.board.printBoard();
        game.runGame();
    }
}
