package KhPI;

import static KhPI.DataPort.blackMove;
import static KhPI.DataPort.whiteMove;
import static KhPI.GlobalConstant.*;

public class GameInitialization {
    private static final int SHIFT_BY_PLUS_33 = 33;

    static void currentMove() {
        blackMove = FALSE;
        whiteMove = TRUE;
    }

    private static int cellNameA8 = TRUE;//cells on the chessboard begin to be numbered from 1 in total 64 cells.
    private static int figureNameInCellFromA8ToH1 = BLACK_ROOK_A8;//pieces on a chessboard are numbered from 1 to 98.

    static void createThePlayingField(int[][] chessBoard) {
        currentMove();

        for (int i = FALSE; i < chessBoard.length; i++) {
            if (((i > ROW_8_START) && (i < ROW_8_END))
                    || ((i > ROW_7_START) && (i < ROW_7_END))
                    || ((i > ROW_6_START) && (i < ROW_6_END))
                    || ((i > ROW_5_START) && (i < ROW_5_END))
                    || ((i > ROW_4_START) && (i < ROW_4_END))
                    || ((i > ROW_3_START) && (i < ROW_3_END))
                    || ((i > ROW_2_START) && (i < ROW_2_END))
                    || ((i > ROW_1_START) && (i < ROW_1_END))) {
                chessBoard[i][CHESSBOARD_LAYER_0] = cellNameA8;
                cellNameA8++;

                if ((i < ROW_7_END) || (i > ROW_2_START)) {

                    if ((i == CHESS_BOARD_INDEX_A8)
                            || (i == CHESS_BOARD_INDEX_E8)
                            || (i == CHESS_BOARD_INDEX_H8)
                            || (i == CHESS_BOARD_INDEX_A1)
                            || (i == CHESS_BOARD_INDEX_E1)
                            || (i == CHESS_BOARD_INDEX_H1)) {
                        chessBoard[i][CHESSBOARD_LAYER_2] = TRUE;
                    }

                    if (((i > ROW_7_START) && (i < ROW_7_END)) || ((i > ROW_2_START) && (i < ROW_2_END))) {
                        chessBoard[i][CHESSBOARD_LAYER_2] = TRUE;
                        chessBoard[i][CHESSBOARD_LAYER_3] = TRUE;
                    }

                    if (figureNameInCellFromA8ToH1 == BLACK_FIGURE_TO_PROMOTION_A1_H1) {
                        figureNameInCellFromA8ToH1 += SHIFT_BY_PLUS_33;
                    }
                    chessBoard[i][CHESSBOARD_LAYER_1] = figureNameInCellFromA8ToH1++;
                }
            }
        }
    }
}