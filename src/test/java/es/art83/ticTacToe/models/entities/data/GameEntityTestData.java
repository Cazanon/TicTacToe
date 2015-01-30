package es.art83.ticTacToe.models.entities.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.entities.TurnEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.utils.ArrayToListTransformer;

public class GameEntityTestData {

    private static final ColorModel[][] COLOR_PIECES = { {},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X}, {ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] COORDINATE_PIECES = { {},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 0}}, { {0, 0}, {1, 0}, {1, 1}, {1, 2}, {2, 1}},
            { {0, 1}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 1}}, { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 2}}, { {0, 1}, {0, 2}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {1, 2}}, { {0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {0, 2}, {1, 0}, {2, 0}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 1}}, { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 0}}, { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}}, { {0, 0}, {0, 2}, {1, 1}, {1, 2}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 0}}, { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 1}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 2}}, { {0, 0}, {1, 0}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {1, 1}},
            { {0, 0}, {0, 1}}, { {0, 0}, {1, 0}, {1, 1}, {2, 1}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 2}}, { {0, 1}, {1, 1}, {2, 1}},
            { {0, 1}, {1, 1}, {1, 2}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {2, 0}}, { {0, 1}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final ColorModel[] TURN = {ColorModel.X, ColorModel.O, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X,
            ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X,
            ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X};

    private static final boolean[] HAS_ALL_PIECES = {false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, true, false, false, false, true, false, false,
            false, false, false, true, true, true, true, true, true, true, true, true, true, true,
            true, true, true, true, true, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false};

    private static final int[][][] VALID_SOURCE_COORDINATE = { {}, { {1, 1}, {2, 0}},
            { {0, 0}, {2, 1}}, { {0, 1}, {1, 1}}, { {0, 1}, {1, 1}}, { {0, 0}, {1, 0}},
            { {0, 1}, {1, 0}}, { {0, 1}, {0, 2}}, { {0, 1}, {2, 1}}, { {1, 1}, {1, 2}},
            { {0, 1}, {2, 2}}, { {0, 0}, {1, 1}}, { {0, 2}, {2, 2}}, { {0, 2}, {1, 0}},
            { {0, 1}, {1, 0}}, { {0, 0}, {0, 1}}, { {0, 1}, {1, 0}}, { {0, 1}, {1, 1}},
            { {0, 2}, {1, 1}}, { {0, 1}, {1, 1}}, { {0, 1}, {0, 2}}, { {1, 0}, {2, 2}},
            { {2, 0}, {2, 2}}, { {0, 0}, {1, 0}, {2, 2}}, {{1, 1}}, {{0, 1}}, { {0, 0}, {1, 1}},
            { {0, 2}, {1, 1}, {1, 2}}, {{2, 1}}, { {1, 1}, {2, 2}}, { {2, 1}, {2, 2}},
            { {0, 2}, {1, 1}}, {{0, 1}}, { {0, 0}, {1, 1}, {2, 0}}, { {0, 0}, {1, 1}, {2, 0}},
            { {0, 1}, {1, 0}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}}, { {0, 1}, {1, 0}, {2, 2}},
            { {0, 0}, {1, 1}, {2, 0}}, { {0, 1}, {1, 0}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}},
            { {0, 1}, {1, 0}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}}, { {0, 1}, {1, 0}, {2, 2}},
            { {0, 0}, {1, 1}, {2, 0}}, { {0, 1}, {1, 0}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}},
            { {0, 1}, {1, 0}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] VALID_DESTINATION_COORDINATES = {
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {1, 0}, {1, 2}, {2, 1}, {2, 2}}, { {0, 1}, {0, 2}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 2}}, { {0, 2}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 2}, {1, 2}, {2, 0}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {1, 0}, {1, 2}, {2, 0}, {2, 1}}, { {0, 0}, {1, 0}, {1, 2}, {2, 2}},
            { {1, 0}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {0, 2}, {2, 0}, {2, 1}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 2}}, { {0, 1}, {1, 1}, {1, 2}, {2, 1}},
            { {0, 0}, {1, 2}, {2, 0}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {1, 0}, {1, 2}, {2, 1}, {2, 2}}, { {0, 2}, {1, 2}, {2, 0}, {2, 1}},
            { {0, 2}, {1, 0}, {2, 0}, {2, 1}}, { {0, 1}, {1, 0}, {2, 0}, {2, 2}},
            { {0, 2}, {1, 0}, {2, 1}, {2, 2}}, { {1, 0}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 2}, {2, 1}}, { {0, 1}, {0, 2}, {1, 1}, {1, 2}},
            { {0, 1}, {0, 2}, {1, 2}}, { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 2}}, { {0, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {2, 0}, {2, 1}}, { {0, 1}, {0, 2}, {1, 0}, {1, 2}},
            { {0, 1}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 2}}, { {0, 2}, {1, 2}, {2, 1}},
            { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}},
            { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}},
            { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}},
            { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}},
            { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}}};

    private static final boolean[] EXIST_TICTACTOE = {false, true, true, true, true, true, true,
            true, true, true, true, true, true, true, true, true, true, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false};

    private static final ColorModel[] PUT_COLOR_PIECE = {ColorModel.X, ColorModel.O, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O,
            ColorModel.O, ColorModel.O, null, ColorModel.X, ColorModel.X, ColorModel.X, null,
            ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null};

    private static final int[][] PUT_COORDINATE_PIECE = { {1, 1}, {1, 2}, {0, 1}, {1, 2}, {2, 1},
            {2, 0}, {2, 1}, {1, 0}, {2, 2}, {2, 0}, {0, 0}, {1, 2}, {1, 2}, {2, 2}, {1, 1}, {1, 0},
            {0, 2}, {0, 1}, {1, 0}, {0, 2}, {2, 2}, {2, 1}, {0, 1}, null, {0, 2}, {1, 1}, {2, 2},
            null, {2, 0}, {0, 0}, {1, 0}, {2, 2}, {1, 1}, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null};

    private static final ColorModel[][] PUT_COLOR_PIECES = { {ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X}, {ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] PUT_COORDINATE_PIECES = { {{1, 1}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 0}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 1}},
            { {0, 1}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 0}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 1}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 0}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 1}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 0}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 1}, {2, 2}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {0, 2}, {1, 1}},
            { {0, 0}, {0, 1}, {1, 1}}, { {0, 0}, {1, 0}, {1, 1}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 2}}, { {0, 1}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {2, 0}, {2, 2}}, { {0, 1}, {1, 1}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 2}}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final ColorModel[] SOURCE_MOVE_COLOR_PIECE = {null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, ColorModel.X, null, null, null, ColorModel.X, null, null, null,
            null, null, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.O,
            ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null};

    private static final int[][] SOURCE_MOVE_COORDINATE_PIECE = {null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, {1, 0}, null, null, null, {1, 1}, null, null, null, null, null,
            {0, 0}, {2, 0}, {1, 1}, {0, 0}, {1, 0}, {0, 1}, {2, 2}, {1, 0}, {0, 1}, {1, 1}, {2, 2},
            {1, 1}, {2, 2}, {1, 1}, {1, 0}, {0, 0}, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null};

    private static final ColorModel[] DESTINATION_MOVE_COLOR_PIECE = {null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, ColorModel.X, null, null, null, ColorModel.X, null, null, null,
            null, null, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.O,
            ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null};

    private static final int[][] DESTINATION_MOVE_COORDINATE_PIECE = {null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, {0, 1}, null, null, null, {2, 0}, null, null, null, null, null,
            {0, 2}, {2, 1}, {0, 2}, {1, 2}, {0, 2}, {2, 1}, {2, 1}, {2, 1}, {0, 2}, {1, 2}, {0, 2},
            {2, 1}, {1, 2}, {0, 2}, {1, 2}, {1, 2}, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null};

    private static final ColorModel[][] MOVE_COLOR_PIECES = { {},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X}, {ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] MOVE_COORDINATE_PIECES = { {},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 0}}, { {0, 0}, {1, 0}, {1, 1}, {1, 2}, {2, 1}},
            { {0, 1}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 1}}, { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 2}}, { {0, 1}, {0, 2}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {1, 2}}, { {0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {0, 2}, {1, 0}, {2, 0}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 1}}, { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 0}}, { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}}, { {0, 0}, {0, 2}, {1, 1}, {1, 2}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 0}}, { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 1}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 2}}, { {0, 0}, {1, 0}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {1, 1}},
            { {0, 0}, {0, 1}}, { {0, 0}, {1, 0}, {1, 1}, {2, 1}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}}, { {0, 1}, {1, 1}, {2, 1}},
            { {0, 1}, {1, 1}, {1, 2}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {2, 0}}, { {0, 1}, {2, 1}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {2, 0}, {2, 2}},
            { {0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 0}},
            { {0, 0}, {0, 1}, {1, 0}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 0}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 1}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 2}}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    // piecesGames
    private Iterator<List<PieceEntity>> piecesGamesIterator;

    private List<PieceEntity> piecesGame;

    // turnGames
    private Iterator<TurnEntity> turnGamesIterator;

    private TurnEntity turnGame;

    // hasAllPiecesGames
    private Iterator<Boolean> hasAllPiecesGamesIterator;

    private Boolean hasAllPiecesGame;

    // validSourceCoordinatesGames
    private Iterator<List<CoordinateEntity>> validSourceCoordinatesGamesIterator;

    private List<CoordinateEntity> validSourceCoordinatesGame;

    // validDestinationCoordinatesGames
    private Iterator<List<CoordinateEntity>> validDestinationCoordinatesGamesIterator;

    private List<CoordinateEntity> validDestinationCoordinatesGame;

    // putPieceGames
    private Iterator<PieceEntity> putPieceGamesIterator;

    private PieceEntity putPieceGame;

    // putPiecesGames
    private Iterator<List<PieceEntity>> putPiecesGamesIterator;

    private List<PieceEntity> putPiecesGame;

    // sourceMovePieceGames
    private Iterator<PieceEntity> sourceMovePieceGamesIterator;

    private PieceEntity sourceMovePieceGame;

    // destinationMovePiecesGames
    private Iterator<PieceEntity> destinationMovePieceGamesIterator;

    private PieceEntity destinationMovePieceGame;

    // movePiecesGames
    private Iterator<List<PieceEntity>> movePiecesGamesIterator;

    private List<PieceEntity> movePiecesGame;

    // existTitTacToeGames
    private Iterator<Boolean> existTitTacToeGamesIterator;

    private Boolean existTitTacToeGame;

    private int numBoard = 0;

    public String message() {
        String result = "Board: " + numBoard + "\n" + "piecesGame: " + piecesGame + "\n"
                + "hasAllPiecesGame: " + hasAllPiecesGame + "\n" + "turnGame: " + turnGame + "\n"
                + "validSourceCoordinatesGame: " + validSourceCoordinatesGame + "\n"
                + "validDestinationCoordinatesGame: " + validDestinationCoordinatesGame + "\n"
                + "putPieceBoard: " + putPieceGame + "\n" + "putPiecesGame: " + putPiecesGame
                + "\n" + "sourceMovePieceGame: " + sourceMovePieceGame + "\n"
                + "destinationMovePieceGame: " + destinationMovePieceGame + "\n"
                + "movePiecesGame: " + movePiecesGame + "\n" + "existTitTacToeGame: "
                + existTitTacToeGame;
        return result;
    }

    public GameEntityTestData() {
        piecesGamesIterator = ArrayToListTransformer.transform(COLOR_PIECES, COORDINATE_PIECES);
        turnGamesIterator = ArrayToListTransformer.transform(TURN);
        hasAllPiecesGamesIterator = ArrayToListTransformer.transform(HAS_ALL_PIECES);
        validSourceCoordinatesGamesIterator = ArrayToListTransformer
                .transform(VALID_SOURCE_COORDINATE);
        validDestinationCoordinatesGamesIterator = ArrayToListTransformer
                .transform(VALID_DESTINATION_COORDINATES);
        putPieceGamesIterator = ArrayToListTransformer.transform(PUT_COLOR_PIECE,
                PUT_COORDINATE_PIECE);
        putPiecesGamesIterator = ArrayToListTransformer.transform(PUT_COLOR_PIECES,
                PUT_COORDINATE_PIECES);
        sourceMovePieceGamesIterator = ArrayToListTransformer.transform(SOURCE_MOVE_COLOR_PIECE,
                SOURCE_MOVE_COORDINATE_PIECE);
        destinationMovePieceGamesIterator = ArrayToListTransformer.transform(
                DESTINATION_MOVE_COLOR_PIECE, DESTINATION_MOVE_COORDINATE_PIECE);
        movePiecesGamesIterator = ArrayToListTransformer.transform(MOVE_COLOR_PIECES,
                MOVE_COORDINATE_PIECES);
        existTitTacToeGamesIterator = ArrayToListTransformer.transform(EXIST_TICTACTOE);
        this.nextGame();
    }

    public boolean hasNextGame() {
        List<Boolean> results = new ArrayList<Boolean>();
        results.add(piecesGamesIterator.hasNext());
        results.add(hasAllPiecesGamesIterator.hasNext());
        results.add(turnGamesIterator.hasNext());
        results.add(validSourceCoordinatesGamesIterator.hasNext());
        results.add(validDestinationCoordinatesGamesIterator.hasNext());
        results.add(putPieceGamesIterator.hasNext());
        results.add(putPiecesGamesIterator.hasNext());
        results.add(sourceMovePieceGamesIterator.hasNext());
        results.add(destinationMovePieceGamesIterator.hasNext());
        results.add(movePiecesGamesIterator.hasNext());
        results.add(existTitTacToeGamesIterator.hasNext());
        boolean firstResult = results.remove(0);
        for (Boolean result : results) {
            assert (firstResult == result);
        }
        return firstResult;
    }

    public void nextGame() {
        numBoard++;
        piecesGame = piecesGamesIterator.next();
        hasAllPiecesGame = hasAllPiecesGamesIterator.next();
        turnGame = turnGamesIterator.next();
        validSourceCoordinatesGame = validSourceCoordinatesGamesIterator.next();
        validDestinationCoordinatesGame = validDestinationCoordinatesGamesIterator.next();
        putPieceGame = putPieceGamesIterator.next();
        putPiecesGame = putPiecesGamesIterator.next();
        sourceMovePieceGame = sourceMovePieceGamesIterator.next();
        destinationMovePieceGame = destinationMovePieceGamesIterator.next();
        movePiecesGame = movePiecesGamesIterator.next();
        existTitTacToeGame = existTitTacToeGamesIterator.next();
    }

    public List<PieceEntity> getPiecesGame() {
        return piecesGame;
    }

    public Boolean getHasAllPiecesGame() {
        return hasAllPiecesGame;
    }

    public TurnEntity getTurnGame() {
        return turnGame;
    }

    public List<CoordinateEntity> getValidSourceCoordinatesGame() {
        return validSourceCoordinatesGame;
    }

    public List<CoordinateEntity> getValidDestinationCoordinatesGame() {
        return validDestinationCoordinatesGame;
    }

    public PieceEntity getPutPieceGame() {
        return putPieceGame;
    }

    public List<PieceEntity> getPutPiecesGame() {
        return putPiecesGame;
    }

    public PieceEntity getSourceMovePieceGame() {
        return sourceMovePieceGame;
    }

    public PieceEntity getDestinationMovePieceGame() {
        return destinationMovePieceGame;
    }

    public List<PieceEntity> getMovePiecesGame() {
        return movePiecesGame;
    }

    public Boolean getExistTitTacToeGame() {
        return existTitTacToeGame;
    }

    public static void main(String[] arg) {
        GameEntityTestData data = new GameEntityTestData();
        while (data.hasNextGame()) {
            System.out.println(data.message());
            data.nextGame();
        }
    }

}
