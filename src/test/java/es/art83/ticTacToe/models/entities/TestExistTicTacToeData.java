package es.art83.ticTacToe.models.entities;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.utils.ColorModel;

public class TestExistTicTacToeData {

    private List<List<PieceEntity>> putPieceGamesSet = new ArrayList<List<PieceEntity>>();

    private List<List<CoordinateEntity>> removeCoordinatesGamesSet = new ArrayList<List<CoordinateEntity>>();

    private List<List<Boolean>> ticTacToesGamesSet = new ArrayList<List<Boolean>>();

    public TestExistTicTacToeData() {

        final ColorModel[][] PUT_COLOR_MODEL_GAME_SET = {
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X,
                        ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O,
                        ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X,
                        ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
                {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X,
                        ColorModel.O, ColorModel.X}, {}, {}, {}, {}, {}, {}, {}, {}, {}};
        final int[][][] PUT_INT_INT_GAME_SET = {
                { {0, 0}, {1, 0}, {0, 1}, {1, 1}, {0, 2}},
                { {1, 0}, {2, 0}, {1, 1}, {2, 1}, {1, 2}},
                { {2, 0}, {0, 0}, {2, 1}, {0, 1}, {2, 2}},
                { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}},
                { {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 1}},
                { {0, 2}, {0, 1}, {1, 2}, {1, 1}, {2, 2}},
                { {0, 0}, {1, 0}, {1, 1}, {2, 1}, {2, 2}},
                { {0, 2}, {0, 1}, {1, 1}, {2, 1}, {2, 0}},
                { {1, 1}, {0, 0}, {2, 0}, {0, 2}, {0, 1}, {2, 1}, {1, 0}, {1, 2}, {2, 2}, {0, 1},
                        {0, 0}},
                { {0, 0}, {1, 0}, {1, 1}, {2, 2}, {2, 1}, {0, 1}, {2, 0}, {1, 2}, {2, 2}},
                { {1, 1}, {0, 2}, {1, 0}, {0, 1}, {0, 0}, {2, 2}, {1, 2}}, {}, {}, {}, {}, {}, {},
                {}, {}, {}};
        final int[][][] REMOVED_INT_INT_GAMES_SET = { {}, {}, {}, {}, {}, {}, {}, {},
                { {2, 0}, {2, 1}, {0, 1}, {0, 0}, {1, 0}}, { {2, 1}, {2, 2}, {2, 0}}, {{0, 0}}, {},
                {}, {}, {}, {}, {}, {}, {}, {}};
        final boolean[][] TICTACTOE_GAME_SET = { {false, false, false, false, true},
                {false, false, false, false, true}, {false, false, false, false, true},
                {false, false, false, false, true}, {false, false, false, false, true},
                {false, false, false, false, true}, {false, false, false, false, true},
                {false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, true}, {}, {}, {}, {}, {}, {}, {}, {},
                {}};

        for (int i = 0; i < PUT_COLOR_MODEL_GAME_SET.length; i++) {
            List<PieceEntity> putPieceGame = new ArrayList<PieceEntity>();
            for (int j = 0; j < PUT_COLOR_MODEL_GAME_SET[i].length; j++) {
                putPieceGame.add(new PieceEntity(PUT_COLOR_MODEL_GAME_SET[i][j],
                        new CoordinateEntity(PUT_INT_INT_GAME_SET[i][j][0],
                                PUT_INT_INT_GAME_SET[i][j][1])));
            }
            putPieceGamesSet.add(putPieceGame);
        }
        for (int i = 0; i < REMOVED_INT_INT_GAMES_SET.length; i++) {
            List<CoordinateEntity> removeCoordinate = new ArrayList<CoordinateEntity>();
            for (int j = 0; j < REMOVED_INT_INT_GAMES_SET[i].length; j++) {
                removeCoordinate.add(new CoordinateEntity(REMOVED_INT_INT_GAMES_SET[i][j][0],
                        REMOVED_INT_INT_GAMES_SET[i][j][1]));
            }
            removeCoordinatesGamesSet.add(removeCoordinate);
        }
        for (int i = 0; i < TICTACTOE_GAME_SET.length; i++) {
            List<Boolean> ticTacToesGames = new ArrayList<Boolean>();
            for (int j = 0; j < TICTACTOE_GAME_SET[i].length; j++) {
                ticTacToesGames.add(TICTACTOE_GAME_SET[i][j]);
            }
            ticTacToesGamesSet.add(ticTacToesGames);
        }
    }

    public List<List<PieceEntity>> getPutPieceGamesSet() {
        return putPieceGamesSet;
    }

    public List<List<CoordinateEntity>> getRemoveCoordinatesGamesSet() {
        return removeCoordinatesGamesSet;
    }

    public List<List<Boolean>> getTicTacToesGamesSet() {
        return ticTacToesGamesSet;
    }


}
