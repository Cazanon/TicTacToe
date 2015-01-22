package es.art83.ticTacToe.models.daos;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.entities.PieceEntity;

public interface PieceDAO extends GenericDAO<PieceEntity, Integer> {
    void deleteByCoordinate(CoordinateEntity coordinateEntity);

}
