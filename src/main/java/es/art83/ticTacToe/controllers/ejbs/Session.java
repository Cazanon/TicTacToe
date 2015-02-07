package es.art83.ticTacToe.controllers.ejbs;

import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.StateModel;

class Session {
    private StateModel state;

    private PlayerEntity player;

    private GameEntity game;

    private boolean saved;

    Session() {
        state = StateModel.INITIAL;
        player = null;
        game = null;
        saved = true;
    }

    StateModel getState() {
        return state;
    }

    void setState(StateModel ticTacToeStateModel) {
        this.state = ticTacToeStateModel;
    }

    PlayerEntity getPlayer() {
        return player;
    }

    void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    GameEntity getGame() {
        return game;
    }

    void setGame(GameEntity game) {
        this.game = game;
    }

    boolean getSavedGame() {
        return saved;
    }

    void setSavedGame(boolean saved) {
        this.saved = saved;
    }
    
}
