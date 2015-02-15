package es.art83.ticTacToe.views.web.beans;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public abstract class PlayerViewBean extends ViewBean {

    private PlayerEntity player = new PlayerEntity();

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

}
