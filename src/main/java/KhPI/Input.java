package KhPI;

import java.util.Scanner;

import static KhPI.DataPort.activeFigureName;
import static KhPI.DataPort.blackFigureStyle;
import static KhPI.DataPort.blackMove;
import static KhPI.DataPort.callingThePlayerToMakeTheMove;
import static KhPI.DataPort.chessBoard;
import static KhPI.DataPort.displayingAStalemateForTheBlackPlayer;
import static KhPI.DataPort.displayingAStalemateForTheWhitePlayer;
import static KhPI.DataPort.figureNameAfterPromotionTypeStringAfterTrim;
import static KhPI.DataPort.finalPositionOfTheFigure;
import static KhPI.DataPort.greyStyle;
import static KhPI.DataPort.listOfLegalMoves;
import static KhPI.DataPort.matrixStyle;
import static KhPI.DataPort.playsBlackPieces;
import static KhPI.DataPort.playsWhitePieces;
import static KhPI.DataPort.promotionProcessMarking;
import static KhPI.DataPort.startingPositionOfTheFigure;
import static KhPI.DataPort.whiteFigureStyle;
import static KhPI.DataPort.whiteMove;
import static KhPI.GlobalConstant.*;
import static KhPI.GUI.additionalInfoMessage;
import static KhPI.GUI.callingThePlayerToMakeTheMove;
import static KhPI.GUI.colorSchemaMessage;
import static KhPI.GUI.figureStyleMessage;
import static KhPI.GUI.inputDataAnnotationRepeatMessage;
import static KhPI.GUI.playerNameMessage;
import static KhPI.GUI.playerNewNameMessage;
import static KhPI.GUI.possibleCustomizationMessage;
import static KhPI.GUI.promotionMessageRepeat;
import static KhPI.GUI.repeatInputData;
import static KhPI.GUI.settingsMenuStartClueMessage;
import static KhPI.GUI.settingsMenuStartMainMessage;
import static KhPI.GUI.successMessage;

