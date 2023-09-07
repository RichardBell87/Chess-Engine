package KhPI;

import static KhPI.DataPort.blackFigureStyle;
import static KhPI.DataPort.displayingAStalemateForTheBlackPlayer;
import static KhPI.DataPort.displayingAStalemateForTheWhitePlayer;
import static KhPI.DataPort.greyStyle;
import static KhPI.DataPort.matrixStyle;
import static KhPI.DataPort.moveCountBeforeGameEnd;
import static KhPI.DataPort.playingFieldDisplay;
import static KhPI.DataPort.playsBlackPieces;
import static KhPI.DataPort.playsWhitePieces;
import static KhPI.DataPort.sleepTimeBetweenMove;
import static KhPI.DataPort.spaceControlledByTheBlackPlayer;
import static KhPI.DataPort.spaceControlledByTheWhitePlayer;
import static KhPI.DataPort.whiteFigureStyle;
import static KhPI.GlobalConstant.*;

public class Setup {
    private static final String PLAYER_ONE_DEFAULT_NAME = "Player 1";
    private static final String PLAYER_TWO_DEFAULT_NAME = "Player 2";
    private static final int SLEEP_TIME_BETWEEN_MOVE = 500;
    private static final int MOVE_COUNT_BEFORE_GAME_END = 100187;

    static void setup() {
        playsBlackPieces = PLAYER_TWO_DEFAULT_NAME;
        playsWhitePieces = PLAYER_ONE_DEFAULT_NAME;

        sleepTimeBetweenMove = SLEEP_TIME_BETWEEN_MOVE;
        moveCountBeforeGameEnd = MOVE_COUNT_BEFORE_GAME_END;

        playingFieldDisplay = TRUE;
        displayingAStalemateForTheBlackPlayer = TRUE;
        displayingAStalemateForTheWhitePlayer = TRUE;
        spaceControlledByTheBlackPlayer = FALSE;
        spaceControlledByTheWhitePlayer = FALSE;
        greyStyle = TRUE;
        matrixStyle = FALSE;
        blackFigureStyle = TRUE;
        whiteFigureStyle = TRUE;
    }
}