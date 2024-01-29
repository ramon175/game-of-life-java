import java.io.FileWriter;
import java.io.IOException;

public class GameOfLife {

    private static final int SIZE = 10;
    private boolean [][] board;

    public GameOfLife() {
        board = new boolean[SIZE][SIZE];
    }

    public void initialize() {
        for (int i = 0; i< SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = Math.random() < 0.5;
            }
        }
        exportToCSV("entry_board.csv");
    }

    public void printBoard() {
        System.out.println("  ");
        for(int i = 0; i < SIZE; i++){
            System.out.println(i + "");
        }
        System.out.println();

        for(int i = 0; i < SIZE; i++){
            System.out.println(i + " ");
            for(int j =0; j<SIZE; j++){
                System.out.println((board[i][j] ? "0" : ". ") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void updateBoard() {
        boolean[][] newBoard = new boolean[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                int liveNeighbors = countLiveNeighbors(i, j);

                if(board[i][j]) {
                    newBoard[i][j] = liveNeighbors == 2 || liveNeighbors == 3;
                } else {
                    newBoard[i][j] = liveNeighbors == 3;
                }
            }
        }

        board = newBoard;
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++){
            for(int j = -1; j<= 1; j++){
                if(i == 0 && j == 0) continue;

                // calculate the delta from current line (get previous line position)
                int dx = x + i;
                // calculate the delta from current column (get previous column position)
                int dy = y + j;
                //verify if delta positions are bigger than 0 (avoid edges) and if cell is alive
                if(dx >= 0 && dx < SIZE && dy >= 0 && dy < SIZE && board[dx][dy]){
                    count++;
                }
            }
        }
        return count;
    }

    public void run (int generations,String csvFilename) {
        for (int i = 0; i < generations; i++){
            printBoard();
            updateBoard();
        }
        exportToCSV(csvFilename);
    }

    public void exportToCSV(String filename) {
        try (FileWriter csvWriter = new FileWriter(filename)) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    csvWriter.append(board[i][j] ? "0" : " ");
                    if (j < SIZE - 1) {
                        csvWriter.append(",");
                    }
                }
                csvWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