public class Input {
    private static final char NULL_TYPE_CHAR = '\u0000';
    private static final int BLACK_PAWN_BISHOP_A7 = 34;
    private static final int BLACK_PAWN_BISHOP_B7 = 35;
    private static final int BLACK_PAWN_BISHOP_C7 = 36;
    private static final int BLACK_PAWN_BISHOP_D7 = 37;
    private static final int BLACK_PAWN_BISHOP_E7 = 38;
    private static final int BLACK_PAWN_BISHOP_F7 = 39;
    private static final int BLACK_PAWN_BISHOP_G7 = 40;
    private static final int BLACK_PAWN_BISHOP_H7 = 41;
    private static final int BLACK_PAWN_KNIGHT_A7 = 26;
    private static final int BLACK_PAWN_KNIGHT_B7 = 27;
    private static final int BLACK_PAWN_KNIGHT_C7 = 28;
    private static final int BLACK_PAWN_KNIGHT_D7 = 29;
    private static final int BLACK_PAWN_KNIGHT_E7 = 30;
    private static final int BLACK_PAWN_KNIGHT_F7 = 31;
    private static final int BLACK_PAWN_KNIGHT_G7 = 32;
    private static final int BLACK_PAWN_KNIGHT_H7 = 33;
    private static final int BLACK_PAWN_QUEEN_A7 = 42;
    private static final int BLACK_PAWN_QUEEN_B7 = 43;
    private static final int BLACK_PAWN_QUEEN_C7 = 44;
    private static final int BLACK_PAWN_QUEEN_D7 = 45;
    private static final int BLACK_PAWN_QUEEN_E7 = 46;
    private static final int BLACK_PAWN_QUEEN_F7 = 47;
    private static final int BLACK_PAWN_QUEEN_G7 = 48;
    private static final int BLACK_PAWN_QUEEN_H7 = 49;
    private static final int BLACK_PAWN_ROOK_A7 = 18;
    private static final int BLACK_PAWN_ROOK_B7 = 19;
    private static final int BLACK_PAWN_ROOK_C7 = 20;
    private static final int BLACK_PAWN_ROOK_D7 = 21;
    private static final int BLACK_PAWN_ROOK_E7 = 22;
    private static final int BLACK_PAWN_ROOK_F7 = 23;
    private static final int BLACK_PAWN_ROOK_G7 = 24;
    private static final int BLACK_PAWN_ROOK_H7 = 25;
    private static final int WHITE_PAWN_BISHOP_A2 = 83;
    private static final int WHITE_PAWN_BISHOP_B2 = 84;
    private static final int WHITE_PAWN_BISHOP_C2 = 85;
    private static final int WHITE_PAWN_BISHOP_D2 = 86;
    private static final int WHITE_PAWN_BISHOP_E2 = 87;
    private static final int WHITE_PAWN_BISHOP_F2 = 88;
    private static final int WHITE_PAWN_BISHOP_G2 = 89;
    private static final int WHITE_PAWN_BISHOP_H2 = 90;
    private static final int WHITE_PAWN_KNIGHT_A2 = 75;
    private static final int WHITE_PAWN_KNIGHT_B2 = 76;
    private static final int WHITE_PAWN_KNIGHT_C2 = 77;
    private static final int WHITE_PAWN_KNIGHT_D2 = 78;
    private static final int WHITE_PAWN_KNIGHT_E2 = 79;
    private static final int WHITE_PAWN_KNIGHT_F2 = 80;
    private static final int WHITE_PAWN_KNIGHT_G2 = 81;
    private static final int WHITE_PAWN_KNIGHT_H2 = 82;
    private static final int WHITE_PAWN_QUEEN_A2 = 91;
    private static final int WHITE_PAWN_QUEEN_B2 = 92;
    private static final int WHITE_PAWN_QUEEN_C2 = 93;
    private static final int WHITE_PAWN_QUEEN_D2 = 94;
    private static final int WHITE_PAWN_QUEEN_E2 = 95;
    private static final int WHITE_PAWN_QUEEN_F2 = 96;
    private static final int WHITE_PAWN_QUEEN_G2 = 97;
    private static final int WHITE_PAWN_QUEEN_H2 = 98;
    private static final int WHITE_PAWN_ROOK_A2 = 67;
    private static final int WHITE_PAWN_ROOK_B2 = 68;
    private static final int WHITE_PAWN_ROOK_C2 = 69;
    private static final int WHITE_PAWN_ROOK_D2 = 70;
    private static final int WHITE_PAWN_ROOK_E2 = 71;
    private static final int WHITE_PAWN_ROOK_F2 = 72;
    private static final int WHITE_PAWN_ROOK_G2 = 73;
    private static final int WHITE_PAWN_ROOK_H2 = 74;
    private static final String A_1_UPPER_CASE = "A1";
    private static final String A_2_UPPER_CASE = "A2";
    private static final String A_3_UPPER_CASE = "A3";
    private static final String A_4_UPPER_CASE = "A4";
    private static final String A_5_UPPER_CASE = "A5";
    private static final String A_6_UPPER_CASE = "A6";
    private static final String A_7_UPPER_CASE = "A7";
    private static final String A_8_UPPER_CASE = "A8";
    private static final String B_1_UPPER_CASE = "B1";
    private static final String B_2_UPPER_CASE = "B2";
    private static final String B_3_UPPER_CASE = "B3";
    private static final String B_4_UPPER_CASE = "B4";
    private static final String B_5_UPPER_CASE = "B5";
    private static final String B_6_UPPER_CASE = "B6";
    private static final String B_7_UPPER_CASE = "B7";
    private static final String B_8_UPPER_CASE = "B8";
    private static final String C_1_UPPER_CASE = "C1";
    private static final String C_2_UPPER_CASE = "C2";
    private static final String C_3_UPPER_CASE = "C3";
    private static final String C_4_UPPER_CASE = "C4";
    private static final String C_5_UPPER_CASE = "C5";
    private static final String C_6_UPPER_CASE = "C6";
    private static final String C_7_UPPER_CASE = "C7";
    private static final String C_8_UPPER_CASE = "C8";
    private static final String D_1_UPPER_CASE = "D1";
    private static final String D_2_UPPER_CASE = "D2";
    private static final String D_3_UPPER_CASE = "D3";
    private static final String D_4_UPPER_CASE = "D4";
    private static final String D_5_UPPER_CASE = "D5";
    private static final String D_6_UPPER_CASE = "D6";
    private static final String D_7_UPPER_CASE = "D7";
    private static final String D_8_UPPER_CASE = "D8";
    private static final String E_1_UPPER_CASE = "E1";
    private static final String E_2_UPPER_CASE = "E2";
    private static final String E_3_UPPER_CASE = "E3";
    private static final String E_4_UPPER_CASE = "E4";
    private static final String E_5_UPPER_CASE = "E5";
    private static final String E_6_UPPER_CASE = "E6";
    private static final String E_7_UPPER_CASE = "E7";
    private static final String E_8_UPPER_CASE = "E8";
    private static final String F_1_UPPER_CASE = "F1";
    private static final String F_2_UPPER_CASE = "F2";
    private static final String F_3_UPPER_CASE = "F3";
    private static final String F_4_UPPER_CASE = "F4";
    private static final String F_5_UPPER_CASE = "F5";
    private static final String F_6_UPPER_CASE = "F6";
    private static final String F_7_UPPER_CASE = "F7";
    private static final String F_8_UPPER_CASE = "F8";
    private static final String G_1_UPPER_CASE = "G1";
    private static final String G_2_UPPER_CASE = "G2";
    private static final String G_3_UPPER_CASE = "G3";
    private static final String G_4_UPPER_CASE = "G4";
    private static final String G_5_UPPER_CASE = "G5";
    private static final String G_6_UPPER_CASE = "G6";
    private static final String G_7_UPPER_CASE = "G7";
    private static final String G_8_UPPER_CASE = "G8";
    private static final String H_1_UPPER_CASE = "H1";
    private static final String H_2_UPPER_CASE = "H2";
    private static final String H_3_UPPER_CASE = "H3";
    private static final String H_4_UPPER_CASE = "H4";
    private static final String H_5_UPPER_CASE = "H5";
    private static final String H_6_UPPER_CASE = "H6";
    private static final String H_7_UPPER_CASE = "H7";
    private static final String H_8_UPPER_CASE = "H8";
    private static final String INPUT_SYMBOL_BACK = "BACK";
    private static final String INPUT_SYMBOL_Back = "Back";
    private static final String INPUT_SYMBOL_back = "back";
    private static final String INPUT_SYMBOL_ESC = "ESC";
    private static final String INPUT_SYMBOL_Esc = "Esc";
    private static final String INPUT_SYMBOL_esc = "esc";
    private static final String INPUT_SYMBOL_ESCAPE = "ESCAPE";
    private static final String INPUT_SYMBOL_Escape = "Escape";
    private static final String INPUT_SYMBOL_escape = "escape";
    private static final String INPUT_SYMBOL_EXIT = "EXIT";
    private static final String INPUT_SYMBOL_Exit = "Exit";
    private static final String INPUT_SYMBOL_exit = "exit";
    private static final String INPUT_SYMBOL_FOUR = "4";
    private static final String INPUT_SYMBOL_MENU = "MENU";
    private static final String INPUT_SYMBOL_Menu = "Menu";
    private static final String INPUT_SYMBOL_menu = "menu";
    private static final String INPUT_SYMBOL_NO = "NO";
    private static final String INPUT_SYMBOL_No = "No";
    private static final String INPUT_SYMBOL_no = "no";
    private static final String INPUT_SYMBOL_ONE = "1";
    private static final String INPUT_SYMBOL_RETURN = "RETURN";
    private static final String INPUT_SYMBOL_Return = "Return";
    private static final String INPUT_SYMBOL_return = "return";
    private static final String INPUT_SYMBOL_SETTINGS = "SETTINGS";
    private static final String INPUT_SYMBOL_Settings = "Settings";
    private static final String INPUT_SYMBOL_settings = "settings";
    private static final String INPUT_SYMBOL_SETUP = "SETUP";
    private static final String INPUT_SYMBOL_Setup = "Setup";
    private static final String INPUT_SYMBOL_setup = "setup";
    private static final String INPUT_SYMBOL_THREE = "3";
    private static final String INPUT_SYMBOL_TWO = "2";
    private static final String INPUT_SYMBOL_YES = "YES";
    private static final String INPUT_SYMBOL_Yes = "Yes";
    private static final String INPUT_SYMBOL_yes = "yes";
    private static final int HUMANS_MOVE_SYMBOL_ARRAY_LAYER_0 = 0;
    private static final int HUMANS_MOVE_SYMBOL_ARRAY_LAYER_1 = 1;
    private static final int HUMANS_MOVE_SYMBOL_ARRAY_LAYER_2 = 2;
    private static final int HUMANS_MOVE_SYMBOL_ARRAY_LAYER_3 = 3;
    private static final int HUMANS_MOVE_SYMBOL_ARRAY_NUMBER_OF_CELLS = 4;
    private static final int INPUT_CHARACTER_COUNT = 4;
    private static int counterOfAttemptsToEnterTheSettingsMenu;
    private static int finalPositionOfTheFigureTypeIntegerVerified;
    private static int startingPositionOfTheFigureTypeIntegerVerified;
    private static String inputDataUnverifiedAfterTrim;


