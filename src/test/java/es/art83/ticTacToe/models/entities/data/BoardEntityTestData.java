package es.art83.ticTacToe.models.entities.data;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.utils.ArrayToListTransformer;

public class BoardEntityTestData {

    private static final ColorModel[][] COLOR_PIECES = { {},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.O, ColorModel.O}, {ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O}, {ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O}, {ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O}, {ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.O},
            {ColorModel.O, ColorModel.X}, {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] COORDINATE_PIECES = { {}, { {0, 0}, {0, 1}, {0, 2}},
            { {1, 0}, {1, 1}, {1, 2}}, { {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {1, 0}, {2, 0}},
            { {0, 1}, {1, 1}, {2, 1}}, { {0, 2}, {1, 2}, {2, 2}}, { {0, 0}, {1, 1}, {2, 2}},
            { {0, 2}, {1, 1}, {2, 0}}, { {0, 0}, {0, 1}, {0, 2}}, { {1, 0}, {1, 1}, {1, 2}},
            { {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {1, 0}, {2, 0}}, { {0, 1}, {1, 1}, {2, 1}},
            { {0, 2}, {1, 2}, {2, 2}}, { {0, 2}, {1, 1}, {2, 0}}, { {0, 0}, {1, 1}, {2, 2}},
            { {0, 0}, {1, 2}, {2, 2}}, { {0, 0}, {1, 2}, {2, 1}}, { {0, 0}, {1, 2}, {2, 0}},
            { {0, 0}, {1, 1}, {2, 1}}, { {0, 0}, {1, 1}, {2, 0}}, { {0, 0}, {1, 0}, {2, 1}},
            { {0, 0}, {1, 0}, {2, 2}}, {{0, 0}}, { {0, 0}, {0, 1}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 1}}, { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 1}, {1, 1}, {2, 1}}, { {0, 1}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {2, 0}},
            { {0, 1}, {2, 1}}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}};

    private static final boolean[] HAS_ALL_PIECES = {false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, true, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false};

    private static final int[][][] COORDINATE_X = { {}, { {0, 0}, {0, 1}, {0, 2}},
            { {1, 0}, {1, 1}, {1, 2}}, { {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {1, 0}, {2, 0}},
            { {0, 1}, {1, 1}, {2, 1}}, { {0, 2}, {1, 2}, {2, 2}}, { {0, 0}, {1, 1}, {2, 2}},
            { {0, 2}, {1, 1}, {2, 0}}, {}, {}, {}, {}, {}, {}, {}, {}, { {0, 0}, {1, 2}, {2, 2}},
            { {0, 0}, {1, 2}, {2, 1}}, { {0, 0}, {1, 2}, {2, 0}}, { {0, 0}, {1, 1}, {2, 1}},
            { {0, 0}, {1, 1}, {2, 0}}, { {0, 0}, {1, 0}, {2, 1}}, { {0, 0}, {1, 0}, {2, 2}}, {},
            {{0, 1}}, { {0, 0}, {1, 1}}, { {0, 2}, {1, 1}, {1, 2}}, {{2, 1}}, { {1, 1}, {2, 2}},
            { {0, 0}, {1, 1}, {2, 0}}, { {0, 0}, {1, 0}, {2, 0}}, {{0, 1}}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] COORDINATE_O = { {}, {}, {}, {}, {}, {}, {}, {}, {},
            { {0, 0}, {0, 1}, {0, 2}}, { {1, 0}, {1, 1}, {1, 2}}, { {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {1, 0}, {2, 0}}, { {0, 1}, {1, 1}, {2, 1}}, { {0, 2}, {1, 2}, {2, 2}},
            { {0, 2}, {1, 1}, {2, 0}}, { {0, 0}, {1, 1}, {2, 2}}, {}, {}, {}, {}, {}, {}, {},
            {{0, 0}}, {{0, 0}}, { {1, 0}, {2, 1}}, { {0, 0}, {1, 0}, {2, 2}}, { {0, 1}, {1, 1}},
            { {0, 1}, {1, 2}}, { {2, 1}, {2, 2}}, { {0, 2}, {1, 1}}, {{2, 1}}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] VALID_DESTINATION_COORDINATES = {
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}},
            { {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}},
            { {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}},
            { {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {2, 1}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 0}, {2, 1}},
            { {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 2}}, { {0, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {2, 0}, {2, 1}}, { {0, 1}, {0, 2}, {1, 0}, {1, 2}},
            { {0, 1}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 2}},
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

    private static final ColorModel[] PUT_COLOR_PIECE = {ColorModel.X, ColorModel.O, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X,
            null, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null};

    private static final int[][] PUT_COORDINATE_PIECE = { {1, 1}, {1, 1}, {0, 0}, {1, 2}, {1, 1},
            {2, 0}, {2, 1}, {1, 0}, {2, 2}, {1, 1}, {0, 0}, {1, 2}, {2, 2}, {2, 2}, {1, 0}, {1, 0},
            {0, 1}, {1, 1}, {1, 0}, {0, 2}, {2, 2}, {2, 1}, {0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0},
            null, {2, 0}, {0, 0}, {1, 0}, {2, 2}, {1, 1}, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null};

    private static final ColorModel[][] PUT_COLOR_PIECES = { {ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X}, {ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.O, ColorModel.O}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] PUT_COORDINATE_PIECES = { {{1, 1}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}}, { {0, 0}, {1, 0}, {1, 1}, {1, 2}},
            { {1, 2}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {1, 0}, {1, 1}, {2, 0}},
            { {0, 1}, {1, 1}, {2, 0}, {2, 1}}, { {0, 2}, {1, 2}, {2, 1}, {2, 2}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 2}}, { {0, 2}, {1, 1}, {2, 0}, {2, 2}},
            { {0, 0}, {0, 1}, {0, 2}, {1, 1}}, { {0, 0}, {1, 0}, {1, 1}, {1, 2}},
            { {1, 2}, {2, 0}, {2, 1}, {2, 2}}, { {0, 0}, {1, 0}, {2, 0}, {2, 2}},
            { {0, 1}, {1, 1}, {2, 1}, {2, 2}}, { {0, 2}, {1, 0}, {1, 2}, {2, 2}},
            { {0, 2}, {1, 0}, {1, 1}, {2, 0}}, { {0, 0}, {0, 1}, {1, 1}, {2, 2}},
            { {0, 0}, {1, 1}, {1, 2}, {2, 2}}, { {0, 0}, {1, 0}, {1, 2}, {2, 1}},
            { {0, 0}, {0, 2}, {1, 2}, {2, 0}}, { {0, 0}, {1, 1}, {2, 1}, {2, 2}},
            { {0, 0}, {1, 1}, {2, 0}, {2, 1}}, { {0, 0}, {0, 1}, {1, 0}, {2, 1}},
            { {0, 0}, {1, 0}, {2, 1}, {2, 2}}, { {0, 0}, {1, 1}}, { {0, 0}, {0, 1}, {1, 0}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 2}}, { {0, 1}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {2, 0}, {2, 2}}, { {0, 1}, {1, 1}, {2, 1}}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final ColorModel[] REMOVE_COLOR_PIECE = {null, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.X,
            ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.O, ColorModel.O,
            ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O, ColorModel.O,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null};

    private static final int[][] REMOVE_COORDINATE_PIECE = {null, {0, 1}, {1, 0}, {2, 2}, {2, 0},
            {1, 1}, {2, 1}, {2, 2}, {0, 2}, {0, 1}, {1, 2}, {2, 0}, {1, 0}, {2, 1}, {2, 2}, {1, 1},
            {0, 0}, {0, 0}, {1, 2}, {2, 0}, {0, 0}, {2, 0}, {1, 0}, {0, 0}, {0, 0}, {0, 0}, {2, 1},
            {2, 2}, {1, 1}, {0, 1}, {2, 2}, {0, 2}, {2, 1}, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null};

    private static final ColorModel[][] REMOVE_COLOR_PIECES = { {}, {ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X}, {ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O}, {ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O}, {ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O}, {ColorModel.O, ColorModel.O},
            {ColorModel.O, ColorModel.O}, {ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X},
            {ColorModel.X, ColorModel.X}, {ColorModel.X, ColorModel.X}, {}, {ColorModel.X},
            {ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.O, ColorModel.X, ColorModel.O, ColorModel.X, ColorModel.X},
            {ColorModel.O, ColorModel.X}, {ColorModel.X, ColorModel.O, ColorModel.X},
            {ColorModel.X, ColorModel.X, ColorModel.X, ColorModel.O},
            {ColorModel.X, ColorModel.X, ColorModel.O, ColorModel.X}, {ColorModel.X}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final int[][][] REMOVE_COORDINATE_PIECES = { {}, { {0, 0}, {0, 2}},
            { {1, 1}, {1, 2}}, { {2, 0}, {2, 1}}, { {0, 0}, {1, 0}}, { {0, 1}, {2, 1}},
            { {0, 2}, {1, 2}, {2, 2}}, { {0, 0}, {1, 1}}, { {1, 1}, {2, 0}}, { {0, 0}, {0, 2}},
            { {1, 0}, {1, 1}}, { {2, 1}, {2, 2}}, { {0, 0}, {2, 0}}, { {0, 1}, {1, 1}},
            { {0, 2}, {1, 2}}, { {0, 2}, {2, 0}}, { {1, 1}, {2, 2}}, { {1, 2}, {2, 2}},
            { {0, 0}, {2, 1}}, { {0, 0}, {1, 2}}, { {1, 1}, {2, 1}}, { {0, 0}, {1, 1}},
            { {0, 0}, {2, 1}}, { {1, 0}, {2, 2}}, {}, {{0, 1}}, { {0, 0}, {1, 0}, {1, 1}},
            { {0, 0}, {0, 2}, {1, 0}, {1, 1}, {1, 2}}, { {0, 1}, {2, 1}},
            { {1, 1}, {1, 2}, {2, 2}}, { {0, 0}, {1, 1}, {2, 0}, {2, 1}},
            { {0, 0}, {1, 0}, {1, 1}, {2, 0}}, {{0, 1}}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

    private static final boolean[] EXIST_TICTACTOE = {false, true, true, true, true, true, true,
            true, true, true, true, true, true, true, true, true, true, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, true, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false};

    // piecesBoards
    private Iterator<List<PieceEntity>> piecesBoardsIterator;

    private List<PieceEntity> piecesBoard;

    // hasAllPiecesBoards
    private Iterator<Boolean> hasAllPiecesBoardsIterator;

    private Boolean hasAllPiecesBoard;

    // coordinatesXBoards
    private Iterator<List<CoordinateEntity>> coordinatesXBoardsIterator;

    private List<CoordinateEntity> coordinatesXBoard;

    // coordinatesOBoards
    private Iterator<List<CoordinateEntity>> coordinatesOBoardsIterator;

    private List<CoordinateEntity> coordinatesOBoard;

    // validDestinationCoordinatesBoards
    private Iterator<List<CoordinateEntity>> validDestinationCoordinatesBoardsIterator;

    private List<CoordinateEntity> validDestinationCoordinatesBoard;

    // putPieceBoards
    private Iterator<PieceEntity> putPieceBoardsIterator;

    private PieceEntity putPieceBoard;

    // putPiecesBoards
    private Iterator<List<PieceEntity>> putPiecesBoardsIterator;

    private List<PieceEntity> putPiecesBoard;

    // removePieceBoards
    private Iterator<PieceEntity> removePieceBoardsIterator;

    private PieceEntity removePieceBoard;

    // removePiecesBoards
    private Iterator<List<PieceEntity>> removePiecesBoardsIterator;

    private List<PieceEntity> removePiecesBoard;

    // existTitTacToeBoards
    private Iterator<Boolean> existTitTacToeBoardsIterator;

    private Boolean existTitTacToeBoard;

    private int numBoard = 0;

    public String message() {
        String result = "Board: " + numBoard + "\n" + "piecesBoard: " + piecesBoard
                + "\n" + "hasAllPiecesBoard: " + hasAllPiecesBoard + "\n" + "coordinatesXBoard: "
                + coordinatesXBoard + "\n" + "coordinatesOBoard: " + coordinatesOBoard + "\n"
                + "validDestinationCoordinatesBoard: " + validDestinationCoordinatesBoard + "\n"
                + "putPieceBoard: " + putPieceBoard + "\n" + "putPiecesBoard: " + putPiecesBoard
                + "\n" + "removePieceBoard: " + removePieceBoard + "\n" + "removePiecesBoard: "
                + removePiecesBoard + "\n" + "existTitTacToeBoard: " + existTitTacToeBoard;
        return result;
    }

    public BoardEntityTestData() {
        piecesBoardsIterator = ArrayToListTransformer.transform(COLOR_PIECES, COORDINATE_PIECES);
        hasAllPiecesBoardsIterator = ArrayToListTransformer.transform(HAS_ALL_PIECES);
        coordinatesXBoardsIterator = ArrayToListTransformer.transform(COORDINATE_X);
        coordinatesOBoardsIterator = ArrayToListTransformer.transform(COORDINATE_O);
        validDestinationCoordinatesBoardsIterator = ArrayToListTransformer.transform(VALID_DESTINATION_COORDINATES);
        putPieceBoardsIterator = ArrayToListTransformer.transform(PUT_COLOR_PIECE, PUT_COORDINATE_PIECE);
        putPiecesBoardsIterator = ArrayToListTransformer.transform(PUT_COLOR_PIECES, PUT_COORDINATE_PIECES);
        removePieceBoardsIterator = ArrayToListTransformer.transform(REMOVE_COLOR_PIECE, REMOVE_COORDINATE_PIECE);
        removePiecesBoardsIterator = ArrayToListTransformer.transform(REMOVE_COLOR_PIECES, REMOVE_COORDINATE_PIECES);
        existTitTacToeBoardsIterator = ArrayToListTransformer.transform(EXIST_TICTACTOE);
        this.nextBoard();
    }

    public boolean hasNextBoard() {
        List<Boolean> results = new ArrayList<Boolean>();
        results.add(piecesBoardsIterator.hasNext());
        results.add(hasAllPiecesBoardsIterator.hasNext());
        results.add(coordinatesXBoardsIterator.hasNext());
        results.add(coordinatesOBoardsIterator.hasNext());
        results.add(validDestinationCoordinatesBoardsIterator.hasNext());
        results.add(putPieceBoardsIterator.hasNext());
        results.add(putPiecesBoardsIterator.hasNext());
        results.add(removePieceBoardsIterator.hasNext());
        results.add(removePiecesBoardsIterator.hasNext());
        results.add(existTitTacToeBoardsIterator.hasNext());
        boolean firstResult = results.remove(0);
        for (Boolean result : results) {
            assert (firstResult == result);
        }
        return firstResult;
    }

    public void nextBoard() {
        numBoard++;
        piecesBoard = piecesBoardsIterator.next();
        hasAllPiecesBoard = hasAllPiecesBoardsIterator.next();
        coordinatesXBoard = coordinatesXBoardsIterator.next();
        coordinatesOBoard = coordinatesOBoardsIterator.next();
        validDestinationCoordinatesBoard = validDestinationCoordinatesBoardsIterator.next();
        putPieceBoard = putPieceBoardsIterator.next();
        putPiecesBoard = putPiecesBoardsIterator.next();
        removePieceBoard = removePieceBoardsIterator.next();
        removePiecesBoard = removePiecesBoardsIterator.next();
        existTitTacToeBoard = existTitTacToeBoardsIterator.next();
    }

    public List<PieceEntity> getPiecesBoard() {
        //TODO todos los siguientes get... debería devolver una copia de objetos!
        return piecesBoard;
    }

    public Boolean getHasAllPiecesBoard() {
        return hasAllPiecesBoard;
    }

    public List<CoordinateEntity> getCoordinatesXBoard() {
        return coordinatesXBoard;
    }

    public List<CoordinateEntity> getCoordinatesOBoard() {
        return coordinatesXBoard;
    }

    public List<CoordinateEntity> getValidDestinationCoordinatesBoard() {
        return validDestinationCoordinatesBoard;
    }

    public PieceEntity getPutPieceBoard() {
        return putPieceBoard;
    }

    public List<PieceEntity> getPutPiecesBoard() {
        return putPiecesBoard;
    }

    public PieceEntity getRemovePieceBoard() {
        return removePieceBoard;
    }

    public List<PieceEntity> getRemovePiecesBoard() {
        return removePiecesBoard;
    }

    public Boolean getExistTitTacToeBoard() {
        return existTitTacToeBoard;
    }

}
