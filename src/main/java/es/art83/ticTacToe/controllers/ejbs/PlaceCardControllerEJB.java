package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class PlaceCardControllerEJB extends ControllerEJB implements PlaceCardController {

    public PlaceCardControllerEJB(TicTacToeContext ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }
    
   private void changeSate(){
        assert this.getTicTacToeContext().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        if (this.getTicTacToeContext().getGame().existTicTacToe()){
            this.getTicTacToeContext().setSaved(true);
            this.getTicTacToeContext().setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);        
        }else{
            this.getTicTacToeContext().setSaved(false);
        }
    }

    @Override
    public void placeCard(CoordinateEntity coordinate) {
        this.getTicTacToeContext().getGame().placePiece(coordinate);
        this.changeSate();
    }

    @Override
    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        this.getTicTacToeContext().getGame().placePiece(source,destination);
        this.changeSate();
    }

}
