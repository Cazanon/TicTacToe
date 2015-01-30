package es.art83.ticTacToe.models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.art83.ticTacToe.models.daos.PieceDAO;
import es.art83.ticTacToe.models.daos.jpa.data.PieceDAOJPATestData;
import es.art83.ticTacToe.models.entities.PieceEntity;

public class PieceDAOJPATest {

    private PieceDAO dao = DAOJPAFactory.getFactory().getPieceDAO();

    private PieceDAOJPATestData data;

    @Before
    public void inti() {
        data = new PieceDAOJPATestData();
    }

    @Test
    public void testCreate() {
        List<PieceEntity> piecesData = new ArrayList<PieceEntity>();
        while (data.hasNextPieces()) {
            dao.create(data.getPiece());
            piecesData.add(data.getPiece());
        }
        List<PieceEntity> pieces = dao.findAll();
        for (PieceEntity piece : piecesData) {
            assertTrue(pieces.contains(piece));
        }
        assertTrue(pieces.size() == piecesData.size());
    }

    @Test
    public void testUpdate() {
  
        // dao.deleteByID(data.getPiece().getId());
        // dao.read(data.getPiece().getId());
        // dao.update(data.getPiece());
    }

    @Test
    public void testDelete() {
      
    }

    @Test
    public void testDeleteByID() {
        
    }

    @Test
    public void testDeleteByCoordinate() {
        
    }

    @Test
    public void testRead() {
        
    }

    @Test
    public void testFindAll() {
        
    }

}
