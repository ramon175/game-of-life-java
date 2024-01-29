public class Main {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();

        //get initial seed
        game.initialize();
        game.run(10, "game_of_life.csv");
    }
}