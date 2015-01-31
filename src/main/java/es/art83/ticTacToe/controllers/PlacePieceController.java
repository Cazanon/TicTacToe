package es.art83.ticTacToe.controllers;

import es.art83.ticTacToe.models.entities.CoordinateEntity;

public interface PlacePieceController {

    void placePiece(CoordinateEntity coordinateEntity);

    void placePiece(CoordinateEntity source, CoordinateEntity destination);

}
