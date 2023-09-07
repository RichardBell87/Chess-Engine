package KhPI;

import static KhPI.CellSecurityCheck.shah;
import static KhPI.DataPort.capture;
import static KhPI.DataPort.cellUnderAttack;
import static KhPI.DataPort.chessBoard;
import static KhPI.DataPort.figureInPromotionProcess;
import static KhPI.DataPort.legalMove;
import static KhPI.DataPort.listOfLegalMoves;
import static KhPI.DataPort.shah;
import static KhPI.GameProcess.checkKingForShah;
import static KhPI.GameProcess.clearListOfLegalMoves;
import static KhPI.GlobalConstant.*;
import static KhPI.GUI.printThePlayingField;
import static KhPI.GUI.promotionMessage;
import static KhPI.Input.promotionChoice;
import static KhPI.LegalMovesList.createTheListOfPossibleMoves;

public class CellOverwrite {
    private static int castling;
    private static int castlingCheck;
    private static int castlingIndexRookTemporary;
    private static int chessBoardIndexRookStartLayer1;
    private static int chessBoardIndexRookStartLayer2;
    private static int enPassant;
    private static int promotion;
    private static int rookCellTemporary;

    static void enPassantSet(int arrayIndexStart, int arrayIndexFinal) {
        if ((arrayIndexFinal - arrayIndexStart == FIGURE_MOVEMENT_VECTOR_TO_1800)
                || (arrayIndexFinal - arrayIndexStart == FIGURE_MOVEMENT_VECTOR_TO_2400)) {
            enPassant = TRUE;
        }
    }

    static void enPassantCapture(int arrayIndexFinal, int temporary, int shift) {
        if ((chessBoard[arrayIndexFinal + shift][CHESSBOARD_LAYER_2] == EN_PASSANT) && (temporary != TRUE)) {
            listOfLegalMoves[(chessBoard[arrayIndexFinal + shift][CHESSBOARD_LAYER_1])][FALSE] = FALSE;
            chessBoard[arrayIndexFinal + shift][CHESSBOARD_LAYER_1] = FALSE;
            chessBoard[arrayIndexFinal + shift][CHESSBOARD_LAYER_2] = FALSE;
        }
    }

