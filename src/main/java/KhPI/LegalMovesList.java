package KhPI;
import static KhPI.CellOverwrite.clearLayer;
import static KhPI.CellOverwrite.overwrite;
import static KhPI.DataPort.alliedFiguresRangeEnd;
import static KhPI.DataPort.alliedFiguresRangeStart;
import static KhPI.DataPort.chessBoard;
import static KhPI.DataPort.enemyFiguresRangeEnd;
import static KhPI.DataPort.enemyFiguresRangeStart;
import static KhPI.DataPort.legalMove;
import static KhPI.DataPort.listOfLegalMoves;
import static KhPI.DataPort.targetKing;
import static KhPI.GlobalConstant.*;

public class LegalMovesList {
    private static final int SHIFT_BY_MINUS_24 = -24;
    private static final int SHIFT_BY_MINUS_3 = -3;
    private static final int SHIFT_BY_PLUS_2 = 2;
    private static final int SHIFT_BY_PLUS_24 = 24;
    private static int furtherMovement;
    private static int i;
    private static int chessboardLayerSpace;
    private static int chessboardLayerStalemate;

    static void furtherMovementMain(int movementVector, int i) {
        if ((((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0300)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0600)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0900)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1200))
                && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_ROOK_A8)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_ROOK_H8)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_ROOK_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_ROOK_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_ROOK_A1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_ROOK_H1)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_ROOK_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_ROOK_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_QUEEN_D8)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_QUEEN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_QUEEN_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_QUEEN_D1)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_QUEEN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_QUEEN_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KING_E8)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KING_E1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_FIGURE_TO_PROMOTION_A1_H1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_FIGURE_TO_PROMOTION_A8_H8)))

                || (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0100)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0200)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0400)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0500)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0700)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0800)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1000)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1100))
                && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KNIGHT_B8)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KNIGHT_G8)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_KNIGHT_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_KNIGHT_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KNIGHT_B1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KNIGHT_G1)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_KNIGHT_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_KNIGHT_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_FIGURE_TO_PROMOTION_A1_H1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_FIGURE_TO_PROMOTION_A8_H8)))

                || (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0130)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0430)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0730)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1030))
                && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_BISHOP_C8)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_BISHOP_F8)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_BISHOP_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_BISHOP_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_BISHOP_C1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_BISHOP_F1)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_BISHOP_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_BISHOP_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_QUEEN_D8)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_QUEEN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_QUEEN_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_QUEEN_D1)
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_QUEEN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_QUEEN_RANGE_END))
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KING_E8)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KING_E1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_FIGURE_TO_PROMOTION_A1_H1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_FIGURE_TO_PROMOTION_A8_H8)))

                || (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0430)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0730))
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_END))
                && ((chessBoard[i + movementVector][CHESSBOARD_LAYER_1] > BLACK_ENEMY_RANGE_START) && (chessBoard[i + movementVector][CHESSBOARD_LAYER_1] < BLACK_ENEMY_RANGE_END)))

                || (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0130)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1030))
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_END))
                && ((chessBoard[i + movementVector][CHESSBOARD_LAYER_1] > WHITE_ENEMY_RANGE_START) && (chessBoard[i + movementVector][CHESSBOARD_LAYER_1] < WHITE_ENEMY_RANGE_END)))

                || (movementVector == FALSE)) {
            furtherMovement = TRUE;
        } else {
            furtherMovement = FALSE;
        }
    }

    static void furtherMovementAuxiliary1(int movementVector) {
        if (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_1500)
                && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] == FALSE)
                && (chessBoard[i + SHIFT_BY_PLUS_2][CHESSBOARD_LAYER_1] == FALSE)
                && (chessBoard[i][CHESSBOARD_LAYER_2] == TRUE)
                && (chessBoard[i + SHIFT_BY_PLUS_3][CHESSBOARD_LAYER_2] == TRUE)
                && (((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KING_E8) && (chessBoard[i + SHIFT_BY_PLUS_3][CHESSBOARD_LAYER_1] == BLACK_ROOK_H8))
                || ((chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KING_E1) && (chessBoard[i + SHIFT_BY_PLUS_3][CHESSBOARD_LAYER_1] == WHITE_ROOK_H1))))

                || ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_2100)
                && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] == FALSE)
                && (chessBoard[i + SHIFT_BY_MINUS_2][CHESSBOARD_LAYER_1] == FALSE)
                && (chessBoard[i + SHIFT_BY_MINUS_3][CHESSBOARD_LAYER_1] == FALSE)
                && (chessBoard[i][CHESSBOARD_LAYER_2] == TRUE)
                && (chessBoard[i + SHIFT_BY_MINUS_4][CHESSBOARD_LAYER_2] == TRUE)
                && (((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KING_E8) && (chessBoard[i + SHIFT_BY_MINUS_4][CHESSBOARD_LAYER_1] == BLACK_ROOK_A8))
                || ((chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KING_E1) && (chessBoard[i + SHIFT_BY_MINUS_4][CHESSBOARD_LAYER_1] == WHITE_ROOK_A1))))

                || ((((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0600) && (chessBoard[i + SHIFT_BY_PLUS_12][CHESSBOARD_LAYER_1] == FALSE))
                || ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_1800) && (chessBoard[i + SHIFT_BY_PLUS_12][CHESSBOARD_LAYER_1] == FALSE) && (chessBoard[i + SHIFT_BY_PLUS_24][CHESSBOARD_LAYER_1] == FALSE) && (chessBoard[i][CHESSBOARD_LAYER_2] == TRUE)))
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_END)))

                || ((((movementVector == FIGURE_MOVEMENT_VECTOR_TO_1200) && (chessBoard[i + SHIFT_BY_MINUS_12][CHESSBOARD_LAYER_1] == FALSE))
                || ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_2400) && (chessBoard[i + SHIFT_BY_MINUS_12][CHESSBOARD_LAYER_1] == FALSE) && (chessBoard[i + SHIFT_BY_MINUS_24][CHESSBOARD_LAYER_1] == FALSE) && (chessBoard[i][CHESSBOARD_LAYER_2] == TRUE)))
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_END)))

                || ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0430)
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_END))
                && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_2] == EN_PASSANT)
                && ((chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_START) && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_END)))

                || ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0730)
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_END))
                && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_2] == EN_PASSANT)
                && ((chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_START) && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_END)))

                || ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0130)
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_END))
                && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_2] == EN_PASSANT)
                && ((chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_START) && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_END)))

                || ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_1030)
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_END))
                && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_2] == EN_PASSANT)
                && ((chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_START) && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_END)))) {
            furtherMovement = TRUE;
        }
    }

    static void furtherMovementAuxiliary2(int movementVector, int i) {
        if (((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_END))
                || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_END))
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0100)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0200)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0400)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0500)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0700)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0800)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1000)
                || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1100)
                || (movementVector == FALSE)) {
            furtherMovement = FALSE;
        }
    }

    static void stalemateToVector(int movementVector) {
        for (i = ROW_8_START; i < ROW_1_END; i++) {
            if (chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) {
                if (chessBoard[i][CHESSBOARD_LAYER_1] != FALSE) {
                    if ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END)) {
                        chessboardLayerStalemate = CHESSBOARD_LAYER_4;
                        chessboardLayerSpace = CHESSBOARD_LAYER_6;
                        targetKing = BLACK_KING_E8;
                        alliedFiguresRangeStart = BLACK_ALLIED_RANGE_START;
                        alliedFiguresRangeEnd = BLACK_ALLIED_RANGE_END;
                        enemyFiguresRangeStart = BLACK_ENEMY_RANGE_START;
                        enemyFiguresRangeEnd = BLACK_ENEMY_RANGE_END;
                    } else if ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END)) {
                        chessboardLayerStalemate = CHESSBOARD_LAYER_5;
                        chessboardLayerSpace = CHESSBOARD_LAYER_7;
                        targetKing = WHITE_KING_E1;
                        alliedFiguresRangeStart = WHITE_ALLIED_RANGE_START;
                        alliedFiguresRangeEnd = WHITE_ALLIED_RANGE_END;
                        enemyFiguresRangeStart = WHITE_ENEMY_RANGE_START;
                        enemyFiguresRangeEnd = WHITE_ENEMY_RANGE_END;
                    }
                    chessBoard[i][chessboardLayerStalemate] = TRUE;
                    chessBoard[i][chessboardLayerSpace] = TRUE;
                    furtherMovementMain(movementVector, i);
                    furtherMovementAuxiliary1(movementVector);

                    for (int j = i + movementVector; (((chessBoard[j][CHESSBOARD_LAYER_0] != FALSE) && (furtherMovement == TRUE))
                            && ((chessBoard[j][CHESSBOARD_LAYER_1] == FALSE)
                            || ((chessBoard[j][CHESSBOARD_LAYER_1] == FALSE) && (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1500) && (chessBoard[j + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] == FALSE) && (chessBoard[i][CHESSBOARD_LAYER_2] == TRUE) && (chessBoard[j + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_2] == TRUE))
                            || ((chessBoard[j][CHESSBOARD_LAYER_1] == FALSE) && (movementVector == FIGURE_MOVEMENT_VECTOR_TO_2100) && (chessBoard[j + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] == FALSE) && (chessBoard[j + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] == FALSE) && (chessBoard[i][CHESSBOARD_LAYER_2] == TRUE) && (chessBoard[j + SHIFT_BY_MINUS_2][CHESSBOARD_LAYER_2] == TRUE))
                            || ((chessBoard[j][CHESSBOARD_LAYER_1] != FALSE)
                            && (movementVector != FIGURE_MOVEMENT_VECTOR_TO_1500)
                            && (movementVector != FIGURE_MOVEMENT_VECTOR_TO_2100)
                            && (movementVector != FIGURE_MOVEMENT_VECTOR_TO_1800)
                            && (movementVector != FIGURE_MOVEMENT_VECTOR_TO_2400)
                            && ((chessBoard[j][CHESSBOARD_LAYER_1] > enemyFiguresRangeStart) && (chessBoard[j][CHESSBOARD_LAYER_1] < enemyFiguresRangeEnd)))
                            || ((chessBoard[j][CHESSBOARD_LAYER_1] != FALSE)
                            && ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0600) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_END))
                            && ((chessBoard[j][CHESSBOARD_LAYER_1] > enemyFiguresRangeStart) && (chessBoard[j][CHESSBOARD_LAYER_1] < enemyFiguresRangeEnd)))
                            || ((chessBoard[j][CHESSBOARD_LAYER_1] != FALSE)
                            && ((movementVector == FIGURE_MOVEMENT_VECTOR_TO_1200) && ((chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_END))
                            && ((chessBoard[j][CHESSBOARD_LAYER_1] > enemyFiguresRangeStart) && (chessBoard[j][CHESSBOARD_LAYER_1] < enemyFiguresRangeEnd))))
                            || ((chessBoard[j][CHESSBOARD_LAYER_1] != FALSE) && (movementVector == FALSE)))
                    ); j += movementVector) {
                        if ((chessBoard[j][CHESSBOARD_LAYER_1] > enemyFiguresRangeStart) && (chessBoard[j][CHESSBOARD_LAYER_1] < enemyFiguresRangeEnd)) {
                            furtherMovement = FALSE;
                        }
                        if ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KING_E8) || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KING_E1)) {
                            furtherMovement = FALSE;
                        }

                        furtherMovementAuxiliary2(movementVector, i);
                        overwrite(i, j, TRUE, targetKing);

                        if (legalMove == TRUE) {
                            chessBoard[j][chessboardLayerStalemate] = TRUE;
                            chessBoard[j][chessboardLayerSpace] = TRUE;

                            /* overwrite listOfLegalMoves */
                            listOfLegalMoves[(chessBoard[i][CHESSBOARD_LAYER_1])][LIST_OF_LEGAL_MOVES_LAYER_0] = i;

                            int writingDataToArray = TRUE;
                            for (int m = TRUE; ((m < NUMBER_OF_LEGAL_MOVES) && (writingDataToArray == TRUE)); m++) {
                                if (listOfLegalMoves[(chessBoard[i][CHESSBOARD_LAYER_1])][m] == FALSE) {
                                    writingDataToArray = FALSE;
                                    listOfLegalMoves[(chessBoard[i][CHESSBOARD_LAYER_1])][m] = j;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void createTheListOfPossibleMoves() {
        clearLayer(CHESSBOARD_LAYER_4);
        clearLayer(CHESSBOARD_LAYER_5);
        clearLayer(CHESSBOARD_LAYER_6);
        clearLayer(CHESSBOARD_LAYER_7);

        stalemateToVector(FALSE);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0100);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0130);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0200);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0300);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0400);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0430);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0500);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0600);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0700);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0730);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0800);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_0900);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_1000);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_1030);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_1100);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_1200);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_1500);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_1800);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_2100);
        stalemateToVector(FIGURE_MOVEMENT_VECTOR_TO_2400);
    }
}