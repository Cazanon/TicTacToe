package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.PlayerDao;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerDaoJpa extends GenericDaoJpa<PlayerEntity, String> implements
        PlayerDao {

    public PlayerDaoJpa() {
        super(PlayerEntity.class);
    }

}
