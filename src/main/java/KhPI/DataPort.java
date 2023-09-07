package KhPI;

import static KhPI.GlobalConstant.*;

public class DataPort {
    private static final int CHESSBOARD_NUMBER_OF_CELLS = 144;
    private static final int CHESSBOARD_NUMBER_OF_LAYERS = 8;

    /* GLOBAL ARRAYS */
    protected static int[][] chessBoard = new int[CHESSBOARD_NUMBER_OF_CELLS][CHESSBOARD_NUMBER_OF_LAYERS];
    protected static int[][] listOfLegalMoves = new int[NUMBER_OF_FIGURES][NUMBER_OF_LEGAL_MOVES];

    /* GLOBAL VARIABLES */
    protected static int activeFigureName;
    protected static int alliedFiguresRangeEnd;
    protected static int alliedFiguresRangeStart;
    protected static int blackMove;
    protected static int callingThePlayerToMakeTheMove;
    protected static int capture;
    protected static int cellUnderAttack;
    protected static int checkmateToTheBlackKing;
    protected static int checkmateToTheWhiteKing;
    protected static int endOfTheGame;
    protected static int enemyFiguresRangeEnd;
    protected static int enemyFiguresRangeStart;
    protected static int enPassantCaptureProcess;
    protected static int figureInPromotionProcess;
    protected static String figureNameAfterPromotionTypeStringAfterTrim;
    protected static int finalPositionOfTheFigure;
    protected static int legalMove;
    protected static int moveCountBeforeGameEnd;
    protected static double movementCounter;
    protected static int promotionProcessMarking;
    protected static int shah;
    protected static int shahToTheBlackKing;
    protected static int shahToTheWhiteKing;
    protected static int sleepTimeBetweenMove;
    protected static int stalemateToTheBlackPlayer;
    protected static int stalemateToTheWhitePlayer;
    protected static int startingPositionOfTheFigure;
    protected static int startTheNewGame;
    protected static int targetKing;
    protected static int whiteMove;


    /* variable for GUI (can be changed in Setup) */
    protected static int blackFigureStyle;
    protected static int displayingAStalemateForTheBlackPlayer;
    protected static int displayingAStalemateForTheWhitePlayer;
    protected static int greyStyle;
    protected static int matrixStyle;
    protected static int playingFieldDisplay;
    protected static String playsBlackPieces;
    protected static String playsWhitePieces;
    protected static int spaceControlledByTheBlackPlayer;
    protected static int spaceControlledByTheWhitePlayer;
    protected static int whiteFigureStyle;
}