    static void inputDataTrim() {
        String inputDataUnverified;
        inputDataUnverifiedAfterTrim = null;
        Scanner inputData = new Scanner(System.in);
        inputDataUnverified = inputData.nextLine();
        inputDataUnverifiedAfterTrim = inputDataUnverified.trim();
    }

    static void inputTreeRoot() {
        if (counterOfAttemptsToEnterTheSettingsMenu == FALSE) {
            counterOfAttemptsToEnterTheSettingsMenu++;
            settingsMenuStartMainMessage();
        }

        settingsMenuStartClueMessage();
        inputDataTrim();

        switch (inputDataUnverifiedAfterTrim) {
            case INPUT_SYMBOL_MENU, INPUT_SYMBOL_Menu, INPUT_SYMBOL_menu,
                    INPUT_SYMBOL_SETTINGS, INPUT_SYMBOL_Settings, INPUT_SYMBOL_settings,
                    INPUT_SYMBOL_SETUP, INPUT_SYMBOL_Setup, INPUT_SYMBOL_setup,
                    INPUT_SYMBOL_YES, INPUT_SYMBOL_Yes, INPUT_SYMBOL_yes -> inputSetupMenu();
            case INPUT_SYMBOL_ESC, INPUT_SYMBOL_Esc, INPUT_SYMBOL_esc,
                    INPUT_SYMBOL_ESCAPE, INPUT_SYMBOL_Escape, INPUT_SYMBOL_escape,
                    INPUT_SYMBOL_EXIT, INPUT_SYMBOL_Exit, INPUT_SYMBOL_exit,
                    INPUT_SYMBOL_NO, INPUT_SYMBOL_No, INPUT_SYMBOL_no -> {
            }
            default -> {
                inputDataAnnotationRepeatMessage();
                inputTreeRoot();
            }
        }

    }

