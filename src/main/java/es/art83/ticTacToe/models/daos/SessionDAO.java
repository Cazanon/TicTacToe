package es.art83.ticTacToe.models.daos;

import java.util.List;

import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.entities.SessionEntity;

public interface SessionDAO extends GenericDAO<SessionEntity, Integer> {
    public List<GameEntity> findPlayerGames(PlayerEntity player);

}
