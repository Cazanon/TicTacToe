package es.art83.ticTacToe.models.daos.jpa.data;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.utils.ArrayToListTransformer;

public class PieceDAOJPATestData {

    private static final ColorModel[] COLOR_PIECES = {ColorModel.X, ColorModel.O, ColorModel.O,
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

private static final int[][] COORDINATE_PIECES = { {1, 1}, {1, 1}, {0, 0}, {1, 2}, {1, 1},
        {2, 0}, {2, 1}, {1, 0}, {2, 2}, {1, 1}, {0, 0}, {1, 2}, {2, 2}, {2, 2}, {1, 0}, {1, 0},
        {0, 1}, {1, 1}, {1, 0}, {0, 2}, {2, 2}, {2, 1}, {0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0},
        null, {2, 0}, {0, 0}, {1, 0}, {2, 2}, {1, 1}, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null};

    // piece
    private Iterator<PieceEntity> piecesIterator;

    private PieceEntity piece;

    private int numBoard = 0;

    public String message() {
        String result = "Board: " + numBoard + "\n" + "Piece: " + piece + "\n";
        return result;
    }

    public PieceDAOJPATestData() {
        piecesIterator = ArrayToListTransformer.transform(COLOR_PIECES, COORDINATE_PIECES);
        this.nextPiece();
    }

    public boolean hasNextPieces() {
        return piecesIterator.hasNext();
    }

    public void nextPiece() {
        numBoard++;
        piece = piecesIterator.next();
    }

    public PieceEntity getPiece() {
        return piece;
    }

}
