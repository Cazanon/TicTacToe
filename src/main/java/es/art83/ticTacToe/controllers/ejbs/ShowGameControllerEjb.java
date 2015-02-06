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
    public List<PieceEntity> allPieces() {
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

    // El problema es que cuando se termina una partida nos encontramos en
    // CLOSED_GAME, pero se debe mostrar el tablero ya que existe partida
    @Override
    public boolean openedGame() {
        boolean result = this.getSession().getState() == StateModel.OPENED_GAME
                || this.getSession().getGame() != null;
        return result;
    }

    @Override
    public List<String> gameNames() {
        return DaoFactory.getFactory().getGameDao()
                .findPlayerGameNames(this.getSession().getPlayer());
    }

}
