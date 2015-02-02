package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.PlacePieceController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class PlacePieceControllerEJB extends ControllerEJB implements PlacePieceController {

    public PlacePieceControllerEJB(TicTacToeSession ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    private void changeSate() {
        assert this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        if (this.getTicTacToeSession().getGame().gameOver() != null) {
            this.getTicTacToeSession().setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);
        }
        this.getTicTacToeSession().setSaved(false);
    }

    @Override
    public void placePiece(CoordinateEntity coordinate) {
        this.getTicTacToeSession().getGame().placePiece(coordinate);
        this.changeSate();
    }

    @Override
    public void placePiece(CoordinateEntity source, CoordinateEntity destination) {
        this.getTicTacToeSession().getGame().deletePiece(source);
        this.getTicTacToeSession().getGame().placePiece(destination);
        this.changeSate();
    }

}
