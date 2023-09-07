package KhPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static KhPI.DataPort.activeFigureName;
import static KhPI.DataPort.blackFigureStyle;
import static KhPI.DataPort.blackMove;
import static KhPI.DataPort.capture;
import static KhPI.DataPort.checkmateToTheBlackKing;
import static KhPI.DataPort.checkmateToTheWhiteKing;
import static KhPI.DataPort.chessBoard;
import static KhPI.DataPort.displayingAStalemateForTheBlackPlayer;
import static KhPI.DataPort.displayingAStalemateForTheWhitePlayer;
import static KhPI.DataPort.enPassantCaptureProcess;
import static KhPI.DataPort.figureInPromotionProcess;
import static KhPI.DataPort.figureNameAfterPromotionTypeStringAfterTrim;
import static KhPI.DataPort.finalPositionOfTheFigure;
import static KhPI.DataPort.greyStyle;
import static KhPI.DataPort.matrixStyle;
import static KhPI.DataPort.moveCountBeforeGameEnd;
import static KhPI.DataPort.movementCounter;
import static KhPI.DataPort.playingFieldDisplay;
import static KhPI.DataPort.playsBlackPieces;
import static KhPI.DataPort.playsWhitePieces;
import static KhPI.DataPort.promotionProcessMarking;
import static KhPI.DataPort.shahToTheBlackKing;
import static KhPI.DataPort.shahToTheWhiteKing;
import static KhPI.DataPort.spaceControlledByTheBlackPlayer;
import static KhPI.DataPort.spaceControlledByTheWhitePlayer;
import static KhPI.DataPort.stalemateToTheBlackPlayer;
import static KhPI.DataPort.stalemateToTheWhitePlayer;
import static KhPI.DataPort.startingPositionOfTheFigure;
import static KhPI.DataPort.whiteFigureStyle;
import static KhPI.DataPort.whiteMove;
import static KhPI.GlobalConstant.*;

public class GUI {
    private static final String ANNOTATION_ADDITIONAL_INFORMATION = "additional information";
    private static final String ANNOTATION_CHANGE_SETTINGS = "If you want to change the default settings";
    private static final String ANNOTATION_CHANGES_APPLIED_SUCCESSFULLY = "Changes applied successfully";
    private static final String ANNOTATION_COLOR_SCHEMA_TO_GREY_STYLE = "color schema to 'Grey style'";
    private static final String ANNOTATION_COLOR_SCHEMA_TO_MATRIX_STYLE = "color schema to 'Matrix style'";
    private static final String ANNOTATION_COLOR_SCHEME = "color scheme";
    private static final String ANNOTATION_CURRENT_PLAYER_BLACK = "Black";
    private static final String ANNOTATION_CURRENT_PLAYER_WHITE = "White";
    private static final String ANNOTATION_DATETIME_FORMATTER = "dd/MM/yyyy HH:mm";
    private static final String ANNOTATION_DEFAULT_SETTINGS = "If you want to continue with the default settings";
    private static final String ANNOTATION_EN_PASSANT_CAPTURE_MARK = "e.p.";
    private static final String ANNOTATION_ESCAPE = "Escape";
    private static final String ANNOTATION_EXIT_THE_MENU = "exit the menu";
    private static final String ANNOTATION_FAQ = "FAQ";
    private static final String ANNOTATION_GAME_DATE = "Game date";
    private static final String ANNOTATION_GROUP_NAME = "КН-220а.е.";
    private static final String ANNOTATION_HIDE_THE_HINTS_FOR_BLACK_FIGURES = "hide the hints for black figures";
    private static final String ANNOTATION_HIDE_THE_HINTS_FOR_WHITE_FIGURES = "hide the hints for white figures";
    private static final String ANNOTATION_IF_YOU_WANT = "If you want";
    private static final String ANNOTATION_IF_YOU_WANT_DISPLAY = "If you want display";
    private static final String ANNOTATION_IF_YOU_WANT_RETURN_TO = "If you want return to";
    private static final String ANNOTATION_IF_YOU_WANT_TO = "If you want to";
    private static final String ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE = "If you want to change the";
    private static final String ANNOTATION_KEY = "key";
    private static final String ANNOTATION_KEY_ENTER = "Enter";
    private static final String ANNOTATION_MAKE_MOVE = "make your move";
    private static final String ANNOTATION_MEANS_BISHOP = "means Bishop";
    private static final String ANNOTATION_MEANS_KNIGHT = "means Knight";
    private static final String ANNOTATION_MEANS_QUEEN = "means Queen";
    private static final String ANNOTATION_MEANS_ROOK = "means Rook";
    private static final String ANNOTATION_MOVE_NUMBER = "Move number";
    private static final String ANNOTATION_NAME_OF_A_PLAYERS = "Name of a players";
    private static final String ANNOTATION_NAME_OF_THE_PLAYER_PLAYING_BLACK_PIECES = "Name of the player playing black pieces";
    private static final String ANNOTATION_NAME_OF_THE_PLAYER_PLAYING_WHITE_PIECES = "Name of the player playing white pieces";
    private static final String ANNOTATION_NEW_PLAYER_NAME = " new player Name";
    private static final String ANNOTATION_NICKNAME = "@RB87";
    private static final String ANNOTATION_NO = "No";
    private static final String ANNOTATION_PLAYS_BLACK_PIECES = "plays black pieces";
    private static final String ANNOTATION_PLAYS_WHITE_PIECES = "plays white pieces";
    private static final String ANNOTATION_please = "please";
    private static final String ANNOTATION_Please = "Please";
    private static final String ANNOTATION_PREVIOUS_MENU = "previous menu";
    private static final String ANNOTATION_PROMOTION_MESSAGE_END = "Bishop, Knight, Queen or Rook";
    private static final String ANNOTATION_PROMOTION_MESSAGE_MIDDLE = "case insensitive)";
    private static final String ANNOTATION_PROMOTION_MESSAGE_REPEAT = "repeat your choice using the letters";
    private static final String ANNOTATION_PROMOTION_MESSAGE_START = "Exchange of your choice (use the keys";
    private static final String ANNOTATION_PUSH = "and push the";
    private static final String ANNOTATION_REPEAT_MOVE = "repeat your input with valid data";
    private static final String ANNOTATION_RETURN = "Return";
    private static final String ANNOTATION_SETTINGS_MENU = "Welcome to the settings menu";
    private static final String ANNOTATION_SHOW_THE_HINTS_FOR_BLACK_FIGURES = "show the hints for black figures";
    private static final String ANNOTATION_SHOW_THE_HINTS_FOR_WHITE_FIGURES = "show the hints for white figures";
    private static final String ANNOTATION_STYLE_BLACK_FIGURES_TO_BOLD = "style black figures to 'Bold'";
    private static final String ANNOTATION_STYLE_BLACK_FIGURES_TO_ITALIC = "style black figures to 'Italic'";
    private static final String ANNOTATION_STYLE_OF_CHESS_FIGURES = "style of chess figures";
    private static final String ANNOTATION_STYLE_WHITE_FIGURES_TO_BOLD = "style white figures to 'Bold'";
    private static final String ANNOTATION_STYLE_WHITE_FIGURES_TO_ITALIC = "style white figures to 'Italic'";
    private static final String ANNOTATION_SYMBOL_COLON = ":";
    private static final String ANNOTATION_SYMBOL_COMMA = ",";
    private static final String ANNOTATION_SYMBOL_DASH = "-";
    private static final String ANNOTATION_SYMBOL_DOT = ".";
    private static final String ANNOTATION_SYMBOL_EQUALS = "=";
    private static final String ANNOTATION_SYMBOL_FOUR = "4";
    private static final String ANNOTATION_SYMBOL_HALF = "½";
    private static final String ANNOTATION_SYMBOL_HIDDEN = "\u3000";
    private static final String ANNOTATION_SYMBOL_MULTIPLY = "x";
    private static final String ANNOTATION_SYMBOL_NEW_LINE = "\n";
    private static final String ANNOTATION_SYMBOL_NUMBER_SIGN = "#";
    private static final String ANNOTATION_SYMBOL_ONE = "1";
    private static final String ANNOTATION_SYMBOL_PLUS = "+";
    private static final String ANNOTATION_SYMBOL_QUESTION = "？";
    private static final String ANNOTATION_SYMBOL_SEMICOLON = ";";
    private static final String ANNOTATION_SYMBOL_SPACE = " ";
    private static final String ANNOTATION_SYMBOL_THREE = "3";
    private static final String ANNOTATION_SYMBOL_TWO = "2";
    private static final String ANNOTATION_SYMBOL_ZERO = "0";
    private static final String ANNOTATION_THE = "the";
    private static final String ANNOTATION_THE_LETTER = "the letter";
    private static final String ANNOTATION_UNIVERSITY_NAME = "KhPI";
    private static final String ANNOTATION_VERSION = "v0.51";
    private static final String ANNOTATION_WIKI_LINK = "en.wikipedia.org/wiki/Chess";
    private static final String ANNOTATION_WRITE = "write";
    private static final String ANNOTATION_YES = "Yes";
    private static final String SERVICE_SYMBOL_1 = "１";
    private static final String SERVICE_SYMBOL_2 = "２";
    private static final String SERVICE_SYMBOL_3 = "３";
    private static final String SERVICE_SYMBOL_4 = "４";
    private static final String SERVICE_SYMBOL_5 = "５";
    private static final String SERVICE_SYMBOL_6 = "６";
    private static final String SERVICE_SYMBOL_7 = "７";
    private static final String SERVICE_SYMBOL_8 = "８";
    private static final String SERVICE_SYMBOL_a = "ａ";
    private static final String SERVICE_SYMBOL_b = "ｂ";
    private static final String SERVICE_SYMBOL_BLACK_BISHOP = "♝";
    private static final String SERVICE_SYMBOL_BLACK_KING = "♚";
    private static final String SERVICE_SYMBOL_BLACK_KNIGHT = "♞";
    private static final String SERVICE_SYMBOL_BLACK_PAWN = "♟";
    private static final String SERVICE_SYMBOL_BLACK_QUEEN = "♛";
    private static final String SERVICE_SYMBOL_BLACK_ROOK = "♜";
    private static final String SERVICE_SYMBOL_c = "ｃ";
    private static final String SERVICE_SYMBOL_d = "ｄ";
    private static final String SERVICE_SYMBOL_e = "ｅ";
    private static final String SERVICE_SYMBOL_f = "ｆ";
    private static final String SERVICE_SYMBOL_g = "ｇ";
    private static final String SERVICE_SYMBOL_h = "ｈ";
    private static final String SERVICE_SYMBOL_WHITE_BISHOP = "♗";
    private static final String SERVICE_SYMBOL_WHITE_KING = "♔";
    private static final String SERVICE_SYMBOL_WHITE_KNIGHT = "♘";
    private static final String SERVICE_SYMBOL_WHITE_PAWN = "♙";
    private static final String SERVICE_SYMBOL_WHITE_QUEEN = "♕";
    private static final String SERVICE_SYMBOL_WHITE_ROOK = "♖";
    private static final String SERVICE_SYMBOL_x = "ｘ";
    private static final String BACKGROUND_COLOR_GREY_COLOR_SCHEME_RGB244 = "\u001b[48;5;244m";
    private static final String BACKGROUND_COLOR_GREY_COLOR_SCHEME_RGB249 = "\u001b[48;5;249m";
    private static final String BACKGROUND_COLOR_GREY_COLOR_SCHEME_RGB255 = "\u001b[48;5;255m";
    private static final String BACKGROUND_COLOR_GREY_COLOR_SCHEME_RGB75 = "\u001b[48;5;75m";
    private static final String BACKGROUND_COLOR_MATRIX_COLOR_SCHEME_DARK_GREEN = "\u001b[48;2;0;59;0m";
    private static final String BACKGROUND_COLOR_MATRIX_COLOR_SCHEME_ISLAMIC_GREEN = "\u001b[48;2;0;143;17m";
    private static final String BACKGROUND_COLOR_MATRIX_COLOR_SCHEME_MALACHITE = "\u001b[48;2;0;255;65m";
    private static final String BACKGROUND_COLOR_MATRIX_COLOR_SCHEME_VAMPIRE_BLACK = "\u001b[48;2;13;2;8m";
    private static final String BACKGROUND_COLOR_TRANSPARENT = "\u001b[48m";
    private static final String TEXT_COLOR_GREY_COLOR_SCHEME_RGB231 = "\u001b[38;5;231m";
    private static final String TEXT_COLOR_GREY_COLOR_SCHEME_RGB232 = "\u001b[38;5;232m";
    private static final String TEXT_COLOR_GREY_COLOR_SCHEME_RGB26 = "\u001b[38;5;26m";
    private static final String TEXT_COLOR_GREY_COLOR_SCHEME_RGB75 = "\u001b[38;5;75m";
    private static final String TEXT_COLOR_GREY_COLOR_SCHEME_RGB94 = "\u001b[38;5;94m";
    private static final String TEXT_COLOR_GREY_COLOR_SCHEME_RGB160 = "\u001b[38;5;160m";
    private static final String TEXT_COLOR_MATRIX_ISLAMIC_COLOR_SCHEME_GREEN = "\u001b[38;2;0;143;17m";
    private static final String TEXT_COLOR_MATRIX_COLOR_SCHEME_MALACHITE = "\u001b[38;2;0;255;65m";
    private static final String TEXT_COLOR_MATRIX_COLOR_SCHEME_VAMPIRE_BLACK = "\u001b[38;2;13;2;8m";
    private static final String TEXT_COLOR_TRANSPARENT = "\u001b[38m";
    private static final String COLOR_RESET = "\033[0m";
    private static String annotationTextAuxiliaryColor;
    private static String annotationTextAuxiliaryDangerColor;
    private static String annotationTextMainColor;
    private static String blackBishopAvatar;
    private static String blackKingAvatar;
    private static String blackKnightAvatar;
    private static String blackPawnAvatar;
    private static String blackQueenAvatar;
    private static String blackRookAvatar;
    private static String blackServiceBackgroundColor;
    private static String blackServiceTextColor;
    private static String captureMark;
    private static String castlingMark;
    private static String cellBackgroundColor;
    private static String cellNameTypeString;
    private static String cellText;
    private static String cellTextColor;
    private static String checkmateMark;
    private static String chessboardBackgroundColorBlack;
    private static String chessboardBackgroundColorWhite;
    private static String chessboardEdgeBackgroundColor;
    private static String chessboardEdgeTextColor;
    private static String currentPlayer;
    private static String endOfTheGameMark;
    private static String enPassantCaptureMark;
    private static int i;
    private static String figureName;
    private static String finalCellNameTypeString;
    private static String nextPlayer;
    private static int moveNumber;
    private static String promotionMark;
    private static String promotionMarkFigureName;
    private static String service_color;
    private static String serviceSymbolQuestionAvatar;
    private static String shahMark;
    private static int shahShow;
    private static String startCellNameTypeString;
    private static String whiteBishopAvatar;
    private static String whiteKingAvatar;
    private static String whiteKnightAvatar;
    private static String whitePawnAvatar;
    private static String whiteQueenAvatar;
    private static String whiteRookAvatar;
    private static String whiteServiceBackgroundColor;
    private static String whiteServiceTextColor;

