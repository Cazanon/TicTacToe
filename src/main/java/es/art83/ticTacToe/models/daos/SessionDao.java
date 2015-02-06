package es.art83.ticTacToe.models.daos;

import java.util.List;

import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;
import es.art83.ticTacToe.models.entities.SessionEntity;

public interface SessionDao extends GenericDao<SessionEntity, Integer> {
    public List<GameEntity> findPlayerGamesOfSession(PlayerEntity player);

}