    static void inputSetupMenu() {
        possibleCustomizationMessage();
        inputDataTrim();

        switch (inputDataUnverifiedAfterTrim) {
            case INPUT_SYMBOL_ONE -> changePlayerName();
            case INPUT_SYMBOL_TWO -> changeColorSchema();
            case INPUT_SYMBOL_THREE -> changeFigureStyle();
            case INPUT_SYMBOL_FOUR -> showAdditionalInfo();
            case INPUT_SYMBOL_BACK, INPUT_SYMBOL_Back, INPUT_SYMBOL_back,
                    INPUT_SYMBOL_RETURN, INPUT_SYMBOL_Return, INPUT_SYMBOL_return -> {
                counterOfAttemptsToEnterTheSettingsMenu = FALSE;
                inputTreeRoot();
            }
            case INPUT_SYMBOL_ESC, INPUT_SYMBOL_Esc, INPUT_SYMBOL_esc,
                    INPUT_SYMBOL_ESCAPE, INPUT_SYMBOL_Escape, INPUT_SYMBOL_escape,
                    INPUT_SYMBOL_EXIT, INPUT_SYMBOL_Exit, INPUT_SYMBOL_exit -> {
            }
            default -> {
                inputDataAnnotationRepeatMessage();
                inputSetupMenu();
            }
        }
    }

    static void inputNewPlayerName(int playerPlaysBlack) {
        playerNewNameMessage();
        inputDataTrim();

        switch (inputDataUnverifiedAfterTrim) {
            case INPUT_SYMBOL_BACK, INPUT_SYMBOL_Back, INPUT_SYMBOL_back,
                    INPUT_SYMBOL_RETURN, INPUT_SYMBOL_Return, INPUT_SYMBOL_return -> changePlayerName();
            case INPUT_SYMBOL_ESC, INPUT_SYMBOL_Esc, INPUT_SYMBOL_esc,
                    INPUT_SYMBOL_ESCAPE, INPUT_SYMBOL_Escape, INPUT_SYMBOL_escape,
                    INPUT_SYMBOL_EXIT, INPUT_SYMBOL_Exit, INPUT_SYMBOL_exit -> {
            }
            default -> {
                if (!inputDataUnverifiedAfterTrim.equals(ANNOTATION_SYMBOL_EMPTY)) {
                    if (playerPlaysBlack == TRUE) {
                        playsBlackPieces = inputDataUnverifiedAfterTrim;
                    } else {
                        playsWhitePieces = inputDataUnverifiedAfterTrim;
                    }
                    successMessage();
                    changePlayerName();
                } else {
                    inputDataAnnotationRepeatMessage();
                    inputNewPlayerName(playerPlaysBlack);
                }
            }
        }
    }

    static void changePlayerName() {
        playerNameMessage();
        inputDataTrim();

        switch (inputDataUnverifiedAfterTrim) {
            case INPUT_SYMBOL_ONE -> inputNewPlayerName(FALSE);
            case INPUT_SYMBOL_TWO -> inputNewPlayerName(TRUE);
            case INPUT_SYMBOL_BACK, INPUT_SYMBOL_Back, INPUT_SYMBOL_back,
                    INPUT_SYMBOL_RETURN, INPUT_SYMBOL_Return, INPUT_SYMBOL_return -> {
                counterOfAttemptsToEnterTheSettingsMenu = FALSE;
                inputSetupMenu();
            }
            case INPUT_SYMBOL_ESC, INPUT_SYMBOL_Esc, INPUT_SYMBOL_esc,
                    INPUT_SYMBOL_ESCAPE, INPUT_SYMBOL_Escape, INPUT_SYMBOL_escape,
                    INPUT_SYMBOL_EXIT, INPUT_SYMBOL_Exit, INPUT_SYMBOL_exit -> {
            }
            default -> {
                inputDataAnnotationRepeatMessage();
                changePlayerName();
            }
        }
    }

