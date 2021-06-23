package pink.ruben.gameoflife;

import java.util.concurrent.TimeUnit;

public class ConwayTesting {
    public static void main(String[] args) throws InterruptedException {
        ConwayLogic game = new ConwayLogic();
        while (true){
            game.printBoard();
            game.updateBoard();
            Thread.sleep(1000);
        }

    }
}
