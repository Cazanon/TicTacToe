package es.art83.ticTacToe.models.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.utils.ColorModel;

//TODO repasar nombres de métodos de test con Entity, Model, ...
public class BoardEntityTest {

    private BoardEntityTestData data;

    @Before
    public void init() {
        data = new BoardEntityTestData();
    }

    @Test
    public void testBoardEntity() {
        assertEquals(data.message(), 0, new BoardEntity().getPieces().size());
    }

    @Test
    public void testBoardEntityListOfPieceEntity() {
        while (data.hasNextBoard()) {
            List<PieceEntity> pieceEntityList = data.getPiecesBoard();
            BoardEntity board = new BoardEntity(pieceEntityList);
            assertSame(data.message(), pieceEntityList, board.getPieces());
            data.nextBoard();
        }
    }

    @Test
    public void testHasAllPieces() {
        while (data.hasNextBoard()) {
            BoardEntity board = new BoardEntity(data.getPiecesBoard());
            assertEquals(data.message(), data.getHasAllPiecesBoard(), board.hasAllPieces());
            data.nextBoard();
        }
    }

    // LUIS debería irse al bean
    @Test
    public void testColors() {
        // TODO LUIS debería irse al bean
    }

    @Test
    public void testCoordinates() {
        this.testCoordinates(ColorModel.X);
        this.testCoordinates(ColorModel.X);
    }

    private void testCoordinates(ColorModel x) {
        while (data.hasNextBoard()) {
            BoardEntity board = new BoardEntity(data.getPiecesBoard());
            assertEquals(data.message(), data.getHasAllPiecesBoard(), board.hasAllPieces());
            data.nextBoard();
        }
    }

    @Test
    public void testValidDestinationCoordinates() {
        while (data.hasNextBoard()) {
            BoardEntity board = new BoardEntity(data.getPiecesBoard());
            assertEquals(data.message(), data.getValidDestinationCoordinatesBoard(),
                    board.validDestinationCoordinates());
            data.nextBoard();
        }
    }

    @Test
    public void testPut() {
        //TODO revisar porque depende de remove!!!
        while (data.hasNextBoard()) {
            BoardEntity board = new BoardEntity(data.getPiecesBoard());
            board.put(data.getPutPieceBoard());
            //System.out.println("antes: " + data.getPutPieceBoard());
            for (PieceEntity piece : board.getPieces()) {
                //System.out.println("sin: " + piece);
                data.getPutPiecesBoard().remove(piece);
                //System.out.println("queda: " + data.getPutPieceBoard());
            }
            //System.out.println("final: " + data.getPutPieceBoard());
            //System.out.println("vacio: " + new ArrayList<PieceEntity>());
            assertEquals(data.message(), new ArrayList<PieceEntity>(), data.getPutPieceBoard());
            data.nextBoard();
        }
    }

    @Test
    public void testRemove() {
        while (data.hasNextBoard()) {
            data.message();
            BoardEntity board = new BoardEntity(data.getPiecesBoard());
            if (data.getRemovePieceBoard() != null) {
                board.remove(data.getRemovePieceBoard().getCoordinate());
            }
            assertEquals(data.message(), data.getRemovePiecesBoard(), board.getPieces());
            data.nextBoard();
        }
    }

    @Test
    public void testExistTicTacToe() {
        while (data.hasNextBoard()) {
            //BoardEntity board = new BoardEntity(data.getPiecesBoard());
            //assertEquals(data.message(), data.getExistTitTacToeBoard(), board.existTicTacToe());
            data.nextBoard();
        }
    }

    @Test
    public void testUpdate() {
        // TODO No sé qué hacer aquí
    }

}
