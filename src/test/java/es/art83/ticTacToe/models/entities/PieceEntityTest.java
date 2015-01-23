package es.art83.ticTacToe.models.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import es.art83.ticTacToe.models.utils.ColorModel;

public class PieceEntityTest {

    @Test
    public void testPieceEntityColorModelCoordinateEntity() {
        final ColorModel[] COLORS = {ColorModel.X, ColorModel.O, ColorModel.X};
        final CoordinateEntity[] COORDINATES = {new CoordinateEntity(0, 0),
                new CoordinateEntity(2, 1), new CoordinateEntity(1, 0)};
        assert COLORS.length == COORDINATES.length;
        for (int i = 0; i < COLORS.length; i++) {
            PieceEntity piece = new PieceEntity(COLORS[i], COORDINATES[i]);
            assertEquals(COLORS[i], piece.getColor());
            assertEquals(COORDINATES[i], piece.getCoordinate());
        }
    }

    @Test
    public void testPieceEntity() {
        PieceEntity piece = new PieceEntity();
        assertEquals(null, piece.getColor());
        assertEquals(null, piece.getCoordinate());
    }

}
