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
import es.art83.ticTacToe.models.utils.StateModel;
import es.art83.ticTacToe.utils.Dependence;

@Entity
public class SessionEntity {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private StateModel state;

    private boolean savedGame;

    @Dependence(name = "player", dependencies = {"SessionDaoJpa"})
    @OneToOne
    private PlayerEntity player;

    @Dependence(name = "game", dependencies = {"SessionDaoJpa"})
    @OneToOne(cascade = CascadeType.ALL)
    private GameEntity game;

    public SessionEntity() {
        this.state = StateModel.INITIAL;
        this.player = null;
        this.game = null;
        this.savedGame = true;
    }

    public int getId() {
        return id;
    }

    public StateModel getState() {
        return this.state;
    }

    public void setState(StateModel state) {
        this.state = state;
    }

    public boolean isSavedGame() {
        return this.savedGame;
    }

    public void setSavedGame(boolean savedGame) {
        this.savedGame = savedGame;
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

    public void setGame(GameEntity gameEntity) {
        this.game = gameEntity;
    }

    @Override
    public String toString() {
        return "SessionEntity[" + id + ":" + state + ",saved:" + savedGame + ";player:" + player
                + ";game:" + game + "]";
    }

}
