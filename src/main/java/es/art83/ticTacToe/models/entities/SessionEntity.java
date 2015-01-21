package es.art83.ticTacToe.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.utils.TicTacToeStateModel;

@Entity
public class SessionEntity {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private TicTacToeStateModel ticTacToeStateModel;

    private boolean saved;

    @OneToOne(cascade = CascadeType.ALL)
    private PlayerEntity player;

    @OneToOne(cascade = CascadeType.ALL)
    private GameEntity game;

    public SessionEntity() {
        this.ticTacToeStateModel = TicTacToeStateModel.INITIAL;
        this.player = null;
        this.game = null;
        this.saved = true;
    }

    public int getId() {
        return id;
    }

    public TicTacToeStateModel getTicTacToeStateModel() {
        return this.ticTacToeStateModel;
    }

    public void setTicTacToeStateModel(TicTacToeStateModel ticTacToeStateModel) {
        this.ticTacToeStateModel = ticTacToeStateModel;
    }

    public PlayerEntity getPlayer() {
        return this.player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public GameEntity getGame() {
        return this.game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public boolean isSavedGame() {
        return this.saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    @Override
    public String toString() {
        return "SessionEntity[" + id + "]";
    }

}
