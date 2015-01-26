package es.art83.ticTacToe.models.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import es.art83.ticTacToe.models.utils.ColorModel;

public class BoardEntityTest {

    @Test
    public void testBoardEntity() {
        assertEquals(0, new BoardEntity().getPieces().size());
    }

    @Test
    public void testBoardEntityListOfPieceEntity() {

        List<List<PieceEntity>> piecesBoardSet = new TestBoardEntityListOfPieceEntityData()
                .getPiecesBoardSet();
        for (List<PieceEntity> piecesBoard : piecesBoardSet) {
            BoardEntity board = new BoardEntity(piecesBoard);
            for (PieceEntity piece : new ArrayList<PieceEntity>(piecesBoard)) {
                board.remove(piece.getCoordinate());
            }
            assertEquals(0, board.getPieces().size());
        }
    }

    @Test
    public void testClear() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testHasAllPieces() {
        fail("Not yet implemented");
    }

    // LUIS debería irse al bean
    @Test
    public void testColors() {
        fail("Not yet implemented");
    }

    @Test
    public void testCoordinates() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testValidDestinationCoordinates() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testPut() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemove() {
        fail("Not yet implemented");
    }

    @Test
    public void testExistTicTacToe() {

        TestExistTicTacToeData gamesSetDataTest = new TestExistTicTacToeData();
        Iterator<List<PieceEntity>> putPieceGamesIterator = gamesSetDataTest.getPutPieceGamesSet()
                .iterator();
        Iterator<List<CoordinateEntity>> removeCoordinateGamesIterator = gamesSetDataTest
                .getRemoveCoordinatesGamesSet().iterator();
        Iterator<List<Boolean>> ticTacToesGamesIterator = gamesSetDataTest.getTicTacToesGamesSet()
                .iterator();
        int juego = 1;
        while (putPieceGamesIterator.hasNext()) {
            System.out.println("Game!!!!!!!!!!!!!!!!!!!!!!! " + juego++);
            BoardEntity board = new BoardEntity();
            Iterator<PieceEntity> putPieceIterator = putPieceGamesIterator.next().iterator();
            Iterator<CoordinateEntity> removeCoordinateIterator = removeCoordinateGamesIterator
                    .next().iterator();
            Iterator<Boolean> ticTacToeIterator = ticTacToesGamesIterator.next().iterator();
            int i = 0;
            while (putPieceIterator.hasNext()) {
                if (i >= CoordinateEntity.DIMENSION * 2) {
                    CoordinateEntity coordinate = removeCoordinateIterator.next();
                    System.out.println("remove: " + coordinate);
                    board.remove(coordinate);
                }
                PieceEntity piece = putPieceIterator.next();
                System.out.println("put: " + piece);
                board.put(piece);
                System.out.println(board);
                boolean ticTacToe = ticTacToeIterator.next();
                System.out.println(ticTacToe);
                System.out.println(board.existTicTacToe());
                assertEquals(ticTacToe, board.existTicTacToe());
                i++;
            }
            System.out.println(board);
        }
    }

    @Test
    public void testUpdate() {
        fail("Not yet implemented");
    }

}