    static void colorStyleArray(int greyStyle, int matrixStyle) {
        if (greyStyle == TRUE) {
            chessboardEdgeTextColor = TEXT_COLOR_GREY_COLOR_SCHEME_RGB94;
            chessboardBackgroundColorBlack = BACKGROUND_COLOR_GREY_COLOR_SCHEME_RGB249;
            chessboardBackgroundColorWhite = BACKGROUND_COLOR_GREY_COLOR_SCHEME_RGB255;
            blackServiceBackgroundColor = BACKGROUND_COLOR_GREY_COLOR_SCHEME_RGB244;
            whiteServiceBackgroundColor = BACKGROUND_COLOR_GREY_COLOR_SCHEME_RGB75;
            blackServiceTextColor = TEXT_COLOR_GREY_COLOR_SCHEME_RGB232;
            whiteServiceTextColor = TEXT_COLOR_GREY_COLOR_SCHEME_RGB26;
            service_color = TEXT_COLOR_GREY_COLOR_SCHEME_RGB231;

        } else if (matrixStyle == TRUE) {
            chessboardEdgeTextColor = TEXT_COLOR_MATRIX_ISLAMIC_COLOR_SCHEME_GREEN;
            chessboardBackgroundColorBlack = BACKGROUND_COLOR_MATRIX_COLOR_SCHEME_DARK_GREEN;
            chessboardBackgroundColorWhite = BACKGROUND_COLOR_MATRIX_COLOR_SCHEME_ISLAMIC_GREEN;
            blackServiceBackgroundColor = BACKGROUND_COLOR_MATRIX_COLOR_SCHEME_VAMPIRE_BLACK;
            whiteServiceBackgroundColor = BACKGROUND_COLOR_MATRIX_COLOR_SCHEME_MALACHITE;
            blackServiceTextColor = TEXT_COLOR_MATRIX_COLOR_SCHEME_VAMPIRE_BLACK;
            whiteServiceTextColor = TEXT_COLOR_MATRIX_COLOR_SCHEME_MALACHITE;
            service_color = TEXT_COLOR_MATRIX_ISLAMIC_COLOR_SCHEME_GREEN;
        }

        chessboardEdgeBackgroundColor = BACKGROUND_COLOR_TRANSPARENT;
        annotationTextMainColor = TEXT_COLOR_GREY_COLOR_SCHEME_RGB75;
        annotationTextAuxiliaryColor = TEXT_COLOR_GREY_COLOR_SCHEME_RGB94;
        annotationTextAuxiliaryDangerColor = TEXT_COLOR_GREY_COLOR_SCHEME_RGB160;
    }

