package KhPI;

import static KhPI.DataPort.chessBoard;
import static KhPI.DataPort.endOfTheGame;
import static KhPI.DataPort.moveCountBeforeGameEnd;
import static KhPI.DataPort.movementCounter;
import static KhPI.DataPort.sleepTimeBetweenMove;
import static KhPI.DataPort.startTheNewGame;
import static KhPI.GameInitialization.createThePlayingField;
import static KhPI.GameProcess.clearListOfLegalMoves;
import static KhPI.GameProcess.endOfTheGame;
import static KhPI.GameProcess.game;
import static KhPI.GameProcess.startTheNewGame;
import static KhPI.GlobalConstant.*;
import static KhPI.GUI.printThePlayingField;
import static KhPI.Input.inputTreeRoot;
import static KhPI.LegalMovesList.createTheListOfPossibleMoves;
import static KhPI.Setup.setup;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        do {
            setup();
            inputTreeRoot();
            createThePlayingField(chessBoard);
            createTheListOfPossibleMoves();
            printThePlayingField();

            while ((endOfTheGame == FALSE) && (movementCounter < moveCountBeforeGameEnd)) {
                game();
                clearListOfLegalMoves();
                createTheListOfPossibleMoves();
                endOfTheGame();
                printThePlayingField();
                Thread.sleep(sleepTimeBetweenMove);
            }

            startTheNewGame();

        } while (startTheNewGame == TRUE);
    }
}