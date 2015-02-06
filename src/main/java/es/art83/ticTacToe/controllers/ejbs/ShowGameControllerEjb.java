package es.art83.ticTacToe.controllers.ejbs;

import java.util.List;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.daos.DaoFactory;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.StateModel;

public class ShowGameControllerEjb extends ControllerEjb implements ShowGameController {

    public ShowGameControllerEjb(Session session) {
        super(session);
    }

    @Override
    protected void changeState() {
        assert this.getSession().getState() == StateModel.CLOSED_GAME
                || this.getSession().getState() == StateModel.OPENED_GAME;
    }

    @Override
    public String gameName() {
        return this.getSession().getGame().getName();
    }

    @Override
    public List<PieceEntity> piecesOnBoard() {
        return this.getSession().getGame().allPieces();
    }

    @Override
    public ColorModel gameOver() {
        return this.getSession().getGame().gameOver();
    }

    @Override
    public ColorModel turnColor() {
        return this.getSession().getGame().turnColor();
    }

    @Override
    public boolean hasAllPieces() {
        return this.getSession().getGame().hasAllPieces();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        return this.getSession().getGame().validSourceCoordinates();
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        return this.getSession().getGame().validDestinationCoordinates();
    }

    @Override
    public boolean existGame() {
        return this.getSession().getGame() != null;
    }

    @Override
    public List<String> gameNamesOfPlayer() {
        return DaoFactory.getFactory().getGameDao()
                .findPlayerGameNames(this.getSession().getPlayer());
    }

}