    static void figureStyleArray(int blackFigureStyle, int whiteFigureStyle) {
        if (blackFigureStyle == FALSE) {
            blackRookAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_ROOK + ANNOTATION_SYMBOL_SPACE;
            blackKnightAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_KNIGHT + ANNOTATION_SYMBOL_SPACE;
            blackBishopAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_BISHOP + ANNOTATION_SYMBOL_SPACE;
            blackQueenAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_QUEEN + ANNOTATION_SYMBOL_SPACE;
            blackKingAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_KING + ANNOTATION_SYMBOL_SPACE;
            blackPawnAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_PAWN + ANNOTATION_SYMBOL_SPACE;

        } else if (blackFigureStyle == TRUE) {
            blackRookAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_ROOK + ANNOTATION_SYMBOL_SPACE;
            blackKnightAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_KNIGHT + ANNOTATION_SYMBOL_SPACE;
            blackBishopAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_BISHOP + ANNOTATION_SYMBOL_SPACE;
            blackQueenAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_QUEEN + ANNOTATION_SYMBOL_SPACE;
            blackKingAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_KING + ANNOTATION_SYMBOL_SPACE;
            blackPawnAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_PAWN + ANNOTATION_SYMBOL_SPACE;
        }

        if (whiteFigureStyle == FALSE) {
            whiteRookAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_ROOK + ANNOTATION_SYMBOL_SPACE;
            whiteKnightAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_KNIGHT + ANNOTATION_SYMBOL_SPACE;
            whiteBishopAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_BISHOP + ANNOTATION_SYMBOL_SPACE;
            whiteQueenAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_QUEEN + ANNOTATION_SYMBOL_SPACE;
            whiteKingAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_KING + ANNOTATION_SYMBOL_SPACE;
            whitePawnAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_BLACK_PAWN + ANNOTATION_SYMBOL_SPACE;

        } else if (whiteFigureStyle == TRUE) {
            whiteRookAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_ROOK + ANNOTATION_SYMBOL_SPACE;
            whiteKnightAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_KNIGHT + ANNOTATION_SYMBOL_SPACE;
            whiteBishopAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_BISHOP + ANNOTATION_SYMBOL_SPACE;
            whiteQueenAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_QUEEN + ANNOTATION_SYMBOL_SPACE;
            whiteKingAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_KING + ANNOTATION_SYMBOL_SPACE;
            whitePawnAvatar = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_WHITE_PAWN + ANNOTATION_SYMBOL_SPACE;
        }
        serviceSymbolQuestionAvatar = ANNOTATION_SYMBOL_SPACE + ANNOTATION_SYMBOL_QUESTION + ANNOTATION_SYMBOL_SPACE;
    }

    static void rowTopBottom() {
        figureStyleArray(blackFigureStyle, whiteFigureStyle);
        System.out.print(chessboardEdgeTextColor + chessboardEdgeBackgroundColor
                + ANNOTATION_SYMBOL_HIDDEN + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_a + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_b + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_c + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_d + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_e + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_f + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_g + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_h + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_HIDDEN + ANNOTATION_SYMBOL_SPACE
                + COLOR_RESET
                + ANNOTATION_SYMBOL_SPACE + ANNOTATION_SYMBOL_HIDDEN + ANNOTATION_SYMBOL_SPACE);
    }

