package KhPI;

import static KhPI.DataPort.cellUnderAttack;
import static KhPI.DataPort.chessBoard;
import static KhPI.DataPort.shah;
import static KhPI.DataPort.shahToTheBlackKing;
import static KhPI.DataPort.shahToTheWhiteKing;
import static KhPI.GlobalConstant.*;

public class CellSecurityCheck {
    private static int alliedFiguresRangeStartChecking;
    private static int alliedFiguresRangeEndChecking;
    private static int enemyFiguresRangeEndForShahChecking;
    private static int enemyFiguresRangeStartForShahChecking;
    private static int temporaryShah;

    static void temporaryShah(int k, int movementVector) {
        if (((chessBoard[k][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START) && (chessBoard[k][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_C8))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_D8))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_E8))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_F8))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_G8))) {

            alliedFiguresRangeStartChecking = BLACK_ALLIED_RANGE_START;
            alliedFiguresRangeEndChecking = BLACK_ALLIED_RANGE_END;

            enemyFiguresRangeStartForShahChecking = WHITE_ALLIED_RANGE_START;
            enemyFiguresRangeEndForShahChecking = WHITE_ALLIED_RANGE_END;

        } else if (((chessBoard[k][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START) && (chessBoard[k][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_C1))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_D1))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_E1))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_F1))
                || ((chessBoard[k][CHESSBOARD_LAYER_1] == FALSE) && (k == CHESS_BOARD_INDEX_G1))) {

            alliedFiguresRangeStartChecking = WHITE_ALLIED_RANGE_START;
            alliedFiguresRangeEndChecking = WHITE_ALLIED_RANGE_END;

            enemyFiguresRangeStartForShahChecking = BLACK_ALLIED_RANGE_START;
            enemyFiguresRangeEndForShahChecking = BLACK_ALLIED_RANGE_END;
        }

        int iteration = FALSE;
        for (int i = k; chessBoard[i][CHESSBOARD_LAYER_0] != FALSE; i += movementVector) {
            iteration++;

            if ((chessBoard[i][CHESSBOARD_LAYER_1] > alliedFiguresRangeStartChecking)
                    && (chessBoard[i][CHESSBOARD_LAYER_1] < alliedFiguresRangeEndChecking)) {
                if (i != k) {
                    break;
                }
            }

            if ((chessBoard[i][CHESSBOARD_LAYER_1] > enemyFiguresRangeStartForShahChecking)
                    && (chessBoard[i][CHESSBOARD_LAYER_1] < enemyFiguresRangeEndForShahChecking)) {

                if (((iteration == TWO)
                        &&((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0100)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0200)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0400)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0500)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0700)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0800)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1000)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1100))
                        && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KNIGHT_B8)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KNIGHT_G8)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_FIGURE_TO_PROMOTION_A1_H1)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_KNIGHT_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_KNIGHT_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KNIGHT_B1)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KNIGHT_G1)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_FIGURE_TO_PROMOTION_A8_H8)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_KNIGHT_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_KNIGHT_RANGE_END))))

                        || ((iteration == TWO)
                        && (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0130)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0300)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0430)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0600)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0730)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0900)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1030)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1200))
                        && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_KING_E8)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_KING_E1))))

                        || ((iteration == TWO)
                        && (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0130)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1030))
                        && ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_RANGE_START
                        && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_RANGE_END)))))

                        || ((iteration == TWO)
                        && (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0430)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0730))
                        && ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_RANGE_START
                        && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_RANGE_END)))))

                        || (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0130)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0430)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0730)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1030))
                        && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_BISHOP_C8)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_BISHOP_F8)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_BISHOP_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_BISHOP_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_QUEEN_D8)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_QUEEN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_QUEEN_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_FIGURE_TO_PROMOTION_A1_H1)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_BISHOP_C1)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_BISHOP_F1)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_BISHOP_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_BISHOP_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_QUEEN_D1)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_QUEEN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_QUEEN_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_FIGURE_TO_PROMOTION_A8_H8)))

                        || (((movementVector == FIGURE_MOVEMENT_VECTOR_TO_0300)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0600)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_0900)
                        || (movementVector == FIGURE_MOVEMENT_VECTOR_TO_1200))
                        && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_ROOK_A8)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_ROOK_H8)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_ROOK_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_ROOK_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_QUEEN_D8)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_PAWN_QUEEN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_PAWN_QUEEN_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_FIGURE_TO_PROMOTION_A1_H1)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_ROOK_A1)
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_ROOK_H1)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_ROOK_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_ROOK_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_QUEEN_D1)
                        || ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_PAWN_QUEEN_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_PAWN_QUEEN_RANGE_END))
                        || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_FIGURE_TO_PROMOTION_A8_H8)))
                ) {
                    temporaryShah = TRUE;
                }
                break;
            }
        }
    }

    static void shah(int k, int checkingCellForShah) {
        cellUnderAttack = FALSE;
        shah = FALSE;
        temporaryShah = FALSE;

        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0100);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0130);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0200);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0300);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0400);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0430);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0500);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0600);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0700);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0730);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0800);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_0900);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_1000);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_1030);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_1100);
        temporaryShah(k, FIGURE_MOVEMENT_VECTOR_TO_1200);

        if (temporaryShah == TRUE) {
            if (checkingCellForShah == FALSE) {
                shah = TRUE;
            } else if (checkingCellForShah == TRUE) {
                cellUnderAttack = TRUE;
            } else if ((checkingCellForShah == TWO) && (chessBoard[k][CHESSBOARD_LAYER_1] == BLACK_KING_E8)) {
                shahToTheBlackKing = TRUE;
            } else if ((checkingCellForShah == TWO) && (chessBoard[k][CHESSBOARD_LAYER_1] == WHITE_KING_E1)) {
                shahToTheWhiteKing = TRUE;
            }
        }
    }
}