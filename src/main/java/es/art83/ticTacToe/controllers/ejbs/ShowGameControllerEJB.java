package es.art83.ticTacToe.controllers.ejbs;

import java.util.List;

import es.art83.ticTacToe.controllers.ShowGameController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;
import es.art83.ticTacToe.models.utils.ColorModel;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class ShowGameControllerEJB extends ControllerEJB implements ShowGameController {

    public ShowGameControllerEJB(TicTacToeSession ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }

    @Override
    public String getNameGame() {
        return this.getTicTacToeSession().getGame().getName();
    }

    @Override
    public List<PieceEntity> allPieces() {
        return this.getTicTacToeSession().getGame().allPieces();
    }

    @Override
    public boolean gameOver() {
        return this.getTicTacToeSession().getGame().gameOver();
    }

    @Override
    public ColorModel winner() {
        return this.getTicTacToeSession().getGame().winner();
    }

    @Override
    public ColorModel turnColor() {
        return this.getTicTacToeSession().getGame().turnColor();
    }

    @Override
    public boolean hasAllPieces() {
        return this.getTicTacToeSession().getGame().hasAllPieces();
    }

    @Override
    public List<CoordinateEntity> validSourceCoordinates() {
        return this.getTicTacToeSession().getGame().validSourceCoordinates();
    }

    @Override
    public List<CoordinateEntity> validDestinationCoordinates() {
        return this.getTicTacToeSession().getGame().validDestinationCoordinates();
    }

    @Override
    public boolean createdGame() {
        boolean result = this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        result = result || this.getTicTacToeSession().getGame() != null;
        return result;
    }

}