    static void cellText(String cellTextAvatar, int figure1) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)
                && (chessBoard[i][CHESSBOARD_LAYER_1] == figure1)) {
            if ((cellTextAvatar.equals(ANNOTATION_SYMBOL_HIDDEN)) && (figure1 == FALSE)) {
                cellText = ANNOTATION_SYMBOL_SPACE + cellTextAvatar + ANNOTATION_SYMBOL_SPACE;
            } else {
                cellText = cellTextAvatar;
            }
        }
    }

    static void cellText(String cellTextAvatar) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)

                && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_FIGURE_TO_PROMOTION_A1_H1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_FIGURE_TO_PROMOTION_A8_H8))) {
            cellText = cellTextAvatar;
        }
    }

    static void cellText(String cellTextAvatar, int figure1, int alliedRangeStart, int alliedRangeEnd) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)
                && ((chessBoard[i][CHESSBOARD_LAYER_1] == figure1)

                || ((chessBoard[i][CHESSBOARD_LAYER_1] > alliedRangeStart)
                && (chessBoard[i][CHESSBOARD_LAYER_1] < alliedRangeEnd)))) {
            cellText = cellTextAvatar;
        }
    }

    static void cellText(String cellTextAvatar, int figure1, int figure2, int alliedRangeStart, int alliedRangeEnd) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)

                && (((chessBoard[i][CHESSBOARD_LAYER_1] == figure1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == figure2))

                || ((chessBoard[i][CHESSBOARD_LAYER_1] > alliedRangeStart)
                && (chessBoard[i][CHESSBOARD_LAYER_1] < alliedRangeEnd)))) {
            cellText = cellTextAvatar;
        }
    }

    static void cellText(int alliedPawnRangeStart, int alliedPawnRangeEnd, String cellTextAvatar) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)

                && ((chessBoard[i][CHESSBOARD_LAYER_1] > alliedPawnRangeStart)
                && (chessBoard[i][CHESSBOARD_LAYER_1] < alliedPawnRangeEnd))) {
            cellText = cellTextAvatar;
        }
    }

    static void cellTextAuxiliary(String cellTextAvatar, int figure1, int chessboardLayer) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)
                && (chessBoard[i][chessboardLayer] != FALSE)
                && (chessBoard[i][CHESSBOARD_LAYER_1] == figure1)) {
            cellText = cellTextAvatar;
        }
    }

    static void cellTextAuxiliary(String cellTextAvatar, int chessboardLayer) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)
                && (chessBoard[i][chessboardLayer] != FALSE)

                && ((chessBoard[i][CHESSBOARD_LAYER_1] == BLACK_FIGURE_TO_PROMOTION_A1_H1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == WHITE_FIGURE_TO_PROMOTION_A8_H8))) {
            cellText = cellTextAvatar;
        }
    }

    static void cellTextAuxiliary(String cellTextAvatar, int figure1, int alliedRangeStart, int alliedRangeEnd, int chessboardLayer) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) && (chessBoard[i][chessboardLayer] != FALSE)
                && ((chessBoard[i][CHESSBOARD_LAYER_1] == figure1)

                || ((chessBoard[i][CHESSBOARD_LAYER_1] > alliedRangeStart)
                && (chessBoard[i][CHESSBOARD_LAYER_1] < alliedRangeEnd)))) {
            cellText = cellTextAvatar;
        }
    }

    static void cellTextAuxiliary(String cellTextAvatar, int figure1, int figure2, int alliedRangeStart, int alliedRangeEnd, int chessboardLayer) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)
                && (chessBoard[i][chessboardLayer] != FALSE)

                && (((chessBoard[i][CHESSBOARD_LAYER_1] == figure1)
                || (chessBoard[i][CHESSBOARD_LAYER_1] == figure2))

                || ((chessBoard[i][CHESSBOARD_LAYER_1] > alliedRangeStart)
                && (chessBoard[i][CHESSBOARD_LAYER_1] < alliedRangeEnd)))) {
            cellText = cellTextAvatar;
        }
    }

    static void cellTextAuxiliary(int alliedPawnRangeStart, int alliedPawnRangeEnd, String cellTextAvatar, int chessboardLayer) {
        if (((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)
                && (chessBoard[i][chessboardLayer] != FALSE)
                && ((chessBoard[i][CHESSBOARD_LAYER_1] > alliedPawnRangeStart)
                && (chessBoard[i][CHESSBOARD_LAYER_1] < alliedPawnRangeEnd)))

                || ((chessBoard[i][CHESSBOARD_LAYER_2] == EN_PASSANT)
                && ((chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] < alliedPawnRangeStart)
                || (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] > alliedPawnRangeEnd))
                && (((chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START)
                && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END))
                || ((chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START)
                && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END))))

                || ((chessBoard[i][CHESSBOARD_LAYER_2] == EN_PASSANT)
                && ((chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] < alliedPawnRangeStart)
                || (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] > alliedPawnRangeEnd))
                && (((chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START)
                && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END))
                || ((chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START)
                && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END))))) {
            cellText = cellTextAvatar;
        }
    }

    static void rowName(String rowName, int figureMovementVector, int rowStart, int rowEnd, int space) {
        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE)
                && (chessBoard[i + figureMovementVector][CHESSBOARD_LAYER_0] == FALSE)
                && (i > rowStart) && (i < rowEnd)) {
            if (space == TRUE) {
                System.out.print(chessboardEdgeBackgroundColor
                        + chessboardEdgeTextColor
                        + ANNOTATION_SYMBOL_SPACE
                        + rowName
                        + COLOR_RESET
                        + ANNOTATION_SYMBOL_HIDDEN
                        + ANNOTATION_SYMBOL_SPACE
                        + ANNOTATION_SYMBOL_SPACE);
            } else {
                System.out.print(chessboardEdgeBackgroundColor
                        + chessboardEdgeTextColor
                        + rowName
                        + ANNOTATION_SYMBOL_SPACE
                        + COLOR_RESET);
            }
        }
    }

    static void settingsMenuStartMainMessage() {
        colorStyleArray(greyStyle, matrixStyle);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                + ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SETTINGS_MENU
                + ANNOTATION_SYMBOL_DOT
                + COLOR_RESET);
    }

    static void inputDataAnnotationRepeatMessage() {
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                + ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_Please
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_REPEAT_MOVE
                + ANNOTATION_SYMBOL_DOT
                + COLOR_RESET);
    }

    static void settingsMenuStartClueMessage() {
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
        phraseIfYouWant(ANNOTATION_CHANGE_SETTINGS, null);
        someKeyPhraseWithKeyEnter(ANNOTATION_YES, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
        phraseIfYouWant(ANNOTATION_DEFAULT_SETTINGS, null);
        someKeyPhraseWithKeyEnter(ANNOTATION_NO, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
    }

    static void phraseIfYouWant(String keyPhrasePartOne, String keyPhrasePartTwo) {
        System.out.print(ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextMainColor
                + keyPhrasePartOne);

        if (keyPhrasePartTwo != null) {
            System.out.print(ANNOTATION_SYMBOL_SPACE
                    + annotationTextAuxiliaryColor
                    + keyPhrasePartTwo
                    + annotationTextMainColor);
        }

        System.out.print(ANNOTATION_SYMBOL_COLON
                + COLOR_RESET);
    }

    static void someKeyPhraseWithKeyEnter(String keyPhrase, int mainSentence) {
        String article;
        String indent;
        String theWordPoliteness;
        if (mainSentence == TRUE) {
            theWordPoliteness = ANNOTATION_Please;
            article = ANNOTATION_THE;
            indent = ANNOTATION_SYMBOL_EMPTY;
        } else {
            theWordPoliteness = ANNOTATION_please;
            article = ANNOTATION_SYMBOL_EMPTY;
            indent = (ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_SYMBOL_SPACE);
        }

        System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                + ANNOTATION_SYMBOL_HIDDEN
                + indent
                + annotationTextMainColor
                + theWordPoliteness
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_WRITE
                + ANNOTATION_SYMBOL_SPACE
                + article
                + annotationTextAuxiliaryColor
                + keyPhrase
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_PUSH
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_KEY_ENTER
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_KEY
                + ANNOTATION_SYMBOL_DOT
                + COLOR_RESET);
    }

    static void possibleCustomizationMessage() {
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, ANNOTATION_NAME_OF_A_PLAYERS);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_ONE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, ANNOTATION_COLOR_SCHEME);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_TWO, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, ANNOTATION_STYLE_OF_CHESS_FIGURES);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_THREE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_DISPLAY, ANNOTATION_ADDITIONAL_INFORMATION);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_FOUR, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO, ANNOTATION_EXIT_THE_MENU);
        someKeyPhraseWithKeyEnter(ANNOTATION_ESCAPE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
    }

    static void twoPointMessage(String message_1_part_2, String message_2_part_2) {
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, message_1_part_2);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_ONE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, message_2_part_2);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_TWO, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_RETURN_TO, ANNOTATION_PREVIOUS_MENU);
        someKeyPhraseWithKeyEnter(ANNOTATION_RETURN, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO, ANNOTATION_EXIT_THE_MENU);
        someKeyPhraseWithKeyEnter(ANNOTATION_ESCAPE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
    }

    static void fourPointMessage(String message_1_part_1, String message_1_part_2, String message_2_part_1, String message_2_part_2, String message_3_part_1, String message_3_part_2, String message_4_part_1, String message_4_part_2) {
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
        phraseIfYouWant(message_1_part_1, message_1_part_2);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_ONE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(message_2_part_1, message_2_part_2);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_TWO, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(message_3_part_1, message_3_part_2);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_THREE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(message_4_part_1, message_4_part_2);
        someKeyPhraseWithKeyEnter(ANNOTATION_SYMBOL_FOUR, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_RETURN_TO, ANNOTATION_PREVIOUS_MENU);
        someKeyPhraseWithKeyEnter(ANNOTATION_RETURN, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);

        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO, ANNOTATION_EXIT_THE_MENU);
        someKeyPhraseWithKeyEnter(ANNOTATION_ESCAPE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
    }

    static void playerNameMessage(){
        twoPointMessage(ANNOTATION_NAME_OF_THE_PLAYER_PLAYING_WHITE_PIECES, ANNOTATION_NAME_OF_THE_PLAYER_PLAYING_BLACK_PIECES);
    }
    static void playerNewNameMessage(){
        someKeyPhraseWithKeyEnter(ANNOTATION_NEW_PLAYER_NAME, TRUE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_RETURN_TO, ANNOTATION_PREVIOUS_MENU);
        someKeyPhraseWithKeyEnter(ANNOTATION_RETURN, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
        phraseIfYouWant(ANNOTATION_IF_YOU_WANT_TO, ANNOTATION_EXIT_THE_MENU);
        someKeyPhraseWithKeyEnter(ANNOTATION_ESCAPE, FALSE);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
    }
    static void colorSchemaMessage(){
        twoPointMessage(ANNOTATION_COLOR_SCHEMA_TO_GREY_STYLE, ANNOTATION_COLOR_SCHEMA_TO_MATRIX_STYLE);
    }
    static void figureStyleMessage(){
        fourPointMessage(ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, ANNOTATION_STYLE_WHITE_FIGURES_TO_ITALIC, ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, ANNOTATION_STYLE_WHITE_FIGURES_TO_BOLD, ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, ANNOTATION_STYLE_BLACK_FIGURES_TO_ITALIC, ANNOTATION_IF_YOU_WANT_TO_CHANGE_THE, ANNOTATION_STYLE_BLACK_FIGURES_TO_BOLD);
    }

    static void additionalInfoMessage(){
        fourPointMessage(ANNOTATION_IF_YOU_WANT, ANNOTATION_SHOW_THE_HINTS_FOR_WHITE_FIGURES, ANNOTATION_IF_YOU_WANT, ANNOTATION_HIDE_THE_HINTS_FOR_WHITE_FIGURES, ANNOTATION_IF_YOU_WANT, ANNOTATION_SHOW_THE_HINTS_FOR_BLACK_FIGURES, ANNOTATION_IF_YOU_WANT, ANNOTATION_HIDE_THE_HINTS_FOR_BLACK_FIGURES);
    }

    static void successMessage() {
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                + ANNOTATION_SYMBOL_HIDDEN
                + annotationTextMainColor
                + ANNOTATION_CHANGES_APPLIED_SUCCESSFULLY
                + ANNOTATION_SYMBOL_DOT
                + COLOR_RESET);
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
    }

    static void moveNumber() {
        moveNumber = (int) Math.ceil(movementCounter);
    }

    static void dateTimeMessage(int moveNumber) {
        if (moveNumber == FALSE) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ANNOTATION_DATETIME_FORMATTER);
            LocalDateTime now = LocalDateTime.now();

            System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                    + ANNOTATION_SYMBOL_HIDDEN
                    + ANNOTATION_SYMBOL_SPACE
                    + annotationTextMainColor
                    + ANNOTATION_FAQ
                    + ANNOTATION_SYMBOL_COLON
                    + ANNOTATION_SYMBOL_SPACE
                    + annotationTextAuxiliaryColor
                    + ANNOTATION_WIKI_LINK
                    + COLOR_RESET);
            System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                    + ANNOTATION_SYMBOL_HIDDEN
                    + ANNOTATION_SYMBOL_SPACE
                    + annotationTextMainColor
                    + ANNOTATION_UNIVERSITY_NAME
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_GROUP_NAME
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_NICKNAME
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_VERSION
                    + ANNOTATION_SYMBOL_SEMICOLON
                    + COLOR_RESET);
            System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                    + annotationTextMainColor
                    + ANNOTATION_SYMBOL_HIDDEN
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_GAME_DATE
                    + ANNOTATION_SYMBOL_COLON
                    + ANNOTATION_SYMBOL_SPACE
                    + dtf.format(now)
                    + ANNOTATION_SYMBOL_SEMICOLON
                    + COLOR_RESET);
            System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                    + annotationTextMainColor
                    + ANNOTATION_SYMBOL_HIDDEN
                    + ANNOTATION_SYMBOL_SPACE
                    + annotationTextAuxiliaryColor
                    + playsWhitePieces
                    + annotationTextMainColor
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_SYMBOL_DASH
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_PLAYS_WHITE_PIECES
                    + ANNOTATION_SYMBOL_SEMICOLON
                    + COLOR_RESET);
            System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                    + annotationTextMainColor
                    + ANNOTATION_SYMBOL_HIDDEN
                    + ANNOTATION_SYMBOL_SPACE
                    + annotationTextAuxiliaryColor
                    + playsBlackPieces
                    + annotationTextMainColor
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_SYMBOL_DASH
                    + ANNOTATION_SYMBOL_SPACE
                    + ANNOTATION_PLAYS_BLACK_PIECES
                    + ANNOTATION_SYMBOL_SEMICOLON
                    + COLOR_RESET
                    + ANNOTATION_SYMBOL_NEW_LINE
                    + ANNOTATION_SYMBOL_NEW_LINE);
        }
    }

    static void currentPlayer() {
        if ((blackMove == FALSE) && (whiteMove == TRUE)) {
            currentPlayer = ANNOTATION_CURRENT_PLAYER_BLACK;
            nextPlayer = playsWhitePieces;

            if (figureInPromotionProcess == TRUE) {
                currentPlayer = ANNOTATION_CURRENT_PLAYER_WHITE;
            }
        } else {
            currentPlayer = ANNOTATION_CURRENT_PLAYER_WHITE;
            nextPlayer = playsBlackPieces;

            if (figureInPromotionProcess == TRUE) {
                currentPlayer = ANNOTATION_CURRENT_PLAYER_BLACK;
            }
        }
    }

    static void callingThePlayerToMakeTheMove() {
        currentPlayer();
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE
                + ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + nextPlayer
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COMMA
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_please
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_MAKE_MOVE
                + ANNOTATION_SYMBOL_COLON
                + COLOR_RESET);
    }

    static void repeatInputData() {
        System.out.print(ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + nextPlayer
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COMMA
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_please
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_REPEAT_MOVE
                + ANNOTATION_SYMBOL_COLON
                + COLOR_RESET);
    }

    static void figureName(int activeFigureName) {
        if ((activeFigureName == BLACK_ROOK_A8)
                || (activeFigureName == BLACK_ROOK_H8)

                || ((activeFigureName > BLACK_ALLIED_PAWN_ROOK_RANGE_START)
                && (activeFigureName < BLACK_ALLIED_PAWN_ROOK_RANGE_END))

                || (activeFigureName == WHITE_ROOK_A1)
                || (activeFigureName == WHITE_ROOK_H1)

                || ((activeFigureName > WHITE_ALLIED_PAWN_ROOK_RANGE_START)
                && (activeFigureName < WHITE_ALLIED_PAWN_ROOK_RANGE_END))) {
            figureName = ANNOTATION_SYMBOL_R;

        } else if ((activeFigureName == BLACK_KNIGHT_B8)
                || (activeFigureName == BLACK_KNIGHT_G8)

                || ((activeFigureName > BLACK_ALLIED_PAWN_KNIGHT_RANGE_START)
                && (activeFigureName < BLACK_ALLIED_PAWN_KNIGHT_RANGE_END))

                || (activeFigureName == WHITE_KNIGHT_B1)
                || (activeFigureName == WHITE_KNIGHT_G1)

                || ((activeFigureName > WHITE_ALLIED_PAWN_KNIGHT_RANGE_START)
                && (activeFigureName < WHITE_ALLIED_PAWN_KNIGHT_RANGE_END))) {
            figureName = ANNOTATION_SYMBOL_N;

        } else if ((activeFigureName == BLACK_BISHOP_C8)
                || (activeFigureName == BLACK_BISHOP_F8)

                || ((activeFigureName > BLACK_ALLIED_PAWN_BISHOP_RANGE_START)
                && (activeFigureName < BLACK_ALLIED_PAWN_BISHOP_RANGE_END))

                || (activeFigureName == WHITE_BISHOP_C1)
                || (activeFigureName == WHITE_BISHOP_F1)

                || ((activeFigureName > WHITE_ALLIED_PAWN_BISHOP_RANGE_START)
                && (activeFigureName < WHITE_ALLIED_PAWN_BISHOP_RANGE_END))) {
            figureName = ANNOTATION_SYMBOL_B;

        } else if ((activeFigureName == BLACK_QUEEN_D8)

                || ((activeFigureName > BLACK_ALLIED_PAWN_QUEEN_RANGE_START)
                && (activeFigureName < BLACK_ALLIED_PAWN_QUEEN_RANGE_END))

                || (activeFigureName == WHITE_QUEEN_D1)

                || ((activeFigureName > WHITE_ALLIED_PAWN_QUEEN_RANGE_START)
                && (activeFigureName < WHITE_ALLIED_PAWN_QUEEN_RANGE_END))) {
            figureName = ANNOTATION_SYMBOL_Q;

        } else if ((activeFigureName == BLACK_KING_E8)
                || (activeFigureName == WHITE_KING_E1)) {
            figureName = ANNOTATION_SYMBOL_K;

        } else {
            figureName = ANNOTATION_SYMBOL_EMPTY;
        }
    }

    static void cellName(int cellName, int returnDataName) {
        switch (cellName) {
            case (CHESS_BOARD_INDEX_A1) -> cellNameTypeString = A_1_LOWER_CASE;
            case (CHESS_BOARD_INDEX_B1) -> cellNameTypeString = B_1_LOWER_CASE;
            case (CHESS_BOARD_INDEX_C1) -> cellNameTypeString = C_1_LOWER_CASE;
            case (CHESS_BOARD_INDEX_D1) -> cellNameTypeString = D_1_LOWER_CASE;
            case (CHESS_BOARD_INDEX_E1) -> cellNameTypeString = E_1_LOWER_CASE;
            case (CHESS_BOARD_INDEX_F1) -> cellNameTypeString = F_1_LOWER_CASE;
            case (CHESS_BOARD_INDEX_G1) -> cellNameTypeString = G_1_LOWER_CASE;
            case (CHESS_BOARD_INDEX_H1) -> cellNameTypeString = H_1_LOWER_CASE;

            case (CHESS_BOARD_INDEX_A2) -> cellNameTypeString = A_2_LOWER_CASE;
            case (CHESS_BOARD_INDEX_B2) -> cellNameTypeString = B_2_LOWER_CASE;
            case (CHESS_BOARD_INDEX_C2) -> cellNameTypeString = C_2_LOWER_CASE;
            case (CHESS_BOARD_INDEX_D2) -> cellNameTypeString = D_2_LOWER_CASE;
            case (CHESS_BOARD_INDEX_E2) -> cellNameTypeString = E_2_LOWER_CASE;
            case (CHESS_BOARD_INDEX_F2) -> cellNameTypeString = F_2_LOWER_CASE;
            case (CHESS_BOARD_INDEX_G2) -> cellNameTypeString = G_2_LOWER_CASE;
            case (CHESS_BOARD_INDEX_H2) -> cellNameTypeString = H_2_LOWER_CASE;

            case (CHESS_BOARD_INDEX_A3) -> cellNameTypeString = A_3_LOWER_CASE;
            case (CHESS_BOARD_INDEX_B3) -> cellNameTypeString = B_3_LOWER_CASE;
            case (CHESS_BOARD_INDEX_C3) -> cellNameTypeString = C_3_LOWER_CASE;
            case (CHESS_BOARD_INDEX_D3) -> cellNameTypeString = D_3_LOWER_CASE;
            case (CHESS_BOARD_INDEX_E3) -> cellNameTypeString = E_3_LOWER_CASE;
            case (CHESS_BOARD_INDEX_F3) -> cellNameTypeString = F_3_LOWER_CASE;
            case (CHESS_BOARD_INDEX_G3) -> cellNameTypeString = G_3_LOWER_CASE;
            case (CHESS_BOARD_INDEX_H3) -> cellNameTypeString = H_3_LOWER_CASE;

            case (CHESS_BOARD_INDEX_A4) -> cellNameTypeString = A_4_LOWER_CASE;
            case (CHESS_BOARD_INDEX_B4) -> cellNameTypeString = B_4_LOWER_CASE;
            case (CHESS_BOARD_INDEX_C4) -> cellNameTypeString = C_4_LOWER_CASE;
            case (CHESS_BOARD_INDEX_D4) -> cellNameTypeString = D_4_LOWER_CASE;
            case (CHESS_BOARD_INDEX_E4) -> cellNameTypeString = E_4_LOWER_CASE;
            case (CHESS_BOARD_INDEX_F4) -> cellNameTypeString = F_4_LOWER_CASE;
            case (CHESS_BOARD_INDEX_G4) -> cellNameTypeString = G_4_LOWER_CASE;
            case (CHESS_BOARD_INDEX_H4) -> cellNameTypeString = H_4_LOWER_CASE;

            case (CHESS_BOARD_INDEX_A5) -> cellNameTypeString = A_5_LOWER_CASE;
            case (CHESS_BOARD_INDEX_B5) -> cellNameTypeString = B_5_LOWER_CASE;
            case (CHESS_BOARD_INDEX_C5) -> cellNameTypeString = C_5_LOWER_CASE;
            case (CHESS_BOARD_INDEX_D5) -> cellNameTypeString = D_5_LOWER_CASE;
            case (CHESS_BOARD_INDEX_E5) -> cellNameTypeString = E_5_LOWER_CASE;
            case (CHESS_BOARD_INDEX_F5) -> cellNameTypeString = F_5_LOWER_CASE;
            case (CHESS_BOARD_INDEX_G5) -> cellNameTypeString = G_5_LOWER_CASE;
            case (CHESS_BOARD_INDEX_H5) -> cellNameTypeString = H_5_LOWER_CASE;

            case (CHESS_BOARD_INDEX_A6) -> cellNameTypeString = A_6_LOWER_CASE;
            case (CHESS_BOARD_INDEX_B6) -> cellNameTypeString = B_6_LOWER_CASE;
            case (CHESS_BOARD_INDEX_C6) -> cellNameTypeString = C_6_LOWER_CASE;
            case (CHESS_BOARD_INDEX_D6) -> cellNameTypeString = D_6_LOWER_CASE;
            case (CHESS_BOARD_INDEX_E6) -> cellNameTypeString = E_6_LOWER_CASE;
            case (CHESS_BOARD_INDEX_F6) -> cellNameTypeString = F_6_LOWER_CASE;
            case (CHESS_BOARD_INDEX_G6) -> cellNameTypeString = G_6_LOWER_CASE;
            case (CHESS_BOARD_INDEX_H6) -> cellNameTypeString = H_6_LOWER_CASE;

            case (CHESS_BOARD_INDEX_A7) -> cellNameTypeString = A_7_LOWER_CASE;
            case (CHESS_BOARD_INDEX_B7) -> cellNameTypeString = B_7_LOWER_CASE;
            case (CHESS_BOARD_INDEX_C7) -> cellNameTypeString = C_7_LOWER_CASE;
            case (CHESS_BOARD_INDEX_D7) -> cellNameTypeString = D_7_LOWER_CASE;
            case (CHESS_BOARD_INDEX_E7) -> cellNameTypeString = E_7_LOWER_CASE;
            case (CHESS_BOARD_INDEX_F7) -> cellNameTypeString = F_7_LOWER_CASE;
            case (CHESS_BOARD_INDEX_G7) -> cellNameTypeString = G_7_LOWER_CASE;
            case (CHESS_BOARD_INDEX_H7) -> cellNameTypeString = H_7_LOWER_CASE;

            case (CHESS_BOARD_INDEX_A8) -> cellNameTypeString = A_8_LOWER_CASE;
            case (CHESS_BOARD_INDEX_B8) -> cellNameTypeString = B_8_LOWER_CASE;
            case (CHESS_BOARD_INDEX_C8) -> cellNameTypeString = C_8_LOWER_CASE;
            case (CHESS_BOARD_INDEX_D8) -> cellNameTypeString = D_8_LOWER_CASE;
            case (CHESS_BOARD_INDEX_E8) -> cellNameTypeString = E_8_LOWER_CASE;
            case (CHESS_BOARD_INDEX_F8) -> cellNameTypeString = F_8_LOWER_CASE;
            case (CHESS_BOARD_INDEX_G8) -> cellNameTypeString = G_8_LOWER_CASE;
            case (CHESS_BOARD_INDEX_H8) -> cellNameTypeString = H_8_LOWER_CASE;
        }
        if (returnDataName == FALSE) {
            startCellNameTypeString = cellNameTypeString;
        } else if (returnDataName == TRUE) {
            finalCellNameTypeString = cellNameTypeString;
        }
    }

    static void captureMark() {
        if (capture == TRUE) {
            captureMark = ANNOTATION_SYMBOL_MULTIPLY;
            figureInPromotionProcess = FALSE;
        } else {
            captureMark = ANNOTATION_SYMBOL_DASH;
        }
    }

    static void enPassantCaptureMark() {
        if ((enPassantCaptureProcess == TRUE)
                && (Objects.equals(figureName, ANNOTATION_SYMBOL_EMPTY))
                && (Objects.equals(captureMark, ANNOTATION_SYMBOL_MULTIPLY))) {
            enPassantCaptureMark = ANNOTATION_EN_PASSANT_CAPTURE_MARK;
            enPassantCaptureProcess = FALSE;
        } else {
            enPassantCaptureMark = ANNOTATION_SYMBOL_EMPTY;
        }

    }


    static void promotionMessage() {
        System.out.print(ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextMainColor
                + ANNOTATION_PROMOTION_MESSAGE_START
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_SYMBOL_COLON
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_b
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COMMA
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_k
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COMMA
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_q
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COMMA
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_r
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_DASH
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_PROMOTION_MESSAGE_MIDDLE
                + ANNOTATION_SYMBOL_SEMICOLON
                + ANNOTATION_SYMBOL_NEW_LINE
                + ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_PROMOTION_MESSAGE_END
                + ANNOTATION_SYMBOL_COLON
                + COLOR_RESET);
    }

    static void promotionMessageRepeat() {
        System.out.println(ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextMainColor
                + ANNOTATION_Please
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_PROMOTION_MESSAGE_REPEAT
                + ANNOTATION_SYMBOL_COLON
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_B
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COMMA
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_K
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COMMA
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_Q
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COMMA
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_R
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_COLON
                + COLOR_RESET);
        System.out.println(ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextMainColor
                + ANNOTATION_THE_LETTER
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_B
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_MEANS_BISHOP
                + ANNOTATION_SYMBOL_SEMICOLON
                + COLOR_RESET);
        System.out.println(ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextMainColor
                + ANNOTATION_THE_LETTER
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_K
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_MEANS_KNIGHT
                + ANNOTATION_SYMBOL_SEMICOLON
                + COLOR_RESET);
        System.out.println(ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextMainColor
                + ANNOTATION_THE_LETTER
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_Q
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_MEANS_QUEEN
                + ANNOTATION_SYMBOL_SEMICOLON
                + COLOR_RESET);
        System.out.println(ANNOTATION_SYMBOL_HIDDEN
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextMainColor
                + ANNOTATION_THE_LETTER
                + ANNOTATION_SYMBOL_SPACE
                + annotationTextAuxiliaryColor
                + ANNOTATION_SYMBOL_R
                + annotationTextMainColor
                + ANNOTATION_SYMBOL_SPACE
                + ANNOTATION_MEANS_ROOK
                + ANNOTATION_SYMBOL_SEMICOLON
                + COLOR_RESET);
    }

    static void promotionMark() {
        if ((Objects.equals(figureName, ANNOTATION_SYMBOL_EMPTY)) && (promotionProcessMarking == TRUE)) {
            switch (figureNameAfterPromotionTypeStringAfterTrim) {
                case ANNOTATION_SYMBOL_R, ANNOTATION_SYMBOL_r, ANNOTATION_ROOK, ANNOTATION_Rook, ANNOTATION_rook ->
                        promotionMarkFigureName = ANNOTATION_SYMBOL_R;
                case ANNOTATION_SYMBOL_N, ANNOTATION_SYMBOL_n, ANNOTATION_SYMBOL_K, ANNOTATION_SYMBOL_k, ANNOTATION_KNIGHT, ANNOTATION_Knight, ANNOTATION_knight ->
                        promotionMarkFigureName = ANNOTATION_SYMBOL_N;
                case ANNOTATION_SYMBOL_B, ANNOTATION_SYMBOL_b, ANNOTATION_BISHOP, ANNOTATION_Bishop, ANNOTATION_bishop ->
                        promotionMarkFigureName = ANNOTATION_SYMBOL_B;
                case ANNOTATION_SYMBOL_Q, ANNOTATION_SYMBOL_q, ANNOTATION_QUEEN, ANNOTATION_Queen, ANNOTATION_queen ->
                        promotionMarkFigureName = ANNOTATION_SYMBOL_Q;
            }
            promotionMark = ANNOTATION_SYMBOL_EQUALS + promotionMarkFigureName;
            promotionProcessMarking = FALSE;
        } else {
            promotionMark = ANNOTATION_SYMBOL_EMPTY;
        }
    }

    static void castlingMark() {
        if (((chessBoard[finalPositionOfTheFigure][CHESSBOARD_LAYER_1] == BLACK_KING_E8)
                && ((finalPositionOfTheFigure - startingPositionOfTheFigure) == FIGURE_MOVEMENT_VECTOR_TO_1500))

                || ((chessBoard[finalPositionOfTheFigure][CHESSBOARD_LAYER_1] == WHITE_KING_E1)
                && ((finalPositionOfTheFigure - startingPositionOfTheFigure) == FIGURE_MOVEMENT_VECTOR_TO_1500))) {

            castlingMark = ANNOTATION_SYMBOL_SPACE + ANNOTATION_SYMBOL_ZERO + ANNOTATION_SYMBOL_DASH + ANNOTATION_SYMBOL_ZERO;
        } else if (((chessBoard[finalPositionOfTheFigure][CHESSBOARD_LAYER_1] == BLACK_KING_E8)
                && ((finalPositionOfTheFigure - startingPositionOfTheFigure) == FIGURE_MOVEMENT_VECTOR_TO_2100))

                || (((chessBoard[finalPositionOfTheFigure][CHESSBOARD_LAYER_1] == WHITE_KING_E1)
                && ((finalPositionOfTheFigure - startingPositionOfTheFigure) == FIGURE_MOVEMENT_VECTOR_TO_2100)))) {

            castlingMark = ANNOTATION_SYMBOL_SPACE + ANNOTATION_SYMBOL_ZERO + ANNOTATION_SYMBOL_DASH + ANNOTATION_SYMBOL_ZERO + ANNOTATION_SYMBOL_DASH + ANNOTATION_SYMBOL_ZERO;
        } else {
            castlingMark = ANNOTATION_SYMBOL_EMPTY;
        }
    }

    static void shahMark() {
        if (((checkmateToTheBlackKing != TRUE) && (shahToTheBlackKing == TRUE) && (shahShow == TRUE))
                || ((checkmateToTheWhiteKing != TRUE) && (shahToTheWhiteKing == TRUE) && (shahShow == TRUE))) {
            shahMark = ANNOTATION_SYMBOL_PLUS;
        } else {
            shahMark = ANNOTATION_SYMBOL_EMPTY;
        }
    }

    static void checkmateMark() {
        if ((checkmateToTheBlackKing == TRUE) || (checkmateToTheWhiteKing == TRUE)) {
            checkmateMark = ANNOTATION_SYMBOL_NUMBER_SIGN;
            shahShow = FALSE;
        } else {
            checkmateMark = ANNOTATION_SYMBOL_EMPTY;
        }
    }

    static void endOfTheGameMark() {
        if (checkmateToTheBlackKing == TRUE) {
            endOfTheGameMark = ANNOTATION_SYMBOL_ONE + ANNOTATION_SYMBOL_DASH + ANNOTATION_SYMBOL_ZERO;
        } else if (checkmateToTheWhiteKing == TRUE) {
            endOfTheGameMark = ANNOTATION_SYMBOL_ZERO + ANNOTATION_SYMBOL_DASH + ANNOTATION_SYMBOL_ONE;
        } else if ((stalemateToTheBlackPlayer == TRUE) || (stalemateToTheWhitePlayer == TRUE)) {
            checkmateMark = ANNOTATION_SYMBOL_HALF + ANNOTATION_SYMBOL_DASH + ANNOTATION_SYMBOL_HALF;
        } else {
            endOfTheGameMark = ANNOTATION_SYMBOL_EMPTY;
        }
    }

    static void textAnnotationTop() {
        moveNumber();
        dateTimeMessage(moveNumber);
        currentPlayer();
    }

    static void textAnnotationBottom() {
        shahShow = TRUE;

        if (moveNumber != FALSE) {
            figureName(activeFigureName);
            cellName(startingPositionOfTheFigure, FALSE);
            cellName(finalPositionOfTheFigure, TRUE);
            captureMark();
            enPassantCaptureMark();
            promotionMark();
            castlingMark();
            checkmateMark();
            shahMark();
            endOfTheGameMark();

            System.out.println(ANNOTATION_SYMBOL_HIDDEN
                    + ANNOTATION_SYMBOL_SPACE
                    + annotationTextMainColor
                    + ANNOTATION_MOVE_NUMBER
                    + ANNOTATION_SYMBOL_SPACE
                    + moveNumber
                    + ANNOTATION_SYMBOL_COLON
                    + ANNOTATION_SYMBOL_SPACE
                    + annotationTextAuxiliaryColor
                    + currentPlayer
                    + ANNOTATION_SYMBOL_SEMICOLON
                    + ANNOTATION_SYMBOL_SPACE
                    + figureName
                    + startCellNameTypeString
                    + captureMark
                    + finalCellNameTypeString
                    + enPassantCaptureMark
                    + promotionMark
                    + castlingMark
                    + annotationTextAuxiliaryDangerColor
                    + shahMark
                    + checkmateMark
                    + annotationTextAuxiliaryColor
                    + ANNOTATION_SYMBOL_DOT
                    + COLOR_RESET);
            if (!Objects.equals(endOfTheGameMark, ANNOTATION_SYMBOL_EMPTY)) {
                System.out.println(ANNOTATION_SYMBOL_HIDDEN
                        + ANNOTATION_SYMBOL_SPACE
                        + annotationTextMainColor
                        + endOfTheGameMark
                        + COLOR_RESET);
            }
        }
    }

    static void playingFieldDisplay(String rowName, int rowStart, int rowEnd) {
        for (i = rowStart; i < rowEnd; i++) {
            cellText = null;

            if (chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) {
                if (((rowName.equals(SERVICE_SYMBOL_2)) || (rowName.equals(SERVICE_SYMBOL_4)) || (rowName.equals(SERVICE_SYMBOL_6)) || (rowName.equals(SERVICE_SYMBOL_8)))) {
                    if (chessBoard[i][CHESSBOARD_LAYER_0] % LOWEST_EVEN_NUMBER != FALSE) {
                        cellBackgroundColor = chessboardBackgroundColorWhite;
                    } else if (chessBoard[i][CHESSBOARD_LAYER_0] % LOWEST_EVEN_NUMBER == FALSE) {
                        cellBackgroundColor = chessboardBackgroundColorBlack;
                    }
                } else if (((rowName.equals(SERVICE_SYMBOL_1)) || (rowName.equals(SERVICE_SYMBOL_3)) || (rowName.equals(SERVICE_SYMBOL_5)) || (rowName.equals(SERVICE_SYMBOL_7)))) {
                    if (chessBoard[i][CHESSBOARD_LAYER_0] % LOWEST_EVEN_NUMBER != FALSE) {
                        cellBackgroundColor = chessboardBackgroundColorBlack;
                    } else if (chessBoard[i][CHESSBOARD_LAYER_0] % LOWEST_EVEN_NUMBER == FALSE) {
                        cellBackgroundColor = chessboardBackgroundColorWhite;
                    }
                }
            }

            if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) && (chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END)) {
                cellTextColor = blackServiceTextColor;
            } else if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) && (chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END)) {
                cellTextColor = whiteServiceTextColor;
            } else if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) && (chessBoard[i][CHESSBOARD_LAYER_1] == FALSE)) {
                cellTextColor = TEXT_COLOR_TRANSPARENT;
            }

            cellText(ANNOTATION_SYMBOL_HIDDEN, FALSE);
            cellText(serviceSymbolQuestionAvatar);
            cellText(blackRookAvatar, BLACK_ROOK_A8, BLACK_ROOK_H8, BLACK_ALLIED_PAWN_ROOK_RANGE_START, BLACK_ALLIED_PAWN_ROOK_RANGE_END);
            cellText(blackKnightAvatar, BLACK_KNIGHT_B8, BLACK_KNIGHT_G8, BLACK_ALLIED_PAWN_KNIGHT_RANGE_START, BLACK_ALLIED_PAWN_KNIGHT_RANGE_END);
            cellText(blackBishopAvatar, BLACK_BISHOP_C8, BLACK_BISHOP_F8, BLACK_ALLIED_PAWN_BISHOP_RANGE_START, BLACK_ALLIED_PAWN_BISHOP_RANGE_END);
            cellText(blackQueenAvatar, BLACK_QUEEN_D8, BLACK_ALLIED_PAWN_QUEEN_RANGE_START, BLACK_ALLIED_PAWN_QUEEN_RANGE_END);
            cellText(blackKingAvatar, BLACK_KING_E8);
            cellText(BLACK_ALLIED_PAWN_RANGE_START, BLACK_ALLIED_PAWN_RANGE_END, blackPawnAvatar);
            cellText(whiteRookAvatar, WHITE_ROOK_A1, WHITE_ROOK_H1, WHITE_ALLIED_PAWN_ROOK_RANGE_START, WHITE_ALLIED_PAWN_ROOK_RANGE_END);
            cellText(whiteKnightAvatar, WHITE_KNIGHT_B1, WHITE_KNIGHT_G1, WHITE_ALLIED_PAWN_KNIGHT_RANGE_START, WHITE_ALLIED_PAWN_KNIGHT_RANGE_END);
            cellText(whiteBishopAvatar, WHITE_BISHOP_C1, WHITE_BISHOP_F1, WHITE_ALLIED_PAWN_BISHOP_RANGE_START, WHITE_ALLIED_PAWN_BISHOP_RANGE_END);
            cellText(whiteQueenAvatar, WHITE_QUEEN_D1, WHITE_ALLIED_PAWN_QUEEN_RANGE_START, WHITE_ALLIED_PAWN_QUEEN_RANGE_END);
            cellText(whiteKingAvatar, WHITE_KING_E1);
            cellText(WHITE_ALLIED_PAWN_RANGE_START, WHITE_ALLIED_PAWN_RANGE_END, whitePawnAvatar);

            rowName(rowName, SHIFT_BY_MINUS_1, rowStart, rowEnd, FALSE);

            if (chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) {
                System.out.print(cellBackgroundColor + cellTextColor + cellText + COLOR_RESET);
            }

            rowName(rowName, SHIFT_BY_PLUS_1, rowStart, rowEnd, TRUE);
        }
    }

    static void auxiliaryDisplay(String rowName, String backgroundColor, int chessboardLayer, int rowStart, int rowEnd, int enemyFiguresRangeStart, int enemyFiguresRangeEnd) {
        for (i = rowStart; i < rowEnd; i++) {
            cellText = null;

            if (chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) {
                if (((rowName.equals(SERVICE_SYMBOL_2)) || (rowName.equals(SERVICE_SYMBOL_4)) || (rowName.equals(SERVICE_SYMBOL_6)) || (rowName.equals(SERVICE_SYMBOL_8)))) {
                    if (chessBoard[i][CHESSBOARD_LAYER_0] % LOWEST_EVEN_NUMBER != FALSE) {
                        cellBackgroundColor = chessboardBackgroundColorWhite;
                    } else if (chessBoard[i][CHESSBOARD_LAYER_0] % LOWEST_EVEN_NUMBER == FALSE) {
                        cellBackgroundColor = chessboardBackgroundColorBlack;
                    }
                } else if (((rowName.equals(SERVICE_SYMBOL_1)) || (rowName.equals(SERVICE_SYMBOL_3)) || (rowName.equals(SERVICE_SYMBOL_5)) || (rowName.equals(SERVICE_SYMBOL_7)))) {
                    if (chessBoard[i][CHESSBOARD_LAYER_0] % LOWEST_EVEN_NUMBER != FALSE) {
                        cellBackgroundColor = chessboardBackgroundColorBlack;
                    } else if (chessBoard[i][CHESSBOARD_LAYER_0] % LOWEST_EVEN_NUMBER == FALSE) {
                        cellBackgroundColor = chessboardBackgroundColorWhite;
                    }
                }

                if ((chessBoard[i][chessboardLayer] != FALSE) && (chessBoard[i][CHESSBOARD_LAYER_1] > enemyFiguresRangeStart) && (chessBoard[i][CHESSBOARD_LAYER_1] < enemyFiguresRangeEnd)) {
                    cellBackgroundColor = backgroundColor;
                }

                if (((chessBoard[i][CHESSBOARD_LAYER_2] == EN_PASSANT)
                        && (chessBoard[i][CHESSBOARD_LAYER_1] > enemyFiguresRangeStart)
                        && (chessBoard[i][CHESSBOARD_LAYER_1] < enemyFiguresRangeEnd))

                        && ((((chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] < enemyFiguresRangeStart)
                        || (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] > enemyFiguresRangeEnd))
                        && (((chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START)
                        && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END))
                        || ((chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START)
                        && (chessBoard[i + SHIFT_BY_PLUS_1][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END))))

                        || (((chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] < enemyFiguresRangeStart)
                        || (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] > enemyFiguresRangeEnd))
                        && (((chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START)
                        && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END))
                        || ((chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START)
                        && (chessBoard[i + SHIFT_BY_MINUS_1][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END)))))) {
                    cellBackgroundColor = backgroundColor;
                }

                if (chessBoard[i][chessboardLayer] != FALSE) {

                    if ((chessboardLayer == CHESSBOARD_LAYER_4) || (chessboardLayer == CHESSBOARD_LAYER_6)) {
                        cellTextColor = blackServiceTextColor;
                        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) && (chessBoard[i][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END)) {
                            cellTextColor = whiteServiceTextColor;
                        }
                    } else if ((chessboardLayer == CHESSBOARD_LAYER_5) || (chessboardLayer == CHESSBOARD_LAYER_7)) {
                        cellTextColor = whiteServiceTextColor;
                        if ((chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) && (chessBoard[i][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START) && (chessBoard[i][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END)) {
                            cellTextColor = blackServiceTextColor;
                        }
                    }
                    cellText = ANNOTATION_SYMBOL_SPACE + SERVICE_SYMBOL_x + ANNOTATION_SYMBOL_SPACE;
                } else if (chessBoard[i][chessboardLayer] == FALSE) {
                    cellTextColor = service_color;
                    cellText = ANNOTATION_SYMBOL_SPACE + ANNOTATION_SYMBOL_HIDDEN + ANNOTATION_SYMBOL_SPACE;
                }
            }

            cellTextAuxiliary(serviceSymbolQuestionAvatar, chessboardLayer);
            cellTextAuxiliary(blackRookAvatar, BLACK_ROOK_A8, BLACK_ROOK_H8, BLACK_ALLIED_PAWN_ROOK_RANGE_START, BLACK_ALLIED_PAWN_ROOK_RANGE_END, chessboardLayer);
            cellTextAuxiliary(blackKnightAvatar, BLACK_KNIGHT_B8, BLACK_KNIGHT_G8, BLACK_ALLIED_PAWN_KNIGHT_RANGE_START, BLACK_ALLIED_PAWN_KNIGHT_RANGE_END, chessboardLayer);
            cellTextAuxiliary(blackBishopAvatar, BLACK_BISHOP_C8, BLACK_BISHOP_F8, BLACK_ALLIED_PAWN_BISHOP_RANGE_START, BLACK_ALLIED_PAWN_BISHOP_RANGE_END, chessboardLayer);
            cellTextAuxiliary(blackQueenAvatar, BLACK_QUEEN_D8, BLACK_ALLIED_PAWN_QUEEN_RANGE_START, BLACK_ALLIED_PAWN_QUEEN_RANGE_END, chessboardLayer);
            cellTextAuxiliary(blackKingAvatar, BLACK_KING_E8, chessboardLayer);
            cellTextAuxiliary(BLACK_ALLIED_PAWN_RANGE_START, BLACK_ALLIED_PAWN_RANGE_END, blackPawnAvatar, chessboardLayer);
            cellTextAuxiliary(whiteRookAvatar, WHITE_ROOK_A1, WHITE_ROOK_H1, WHITE_ALLIED_PAWN_ROOK_RANGE_START, WHITE_ALLIED_PAWN_ROOK_RANGE_END, chessboardLayer);
            cellTextAuxiliary(whiteKnightAvatar, WHITE_KNIGHT_B1, WHITE_KNIGHT_G1, WHITE_ALLIED_PAWN_KNIGHT_RANGE_START, WHITE_ALLIED_PAWN_KNIGHT_RANGE_END, chessboardLayer);
            cellTextAuxiliary(whiteBishopAvatar, WHITE_BISHOP_C1, WHITE_BISHOP_F1, WHITE_ALLIED_PAWN_BISHOP_RANGE_START, WHITE_ALLIED_PAWN_BISHOP_RANGE_END, chessboardLayer);
            cellTextAuxiliary(whiteQueenAvatar, WHITE_QUEEN_D1, WHITE_ALLIED_PAWN_QUEEN_RANGE_START, WHITE_ALLIED_PAWN_QUEEN_RANGE_END, chessboardLayer);
            cellTextAuxiliary(whiteKingAvatar, WHITE_KING_E1, chessboardLayer);
            cellTextAuxiliary(WHITE_ALLIED_PAWN_RANGE_START, WHITE_ALLIED_PAWN_RANGE_END, whitePawnAvatar, chessboardLayer);

            rowName(rowName, SHIFT_BY_MINUS_1, rowStart, rowEnd, FALSE);

            if (chessBoard[i][CHESSBOARD_LAYER_0] != FALSE) {
                System.out.print(cellBackgroundColor + cellTextColor + cellText + COLOR_RESET);
            }

            rowName(rowName, SHIFT_BY_PLUS_1, rowStart, rowEnd, TRUE);
        }
    }

    static void printRow(int playingFieldDisplay, int displayingAStalemateForTheBlackPlayer, int displayingAStalemateForTheWhitePlayer, int spaceControlledByTheBlackPlayer, int spaceControlledByTheWhitePlayer) {
        if (playingFieldDisplay == TRUE) {
            rowTopBottom();
        }
        if (displayingAStalemateForTheBlackPlayer == TRUE) {
            rowTopBottom();
        }
        if (displayingAStalemateForTheWhitePlayer == TRUE) {
            rowTopBottom();
        }
        if (spaceControlledByTheBlackPlayer == TRUE) {
            rowTopBottom();
        }
        if (spaceControlledByTheWhitePlayer == TRUE) {
            rowTopBottom();
        }
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
    }

    static void printRow(int playingFieldDisplay, int displayingAStalemateForTheBlackPlayer, int displayingAStalemateForTheWhitePlayer, int spaceControlledByTheBlackPlayer, int spaceControlledByTheWhitePlayer, String rowName, int rowStart, int rowEnd, String blackServiceBackgroundColor, String whiteServiceBackgroundColor) {
        if (playingFieldDisplay == TRUE) {
            playingFieldDisplay(rowName, rowStart, rowEnd);
        }
        if (displayingAStalemateForTheWhitePlayer == TRUE) {
            auxiliaryDisplay(rowName, whiteServiceBackgroundColor, CHESSBOARD_LAYER_5, rowStart, rowEnd, BLACK_ALLIED_RANGE_START, BLACK_ALLIED_RANGE_END);
        }
        if (displayingAStalemateForTheBlackPlayer == TRUE) {
            auxiliaryDisplay(rowName, blackServiceBackgroundColor, CHESSBOARD_LAYER_4, rowStart, rowEnd, WHITE_ALLIED_RANGE_START, WHITE_ALLIED_RANGE_END);
        }
        if (spaceControlledByTheWhitePlayer == TRUE) {
            auxiliaryDisplay(rowName, whiteServiceBackgroundColor, CHESSBOARD_LAYER_7, rowStart, rowEnd, BLACK_ALLIED_RANGE_START, BLACK_ALLIED_RANGE_END);
        }
        if (spaceControlledByTheBlackPlayer == TRUE) {
            auxiliaryDisplay(rowName, blackServiceBackgroundColor, CHESSBOARD_LAYER_6, rowStart, rowEnd, WHITE_ALLIED_RANGE_START, WHITE_ALLIED_RANGE_END);
        }
        System.out.print(ANNOTATION_SYMBOL_NEW_LINE);
    }

    static void printThePlayingField() {

        if (moveCountBeforeGameEnd == PROPERTY) {
            colorStyleArray(greyStyle, matrixStyle);
        }

        textAnnotationTop();
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer, SERVICE_SYMBOL_8, ROW_8_START, ROW_8_END, blackServiceBackgroundColor, whiteServiceBackgroundColor);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer, SERVICE_SYMBOL_7, ROW_7_START, ROW_7_END, blackServiceBackgroundColor, whiteServiceBackgroundColor);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer, SERVICE_SYMBOL_6, ROW_6_START, ROW_6_END, blackServiceBackgroundColor, whiteServiceBackgroundColor);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer, SERVICE_SYMBOL_5, ROW_5_START, ROW_5_END, blackServiceBackgroundColor, whiteServiceBackgroundColor);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer, SERVICE_SYMBOL_4, ROW_4_START, ROW_4_END, blackServiceBackgroundColor, whiteServiceBackgroundColor);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer, SERVICE_SYMBOL_3, ROW_3_START, ROW_3_END, blackServiceBackgroundColor, whiteServiceBackgroundColor);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer, SERVICE_SYMBOL_2, ROW_2_START, ROW_2_END, blackServiceBackgroundColor, whiteServiceBackgroundColor);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer, SERVICE_SYMBOL_1, ROW_1_START, ROW_1_END, blackServiceBackgroundColor, whiteServiceBackgroundColor);
        printRow(playingFieldDisplay, displayingAStalemateForTheBlackPlayer, displayingAStalemateForTheWhitePlayer, spaceControlledByTheBlackPlayer, spaceControlledByTheWhitePlayer);
        textAnnotationBottom();
    }
}