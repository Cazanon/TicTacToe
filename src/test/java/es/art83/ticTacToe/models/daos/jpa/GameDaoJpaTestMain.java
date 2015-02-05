package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.GameDao;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameDaoJpaTestMain {
    private GameEntity game;

    PlayerEntity p;

    public void createPlayer() {
        this.p = new PlayerEntity("u", "p");
        DaoJpaFactory.getFactory().getPlayerDao().create(this.p);
    }

    public void createTest() {
        GameDao dao = DaoJpaFactory.getFactory().getGameDao();
        this.game = new GameEntity("partida", p);
        game.placePiece(new CoordinateEntity(0, 0));
        game.placePiece(new CoordinateEntity(0, 1));
        game.placePiece(new CoordinateEntity(0, 2));
        dao.create(game);
    }

    public void deleteTest() {
        DaoJpaFactory.getFactory().getGameDao().deleteByID(this.game.getId());
    }

    public void updateTest() {
        this.game.setName("other name");
        CoordinateEntity coor = new CoordinateEntity(0, 0);
        this.game.deletePiece(coor);
        this.game.placePiece(new CoordinateEntity(1, 1));
        DaoJpaFactory.getFactory().getGameDao().update(this.game);
    }

    public static void main(String[] args) {
        GameDaoJpaTestMain gameTest = new GameDaoJpaTestMain();
        gameTest.createPlayer();
        gameTest.createTest();
        gameTest.deleteTest();
        gameTest.createTest();
        gameTest.updateTest();
    }
}
