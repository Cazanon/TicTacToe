package es.art83.ticTacToe.models.daos;

import java.util.List;

import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public interface GameDao extends GenericDao<GameEntity, Integer> {
    List<String> findPlayerGameNames(PlayerEntity playerEntity);

    GameEntity findPlayerGame(PlayerEntity player, String gameNameSelected);
}
