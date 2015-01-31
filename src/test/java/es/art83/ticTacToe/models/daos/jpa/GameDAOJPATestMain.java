package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameDAOJPATestMain {
    private GameEntity game;

    PlayerEntity p;

    public void createPlayer() {
        this.p = new PlayerEntity("u", "p");
        DAOJPAFactory.getFactory().getPlayerDAO().create(this.p);
    }

    public void createTest() {
        GameDAO dao = DAOJPAFactory.getFactory().getGameDAO();
        this.game = new GameEntity("partida", p);
        game.placePiece(new CoordinateEntity(0, 0));
        game.placePiece(new CoordinateEntity(0, 1));
        game.placePiece(new CoordinateEntity(0, 2));
        dao.create(game);
    }

    public void deleteTest() {
        DAOJPAFactory.getFactory().getGameDAO().deleteByID(this.game.getId());
    }

    public void updateTest() {
        this.game.setName("other name");
        CoordinateEntity coor = new CoordinateEntity(0, 0);
        this.game.deletePiece(coor);
        this.game.placePiece(new CoordinateEntity(1, 1));
        DAOJPAFactory.getFactory().getGameDAO().update(this.game);
    }

    public static void main(String[] args) {
        GameDAOJPATestMain gameTest = new GameDAOJPATestMain();
        gameTest.createPlayer();
        gameTest.createTest();
        gameTest.deleteTest();
        gameTest.createTest();
        gameTest.updateTest();
    }
}
