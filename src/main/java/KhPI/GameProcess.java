package KhPI;

import static KhPI.CellOverwrite.overwrite;
import static KhPI.CellSecurityCheck.shah;
import static KhPI.DataPort.blackMove;
import static KhPI.DataPort.callingThePlayerToMakeTheMove;
import static KhPI.DataPort.checkmateToTheBlackKing;
import static KhPI.DataPort.checkmateToTheWhiteKing;
import static KhPI.DataPort.chessBoard;
import static KhPI.DataPort.endOfTheGame;
import static KhPI.DataPort.finalPositionOfTheFigure;
import static KhPI.DataPort.listOfLegalMoves;
import static KhPI.DataPort.movementCounter;
import static KhPI.DataPort.shahToTheBlackKing;
import static KhPI.DataPort.shahToTheWhiteKing;
import static KhPI.DataPort.stalemateToTheBlackPlayer;
import static KhPI.DataPort.stalemateToTheWhitePlayer;
import static KhPI.DataPort.startingPositionOfTheFigure;
import static KhPI.DataPort.startTheNewGame;
import static KhPI.DataPort.targetKing;
import static KhPI.DataPort.whiteMove;
import static KhPI.GlobalConstant.*;
import static KhPI.Input.humansMove;

public class GameProcess {
    private static final double HALF_STROKE = 0.5;

    static void startTheNewGame() {
        startTheNewGame = FALSE;
    }

    static void game() {
        movementCounter += HALF_STROKE;

        clearPosition();
        callingThePlayerToMakeTheMove = TRUE;
        humansMove();

        overwrite(startingPositionOfTheFigure, finalPositionOfTheFigure, FALSE, targetKing);
        callingThePlayerToMakeTheMove = TRUE;

        if ((blackMove == FALSE) && (whiteMove == TRUE)) {
            blackMove = TRUE;
            whiteMove = FALSE;
        } else {
            blackMove = FALSE;
            whiteMove = TRUE;
        }
    }

    static void clearListOfLegalMoves() {
        for (int k = FALSE; k < NUMBER_OF_FIGURES; k++) {
            for (int l = NUMBER_OF_LEGAL_MOVES + SHIFT_BY_MINUS_1; l > FALSE; l--) {
                listOfLegalMoves[k][l] = FALSE;
            }
        }
    }

    static void clearPosition() {
        startingPositionOfTheFigure = FALSE;
        finalPositionOfTheFigure = FALSE;
    }

    static void checkKingForShah(int kingName) {
        if (kingName == BLACK_KING_E8) {
            shahToTheBlackKing = FALSE;
        } else {
            shahToTheWhiteKing = FALSE;
        }

        for (int i = FALSE; i < ROW_1_END; i++) {
            if (chessBoard[i][CHESSBOARD_LAYER_1] == kingName) {
                shah(i, TWO);
                break;
            }
        }
    }

    static void gameOverChecks() {

        checkKingForShah(BLACK_KING_E8);
        checkKingForShah(WHITE_KING_E1);

        for (int i = (BLACK_ALLIED_RANGE_START + SHIFT_BY_PLUS_1); i < BLACK_ALLIED_RANGE_END; i++) {
            if ((listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_0] != FALSE) && (listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_1] != FALSE)) {
                i = BLACK_ALLIED_RANGE_END;
                checkmateToTheBlackKing = FALSE;
            } else {
                checkmateToTheBlackKing = TRUE;
            }
        }

        for (int i = (WHITE_ALLIED_RANGE_START + SHIFT_BY_PLUS_1); i < WHITE_ALLIED_RANGE_END; i++) {
            if ((listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_0] != FALSE) && (listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_1] != FALSE)) {
                i = WHITE_ALLIED_RANGE_END;
                checkmateToTheWhiteKing = FALSE;
            } else {
                checkmateToTheWhiteKing = TRUE;
            }
        }

        for (int i = (BLACK_ALLIED_RANGE_START + SHIFT_BY_PLUS_1); i < BLACK_ALLIED_RANGE_END; i++) {
            if ((listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_0] != FALSE)
                    && (((listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_1] != FALSE) && (listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_0] != listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_1]))
                    || (listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_2] != FALSE))) {
                i = BLACK_ALLIED_RANGE_END;
                stalemateToTheBlackPlayer = FALSE;
            } else {
                stalemateToTheBlackPlayer = TRUE;
            }
        }

        for (int i = (WHITE_ALLIED_RANGE_START + SHIFT_BY_PLUS_1); i < WHITE_ALLIED_RANGE_END; i++) {
            if ((listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_0] != FALSE)
                    && (((listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_1] != FALSE) && (listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_0] != listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_1]))
                    || (listOfLegalMoves[i][LIST_OF_LEGAL_MOVES_LAYER_2] != FALSE))) {
                i = WHITE_ALLIED_RANGE_END;
                stalemateToTheWhitePlayer = FALSE;
            } else {
                stalemateToTheWhitePlayer = TRUE;
            }
        }
    }

    static void endOfTheGame() {
        gameOverChecks();

        if (((stalemateToTheBlackPlayer == TRUE) && (blackMove == TRUE) && (whiteMove == FALSE))
                || (checkmateToTheBlackKing == TRUE)
                || ((stalemateToTheWhitePlayer == TRUE) && (blackMove == FALSE) && (whiteMove == TRUE))
                || (checkmateToTheWhiteKing == TRUE)) {
            endOfTheGame = TRUE;
        } else {
            endOfTheGame = FALSE;
        }
    }
}