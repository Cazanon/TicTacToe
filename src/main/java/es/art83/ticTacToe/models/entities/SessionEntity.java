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

    private boolean savedGame;

    @OneToOne
    private PlayerEntity playerEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private GameEntity gameEntity;

    public SessionEntity() {
        this.ticTacToeStateModel = TicTacToeStateModel.INITIAL;
        this.playerEntity = null;
        this.gameEntity = null;
        this.savedGame = true;
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

    public boolean isSavedGame() {
        return this.savedGame;
    }

    public void setSavedGame(boolean savedGame) {
        this.savedGame = savedGame;
    }

    public PlayerEntity getPlayerEntity() {
        return this.playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public GameEntity getGameEntity() {
        return this.gameEntity;
    }

    public void setGameEntity(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }

    @Override
    public String toString() {
        return "SessionEntity[" + id + ":" + ticTacToeStateModel
                + ",saved:" + savedGame + ";player:" + playerEntity + ";game:" + gameEntity + "]";
    }

}
