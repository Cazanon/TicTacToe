package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.PieceDAO;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public class PieceDAOJPATestMain {
    public static void main(String[] args) {
        PieceDAO dao = DAOJPAFactory.getFactory().getPieceDAO();
        dao.create(new PieceEntity(ColorModel.O, new CoordinateEntity(0, 0)));
        dao.create(new PieceEntity(ColorModel.X, new CoordinateEntity(0, 1)));
        CoordinateEntity coor = new CoordinateEntity(0, 2);
        dao.create(new PieceEntity(ColorModel.O, coor));
        dao.create(new PieceEntity(ColorModel.X, new CoordinateEntity(1, 0)));
        dao.deleteByCoordinate(coor);
        System.out.println("findAll: " + dao.findAll());
    }
}
