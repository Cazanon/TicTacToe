package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.StateModel;

public class PlacePieceControllerEjb extends ControllerEjb implements PlacePieceController {

    public PlacePieceControllerEjb(Session session) {
        super(session);
    }

    @Override
    protected void changeState() {
        assert this.getSession().getState() == StateModel.OPENED_GAME;
        if (this.getSession().getGame().gameOver() != null) {
            this.getSession().setState(StateModel.CLOSED_GAME);
        }
        this.getSession().setSavedGame(false);
    }

    @Override
    public void placePiece(CoordinateEntity coordinate) {
        this.getSession().getGame().placePiece(coordinate);
        this.changeState();
    }

    @Override
    public void placePiece(CoordinateEntity source, CoordinateEntity destination) {
        this.getSession().getGame().deletePiece(source);
        this.getSession().getGame().placePiece(destination);
        this.changeState();
    }

}
