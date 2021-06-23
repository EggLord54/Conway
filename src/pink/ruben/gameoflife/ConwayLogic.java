package pink.ruben.gameoflife;

public class ConwayLogic {

    private boolean[][] currentBoard;

    public ConwayLogic() {
        currentBoard = createBoard();
    }

    public static boolean[][] createBoard() {
        return new boolean[][]{
                {false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true, false, false},
                {false, false, false, false, true, false, false, false, true},
                {false, false, false, true, false, false, false, false, false},
                {false, false, false, true, false, false, false, false, true},
                {false, false, false, true, true, true, true, true, false},
                {false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false}
        };
    }

    public void updateBoard() {
        boolean[][] tempBoard = new boolean[9][9];

        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[i].length; j++) {
                int neighbours = countNeighbours(i, j);

                if (isAlive(i, j) && neighbours == 1 || neighbours == 0) {
                    tempBoard[i][j] = false;
                }
                else if (isAlive(i, j) && (neighbours == 2 || neighbours == 3)) {
                    tempBoard[i][j] = true;
                }
                else if (!isAlive(i, j) && neighbours == 3) {
                    tempBoard[i][j] = true;
                }
                else if (isAlive(i, j) && neighbours >= 4) {
                    tempBoard[i][j] = false;
                }
            }
        }

        currentBoard = tempBoard;
    }

    private boolean isAlive(int i, int j) {
        if (i == -1)
            i = currentBoard.length - 1;
        if (i == currentBoard.length)
            i = 0;
        if (j == -1)
            j = currentBoard.length - 1;
        if (j == currentBoard.length)
            j = 0;

        return currentBoard[i][j];
    }

    private int countNeighbours(int i, int j) {
        int neighbours = 0;
        if (isAlive(i - 1, j)) neighbours++;
        if (isAlive(i + 1, j)) neighbours++;
        if (isAlive(i, j - 1)) neighbours++;
        if (isAlive(i, j + 1)) neighbours++;
        if (isAlive(i - 1, j + 1)) neighbours++;
        if (isAlive(i - 1, j - 1)) neighbours++;
        if (isAlive(i + 1, j + 1)) neighbours++;
        if (isAlive(i + 1, j - 1)) neighbours++;

        return neighbours;
    }

    //formatting the board and printing it
    public void printBoard() {
        //y this and not println?
        System.out.print("  ");

        //printing x index
        for (int i = 0; i < currentBoard.length; i++)
            System.out.print(i + 1 + " ");

        System.out.println();

        for (int i = 0; i < currentBoard.length; i++) {
            //printing y index
            System.out.print(i + 1 + " ");

            //printing each cell + spacings
            for (int j = 0; j < currentBoard[i].length; j++) {
                char cell = currentBoard[i][j] ? '\u25A0' : '\u25A1'; //■ : □
                System.out.print(cell + " ");
            }

            //spacing for next row
            System.out.println();
        }
    }
}