    static void promotion(int arrayIndexStart, int arrayIndexFinal, int alliedPawnRangeStart, int alliedPawnRangeEnd, int rowStart, int rowEnd, int figureNameAfterPromotion, int temporary, int chessBoardIndexStartCheckpointLayer1) {
        if ((chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] > alliedPawnRangeStart)
                && (chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] < alliedPawnRangeEnd)
                && (arrayIndexFinal > rowStart)
                && (arrayIndexFinal < rowEnd)) {
            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = figureNameAfterPromotion;
            (chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_3]) = FALSE;
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] = FALSE;
            if (temporary == FALSE) {
                clearListOfLegalMoves();
                createTheListOfPossibleMoves();

                checkKingForShah(BLACK_KING_E8);
                checkKingForShah(WHITE_KING_E1);

                figureInPromotionProcess = TRUE;
                printThePlayingField();
                promotionMessage();
                promotionChoice(chessBoardIndexStartCheckpointLayer1, arrayIndexFinal);
            }
            promotion = TRUE;
        }
    }

    static void castling(int arrayIndexStart, int castlingIndexRook, int figureMovementVector) {

        castlingCheck = FALSE;
        shah(arrayIndexStart, TRUE);

        if (cellUnderAttack == FALSE) {
            if (figureMovementVector == FIGURE_MOVEMENT_VECTOR_TO_1500) {
                shah((arrayIndexStart + SHIFT_BY_PLUS_1), TRUE);
            } else {
                shah((arrayIndexStart + SHIFT_BY_MINUS_1), TRUE);
            }

            if (cellUnderAttack == FALSE) {
                shah((arrayIndexStart + figureMovementVector), TRUE);

                if (cellUnderAttack == FALSE) {
                    castling = TRUE;
                    castlingCheck = TRUE;
                    castlingIndexRookTemporary = castlingIndexRook;
                    chessBoardIndexRookStartLayer1 = chessBoard[castlingIndexRook][CHESSBOARD_LAYER_1];
                    chessBoardIndexRookStartLayer2 = chessBoard[castlingIndexRook][CHESSBOARD_LAYER_2];

                    if (figureMovementVector == FIGURE_MOVEMENT_VECTOR_TO_1500) {
                        rookCellTemporary = (arrayIndexStart + SHIFT_BY_PLUS_1);
                    } else {
                        rookCellTemporary = (arrayIndexStart + SHIFT_BY_MINUS_1);
                    }

                    chessBoard[rookCellTemporary][CHESSBOARD_LAYER_1] = chessBoard[castlingIndexRook][CHESSBOARD_LAYER_1];
                    chessBoard[castlingIndexRook][CHESSBOARD_LAYER_1] = FALSE;
                    chessBoard[castlingIndexRook][CHESSBOARD_LAYER_2] = FALSE;
                }
            }
        }
    }

    static void legalMove(int targetKing, int temporary) {
        if (temporary == TRUE) {
            for (int k = ROW_8_START; k < ROW_1_END; k++) {
                if (chessBoard[k][CHESSBOARD_LAYER_1] == targetKing) {
                    shah(k, FALSE);
                }
            }
            if ((shah == FALSE) && (castlingCheck == TRUE)) {
                legalMove = TRUE;
            } else {
                legalMove = FALSE;
            }
        }
    }

    static void clearEnPassantList(int arrayIndexFinal, int temporary) {
        if (temporary == FALSE) {
            if ((chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START)
                    && (chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END)) {
                for (int i = ROW_4_START; i < ROW_4_END; i++) {
                    if ((chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START)
                            && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END)
                            && (chessBoard[i][CHESSBOARD_LAYER_2] == EN_PASSANT)) {
                        chessBoard[i][CHESSBOARD_LAYER_2] = FALSE;
                        break;
                    }
                }
            }

            if ((chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START)
                    && (chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END)) {
                for (int i = ROW_5_START; i < ROW_5_END; i++) {
                    if ((chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START)
                            && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END)
                            && (chessBoard[i][CHESSBOARD_LAYER_2] == EN_PASSANT)) {
                        chessBoard[i][CHESSBOARD_LAYER_2] = FALSE;
                        break;
                    }
                }
            }
        }
    }

    static void clearLayer(int chessboardLayer) {
        for (int i = ROW_8_START; i < ROW_1_END; i++) {
            chessBoard[i][chessboardLayer] = FALSE;
        }
    }

    static void overwrite(int arrayIndexStart, int arrayIndexFinal, int temporary, int targetKing) {

        int chessBoardIndexStartCheckpointLayer1 = chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1];
        int chessBoardIndexStartCheckpointLayer2 = chessBoard[arrayIndexStart][CHESSBOARD_LAYER_2];
        int chessBoardIndexStartCheckpointLayer3 = chessBoard[arrayIndexStart][CHESSBOARD_LAYER_3];

        int chessBoardIndexFinalCheckpointLayer1 = chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1];
        int chessBoardIndexFinalCheckpointLayer2 = chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_2];
        int chessBoardIndexFinalCheckpointLayer3 = chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_3];

        enPassantSet(arrayIndexStart, arrayIndexFinal);
        enPassantCapture(arrayIndexFinal, temporary, SHIFT_BY_MINUS_12);
        enPassantCapture(arrayIndexFinal, temporary, SHIFT_BY_PLUS_12);

        promotion(arrayIndexStart, arrayIndexFinal, BLACK_ALLIED_PAWN_RANGE_START, BLACK_ALLIED_PAWN_RANGE_END, ROW_1_START, ROW_1_END, BLACK_FIGURE_TO_PROMOTION_A1_H1, temporary, chessBoardIndexStartCheckpointLayer1);
        promotion(arrayIndexStart, arrayIndexFinal, WHITE_ALLIED_PAWN_RANGE_START, WHITE_ALLIED_PAWN_RANGE_END, ROW_8_START, ROW_8_END, WHITE_FIGURE_TO_PROMOTION_A8_H8, temporary, chessBoardIndexStartCheckpointLayer1);

        castlingCheck = TRUE;
        if ((chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] == BLACK_KING_E8)
                && ((arrayIndexFinal - arrayIndexStart) == FIGURE_MOVEMENT_VECTOR_TO_1500)) {
            castling(arrayIndexStart, CHESS_BOARD_INDEX_H8, FIGURE_MOVEMENT_VECTOR_TO_1500);
        }
        if ((chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] == BLACK_KING_E8)
                && ((arrayIndexFinal - arrayIndexStart) == FIGURE_MOVEMENT_VECTOR_TO_2100)) {
            castling(arrayIndexStart, CHESS_BOARD_INDEX_A8, FIGURE_MOVEMENT_VECTOR_TO_2100);
        }
        if ((chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] == WHITE_KING_E1)
                && ((arrayIndexFinal - arrayIndexStart) == FIGURE_MOVEMENT_VECTOR_TO_1500)) {
            castling(arrayIndexStart, CHESS_BOARD_INDEX_H1, FIGURE_MOVEMENT_VECTOR_TO_1500);
        }
        if ((chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] == WHITE_KING_E1)
                && ((arrayIndexFinal - arrayIndexStart) == FIGURE_MOVEMENT_VECTOR_TO_2100)) {
            castling(arrayIndexStart, CHESS_BOARD_INDEX_A1, FIGURE_MOVEMENT_VECTOR_TO_2100);
        }


        if ((temporary == FALSE) && (chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] != FALSE)) {
            capture = TRUE;
        } else if (temporary == FALSE) {
            capture = FALSE;
        }

        if (arrayIndexFinal != arrayIndexStart) {
            if (promotion == FALSE) {
                chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1];
            }
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] = FALSE;
        }

        if (castling == TRUE) {
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_2] = FALSE;
            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_2] = FALSE;
        } else if (enPassant == TRUE) {
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_2] = FALSE;
            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_2] = EN_PASSANT;
        } else {
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_2] = FALSE;
            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_2] = FALSE;
        }

        if (promotion == TRUE) {
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_3] = FALSE;
            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_3] = FALSE;
        } else {
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_3] = FALSE;
            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_3] = chessBoard[arrayIndexStart][CHESSBOARD_LAYER_3];
        }

        if(temporary == TRUE){
            legalMove(targetKing, temporary);
        } else {
            legalMove = TRUE;
        }

        /* cancel change */
        if ((legalMove == FALSE) || (temporary == TRUE)) {
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_1] = chessBoardIndexStartCheckpointLayer1;
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_2] = chessBoardIndexStartCheckpointLayer2;
            chessBoard[arrayIndexStart][CHESSBOARD_LAYER_3] = chessBoardIndexStartCheckpointLayer3;

            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = chessBoardIndexFinalCheckpointLayer1;
            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_2] = chessBoardIndexFinalCheckpointLayer2;
            chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_3] = chessBoardIndexFinalCheckpointLayer3;

            if (castling == TRUE) {
                chessBoard[castlingIndexRookTemporary][CHESSBOARD_LAYER_1] = chessBoardIndexRookStartLayer1;
                chessBoard[castlingIndexRookTemporary][CHESSBOARD_LAYER_2] = chessBoardIndexRookStartLayer2;

                chessBoard[rookCellTemporary][CHESSBOARD_LAYER_1] = FALSE;
            }
        }

        if (enPassant == TRUE) {
            enPassant = FALSE;
        }

        if (castling == TRUE) {
            castling = FALSE;
            rookCellTemporary = FALSE;
            castlingIndexRookTemporary = FALSE;
            chessBoardIndexRookStartLayer1 = FALSE;
            chessBoardIndexRookStartLayer2 = FALSE;
        }

        if (promotion == TRUE) {
            promotion = FALSE;
        }

        clearEnPassantList(arrayIndexFinal, temporary);
    }
}