package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.controllers.PlaceCardController;
import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

public class PlaceCardControllerEJB extends ControllerEJB implements PlaceCardController {

    public PlaceCardControllerEJB(TicTacToeSession ticTacToeStatesManager) {
        super(ticTacToeStatesManager);
    }
    
   private void changeSate(){
        assert this.getTicTacToeSession().getTicTacToeStateModel() == TicTacToeStateModel.OPENED_GAME;
        if (this.getTicTacToeSession().getGame().existTicTacToe()){
            this.getTicTacToeSession().setSaved(true);
            this.getTicTacToeSession().setTicTacToeStateModel(TicTacToeStateModel.CLOSED_GAME);        
        }else{
            this.getTicTacToeSession().setSaved(false);
        }
    }

    @Override
    public void placeCard(CoordinateEntity coordinate) {
        this.getTicTacToeSession().getGame().placePiece(coordinate);
        this.changeSate();
    }

    @Override
    public void placeCard(CoordinateEntity source, CoordinateEntity destination) {
        this.getTicTacToeSession().getGame().placePiece(source,destination);
        this.changeSate();
    }

}