    static void changeColorSchema() {
        colorSchemaMessage();
        inputDataTrim();

        switch (inputDataUnverifiedAfterTrim) {
            case INPUT_SYMBOL_ONE -> {
                greyStyle = TRUE;
                matrixStyle = FALSE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_TWO -> {
                greyStyle = FALSE;
                matrixStyle = TRUE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_BACK, INPUT_SYMBOL_Back, INPUT_SYMBOL_back,
                    INPUT_SYMBOL_RETURN, INPUT_SYMBOL_Return, INPUT_SYMBOL_return -> {
                counterOfAttemptsToEnterTheSettingsMenu = FALSE;
                inputSetupMenu();
            }
            case INPUT_SYMBOL_ESC, INPUT_SYMBOL_Esc, INPUT_SYMBOL_esc,
                    INPUT_SYMBOL_ESCAPE, INPUT_SYMBOL_Escape, INPUT_SYMBOL_escape,
                    INPUT_SYMBOL_EXIT, INPUT_SYMBOL_Exit, INPUT_SYMBOL_exit -> {
            }
            default -> {
                inputDataAnnotationRepeatMessage();
                changeColorSchema();
            }
        }
    }

    static void changeFigureStyle() {
        figureStyleMessage();
        inputDataTrim();

        switch (inputDataUnverifiedAfterTrim) {
            case INPUT_SYMBOL_ONE -> {
                whiteFigureStyle = TRUE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_TWO -> {
                whiteFigureStyle = FALSE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_THREE -> {
                blackFigureStyle = TRUE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_FOUR -> {
                blackFigureStyle = FALSE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_BACK, INPUT_SYMBOL_Back, INPUT_SYMBOL_back,
                    INPUT_SYMBOL_RETURN, INPUT_SYMBOL_Return, INPUT_SYMBOL_return -> {
                counterOfAttemptsToEnterTheSettingsMenu = FALSE;
                inputSetupMenu();
            }
            case INPUT_SYMBOL_ESC, INPUT_SYMBOL_Esc, INPUT_SYMBOL_esc,
                    INPUT_SYMBOL_ESCAPE, INPUT_SYMBOL_Escape, INPUT_SYMBOL_escape,
                    INPUT_SYMBOL_EXIT, INPUT_SYMBOL_Exit, INPUT_SYMBOL_exit -> {
            }
            default -> {
                inputDataAnnotationRepeatMessage();
                changeFigureStyle();
            }
        }
    }

    static void showAdditionalInfo() {
        additionalInfoMessage();
        inputDataTrim();

        switch (inputDataUnverifiedAfterTrim) {
            case INPUT_SYMBOL_ONE -> {
                displayingAStalemateForTheWhitePlayer = TRUE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_TWO -> {
                displayingAStalemateForTheWhitePlayer = FALSE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_THREE -> {
                displayingAStalemateForTheBlackPlayer = TRUE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_FOUR -> {
                displayingAStalemateForTheBlackPlayer = FALSE;
                successMessage();
                inputSetupMenu();
            }
            case INPUT_SYMBOL_BACK, INPUT_SYMBOL_Back, INPUT_SYMBOL_back,
                    INPUT_SYMBOL_RETURN, INPUT_SYMBOL_Return, INPUT_SYMBOL_return -> {
                counterOfAttemptsToEnterTheSettingsMenu = FALSE;
                inputSetupMenu();
            }
            case INPUT_SYMBOL_ESC, INPUT_SYMBOL_Esc, INPUT_SYMBOL_esc,
                    INPUT_SYMBOL_ESCAPE, INPUT_SYMBOL_Escape, INPUT_SYMBOL_escape,
                    INPUT_SYMBOL_EXIT, INPUT_SYMBOL_Exit, INPUT_SYMBOL_exit -> {
            }
            default -> {
                inputDataAnnotationRepeatMessage();
                showAdditionalInfo();
            }
        }
    }

    static void promotionChoice(int chessBoardIndexStartCheckpointLayer1, int arrayIndexFinal) {

        inputDataTrim();
        figureNameAfterPromotionTypeStringAfterTrim = inputDataUnverifiedAfterTrim;

        promotionProcessMarking = TRUE;
        switch (figureNameAfterPromotionTypeStringAfterTrim) {

            case ANNOTATION_SYMBOL_R, ANNOTATION_SYMBOL_r,
                    ANNOTATION_ROOK, ANNOTATION_Rook, ANNOTATION_rook -> {
                switch (chessBoardIndexStartCheckpointLayer1) {
                    case BLACK_PAWN_A7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_ROOK_A7;
                    case BLACK_PAWN_B7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_ROOK_B7;
                    case BLACK_PAWN_C7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_ROOK_C7;
                    case BLACK_PAWN_D7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_ROOK_D7;
                    case BLACK_PAWN_E7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_ROOK_E7;
                    case BLACK_PAWN_F7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_ROOK_F7;
                    case BLACK_PAWN_G7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_ROOK_G7;
                    case BLACK_PAWN_H7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_ROOK_H7;
                    case WHITE_PAWN_A2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_ROOK_A2;
                    case WHITE_PAWN_B2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_ROOK_B2;
                    case WHITE_PAWN_C2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_ROOK_C2;
                    case WHITE_PAWN_D2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_ROOK_D2;
                    case WHITE_PAWN_E2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_ROOK_E2;
                    case WHITE_PAWN_F2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_ROOK_F2;
                    case WHITE_PAWN_G2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_ROOK_G2;
                    case WHITE_PAWN_H2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_ROOK_H2;
                }
            }
            case ANNOTATION_SYMBOL_N, ANNOTATION_SYMBOL_n,
                    ANNOTATION_SYMBOL_K, ANNOTATION_SYMBOL_k,
                    ANNOTATION_KNIGHT, ANNOTATION_Knight, ANNOTATION_knight -> {
                switch (chessBoardIndexStartCheckpointLayer1) {
                    case BLACK_PAWN_A7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_KNIGHT_A7;
                    case BLACK_PAWN_B7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_KNIGHT_B7;
                    case BLACK_PAWN_C7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_KNIGHT_C7;
                    case BLACK_PAWN_D7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_KNIGHT_D7;
                    case BLACK_PAWN_E7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_KNIGHT_E7;
                    case BLACK_PAWN_F7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_KNIGHT_F7;
                    case BLACK_PAWN_G7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_KNIGHT_G7;
                    case BLACK_PAWN_H7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_KNIGHT_H7;
                    case WHITE_PAWN_A2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_KNIGHT_A2;
                    case WHITE_PAWN_B2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_KNIGHT_B2;
                    case WHITE_PAWN_C2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_KNIGHT_C2;
                    case WHITE_PAWN_D2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_KNIGHT_D2;
                    case WHITE_PAWN_E2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_KNIGHT_E2;
                    case WHITE_PAWN_F2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_KNIGHT_F2;
                    case WHITE_PAWN_G2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_KNIGHT_G2;
                    case WHITE_PAWN_H2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_KNIGHT_H2;
                }
            }
            case ANNOTATION_SYMBOL_B, ANNOTATION_SYMBOL_b,
                    ANNOTATION_BISHOP, ANNOTATION_Bishop, ANNOTATION_bishop -> {
                switch (chessBoardIndexStartCheckpointLayer1) {
                    case BLACK_PAWN_A7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_BISHOP_A7;
                    case BLACK_PAWN_B7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_BISHOP_B7;
                    case BLACK_PAWN_C7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_BISHOP_C7;
                    case BLACK_PAWN_D7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_BISHOP_D7;
                    case BLACK_PAWN_E7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_BISHOP_E7;
                    case BLACK_PAWN_F7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_BISHOP_F7;
                    case BLACK_PAWN_G7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_BISHOP_G7;
                    case BLACK_PAWN_H7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_BISHOP_H7;
                    case WHITE_PAWN_A2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_BISHOP_A2;
                    case WHITE_PAWN_B2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_BISHOP_B2;
                    case WHITE_PAWN_C2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_BISHOP_C2;
                    case WHITE_PAWN_D2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_BISHOP_D2;
                    case WHITE_PAWN_E2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_BISHOP_E2;
                    case WHITE_PAWN_F2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_BISHOP_F2;
                    case WHITE_PAWN_G2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_BISHOP_G2;
                    case WHITE_PAWN_H2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_BISHOP_H2;
                }
            }
            case ANNOTATION_SYMBOL_Q, ANNOTATION_SYMBOL_q,
                    ANNOTATION_QUEEN, ANNOTATION_Queen, ANNOTATION_queen -> {
                switch (chessBoardIndexStartCheckpointLayer1) {
                    case BLACK_PAWN_A7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_QUEEN_A7;
                    case BLACK_PAWN_B7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_QUEEN_B7;
                    case BLACK_PAWN_C7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_QUEEN_C7;
                    case BLACK_PAWN_D7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_QUEEN_D7;
                    case BLACK_PAWN_E7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_QUEEN_E7;
                    case BLACK_PAWN_F7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_QUEEN_F7;
                    case BLACK_PAWN_G7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_QUEEN_G7;
                    case BLACK_PAWN_H7 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = BLACK_PAWN_QUEEN_H7;
                    case WHITE_PAWN_A2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_QUEEN_A2;
                    case WHITE_PAWN_B2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_QUEEN_B2;
                    case WHITE_PAWN_C2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_QUEEN_C2;
                    case WHITE_PAWN_D2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_QUEEN_D2;
                    case WHITE_PAWN_E2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_QUEEN_E2;
                    case WHITE_PAWN_F2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_QUEEN_F2;
                    case WHITE_PAWN_G2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_QUEEN_G2;
                    case WHITE_PAWN_H2 -> chessBoard[arrayIndexFinal][CHESSBOARD_LAYER_1] = WHITE_PAWN_QUEEN_H2;
                }
            }
            default -> {
                promotionProcessMarking = FALSE;
                promotionMessageRepeat();
                promotionChoice(chessBoardIndexStartCheckpointLayer1, arrayIndexFinal);
            }
        }
    }

    static void humansMoveConverterFromStringToInteger(String positionOfTheFigureTypeStringUnverified,
                                                       int startingPositionVerification, int finalPositionVerification) {
        int positionOfTheFigureTypeIntegerUnverified;
        switch (positionOfTheFigureTypeStringUnverified) {
            case A_1_UPPER_CASE, A_1_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_A1;
            case A_2_UPPER_CASE, A_2_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_A2;
            case A_3_UPPER_CASE, A_3_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_A3;
            case A_4_UPPER_CASE, A_4_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_A4;
            case A_5_UPPER_CASE, A_5_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_A5;
            case A_6_UPPER_CASE, A_6_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_A6;
            case A_7_UPPER_CASE, A_7_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_A7;
            case A_8_UPPER_CASE, A_8_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_A8;
            case B_1_UPPER_CASE, B_1_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_B1;
            case B_2_UPPER_CASE, B_2_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_B2;
            case B_3_UPPER_CASE, B_3_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_B3;
            case B_4_UPPER_CASE, B_4_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_B4;
            case B_5_UPPER_CASE, B_5_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_B5;
            case B_6_UPPER_CASE, B_6_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_B6;
            case B_7_UPPER_CASE, B_7_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_B7;
            case B_8_UPPER_CASE, B_8_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_B8;
            case C_1_UPPER_CASE, C_1_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_C1;
            case C_2_UPPER_CASE, C_2_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_C2;
            case C_3_UPPER_CASE, C_3_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_C3;
            case C_4_UPPER_CASE, C_4_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_C4;
            case C_5_UPPER_CASE, C_5_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_C5;
            case C_6_UPPER_CASE, C_6_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_C6;
            case C_7_UPPER_CASE, C_7_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_C7;
            case C_8_UPPER_CASE, C_8_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_C8;
            case D_1_UPPER_CASE, D_1_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_D1;
            case D_2_UPPER_CASE, D_2_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_D2;
            case D_3_UPPER_CASE, D_3_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_D3;
            case D_4_UPPER_CASE, D_4_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_D4;
            case D_5_UPPER_CASE, D_5_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_D5;
            case D_6_UPPER_CASE, D_6_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_D6;
            case D_7_UPPER_CASE, D_7_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_D7;
            case D_8_UPPER_CASE, D_8_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_D8;
            case E_1_UPPER_CASE, E_1_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_E1;
            case E_2_UPPER_CASE, E_2_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_E2;
            case E_3_UPPER_CASE, E_3_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_E3;
            case E_4_UPPER_CASE, E_4_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_E4;
            case E_5_UPPER_CASE, E_5_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_E5;
            case E_6_UPPER_CASE, E_6_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_E6;
            case E_7_UPPER_CASE, E_7_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_E7;
            case E_8_UPPER_CASE, E_8_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_E8;
            case F_1_UPPER_CASE, F_1_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_F1;
            case F_2_UPPER_CASE, F_2_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_F2;
            case F_3_UPPER_CASE, F_3_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_F3;
            case F_4_UPPER_CASE, F_4_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_F4;
            case F_5_UPPER_CASE, F_5_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_F5;
            case F_6_UPPER_CASE, F_6_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_F6;
            case F_7_UPPER_CASE, F_7_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_F7;
            case F_8_UPPER_CASE, F_8_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_F8;
            case G_1_UPPER_CASE, G_1_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_G1;
            case G_2_UPPER_CASE, G_2_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_G2;
            case G_3_UPPER_CASE, G_3_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_G3;
            case G_4_UPPER_CASE, G_4_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_G4;
            case G_5_UPPER_CASE, G_5_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_G5;
            case G_6_UPPER_CASE, G_6_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_G6;
            case G_7_UPPER_CASE, G_7_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_G7;
            case G_8_UPPER_CASE, G_8_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_G8;
            case H_1_UPPER_CASE, H_1_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_H1;
            case H_2_UPPER_CASE, H_2_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_H2;
            case H_3_UPPER_CASE, H_3_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_H3;
            case H_4_UPPER_CASE, H_4_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_H4;
            case H_5_UPPER_CASE, H_5_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_H5;
            case H_6_UPPER_CASE, H_6_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_H6;
            case H_7_UPPER_CASE, H_7_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_H7;
            case H_8_UPPER_CASE, H_8_LOWER_CASE -> positionOfTheFigureTypeIntegerUnverified = CHESS_BOARD_INDEX_H8;
            default -> positionOfTheFigureTypeIntegerUnverified = FALSE;
        }

        if (((startingPositionVerification == TRUE)
                && (finalPositionVerification == FALSE))
                && (positionOfTheFigureTypeIntegerUnverified != FALSE)
                && ((((blackMove == FALSE)
                && (whiteMove == TRUE))
                && ((chessBoard[positionOfTheFigureTypeIntegerUnverified][CHESSBOARD_LAYER_1] > WHITE_ALLIED_RANGE_START)
                && (chessBoard[positionOfTheFigureTypeIntegerUnverified][CHESSBOARD_LAYER_1] < WHITE_ALLIED_RANGE_END)))
                || (((blackMove == TRUE)
                && (whiteMove == FALSE))
                && ((chessBoard[positionOfTheFigureTypeIntegerUnverified][CHESSBOARD_LAYER_1] > BLACK_ALLIED_RANGE_START)
                && (chessBoard[positionOfTheFigureTypeIntegerUnverified][CHESSBOARD_LAYER_1] < BLACK_ALLIED_RANGE_END))))
                && (((listOfLegalMoves[(chessBoard[positionOfTheFigureTypeIntegerUnverified][CHESSBOARD_LAYER_1])][LIST_OF_LEGAL_MOVES_LAYER_1] != FALSE)
                && (listOfLegalMoves[(chessBoard[positionOfTheFigureTypeIntegerUnverified][CHESSBOARD_LAYER_1])][LIST_OF_LEGAL_MOVES_LAYER_1] != positionOfTheFigureTypeIntegerUnverified))
                || ((listOfLegalMoves[(chessBoard[positionOfTheFigureTypeIntegerUnverified][CHESSBOARD_LAYER_1])][LIST_OF_LEGAL_MOVES_LAYER_2] != FALSE)
                && (listOfLegalMoves[(chessBoard[positionOfTheFigureTypeIntegerUnverified][CHESSBOARD_LAYER_1])][LIST_OF_LEGAL_MOVES_LAYER_2] != positionOfTheFigureTypeIntegerUnverified)))) {
            startingPositionOfTheFigureTypeIntegerVerified = positionOfTheFigureTypeIntegerUnverified;
        } else if ((startingPositionVerification == TRUE)
                && (finalPositionVerification == FALSE)) {
            startingPositionOfTheFigureTypeIntegerVerified = FALSE;
        }

        if (((startingPositionVerification == FALSE)
                && (finalPositionVerification == TRUE))
                && (startingPositionOfTheFigureTypeIntegerVerified != FALSE)
                && (positionOfTheFigureTypeIntegerUnverified != FALSE)
                && (positionOfTheFigureTypeIntegerUnverified != startingPositionOfTheFigureTypeIntegerVerified)
        ) {
            for (int i = FALSE; (i < NUMBER_OF_LEGAL_MOVES); i++) {
                if (positionOfTheFigureTypeIntegerUnverified == listOfLegalMoves[(chessBoard[startingPositionOfTheFigureTypeIntegerVerified][CHESSBOARD_LAYER_1])][i]) {
                    finalPositionOfTheFigureTypeIntegerVerified = positionOfTheFigureTypeIntegerUnverified;
                    break;
                } else {
                    finalPositionOfTheFigureTypeIntegerVerified = FALSE;
                }
            }
        }
    }

    static void humansMove() {
        if (callingThePlayerToMakeTheMove == TRUE) {
            callingThePlayerToMakeTheMove();
        }

        inputDataTrim();
        String humansMoveNotProcessedAfterTrim = inputDataUnverifiedAfterTrim;

        startingPositionOfTheFigure = FALSE;
        finalPositionOfTheFigure = FALSE;

        if (humansMoveNotProcessedAfterTrim.length() == INPUT_CHARACTER_COUNT) {
            char[] humansMoveSymbolArray = new char[HUMANS_MOVE_SYMBOL_ARRAY_NUMBER_OF_CELLS];
            humansMoveSymbolArray[HUMANS_MOVE_SYMBOL_ARRAY_LAYER_0] = NULL_TYPE_CHAR;
            humansMoveSymbolArray[HUMANS_MOVE_SYMBOL_ARRAY_LAYER_1] = NULL_TYPE_CHAR;
            humansMoveSymbolArray[HUMANS_MOVE_SYMBOL_ARRAY_LAYER_2] = NULL_TYPE_CHAR;
            humansMoveSymbolArray[HUMANS_MOVE_SYMBOL_ARRAY_LAYER_3] = NULL_TYPE_CHAR;
            humansMoveSymbolArray = humansMoveNotProcessedAfterTrim.toCharArray();
            String humansMoveSymbolArray_0 = String.valueOf(humansMoveSymbolArray[HUMANS_MOVE_SYMBOL_ARRAY_LAYER_0]);
            String humansMoveSymbolArray_1 = String.valueOf(humansMoveSymbolArray[HUMANS_MOVE_SYMBOL_ARRAY_LAYER_1]);
            String humansMoveSymbolArray_2 = String.valueOf(humansMoveSymbolArray[HUMANS_MOVE_SYMBOL_ARRAY_LAYER_2]);
            String humansMoveSymbolArray_3 = String.valueOf(humansMoveSymbolArray[HUMANS_MOVE_SYMBOL_ARRAY_LAYER_3]);

            String startingPositionOfTheFigureTypeStringUnverified = (humansMoveSymbolArray_0 + humansMoveSymbolArray_1);
            String finalPositionOfTheFigureUnverified = (humansMoveSymbolArray_2 + humansMoveSymbolArray_3);

            humansMoveConverterFromStringToInteger(startingPositionOfTheFigureTypeStringUnverified, TRUE, FALSE);
            humansMoveConverterFromStringToInteger(finalPositionOfTheFigureUnverified, FALSE, TRUE);

            if ((startingPositionOfTheFigureTypeIntegerVerified != FALSE)
                    && (finalPositionOfTheFigureTypeIntegerVerified != FALSE)) {
                startingPositionOfTheFigure = startingPositionOfTheFigureTypeIntegerVerified;
                finalPositionOfTheFigure = finalPositionOfTheFigureTypeIntegerVerified;
                activeFigureName = chessBoard[startingPositionOfTheFigure][CHESSBOARD_LAYER_1];
            } else {
                repeatInputData();
                callingThePlayerToMakeTheMove = FALSE;
                humansMove();
            }

        } else {
            repeatInputData();
            callingThePlayerToMakeTheMove = FALSE;
            humansMove();
        }
    }
}